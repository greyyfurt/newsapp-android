package mobi.argun.newsapp_android.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mobi.argun.newsapp_android.ui.common.util.BottomNavItem
import mobi.argun.newsapp_android.ui.theme.*

@Composable
fun BottomNavigationBar(
    currentScreenId: String,
    onItemSelected: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem.News,
        BottomNavItem.Favorites,
        BottomNavItem.Search
    )

    Card(
        elevation = 8.dp,
        shape = RectangleShape,
        backgroundColor = White100,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
        ) {
            items.forEach { navItem ->
                BottomNavigationItem(
                    item = navItem,
                    isSelected = navItem.route == currentScreenId,
                    onClick = onItemSelected
                )
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: (String) -> Unit
) {
    val background = if (isSelected) Purple500 else Transparent
    val contentColor = if (isSelected) White100 else Dark40

    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(background)
            .clickable { onClick(item.route) }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = item.name,
                color = contentColor,
                fontSize = 14.sp
            )
        }
    }
}