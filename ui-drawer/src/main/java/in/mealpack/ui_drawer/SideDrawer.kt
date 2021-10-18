package `in`.mealpack.ui_drawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SideDrawer(
    onProfileClick: () -> Unit,
    onFeedbackClick: () -> Unit,
    onHelpClick: () -> Unit,
    onLogOutClicked: () -> Unit
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ProfileInfo()

            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DrawerItem(
                    title = "Profile",
                    id = R.drawable.ic_profile,
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    onProfileClick()
                }

                SideDrawerDivider()

                DrawerItem(
                    title = "Give Feedback",
                    id = R.drawable.ic_feedback,
                    modifier = Modifier.fillMaxWidth(0.7f)

                ) {
                    onFeedbackClick()
                }

                SideDrawerDivider()

                DrawerItem(
                    title = "Help & Support",
                    id = R.drawable.ic_help,
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    onHelpClick()
                }

                SideDrawerDivider()
            }
        }
        Row(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onLogOutClicked()
            }
            .background(MaterialTheme.colors.onPrimary.copy(0.3f))
            .padding(8.dp)

        ) {
            Text(
                text = "Logout",
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(R.drawable.ic_log_out),
                contentDescription = "LogOut",
                tint = MaterialTheme.colors.onPrimary
            )
        }

    }
}


@Composable
fun SideDrawerDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 32.dp)

    )
}

@Composable
fun ProfileInfo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop
        )
        Text(
            text = "roamao@gmail.com",
            color = MaterialTheme.colors.onPrimary
        )
        Text(
            text = "615561564651564",
            color = MaterialTheme.colors.onPrimary

        )
        Text(
            text = "Roamao jit",
            color = MaterialTheme.colors.onPrimary
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
        )
    }

}

@Composable
fun DrawerItem(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes id: Int,
    onDrawerItemClicked: () -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .clickable { }
            .background(MaterialTheme.colors.onPrimary.copy(0.3f))
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id),
            contentDescription = title,
            tint = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = MaterialTheme.colors.onPrimary
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SideDrawerPreview() {

        SideDrawer({},{},{},{})
}