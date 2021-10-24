package `in`.mealpack.ui_drawer.ui.feedback

import `in`.mealpack.components.StandardButton
import `in`.mealpack.components.StandardTextField
import `in`.mealpack.components.VerticalDivider
import `in`.mealpack.drawer_data.feedback.FeedbackExperienceRating.RatingList
import `in`.mealpack.ui_drawer.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FeedbackScreen(
    backClicked: () -> Unit


) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Feedback")
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.background.copy(0.7f)),
                        onClick = {
                            backClicked()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "back"
                        )
                    }
                },
                elevation = 20.dp
            )
        },
        bottomBar = {
            StandardButton(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                buttonText = "Submit",
                onClick = {

                }
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(
                top = it.calculateTopPadding()+4.dp,
                bottom = 0.dp,
                start = 16.dp,
                end = 16.dp,
            )
        ){
            LazyColumn{
                items(1){
                    Feedback()
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FeedbackScreenPreview() {
    FeedbackScreen(){}
}

