package `in`.mealpack.MealPack.ui.navigation

interface Router {

    fun navigateTo(route: String)
}

fun createRouter(block: (String) -> Unit): Router = object : Router {

    override fun navigateTo(route: String) {
        block.invoke(route)
    }
}