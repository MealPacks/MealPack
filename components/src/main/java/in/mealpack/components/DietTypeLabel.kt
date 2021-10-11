package `in`.mealpack.components

import `in`.mealpack.components.R
import `in`.mealpack.core.domain.DietType
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DietTypeLabel(
    modifier: Modifier = Modifier,
    dietType: DietType,
    contentDes: String,
    color:Color =Color.White
) {
    when (dietType) {
        is DietType.NonVeg -> Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier,
        ) {
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.ic_non_veg),
                contentDescription = contentDes,
                tint = Color.Red
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "non-veg",
                color = color,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        is DietType.Veg -> Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.ic_veg),
                contentDescription = contentDes,
                tint = Color.Green

            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "veg",
                color = color,
                modifier = Modifier.align(Alignment.CenterVertically)

            )
        }
    }
}

@Preview
@Composable
fun ShowDietTypeLabel() {

        DietTypeLabel(dietType = DietType.Veg, contentDes = "Veg")
}