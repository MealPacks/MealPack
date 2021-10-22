package `in`.mealpack.ui_drawer.ui

import `in`.mealpack.ui_drawer.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    backClicked:()->Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text(text = "Profile")
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
        }
    ) {
        Box(modifier = Modifier.padding(top = it.calculateTopPadding())){

        }
    }
}