package `in`.mealpack.ui_drawer.ui.history

import `in`.mealpack.components.DietTypeLabel
import `in`.mealpack.components.MealCoveredIcon
import `in`.mealpack.components.StandardButton
import `in`.mealpack.core.DietType
import `in`.mealpack.ui_drawer.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HistoryItem() {
    Card(elevation = 20.dp,
    shape = RoundedCornerShape(20.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colors.primaryVariant)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Image(
                        modifier = Modifier
                            .size(50.dp),
                        painter = painterResource(id = R.drawable.meal_box),
                        contentDescription = "Meal Image",
                        contentScale = ContentScale.Crop
                    )
                    Column (verticalArrangement = Arrangement.spacedBy(8.dp)){
                        Text(text = "Heavy Meal Plan")
                        DietTypeLabel(dietType = DietType.Veg, contentDes = "Veg")
                    }

                }

                Text(text = "Price : ₹400")
            }

            Divider(modifier = Modifier.fillMaxWidth())

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(text = "Qty :")
                        Text(text = "1")
                    }
                    Text(text = "Ordered On : ")
                    Text(text = "22 jul 2021 at 3:35 pm")
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    MealCoveredIcon(isAvailable = true, coveredMealName = "breakfast")
                    MealCoveredIcon(isAvailable = true, coveredMealName = "Lunch")
                    MealCoveredIcon(isAvailable = true, coveredMealName = "Dinner")

                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "From :")
                    Text(text = "16/06/2021")
                    Text(text = "To :")
                    Text(text = "16/07/2021")
                }

            }

            Divider(modifier = Modifier.fillMaxWidth())

            StandardButton(leadingIcon = R.drawable.ic_repeat,
                buttonText = "Repeat Order",
                onClick = {
                    /*TODO*/
                }
            )
        }
    }

}

@Preview(showBackground = false)
@Composable
fun HistoryItemPreview() {
    HistoryItem()
}