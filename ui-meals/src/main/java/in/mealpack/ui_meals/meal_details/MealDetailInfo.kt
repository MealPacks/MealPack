package `in`.mealpack.ui_meals.meal_details

import `in`.mealpack.meal_domain.model.DeliveryTimings
import `in`.mealpack.meal_domain.model.GenerallyIncludes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MealDetailInfo(
    deliveryTimings: DeliveryTimings,
    generallyIncludes: GenerallyIncludes
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(text = "Timing of Delivery : ")

            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "Timings ", modifier = Modifier.padding(end = 52.dp))
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Breakfast : ")
                Text(text = deliveryTimings.breakfast)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Lunch : ")
                Text(text = deliveryTimings.lunch)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Dinner : ")
                Text(text = deliveryTimings.dinner)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))


            Spacer(modifier = Modifier.padding(16.dp))


            Text(text = "Meal Includes : ")

            Spacer(modifier = Modifier.size(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Breakfast : ")
                Text(text = generallyIncludes.breakfast, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Lunch : ")
                Text(text = generallyIncludes.lunch, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Dinner : ")
                Text(text = generallyIncludes.dinner, maxLines = 2)
            }

            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Specials : ")
                Text(text = generallyIncludes.specials, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
        }

    }
}