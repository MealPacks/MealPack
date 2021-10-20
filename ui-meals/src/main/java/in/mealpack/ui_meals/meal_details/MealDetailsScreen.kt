package `in`.mealpack.ui_meals.meal_details

import `in`.mealpack.components.DietTypeLabel
import `in`.mealpack.components.MealCoveredIcon
import `in`.mealpack.components.StandardButton
import `in`.mealpack.core.DietType
import `in`.mealpack.meal_domain.model.DeliveryTimings
import `in`.mealpack.meal_domain.model.GenerallyIncludes
import `in`.mealpack.ui_meals.R
import `in`.mealpack.ui_meals.choose_plan.ChoosePlanPopUp
import `in`.mealpack.ui_meals.meals.MealsViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberImagePainter


@Composable
fun MealDetailScreen(
    mealsViewModel: MealsViewModel,
    imageLoader: ImageLoader,
    backClicked: () -> Unit,
) {
    val mealsDetail by mealsViewModel.mealsDetail.collectAsState()

    var showChooseAPlan by remember {
        mutableStateOf(false)
    }

    Scaffold(
        bottomBar = {
            if (showChooseAPlan) {
                    StandardButton(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 1.dp),
                        buttonText = "Add To Cart",
                        onClick = { },
                        buttonTextColor = MaterialTheme.colors.onPrimary
                    )

            } else {
                BottomAppBar(
                    elevation = 20.dp,
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    StandardButton(
                        onClick = {
                            //  choose a plan clicked
                                  showChooseAPlan = true
                        },
                        modifier = Modifier
                            .requiredHeight(70.dp)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 6.dp),
                        buttonText = "Choose A Plan"
                    )
                }
            }

        },
        floatingActionButton = {
            if (!showChooseAPlan) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = MaterialTheme.colors.primary.copy(0.3f)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Cart",
                            color = MaterialTheme.colors.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box {
                            Icon(
                                modifier = Modifier.padding(4.dp),
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = "cart",
                                tint = MaterialTheme.colors.onPrimary
                            )
                            Box(modifier = Modifier.align(Alignment.TopEnd)) {
                                Text(
                                    text = "2",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

        }
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding() + 6.dp)
        ) {

            MealDetailScreenInfo(
                dietType = if (mealsDetail.category.lowercase().trim() == "veg")
                    DietType.Veg
                else
                    DietType.NonVeg,
                mealName = mealsDetail.mealName,
                deliveryTimings = DeliveryTimings(),
                generallyIncludes = mealsDetail.generallyIncludes,
                extraDesc = mealsDetail.extraDesc,
                mealPhoto = mealsDetail.mealPhoto,
                imageLoader = imageLoader,
                backClicked = {
                    backClicked()
                }
            )
            if (showChooseAPlan) {
                ChoosePlanPopUp(
                    currentSelectedMeal = mealsDetail,
                    closeChoosePopUpPlanClicked = {
                        showChooseAPlan = false
                    }
                )
            }
        }
    }
}

@Composable
fun MealDetailScreenInfo(
    dietType: DietType,
    mealName: String,
    deliveryTimings: DeliveryTimings,
    generallyIncludes: GenerallyIncludes,
    extraDesc: String,
    mealPhoto: String,
    imageLoader: ImageLoader,
    backClicked: () -> Unit,
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 500.dp, height = 300.dp)
                .requiredWidth(500.dp)
                .clip(RoundedCornerShape(bottomEnd = 600.dp, bottomStart = 600.dp))
        ) {
            val painter = rememberImagePainter(
                data = mealPhoto,
                imageLoader = imageLoader,
                builder = {
                    placeholder(R.drawable.ic_image_placeholder)
                    crossfade(1000)
                }
            )

            Image(
                painter = painter,
                contentDescription = "meal Box",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.TopCenter)
                    .padding(top = 4.dp, start = 1.dp)

            ) {
                IconButton(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.background.copy(0.7f)),
                    onClick = {
                        backClicked()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back"
                    )
                }
            }

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
                    .padding(4.dp),
                color = if (isSystemInDarkTheme()) Color.Black
                else Color.White
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

        if (extraDesc.length > 3) {

            SomeDetails(
                modifier = Modifier.padding(start = 16.dp),
                someDetail = extraDesc
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        MealDetailInfo(
            deliveryTimings = deliveryTimings,
            generallyIncludes = generallyIncludes
        )


    }
}



@Composable
fun MealIncludesItem(
    mealIncludesString: String,
    modifier: Modifier = Modifier,

    ) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Breakfast : ")
        Text(text = mealIncludesString, maxLines = 2)
    }
    Spacer(modifier = Modifier.size(16.dp))
    Divider()
    Spacer(modifier = Modifier.size(16.dp))
}

//
//@Preview(showBackground = true)
//@Composable
//fun ShowMealDetailPage() {
//    MealDetailScreenInfo(
//        dietType = DietType.NonVeg,
//        mealName = "Heavy Meal Plan",
//        deliveryTimings = DeliveryTimings(
//            "08:00 am --- 10:00 am",
//            "01:00 pm  ---  03:00 pm",
//            "08:00 pm  ---  10:00 pm"
//        ),
//        generallyIncludes = GenerallyIncludes(
//            "Roti Sabji   Poha   Sooji   Puri",
//            "Roti Sabji  Rice,Dal  Chole",
//            "Roti Sabji   Rice,Dal   Rice,Dal",
//            "Puri   Paneer   Kheer"
//        ),
//        extraDesc = "",
//        mealPhoto = "",
//        imageLoader =
//    )
//}