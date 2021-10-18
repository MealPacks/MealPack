package `in`.mealpack.ui_cart

import `in`.mealpack.components.MealCoveredIcon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MealCartItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.onPrimary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.bg_login2),
            contentScale = ContentScale.Crop,
            contentDescription = "Cart Item"
        )
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(text = "Name of the meal")
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    MealCoveredIcon(isAvailable = true, coveredMealName = "Breakfast")
                    MealCoveredIcon(isAvailable = true, coveredMealName = "Lunch")
                    MealCoveredIcon(isAvailable = true, coveredMealName = "Dinner")
                }
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(text = "Plan Period")
                    Text(text = "From : ")
                    Text(text = "To :")
                }
            }

        }
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Column(
                modifier = Modifier
                    .height(80.dp)
                    .width(30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colors.primary),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Add"
                    )
                }
                Text(
                    modifier = Modifier.weight(1f),
                    text = "1"
                )
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_remove_circle),
                        contentDescription = "Add"
                    )
                }
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete"
                )
            }
        }
    }

}

@Preview(showBackground = false)
@Composable
fun CartItemPreview() {
    MealCartItem()
}