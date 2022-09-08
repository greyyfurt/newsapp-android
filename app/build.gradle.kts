plugins {
    id(Config.Plugins.androidApp)
    id(Config.Plugins.kotlinPlug)
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

    // Test
    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.espresso)
    androidTestImplementation(Libraries.Test.composeJunit4)
    debugImplementation(Libraries.Test.composeUiTooling)
    debugImplementation(Libraries.Test.composeTestManifest)
}