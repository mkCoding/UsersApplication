plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.usersapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.usersapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.6")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")

    // Coroutines
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //Ok Http
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.6")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")

    //Koin
    implementation("io.insert-koin:koin-android:3.5.6")

    //Hilt
//    implementation("com.google.dagger:hilt-android:2.44")
//    kapt("com.google.dagger:hilt-android-compiler:2.44")





}