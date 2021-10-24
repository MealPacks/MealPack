package `in`.mealpack.ui_drawer.ui.feedback

import `in`.mealpack.drawer_data.feedback.FeedbackExperienceRating
import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun FeedbackRating(
    onRatingClick: (FeedbackExperienceRating) -> Unit,
    @DrawableRes icon: Int,
    feedbackExperienceRating: FeedbackExperienceRating
) {
    IconButton(onClick = {
        onRatingClick(feedbackExperienceRating)
    }) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Angry Rating",
            tint = Color.Unspecified
        )
    }
}