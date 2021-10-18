package `in`.mealpack.meal_for_next_week


import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DateFlag(
    height: Float
) {
    Column(
        modifier = Modifier
            .offset(y = 10.dp)
            .size(80.dp)
            .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
            .background(Color.Blue)
            .padding(8.dp)
    ) {
        Text(text = "04 June 2021, Sun", textAlign = TextAlign.Center)

    }
    Canvas(modifier = Modifier.fillMaxSize(height)) {
        val canvasHeight = size.height

        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = 0f, y = height),
            color = Color.Blue,
            strokeWidth = 15F
        )
    }
}

fun convertDpToPixels(context: Context, dp: Float) =
    dp * context.resources.displayMetrics.density


@Preview
@Composable
fun ShowDateFlag() {
        DateFlag(600f)
}