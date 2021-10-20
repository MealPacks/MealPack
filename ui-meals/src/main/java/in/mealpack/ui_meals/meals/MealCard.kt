package `in`.mealpack.ui_meals.meals

import `in`.mealpack.components.DietTypeLabel
import `in`.mealpack.components.ImageCardSingleTitle
import `in`.mealpack.components.MealCoveredIcon
import `in`.mealpack.core.DietType
import `in`.mealpack.meal_domain.MealCovered
import `in`.mealpack.meal_domain.model.Meals
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
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter


@Composable
fun MealCards(
    imageLoader: ImageLoader,
    mealsViewModel: MealsViewModel,
    mealCards: List<Meals>,
    onMealCardClick: (String) -> Unit,
    chooseAPlanClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(mealCards) { item ->
            MealCard(
                imageLoader = imageLoader,
                mealId = item.mealId,
                imageUrl = item.mealPhoto,
                mealName = item.mealName,
                mealDesc = item.desc,
                dietType = if (item.category.lowercase().trim() == "veg")
                    DietType.Veg
                else
                    DietType.NonVeg,
                mealCovered = MealCovered(
                    item.mealCovered[0],
                    item.mealCovered[1],
                    item.mealCovered[2]
                ),
                onMealCardClick = {
                    mealsViewModel.getMealsDetails(it)
                    onMealCardClick(it)
                },
                chooseAPlanClick = {
                    mealsViewModel.getMealsDetails(it)
                    chooseAPlanClick(it)
                }
            )
        }
    }
}

//@ExperimentalMaterialApi
@Composable
fun MealCard(
    imageLoader: ImageLoader,
    mealId: String,
    imageUrl: String,
    mealName: String,
    mealDesc: String,
    dietType: DietType,
    mealCovered: MealCovered,
    onMealCardClick: (String) -> Unit,
    chooseAPlanClick: (String) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(top = 1.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onMealCardClick(mealId)
            },
        elevation = 20.dp,
    ) {
        Column {
            Box {
                val painter = rememberImagePainter(
                    data = imageUrl,
                    imageLoader = imageLoader,
                    builder = {
                        placeholder(R.drawable.ic_image_placeholder)
                        crossfade(1000)
                    }
                )
                ImageCardSingleTitle(
                    painter = painter,
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
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Meal includes Dishes: ",
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$mealDesc",
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Meal Covered : ",
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier.padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MealCoveredIcon(
                    isAvailable = mealCovered.breakfast,
                    coveredMealName = "Breakfast",
                    modifier = Modifier
                )
                MealCoveredIcon(
                    isAvailable = mealCovered.lunch,
                    coveredMealName = "Lunch",
                    modifier = Modifier
                )
                MealCoveredIcon(
                    isAvailable = mealCovered.dinner,
                    coveredMealName = "Dinner",
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = { chooseAPlanClick(mealId) },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colors.onPrimary,
                    backgroundColor = MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 16.dp,
                    pressedElevation = 8.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(
                    text = "Choose A Plan",
                )
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun ShowMealCard() {
//    val app = Application()
//    MealCard(
//        mealId = "",
//        mealName = "Heavy Meal Plan",
//        mealDesc = "2 Roti, Choole, 1Bowl Rice, Dal, Poha, idli...",
//        imageUrl = "",
//        dietType = DietType.Veg,
//        mealCovered = MealCovered(false, true, true),
//        imageLoader = ImageLoader.Builder(app).build(),
//        onMealCardClick = {},
//        chooseAPlanClick = {})
//
//}