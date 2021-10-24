package `in`.mealpack.ui_drawer.ui.help_and_support

import `in`.mealpack.components.StandardTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MessageUs() {

    Column {
        Text(text = "Message Us")

        StandardTextField(
            text = "",
            onValueChange = {

            },
            label = "Full Name :"
        )
        StandardTextField(
            text = "",
            onValueChange = {

            },
            label = "Email :"
        )
        StandardTextField(
            text = "",
            onValueChange = {

            },
            label = "Phone :"
        )
        StandardTextField(
            text = "",
            onValueChange = {

            },
            label = "Tell us what do you need help with :",
            maxLines = 10,
            maxLength = 200
        )


    }

}




@Preview
@Composable
fun MessageUsPreview() {

}
