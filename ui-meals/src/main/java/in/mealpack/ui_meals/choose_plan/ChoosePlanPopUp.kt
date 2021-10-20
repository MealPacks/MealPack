package `in`.mealpack.ui_meals.choose_plan

import `in`.mealpack.meal_domain.model.Meals
import `in`.mealpack.ui_meals.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun ChoosePlanPopUp(
    currentSelectedMeal:Meals,
    closeChoosePopUpPlanClicked:()->Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomStart)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                    .fillMaxHeight()
                    .background(Color.Black.copy(0.1f))
                .weight(1f)
                    .clickable { closeChoosePopUpPlanClicked() }
            ) {
                IconButton(
                    onClick = { closeChoosePopUpPlanClicked() }, modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cross_remove),
                        contentDescription = "Cross",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colors.background)

//        .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp,top =16.dp ,bottom =16.dp )
//                    .defaultMinSize(minHeight = 100.dp),
//                .weight(1f)
            ,verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Choose A Plan ")
                    Text(text = "Plan will start tomorrow")
                }

                Divider()

                SinglePlan(
                    planTitle = currentSelectedMeal.mealPrice.plan1.title,
                    durationOfPlan = currentSelectedMeal.mealPrice.plan1.planTimePeriod,
                    priceOfPlan = currentSelectedMeal.mealPrice.plan1.price
                )


                SinglePlan(
                    planTitle = currentSelectedMeal.mealPrice.plan2.title,
                    durationOfPlan = currentSelectedMeal.mealPrice.plan2.planTimePeriod,
                    priceOfPlan = currentSelectedMeal.mealPrice.plan2.price
                )

                SinglePlan(
                    planTitle = currentSelectedMeal.mealPrice.plan3.title,
                    durationOfPlan = currentSelectedMeal.mealPrice.plan3.planTimePeriod,
                    priceOfPlan = currentSelectedMeal.mealPrice.plan3.price
                )

            }
        }
    }


}

@Composable
fun SinglePlan(
    planTitle: String,
    durationOfPlan: String,
    priceOfPlan: Float
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { }
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = planTitle,
            modifier = Modifier.weight(6f)
        )

        Text(
            text = durationOfPlan,
            modifier = Modifier.weight(4f)
        )

        Text(
            text = "₹ $priceOfPlan",
            modifier = Modifier.weight(3f)
        )

        RadioButton(
            selected = true,
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun ShowPopUp() {
    SinglePlan(
        planTitle = "Get Started by trying out ",
        durationOfPlan = "3 Days Plan",
        priceOfPlan = 500f
    )
}

@Preview(showBackground = true)
@Composable
fun ShowPlanPopUp() {
    ChoosePlanPopUp(Meals()){}
}