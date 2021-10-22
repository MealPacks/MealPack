package `in`.mealpack.core.states

data class FilterState(
    var selectedFilter:String = "All",
    var filters: List<String> = listOf()
)
