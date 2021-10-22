package `in`.mealpack.ui_drawer.ui

import `in`.mealpack.ui_drawer.R
import `in`.mealpack.components.StandardTextField
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun PersonalInformation() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Personal Information")
        
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
                Icon(painter = painterResource(id = R.drawable.ic_india), contentDescription = "India icon")
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = "+91")
            }
        )


        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Address")
            IconButton(onClick = { /*TODO*/ }) {
                Row (verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(4.dp)){
                    Text(text = "Locate Me")
                    Icon(painter = painterResource(id = `in`.mealpack.components.R.drawable.ic_locate_me), contentDescription = "Locate Me")
                }
            }
        }

        Column (modifier = Modifier.fillMaxWidth()){
            TextButton(modifier = Modifier.align(Alignment.End),onClick = { /*TODO*/ }) {
                Row (verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(4.dp)){
                    Text(text = "edit")
                    Icon(painter = painterResource(id = R.drawable.ic_edit_location), contentDescription = "locate")
                }

            }
            Text(text ="Address")
        }

    }
}
