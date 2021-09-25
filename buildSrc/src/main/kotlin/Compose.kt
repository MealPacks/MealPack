object Compose {
    private const val activityComposeVersion = "1.3.1"
    const val activity = "androidx.activity:activity-compose:$activityComposeVersion"

    const val composeVersion = "1.0.2"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val compose_runtime_livedata="androidx.compose.runtime:runtime-livedata:$composeVersion"

    private const val navigationVersion = "2.4.0-alpha04"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-alpha03"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val lifecycleViewmodelComposeVersion = "2.4.0-beta01"
    const val lifecycleViewmodelCompose="androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleViewmodelComposeVersion"
}

object ComposeTest {
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
    const val ui_tooling = "androidx.compose.ui:ui-tooling:${Compose.composeVersion}"

}