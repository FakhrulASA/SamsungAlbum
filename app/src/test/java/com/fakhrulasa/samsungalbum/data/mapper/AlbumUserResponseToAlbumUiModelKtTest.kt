package com.fakhrulasa.samsungalbum.data.mapper


import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.Address
import com.fakhrulasa.samsungalbum.data.model.response.user.Company
import com.fakhrulasa.samsungalbum.data.model.response.user.Geo
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel
import org.junit.Assert.assertEquals
import org.junit.Test
class AlbumMapperTest {

    @Test
    fun `test mapUserAlbumResponseToAlbumUiModel with valid data`() {
        val photos = listOf(
            Album(albumId = 1, id = 101, thumbnailUrl = "Thumbnail URL 1", title = "Photo Title 1", url = "URL 1"),
            Album(albumId = 2, id = 102, thumbnailUrl = "Thumbnail URL 2", title = "Photo Title 2", url = "URL 2"),
            Album(albumId = 3, id = 103, thumbnailUrl = "Thumbnail URL 3", title = "Photo Title 3", url = "URL 3")
        )

        val albums = listOf(
            Photo(id = 1, title = "Album Title 1", userId = 1),
            Photo(id = 2, title = "Album Title 2", userId = 2)
        )

        val users = listOf(
            User(
                address = Address(
                    city = "City 1", geo = Geo(lat = "0.0", lng = "0.0"), street = "Street 1", suite = "Suite 1", zipcode = "12345"
                ),
                company = Company(bs = "BS 1", catchPhrase = "Catchphrase 1", name = "Company 1"),
                email = "email1@example.com", id = 1, name = "User 1", phone = "1234567890", username = "user1", website = "www.user1.com"
            ),
            User(
                address = Address(
                    city = "City 2", geo = Geo(lat = "0.0", lng = "0.0"), street = "Street 2", suite = "Suite 2", zipcode = "67890"
                ),
                company = Company(bs = "BS 2", catchPhrase = "Catchphrase 2", name = "Company 2"),
                email = "email2@example.com", id = 2, name = "User 2", phone = "0987654321", username = "user2", website = "www.user2.com"
            )
        )

        val result = mapUserAlbumResponseToAlbumUiModel(photos, albums, users)

        val expected = listOf(
            AlbumUiModel(
                albumId = "1",
                thumbNail = "Thumbnail URL 1",
                userName = "User 1",
                albumName = "Album Title 1",
                photoTitle = "Photo Title 1"
            ),
            AlbumUiModel(
                albumId = "3",
                thumbNail = "Thumbnail URL 3",
                userName = "User 2",
                albumName = "Album Title 2",
                photoTitle = "Photo Title 3"
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `test mapUserAlbumResponseToAlbumUiModel with missing user`() {
        val photos = listOf(
            Album(albumId = 1, id = 101, thumbnailUrl = "Thumbnail URL 1", title = "Photo Title 1", url = "URL 1")
        )

        val albums = listOf(
            Photo(id = 1, title = "Album Title 1", userId = 1)
        )

        val users = emptyList<User>() // No users

        val result = mapUserAlbumResponseToAlbumUiModel(photos, albums, users)

        assertEquals(emptyList<AlbumUiModel>(), result)
    }

    @Test
    fun `test mapUserAlbumResponseToAlbumUiModel with duplicate albums`() {
        val photos = listOf(
            Album(albumId = 1, id = 101, thumbnailUrl = "Thumbnail URL 1", title = "Photo Title 1", url = "URL 1"),
            Album(albumId = 1, id = 101, thumbnailUrl = "Thumbnail URL 1", title = "Photo Title 1", url = "URL 1") // Duplicate
        )

        val albums = listOf(
            Photo(id = 1, title = "Album Title 1", userId = 1)
        )

        val users = listOf(
            User(
                address = Address(
                    city = "City 1", geo = Geo(lat = "0.0", lng = "0.0"), street = "Street 1", suite = "Suite 1", zipcode = "12345"
                ),
                company = Company(bs = "BS 1", catchPhrase = "Catchphrase 1", name = "Company 1"),
                email = "email1@example.com", id = 1, name = "User 1", phone = "1234567890", username = "user1", website = "www.user1.com"
            )
        )

        val result = mapUserAlbumResponseToAlbumUiModel(photos, albums, users)

        val expected = listOf(
            AlbumUiModel(
                albumId = "1",
                thumbNail = "Thumbnail URL 1",
                userName = "User 1",
                albumName = "Album Title 1",
                photoTitle = "Photo Title 1"
            )
        )

        assertEquals(expected, result)
    }
}