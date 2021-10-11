package `in`.mealpack.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordTextField(
    password: String = "",
    maxLength: Int = 40,
    onPasswordChange: (String) -> Unit,
    visibilityToggle: Boolean = true,
    visibilityToggleChange: (Boolean) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        value = password,
        onValueChange = {
            if (it.length <= maxLength) {
                onPasswordChange(it)
            }

        },
        placeholder = {
            Text(text = "Password")
        },
        singleLine = true,
        label = {
            Text(text = "Password")
        },
        trailingIcon = {
            IconButton(onClick = { visibilityToggleChange(!visibilityToggle) }) {
                if (visibilityToggle) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "Visibility"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "Visibility Off"
                    )
                }
            }
        },
        visualTransformation = if (visibilityToggle)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}