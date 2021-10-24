package `in`.mealpack.ui_drawer.ui.help_and_support

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HelpAndSupportScreen() {
    ContactUs()
    MessageUs()
}

@Preview(showBackground = true)
@Composable
fun HelpAndSupportPreview() {
    HelpAndSupportScreen()
}