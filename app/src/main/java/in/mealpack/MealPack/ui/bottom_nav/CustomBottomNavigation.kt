package `in`.mealpack.MealPack.ui.bottom_nav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CustomBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationDefaults.Elevation,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(
    bottomNavItem: BottomNavItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    val background = if (selected) MaterialTheme.colors.primary.copy(0.1f) else Color.Transparent
    val contentColor = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(modifier = Modifier
        .clip(CircleShape)
        .background(background)
        .clickable { onClick }) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Icon(
                painter = painterResource(id = bottomNavItem.icon),
                contentDescription = null,
                tint = if (bottomNavItem == BottomNavItem.MealsPlan) Color.Unspecified else contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = bottomNavItem.title,
                    color = contentColor
                )
            }

        }
    }

}