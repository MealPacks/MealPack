package `in`.mealpack.ui_meals.meal_details

import `in`.mealpack.components.DietTypeLabel
import `in`.mealpack.components.MealCoveredIcon
import `in`.mealpack.core.domain.DietType
import `in`.mealpack.meal_domain.MealIncludes
import `in`.mealpack.meal_domain.MealTimings
import `in`.mealpack.ui_meals.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ShowMealDetailScreen() {
    MealDetailScreen(
        dietType = DietType.NonVeg,
        mealName = "Heavy Meal Plan",
        mealTimings = MealTimings(
            "08:00 am --- 10:00 am",
            "01:00 pm  ---  03:00 pm",
            "08:00 pm  ---  10:00 pm"
        ),
        MealIncludes(
            "Roti Sabji   Poha   Sooji   Puri",
            "Roti Sabji  Rice,Dal  Chole",
            "Roti Sabji   Rice,Dal   Rice,Dal",
            "Puri   Paneer   Kheer"
        )


    )
}

@Composable
fun MealDetailScreen(
    dietType: DietType,
    mealName: String,
    mealTimings: MealTimings,
    mealIncludes: MealIncludes
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .size(width = 500.dp, height = 300.dp)
                .requiredWidth(500.dp)
                .clip(RoundedCornerShape(bottomEnd = 600.dp, bottomStart = 600.dp))
        ) {

            Image(
                painter = painterResource(id = R.drawable.meal_box),
                contentDescription = "meal Box",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DietTypeLabel(
                dietType = dietType,
                contentDes = "Diet Type",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .padding(4.dp)
            )

            Text(text = mealName)
            Column(
            ) {
                MealCoveredIcon(
                    modifier = Modifier,
                    isAvailable = true,
                    coveredMealName = "Breakfast"
                )
                Spacer(modifier = Modifier.size(8.dp))

                MealCoveredIcon(
                    modifier = Modifier,
                    isAvailable = true,
                    coveredMealName = "Lunch"
                )
                Spacer(modifier = Modifier.size(8.dp))

                MealCoveredIcon(
                    modifier = Modifier,
                    isAvailable = true,
                    coveredMealName = "Dinner"
                )
            }

        }
        MealDetailInfo(mealTimings = mealTimings, mealIncludes = mealIncludes)
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20.dp),
            contentColor = MaterialTheme.colors.onPrimary,
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .requiredHeight(70.dp)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            text = {
                Text(text = "Choose A Plan")
            }
        )

    }
}

@Composable
fun MealDetailInfo(
    mealTimings: MealTimings,
    mealIncludes: MealIncludes
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
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
                Text(text = mealTimings.breakfastTiming)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Lunch : ")
                Text(text = mealTimings.lunchTiming)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Dinner : ")
                Text(text = mealTimings.dinnerTiming)
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
                Text(text = mealIncludes.breakfastIncludes, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Lunch : ")
                Text(text = mealIncludes.lunchIncludes, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Dinner : ")
                Text(text = mealIncludes.dinnerIncludes, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Specials : ")
                Text(text = mealIncludes.specials, maxLines = 2)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowMealDetailPage() {
        MealDetailScreen(
            dietType = DietType.NonVeg,
            mealName = "Heavy Meal Plan",
            mealTimings = MealTimings(
                "08:00 am --- 10:00 am",
                "01:00 pm  ---  03:00 pm",
                "08:00 pm  ---  10:00 pm"
            ),
            MealIncludes(
                "Roti Sabji   Poha   Sooji   Puri",
                "Roti Sabji  Rice,Dal  Chole",
                "Roti Sabji   Rice,Dal   Rice,Dal",
                "Puri   Paneer   Kheer"
            )


        )
}