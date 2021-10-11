package `in`.mealpack.mealpack_testing_new_things.ui.components.meals

import `in`.mealpack.components.DietTypeLabel
import `in`.mealpack.components.ImageCardSingleTitle
import `in`.mealpack.components.MealCoveredIcon
import `in`.mealpack.core.domain.DietType
import `in`.mealpack.meal_domain.MealCardData
import `in`.mealpack.meal_domain.MealsCovered
import `in`.mealpack.ui_meals.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MealCards(
    mealCards: List<MealCardData>,
    onMealCardClick: (String) -> Unit
) {
    LazyColumn() {
        items(mealCards) { item ->
            MealCard(
                mealId= item.mealId,
                imageUrl = "",
                mealName = item.mealName,
                mealDesc = item.mealDesc,
                dietType = item.dietType,
                mealsCovered = item.mealsCovered
            ) {
                onMealCardClick(it)
            }
        }
    }
}

//@ExperimentalMaterialApi
@Composable
fun MealCard(
    mealId: String,
    imageUrl: String,
    mealName: String,
    mealDesc: String,
    dietType: DietType,
    mealsCovered: MealsCovered,
    onMealCardClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onMealCardClick(mealId)
            },
        elevation = 10.dp,
    ) {
        Column {
            Box() {
                ImageCardSingleTitle(
                    painter = painterResource(id = R.drawable.meals),
                    title = mealName,
                    elevation = 0.dp,
                    cornerShape = RoundedCornerShape(8.dp)
                )
                DietTypeLabel(
                    dietType = dietType,
                    contentDes = "Diet Type",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                bottomStart = 10.dp
                            )
                        )
                        .background(Color.Gray)
                        .padding(4.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Meal includes Dishes: ",
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "$mealDesc",
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Meal Covered : ",
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.size(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                MealCoveredIcon(
                    isAvailable = mealsCovered.breakfast,
                    coveredMealName = "Breakfast",
                    modifier = Modifier
                )
                MealCoveredIcon(
                    isAvailable = mealsCovered.lunch,
                    coveredMealName = "Lunch",
                    modifier = Modifier
                )
                MealCoveredIcon(
                    isAvailable = mealsCovered.dinner,
                    coveredMealName = "Dinner",
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colors.onPrimary,
                    backgroundColor = MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp),
                elevation = ButtonDefaults.elevation(10.dp)
            ) {
                Text(
                    text = "Choose A Plan",
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowMealCard() {
    MealCard(
        mealId = "",
        mealName = "Heavy Meal Plan",
        mealDesc = "2 Roti, Choole, 1Bowl Rice, Dal, Poha, idli...",
        imageUrl = "",
        dietType = DietType.Veg,
        mealsCovered = MealsCovered(false, true, true)
    ){

    }

}