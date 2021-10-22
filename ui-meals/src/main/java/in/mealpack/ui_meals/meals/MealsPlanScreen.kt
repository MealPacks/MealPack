package `in`.mealpack.ui_meals.meals

import `in`.mealpack.ui_meals.choose_plan.ChoosePlanPopUp
import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader


@Composable
fun MealsPlanScreen(
    mealsViewModel: MealsViewModel,
    imageLoader: ImageLoader,
    onMealCardClicked: (String) -> Unit,
    chooseAPlanClick: (String) -> Unit,
    closeChoosePopUpPlanClicked: () -> Unit

) {

    val uiState by mealsViewModel.uiState.collectAsState()

    val currentMealList by mealsViewModel.currentMealList.collectAsState()

    val showChooseAPlan by mealsViewModel.showChoosePlanPopUp.collectAsState()

    val currentSelectedMeal by mealsViewModel.mealsDetail.collectAsState()

    val filterState by mealsViewModel.filteredList

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 20.dp
            ) {

                Log.d("selectedScreenFilter", "${filterState.selectedFilter},${filterState.filters}")


                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(filterState.filters) { filterItem ->

                        Log.d("selectedScreenFilter", "${filterState.selectedFilter},${filterState.filters}")

                        MealsFilterButton(
                            filterText = filterItem,
                            enabled = filterItem.lowercase().trim() != filterState.selectedFilter.lowercase().trim()
                        ) {
                            mealsViewModel.changeCurrentFilterSelected(it)
                            mealsViewModel.filterMeals(it)

                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(top = innerPadding.calculateTopPadding() + 6.dp)) {

            Box(modifier = Modifier.fillMaxSize()) {
                    MealCards(
                        imageLoader = imageLoader,
                        mealsViewModel = mealsViewModel,
                        mealCards = currentMealList,
                        onMealCardClick =
                        {
                            onMealCardClicked(it)
                        },
                        chooseAPlanClick = {
                            chooseAPlanClick(it)
                        }
                    )
                    if (showChooseAPlan) {
                        ChoosePlanPopUp(currentSelectedMeal) {
                            closeChoosePopUpPlanClicked()
                        }

                    }



            }


        }
    }
//    }

}


@Preview(showBackground = true)
@Composable
fun ShowMealScreen() {
    val app = Application()
    val mealsViewModel: MealsViewModel by hiltViewModel()
    MealsPlanScreen(
        mealsViewModel = mealsViewModel,
        imageLoader = ImageLoader.Builder(app).build(), {}, {}, {})
}