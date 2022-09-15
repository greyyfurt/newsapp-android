object Libraries {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.composeVers}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeVers}"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVers}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
        const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
        const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"
    }
    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val composeJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeVers}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVers}"
        const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVers}"
    }
    object Utils {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVers}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVers}"
        const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.composeVers}"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.composeVers}"
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
        const val facebookStetho = "com.facebook.stetho:stetho:${Versions.facebookStetho}"
        const val stethoOkhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.facebookStetho}"
    }
    object Retrofit {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
    }
    object OkHttp {
        const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3}"
        const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3}"
    }
    object Coroutines {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    }
    object Room {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVers}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVers}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVers}"
    }
    object Google {
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.systemUiController}"
    }
}