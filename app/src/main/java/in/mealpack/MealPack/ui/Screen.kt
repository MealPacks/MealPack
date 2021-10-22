package `in`.mealpack.MealPack.ui

const val SPLASH_SCREEN = "splash_screen"
const val LOGIN_SCREEN = "login_screen"


const val MAIN_SCREEN_USER_ID_KEY = "userId"
const val MAIN_SCREEN = "main_screen?userId="


const val MEAL_DETAIL_SCREEN = "meal_detail_screen"
const val MEAL_DETAIL_MEAL_ID_KEY ="mealId"
const val MEAL_DETAIL_CART_ID_KEY ="cartId"

const val PROFILE_SCREEN = "profile_screen"
const val FEEDBACK_SCREEN = "give_feedback_screen"
const val HELP_AND_SUPPORT_SCREEN = "help_and_support_screen"

sealed class Screen(
    val route: String
) {
    //SplashScreen
    object SplashScreen : Screen(route = SPLASH_SCREEN)

    //Login
    object LoginScreen : Screen(route = LOGIN_SCREEN)

    object MainScreen : Screen(route = "$MAIN_SCREEN{$MAIN_SCREEN_USER_ID_KEY}") {
        fun sendUserId(id: String): String {
            return "$MAIN_SCREEN$id"
        }
    }

    //MealDetails
    object MealDetailScreen : Screen(route = "$MEAL_DETAIL_SCREEN/{$MEAL_DETAIL_MEAL_ID_KEY}/{$MEAL_DETAIL_CART_ID_KEY}"){
        fun sendMealIdAndCartId(mealId:String,cartId:Int):String{
            return "$MEAL_DETAIL_SCREEN/$mealId/$cartId"
        }
    }

    object ProfileScreen : Screen(route = PROFILE_SCREEN)
    object FeedbackScreen : Screen(route = FEEDBACK_SCREEN)
    object HelpAndSupportScreen : Screen(route = HELP_AND_SUPPORT_SCREEN)


}
