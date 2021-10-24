package `in`.mealpack.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = 40,
    maxLines: Int = 1,
    hint: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    label: String = hint,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            if (it.length <= maxLength)
                onValueChange(it)
        },
        placeholder = {
            Text(text = hint)
        },
        singleLine = true,
        label = {
            Text(text = label)
        },
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        maxLines = maxLines
    )
}

@Preview(showBackground = true)
@Composable
fun NormalTextFieldPreview() {
    StandardTextField(text = "Normal Text Field", onValueChange = {}, hint = "Normal Text Field",maxLines = 1)
}