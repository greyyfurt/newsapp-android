object Config {
    object Plugins {
        const val androidApp = "com.android.application"
        const val androidLib = "com.android.library"
        const val kotlinPlug = "org.jetbrains.kotlin.android"
        const val kotlinKapt = "kapt"
        const val hiltPlug = "dagger.hilt.android.plugin"
    }
    object Dependencies {
        const val hiltGradlePlug = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVers}"
    }
}