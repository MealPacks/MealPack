package `in`.mealpack.ui_drawer.ui.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HistoryScreen() {
    LazyColumn{
        items(10){
            for (i in 1..10){
                HistoryItem()
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview(){
    HistoryScreen()
}