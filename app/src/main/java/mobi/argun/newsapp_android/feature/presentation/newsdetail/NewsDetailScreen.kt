package mobi.argun.newsapp_android.feature.presentation.newsdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.flow.collectLatest
import mobi.argun.newsapp_android.R
import mobi.argun.newsapp_android.core.vo.noRippleClickable
import mobi.argun.newsapp_android.core.vo.splitByCharacter
import mobi.argun.newsapp_android.feature.presentation.newsdetail.events.NewsDetailReUiEvents
import mobi.argun.newsapp_android.feature.presentation.newsdetail.events.NewsDetailUiEvents
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.feature.presentation.util.SharedViewModel
import mobi.argun.newsapp_android.ui.theme.*

@Composable
fun NewsDetailScreen(
    navController: NavController,
    sharedVM: SharedViewModel,
    newsDetailVM: NewsDetailViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()

    // region ReUi Events
    LaunchedEffect(key1 = true) {
        newsDetailVM.eventFlow.collectLatest { event ->
            when(event) {
                is NewsDetailReUiEvents.ShowSnackBar -> {
                    val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = "OK",
                        duration = SnackbarDuration.Short
                    )
                    when(snackbarResult) {
                        SnackbarResult.ActionPerformed -> {
                            navController.navigate(Screen.FavoritesScreen.route)
                        }
                        else -> {
                            // Do Nothing!
                        }
                    }
                }
            }
        }
    }
    // endregion

    sharedVM.article?.let { article ->
        Scaffold(
            scaffoldState = scaffoldState,
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                /** AddToFavorites Button */
                if (!article.isMyFav) {
                    FloatingActionButton(
                        shape = CircleShape,
                        backgroundColor = Red100,
                        modifier = Modifier.size(50.dp),
                        onClick = {
                            newsDetailVM.onEvent(
                                event = NewsDetailUiEvents.AddToFavorites(article.copy(isMyFav = true))
                            )
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favorites),
                            contentDescription = null,
                            tint = White100
                        )
                    }
                }
            }
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                /** News' Picture */
                val painter =
                    rememberImagePainter(
                        article.urlToImage ?: R.drawable.ic_launcher_background
                    )
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 250.dp),
                )

                /** News' Title **/
                Text(
                    text = article.title.splitByCharacter('-'),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Dark100,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                /** News' Description */
                Text(
                    text = article.content.splitByCharacter('['),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Dark60,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                /** Read More */
                article.url?.let { newsUrl ->
                    val uriHandler = LocalUriHandler.current
                    Text(
                        text = "Read More...",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Teal200,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .noRippleClickable {
                                uriHandler.openUri(newsUrl)
                            }
                    )
                }
            }
        }
    }
}