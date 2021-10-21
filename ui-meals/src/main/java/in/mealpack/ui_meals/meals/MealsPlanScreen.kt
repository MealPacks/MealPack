package `in`.mealpack.ui_meals.meals

import `in`.mealpack.ui_meals.choose_plan.ChoosePlanPopUp
import `in`.mealpack.util.MealsUiState
import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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

    var currentItemSelected by remember {
        mutableStateOf("All")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 20.dp
            ) {

                val newFilterItems = mutableListOf<String>()
                newFilterItems.add("All")
                for (item in mealsViewModel.getFilers()) {
                    newFilterItems.add(item)
                }


                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(newFilterItems) { filterItem ->
                        MealsFilterButton(
                            filterText = filterItem,
                            enabled = filterItem != currentItemSelected
                        ) {
                            currentItemSelected = it
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