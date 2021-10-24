package `in`.mealpack.ui_drawer.ui.help_and_support

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FAQ() {
    Column {
        Text(text = "question")
    }
}

@Preview(showBackground = true)
@Composable
fun FAQPreview(){
    FAQ()
}