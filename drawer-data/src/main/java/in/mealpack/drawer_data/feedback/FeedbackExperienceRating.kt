package `in`.mealpack.drawer_data.feedback

import `in`.mealpack.drawer_data.R
import androidx.annotation.DrawableRes


sealed class FeedbackExperienceRating(@DrawableRes val icon: Int, val rating: Int) {
    object Angry : FeedbackExperienceRating(R.drawable.ic_angry,1)
    object Upset : FeedbackExperienceRating(R.drawable.ic_upset,2)
    object Neutral : FeedbackExperienceRating(R.drawable.ic_neutral,3)
    object Happy : FeedbackExperienceRating(R.drawable.ic_happy,4)
    object Excited : FeedbackExperienceRating(R.drawable.ic_exited,5)

    companion object RatingList{
        val listRating = listOf(Angry,Upset,Neutral,Happy,Excited)
    }
}
