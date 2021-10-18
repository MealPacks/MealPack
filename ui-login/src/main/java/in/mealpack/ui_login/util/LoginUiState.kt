package `in`.mealpack.ui_login.util

sealed class LoginUiState{
    object SignedOut : LoginUiState()
    object InProgress : LoginUiState()
    object Error : LoginUiState()
    object SignIn : LoginUiState()
}
