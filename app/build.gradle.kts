plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.example.e_commerce_task"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.e_commerce_task"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-compiler:2.44")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")
    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")

    dependencies {
        // Intuit (sdp/ssp)
        implementation("com.intuit.sdp:sdp-android:1.1.0")
        implementation("com.intuit.ssp:ssp-android:1.1.0")
        // Coil
        implementation("io.coil-kt:coil:2.0.0-rc03")
        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        // Gson
        implementation("com.google.code.gson:gson:2.9.0")
        // JSON
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
        // Moshi
        implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
        implementation("com.serjltt.moshi:moshi-lazy-adapters:2.2")
        implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    }
}
