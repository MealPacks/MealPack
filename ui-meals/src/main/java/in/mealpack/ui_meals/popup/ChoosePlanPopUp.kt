package `in`.mealpack.ui_meals.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChoosePlanPopUp() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .height(200.dp)
                .background(Color.Black.copy(0.2f))
                .weight(1f)
        ) {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.BottomCenter)) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Cross",
                    tint = Black,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
//        .fillMaxSize()
                .padding(16.dp)
                .weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Choose A Plan ")
                Text(text = "Plan will start tomorrow")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(16.dp))

            SinglePlan(
                planTitle = "Get started by\n" +
                        "trying it out",
                durationOfPlan = "3 Days\n" +
                        "Plan",
                priceOfPlan = 500
            )

            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(16.dp))

            SinglePlan(
                planTitle = "Get a hang \n" +
                        "of things",
                durationOfPlan = "1Week\n" +
                        "Plan",
                priceOfPlan = 1000
            )
            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(16.dp))

            SinglePlan(
                planTitle = "Get going with \n" +
                        "full subscription",
                durationOfPlan = "1Month\n" +
                        "Plan",
                priceOfPlan = 2500
            )

            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colors.onPrimary,
                    backgroundColor = MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
            ) {
                Text(
                    text = "Add to Cart",
                )
            }
        }
    }

}

@Composable
fun SinglePlan(
    planTitle: String,
    durationOfPlan: String,
    priceOfPlan: Int
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { }
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = planTitle,
            modifier = Modifier.weight(6f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = durationOfPlan,
            modifier = Modifier.weight(4f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "₹ $priceOfPlan",
            modifier = Modifier.weight(3f)
        )
        Spacer(modifier = Modifier.height(8.dp))
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
            priceOfPlan = 500
        )
}

@Preview(showBackground = true)
@Composable
fun ShowPlanPopUp() {
        ChoosePlanPopUp()
}