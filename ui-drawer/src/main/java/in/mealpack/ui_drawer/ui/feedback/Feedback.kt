package `in`.mealpack.ui_drawer.ui.feedback

import `in`.mealpack.components.StandardTextField
import `in`.mealpack.components.VerticalDivider
import `in`.mealpack.drawer_data.feedback.FeedbackExperienceRating
import `in`.mealpack.ui_drawer.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Feedback() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = "Rate Your Experience")
        Icon(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_main_rating),
            contentDescription = "Main Rating",
            tint = Color.Unspecified
        )

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            FeedbackExperienceRating.listRating.forEach {
                FeedbackRating(
                    onRatingClick = {
                        /*TODO*/
                    },
                    icon = it.icon,
                    feedbackExperienceRating = it
                )
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(0.7f),
                    text = ""
                )
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VerticalDivider()

                    Text(text = "Best")
                    VerticalDivider()

                    Text(text = "Good")
                    VerticalDivider()

                    Text(text = "Fair")
                    VerticalDivider()

                    Text(text = "Poor")

                    VerticalDivider()

                }

            }
            CategoryRatings(
                category = "Price"
            )
            CategoryRatings(
                category = "Quality of Food"
            )
            CategoryRatings(
                category = "Quality of Servie"
            )
            CategoryRatings(
                category = "Temperature of Food"
            )
        }

        StandardTextField(
            text = "Any Suggestions", onValueChange = {},
            maxLines = 10
        )
    }
}


@Composable
fun CategoryRatings(
    category: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(0.7f),
            text = category
        )
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            VerticalDivider()
            RadioButton(
                selected = true,
                onClick = {
                    /*TODO*/
                }
            )
            VerticalDivider()
            RadioButton(
                selected = true,
                onClick = {
                    /*TODO*/
                }
            )
            VerticalDivider()

            RadioButton(
                selected = true,
                onClick = {
                    /*TODO*/
                }
            )
            VerticalDivider()

            RadioButton(
                selected = true,
                onClick = {
                    /*TODO*/
                }
            )

            VerticalDivider()

        }
    }
}


@Preview
@Composable
fun FeedbackPreview() {
    Feedback()
}
