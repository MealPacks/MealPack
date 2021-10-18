package `in`.mealpack.ui_cart

import `in`.mealpack.components.StandardButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Cart")

                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back"
                        )
                    }
                },
                elevation = AppBarDefaults.TopAppBarElevation
            )

        },
        bottomBar = {

            BottomAppBar(modifier = Modifier.padding(4.dp),
            elevation = 20.dp) {
                Row (modifier = Modifier.fillMaxWidth()
                    .padding(horizontal=16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column {
                        Text(text = "Total :")
                        Text(text = "₹ 1999")
                    }
                    Spacer(modifier = Modifier.width(64.dp))
                    StandardButton(
                        modifier = Modifier, buttonText = "PlaceOrder",
                        onClick = { /*TODO*/ },
                        trailingIcon = R.drawable.ic_proceed
                    )
                }

            }
        }
    ) {
        Box(
            modifier = Modifier.padding(
                bottom = it.calculateBottomPadding(),
                top = it.calculateTopPadding()
            )
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(5) {
                    MealCartItem()
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen()
}