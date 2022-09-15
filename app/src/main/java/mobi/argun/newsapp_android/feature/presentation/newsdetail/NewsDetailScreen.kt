package mobi.argun.newsapp_android.feature.presentation.newsdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import mobi.argun.newsapp_android.R
import mobi.argun.newsapp_android.feature.presentation.util.SharedViewModel
import mobi.argun.newsapp_android.ui.theme.Dark100
import mobi.argun.newsapp_android.ui.theme.Dark60

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
@Composable
fun NewsDetailScreen(
    sharedVM: SharedViewModel
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        sharedVM.article?.let { article ->
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                /** News' Picture */
                val painter =
                    rememberImagePainter(article.urlToImage ?: R.drawable.ic_launcher_background)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                /** News' Title **/
                Text(
                    text = article.title.orEmpty(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Dark100,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                /** News' Description */
                Text(
                    text = article.description.orEmpty(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Dark60,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}