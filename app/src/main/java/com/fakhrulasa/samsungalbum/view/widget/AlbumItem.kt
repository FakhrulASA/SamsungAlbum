package com.fakhrulasa.samsungalbum.view.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakhrulasa.samsungalbum.R
import com.fakhrulasa.samsungalbum.core.views.ComposeImageView
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel


@Composable
fun AlbumItemWidget(uiModel: AlbumUiModel){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(4.dp).padding(4.dp).background(Color.LightGray)) {
        ComposeImageView(imageUrl = uiModel.thumbNail, h = 150, w = 150 )
        Column {
            Text(text = uiModel.albumName.uppercase(), style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W700, color = Color.Black))
            Text(text = uiModel.photoTitle, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500, color = Color.Black))
            Text(text = uiModel.userName, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W300, color = Color.Black))
        }
    }
}