plugins {
    id(Config.Plugins.androidApp)
    id(Config.Plugins.kotlinPlug)
    id(Config.Plugins.hiltPlug)
    kotlin(Config.Plugins.kotlinKapt)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = ApplicationId.appId
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVers
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    
    // AndroidX
    implementation(Libraries.AndroidX.coreKtx)
    implementation(Libraries.AndroidX.composeUi)
    implementation(Libraries.AndroidX.composeMaterial)
    implementation(Libraries.AndroidX.composePreview)
    implementation(Libraries.AndroidX.lifecycleKtx)
    implementation(Libraries.AndroidX.composeActivity)
    implementation(Libraries.AndroidX.composeNavigation)
    implementation(Libraries.AndroidX.constraintLayout)

    // Coroutine
    implementation(Libraries.Coroutines.coroutinesCore)
    implementation(Libraries.Coroutines.coroutinesAndroid)

    // Hilt
    implementation(Libraries.Utils.hiltAndroid)
    kapt(Libraries.Utils.hiltAndroidCompiler)
    implementation(Libraries.Utils.hiltViewModel)
    kapt(Libraries.Utils.hiltCompiler)
    implementation(Libraries.Utils.hiltNavigation)

    // Retrofit
    implementation(Libraries.Retrofit.retrofit2)
    implementation(Libraries.Retrofit.gsonConverter)

    // Room
    implementation(Libraries.Room.roomRuntime)
    kapt(Libraries.Room.roomCompiler)
    implementation(Libraries.Room.roomKtx)

    // OkHttp
    implementation(Libraries.OkHttp.okHttp3)
    implementation(Libraries.OkHttp.okHttpLogging)

    // Timber
    implementation(Libraries.Utils.timber)

    // Utils
    implementation(Libraries.Utils.gson)
    implementation(Libraries.Utils.coil)
    implementation(Libraries.Utils.facebookStetho)
    implementation(Libraries.Utils.stethoOkhttp3)

    // Test
    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.espresso)
    androidTestImplementation(Libraries.Test.composeJunit4)
    debugImplementation(Libraries.Test.composeUiTooling)
    debugImplementation(Libraries.Test.composeTestManifest)
}