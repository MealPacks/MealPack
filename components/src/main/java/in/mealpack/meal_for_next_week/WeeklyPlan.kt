package `in`.mealpack.meal_for_next_week

import `in`.mealpack.components.R
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WeeklyPlan(
    modifier: Modifier = Modifier
) {

    BoxWithConstraints {
        val height = maxHeight.value
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleMeal(image = painterResource(id = R.drawable.sample_singlemeal2))
            Spacer(modifier = Modifier.padding(16.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                SingleMeal(image = painterResource(id = R.drawable.sample_singlemeal2))
                Spacer(modifier = Modifier.width(16.dp))
                SingleMeal(image = painterResource(id= R.drawable.sample_singlemeal2))
            }

        }
        DateFlag(height)
    }


}

@Preview
@Composable
fun ShowWeeklyPlan() {
        WeeklyPlan()
}