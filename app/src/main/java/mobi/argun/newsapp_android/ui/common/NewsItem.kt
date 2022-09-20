package mobi.argun.newsapp_android.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import mobi.argun.newsapp_android.R
import mobi.argun.newsapp_android.core.util.converter.DateFormatting
import mobi.argun.newsapp_android.core.vo.noRippleClickable
import mobi.argun.newsapp_android.core.vo.splitByCharacter
import mobi.argun.newsapp_android.feature.domain.entity.Article
import mobi.argun.newsapp_android.ui.theme.*

@Composable
fun NewsItem(
    article: Article,
    onItemClicked: () -> Unit,
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = White100,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
            .noRippleClickable { onItemClicked() }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                val painter =
                    rememberImagePainter(article.urlToImage ?: R.drawable.ic_launcher_background)

                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = article.author.orEmpty(),
                    fontSize = 12.sp,
                    color = White100,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                        .wrapContentSize()
                        .background(White100, RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null,
                        tint = Dark60,
                        modifier = Modifier
                            .padding(start = 14.dp)
                            .size(18.dp)
                    )

                    Text(
                        text = DateFormatting.convertDateFormat(article.publishedAt.orEmpty()),
                        fontSize = 14.sp,
                        color = Dark60,
                        modifier = Modifier.padding(
                            start = 6.dp,
                            end = 14.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                    )
                }
            }

            Text(
                text = article.title.splitByCharacter('-'),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Dark100,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = article.description.orEmpty(),
                fontSize = 14.sp,
                color = Dark40,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Row {
                Text(
                    text = article.source?.name.orEmpty(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Red100,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}