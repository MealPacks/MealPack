package `in`.mealpack.ui_drawer.ui

import `in`.mealpack.components.StandardTextField
import `in`.mealpack.ui_drawer.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PersonalInformation() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(text = "Personal Information")

        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.bg_login3),
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop
        )

        StandardTextField(
            text = "",
            onValueChange = {},
            label = "Full Name",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        StandardTextField(
            text = "",
            onValueChange = {},
            label = "Email address",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        StandardTextField(
            text = "",
            onValueChange = {},
            label = "Phone Number",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_india),
                    contentDescription = "India icon",
                    tint = Color.Unspecified
                )
            }
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Address")

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {

                    }
                    .padding(16.dp)
                    ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Locate Me",
                    color = MaterialTheme.colors.primary
                )
                Icon(
                    painter = painterResource(
                        id = `in`.mealpack.components.R.drawable.ic_locate_me
                    ),
                    contentDescription = "Locate Me",
                    tint = MaterialTheme.colors.primary
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {

                    }
                    .padding(16.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)

            ) {

                Text(text = "edit",
                color = MaterialTheme.colors.primary)
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit_location),
                    contentDescription = "locate",
                    tint = MaterialTheme.colors.primary
                )

            }

            Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PersonalInformationPreview() {
    PersonalInformation()
}
