package `in`.mealpack.ui_meals.meals

import `in`.mealpack.ui_meals.choose_plan.ChoosePlanPopUp
import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
    closeChoosePopUpPlanClicked:()->Unit

) {
    val mealsList by mealsViewModel.allMeals.collectAsState()
    val uiState by mealsViewModel.uiState.collectAsState()

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

                val filterItems = mealsList.filter {
                    it.category != ""
                }.map {
                    it.category.trim()
                }.distinct()

                val neFilterItems = mutableListOf<String>()
                neFilterItems.add("All")
                for (item in filterItems) {
                    neFilterItems.add(item)
                }
                // TODO: 10/20/2021 new filter items check
                val newFilterItems = neFilterItems.distinct()

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(neFilterItems) { filterItem ->
                        MealsFilterButton(
                            filterText = filterItem,
                            enabled = filterItem != currentItemSelected
                        ) {
                            currentItemSelected = it

                        }
                    }
                }
            }
        }
    ) {innerPadding->
        Box(modifier = Modifier.padding(top = innerPadding.calculateTopPadding() + 6.dp)) {

            Box(modifier = Modifier.fillMaxSize()){
                MealCards(
                    imageLoader,
                    mealsViewModel = mealsViewModel,
                    mealCards = mealsList,
                    onMealCardClick =
                    {
                        onMealCardClicked(it)
                    },
                    chooseAPlanClick = {
                        chooseAPlanClick(it)
                    }
                )
                if (showChooseAPlan){
                        ChoosePlanPopUp(currentSelectedMeal){
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
        imageLoader = ImageLoader.Builder(app).build()
     ,{},{},{})
}