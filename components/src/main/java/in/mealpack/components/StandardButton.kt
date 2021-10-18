package `in`.mealpack.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StandardButton(
    buttonText: String,
    buttonTextColor:Color = MaterialTheme.colors.onPrimary,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    @DrawableRes leadingIcon: Int? = null,
    leadingIconColor:Color= MaterialTheme.colors.onPrimary,
    @DrawableRes trailingIcon: Int? = null,
trailingIconColor:Color= MaterialTheme.colors.onPrimary,

) {
    OutlinedButton(
        modifier = modifier, onClick = { onClick() },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 16.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(20.dp),
        enabled = enabled,
        colors = colors
    ) {
        leadingIcon?.let {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = "Leading Icon",
                tint = leadingIconColor
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
        Text(text = buttonText,
            color = buttonTextColor
        )
        trailingIcon?.let {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painter = painterResource(id = trailingIcon),
                contentDescription = "Trailing Icon",
                tint = trailingIconColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StandardButtonPreview() {
    StandardButton(
        buttonText = "Button",
        onClick = {},
        leadingIcon = R.drawable.ic_delete
    )
}