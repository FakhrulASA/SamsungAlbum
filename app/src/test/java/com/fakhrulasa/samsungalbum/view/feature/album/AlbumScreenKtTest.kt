package com.fakhrulasa.samsungalbum.view.feature.album

import android.os.Build
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel
import com.fakhrulasa.samsungalbum.view.viewmodel.AlbumViewModel
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
class AlbumScreenTest {
    @Before
    fun setup() {
        mockkStatic(Build::class)
        every { Build.FINGERPRINT } returns "mocked-fingerprint"
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    // Test for loading state
    @Test
    fun albumScreen_loadingState_displaysShimmer() {
        // Create a mock view model
        val mockViewModel = object : AlbumViewModel() {
            val mockIsLoading = MutableStateFlow(true)
            val mockIsError = MutableStateFlow("")
            val mockUiData = MutableStateFlow<List<AlbumUiModel>>(emptyList())

            override val isLoading: StateFlow<Boolean> = mockIsLoading
            override val isError: StateFlow<String> = mockIsError
            override val uiData: StateFlow<List<AlbumUiModel>> = mockUiData
        }

        composeTestRule.setContent {
            AlbumScreen(safePadding = PaddingValues(), viewModel = mockViewModel)
        }

        // Assert that shimmer loading is shown
        composeTestRule.onNodeWithTag("ShimmerLoading").assertIsDisplayed()
    }

    // Test for error state
    @Test
    fun albumScreen_errorState_displaysToast() {
        val mockViewModel = object : AlbumViewModel() {
            val mockIsLoading = MutableStateFlow(false)
            val mockIsError = MutableStateFlow("Error")
            val mockUiData = MutableStateFlow(emptyList<AlbumUiModel>())

            override var isLoading: StateFlow<Boolean> = mockIsLoading
            override var isError: StateFlow<String> = mockIsError
            override var uiData: StateFlow<List<AlbumUiModel>> = mockUiData
        }

        composeTestRule.setContent {
            AlbumScreen(safePadding = PaddingValues(), viewModel = mockViewModel)
        }

        // Assert that the error state is shown (e.g., a toast or a UI component)
        composeTestRule.onNodeWithTag("ErrorState").assertIsDisplayed()  // Assuming you have a UI for the error state
    }

    // Test for success state with actual data
    @Test
    fun albumScreen_successState_displaysAlbums() {
        val mockAlbums = listOf(
            AlbumUiModel(
                albumId = "1",
                thumbNail = "https://example.com/thumb1.jpg",
                userName = "John Doe",
                albumName = "non sunt voluptatem placeat consequuntur rem incidunt",
                photoTitle = "Beach Day"
            ),
            AlbumUiModel(
                albumId = "2",
                thumbNail = "https://example.com/thumb2.jpg",
                userName = "Jane Smith",
                albumName = "accusamus beatae ad facilis cum similique qui sunt",
                photoTitle = "Mountain Hike"
            )
        )

        val mockViewModel = object : AlbumViewModel() {
            val mockIsLoading = MutableStateFlow(false)
            val mockIsError = MutableStateFlow("")
            val mockUiData = MutableStateFlow(mockAlbums)

            override val isLoading: StateFlow<Boolean> = mockIsLoading
            override val isError: StateFlow<String> = mockIsError
            override val uiData: StateFlow<List<AlbumUiModel>> = mockUiData
        }

        composeTestRule.setContent {
            AlbumScreen(safePadding = PaddingValues(), viewModel = mockViewModel)
        }

        // Assert that album titles are displayed correctly
        composeTestRule.onNodeWithText("accusamus beatae ad facilis cum similique qui sunt").assertIsDisplayed()
        composeTestRule.onNodeWithText("non sunt voluptatem placeat consequuntur rem incidunt").assertIsDisplayed()
    }
}