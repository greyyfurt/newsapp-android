/**
 * @author ufuk.argun
 * Created on 8.09.2022
 */
object Libraries {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.composeVers}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeVers}"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVers}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
        const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    }
    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val composeJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeVers}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVers}"
        const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVers}"
    }
}