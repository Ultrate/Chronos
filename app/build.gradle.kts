plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.meenbeese.chronos"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.meenbeese.chronos"
        minSdk = 24
        targetSdk = 34
        versionCode = 5
        versionName = "1.4.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    lint {
        abortOnError = false
    }

    androidResources {
        generateLocaleConfig = true
    }
}

dependencies {
    // Core
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Media
    implementation("androidx.media3:media3-exoplayer:1.3.1")
    implementation("androidx.media3:media3-exoplayer-hls:1.3.1")
    implementation("androidx.media3:media3-ui:1.3.1")

    // Material
    implementation("com.google.android.material:material:1.11.0")

    // FAB
    implementation("com.leinardi.android:speed-dial:3.3.0")

    // Image
    implementation("io.coil-kt:coil:2.6.0")

    // About
    implementation("io.github.medyo:android-about-page:2.0.0")

    // Async
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    // Misc
    implementation("com.afollestad:aesthetic:0.7.2")
    implementation("me.jfenn:timedatepickers:0.0.6")
    implementation("me.jfenn:AndroidUtils:0.0.5")
}
