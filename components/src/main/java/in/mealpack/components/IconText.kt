package `in`.mealpack.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LeadingIconText(
    modifier : Modifier = Modifier,
    text:String,
    @DrawableRes icon:Int,
    tint : Color = Color.Unspecified,
    textColor:Color = Color.Unspecified
) {
    Row(
        modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "icon",
            tint = tint
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = textColor
        )
    }
}
