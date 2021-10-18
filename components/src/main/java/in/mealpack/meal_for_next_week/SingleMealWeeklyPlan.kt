package `in`.mealpack.meal_for_next_week

import `in`.mealpack.components.DietTypeLabel
import `in`.mealpack.components.R
import `in`.mealpack.core.DietType
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun SingleMeal(
    modifier: Modifier = Modifier,
    image: Painter
) {
    Box(
        modifier = Modifier
            .size(180.dp, 280.dp)
            .background(Color.Transparent)
            .zIndex(10f),

        ) {
        Box(
            modifier = Modifier
                .size(width = 180.dp, height = 200.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 66.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Idli")
                Text(
                    text = "Rice, dal, 2Roti, choole ki sabji,",
                    modifier = Modifier.padding(8.dp)
                )
                MealTag(
                    mealName = "Breakfast",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 16.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .size(150.dp, 140.dp)
                .background(Color.Transparent)
                .align(Alignment.TopCenter)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = `in`.mealpack.components.R.drawable.sample_singlemeal2),
                contentDescription = "sample meal",
                modifier = Modifier.align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Composable
fun MealTag(
    mealName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .shadow(elevation = 20.dp)
            .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
            .background(Color.Gray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "mealName", fontSize = 10.sp)
        Spacer(modifier = Modifier.width(16.dp))
        DietTypeLabel(dietType = DietType.Veg, contentDes = "Veg")
    }
}

@Preview
@Composable
fun ShowMealTag() {
        MealTag("Breakfast")
}

@Preview()
@Composable
fun ShowSingleMeal() {
        SingleMeal(image = painterResource(id = R.drawable.sample_singlemeal))
}