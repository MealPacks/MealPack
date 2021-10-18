package `in`.mealpack.MealPack.ui

import `in`.mealpack.MealPack.R
import `in`.mealpack.MealPack.ui.bottom_nav.BottomNavItem
import `in`.mealpack.MealPack.ui.bottom_nav.CustomBottomNavigation
import `in`.mealpack.MealPack.ui.navigation.Router
import `in`.mealpack.MealPack.ui.navigation.currentRoute
import `in`.mealpack.MealPack.ui.theme.MealPackTheme
import `in`.mealpack.ui_drawer.SideDrawer
import `in`.mealpack.ui_meals.meals.MealsPlanScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun MainScreen(
    userId: String,
    externalRouter: Router
) {
    val bottomNavTabs = BottomNavItem.list

    val navController = rememberNavController()

    MealPackTheme {
        Scaffold(
            bottomBar = {

                CustomBottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom= 8.dp,top=1.dp),
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 10.dp
                ) {
                    bottomNavTabs.forEach { bottomNavItem ->
                        val currentRoute = navController.currentRoute()
                        val selected = currentRoute == bottomNavItem.route
                                ||
                                bottomNavItem.routesIncluded.contains(currentRoute)

                        val contentColor =
                            if (selected)
                                MaterialTheme.colors.primary
                            else
                                MaterialTheme.colors.onBackground

                        BottomNavigationItem(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(
                                    if (selected)
                                        MaterialTheme.colors.primary.copy(0.1f)
                                    else
                                        Color.Transparent
                                ),
                            selected = selected,
                            onClick = {
                                if (currentRoute != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            },
                            label = {
                                Text(text = if (selected) bottomNavItem.title else "")
                            },
                            icon = {
                                // TODO: fix contentDescription
                                Icon(
                                    painter = painterResource(id = bottomNavItem.icon),
                                    contentDescription = null,
                                    tint = if (bottomNavItem == BottomNavItem.MealsPlan)
                                        Color.Unspecified
                                    else
                                        contentColor
                                )
                            },
                            selectedContentColor = MaterialTheme.colors.primary,
                            unselectedContentColor = MaterialTheme.colors.onBackground
                        )
                    }


                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ },backgroundColor = MaterialTheme.colors.primary.copy(0.3f)) {
                    Row(
                        modifier= Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Cart",
                            color = MaterialTheme.colors.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box{

                            Icon(
                                modifier = Modifier.padding(4.dp),
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = "cart",
                                tint = MaterialTheme.colors.onPrimary
                            )
                            Box(modifier = Modifier.align(Alignment.TopEnd)) {

                                Text(
                                    text = "2",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
                NavHost(
                    navController = navController,
                    startDestination = BottomNavItem.MealsPlan.route
                ) {
                    composable(route = BottomNavItem.MealsPlan.route) {
                        MealsPlanScreen(
                            onMealCardClicked = {
                                externalRouter.navigateTo(
                                    Screen.MealDetailScreen.sendMealIdAndCartId(
                                        mealId = "lkajsdfoijw",
                                        cartId = 325
                                    )
                                )
                            }
                        )
                    }
                    composable(route = BottomNavItem.Menu.route) {
                        SideDrawer(
                            onProfileClick = {
                                externalRouter.navigateTo(
                                    Screen.ProfileScreen.route
                                )
                            },
                            onFeedbackClick = {
                                externalRouter.navigateTo(
                                    Screen.FeedbackScreen.route
                                )
                            },
                            onHelpClick = {
                                externalRouter.navigateTo(
                                    Screen.HelpAndSupportScreen.route
                                )
                            },
                            onLogOutClicked = {
                                Firebase.auth.signOut()
                                externalRouter.navigateTo(
                                    Screen.LoginScreen.route
                                )
                            }
                        )
                    }
                    composable(route = BottomNavItem.MyMealsPlans.route) {
                        Text(text = "My Meal Plans")
                    }
                }
            }
        }
    }
}