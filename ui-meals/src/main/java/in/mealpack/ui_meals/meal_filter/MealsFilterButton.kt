package `in`.mealpack.ui_meals.meals

import `in`.mealpack.components.StandardButton
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MealsFilterButton(
    filterText: String,
    enabled: Boolean,
    onclick: (String) -> Unit
) {

    Log.d("nameandselected","$enabled,$filterText")

    StandardButton(
        buttonText = filterText,
        buttonTextColor = if (!enabled)
            MaterialTheme.colors.primary
        else
            MaterialTheme.colors.onPrimary,
        onClick = {
            onclick(filterText)
        },
        enabled = enabled,
        border =
        if (!enabled)
            BorderStroke(2.dp, MaterialTheme.colors.primary)
        else
            ButtonDefaults.outlinedBorder,

        )
}

@Composable
fun RowOfFilters() {
    var currentItemSelected by remember {
        mutableStateOf("All")
    }
    val filterItems = listOf("All", "Veg", "NonVeg", "2Times", "3Times")
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(filterItems) { filterItem ->
            MealsFilterButton(
                filterText = filterItem,
                enabled = filterItem != currentItemSelected
            ) {
                currentItemSelected = it
            }
        }
    }
}

@Preview
@Composable
fun RowOfFiltersPreview() {
    RowOfFilters()
}

@Preview
@Composable
fun MealsFilterButtonPreview() {
    MealsFilterButton(
        filterText = "Veg",
        enabled = true
    ) {}
}
