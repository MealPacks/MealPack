package `in`.mealpack.ui_drawer.ui.help_and_support

import `in`.mealpack.components.LeadingIconText
import `in`.mealpack.ui_drawer.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ContactUs() {
    Column {
        Text(text = "Contact Us")

        ContactUsPopulation(
            contactUsText = "Whatsapp :",
            icon = R.drawable.ic_whatsapp,
            data = "98523646461"
        )
        ContactUsPopulation(
            contactUsText = "Phone :",
            icon = R.drawable.ic_phone,
            data = "545513513"
        )
        ContactUsPopulation(
            contactUsText = "Email :",
            icon = R.drawable.ic_mail,
            data = "xyz@gmail.com"
        )
    }
}

@Composable
fun ContactUsPopulation(
    contactUsText :String,
    data : String,
    @DrawableRes icon:Int
) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        LeadingIconText(text = contactUsText, icon = icon)
        Text(text = data)
    }
}

@Preview(showBackground = true)
@Composable
fun ContactUsPreview(){
    ContactUs()
}