package `in`.mealpack.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VerticalDivider(
    height : Int = 20,
    width : Int = 1
) {
    Divider(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
    )
}

@Composable
fun HorizontalDivider(
    height: Int,
    width: Int
) {
    Divider(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HorizontalDividerPreview(){
    HorizontalDivider(1,300)
}

@Preview(showBackground = true)
@Composable
fun VerticalDividerPreview() {
    VerticalDivider()
}