plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.lab07"
    compileSdk = 34 // AGP 8.4.2 → maks compileSdk = 34 (bukan 36)

    defaultConfig {
        applicationId = "com.example.lab07"
        minSdk = 24
        targetSdk = 34 // Sesuaikan dengan compileSdk
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17" // AGP 8.4+ memerlukan JDK 17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14" // Kompatibel dengan Kotlin 1.9.24
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // 🔑 Compose BOM — kelola semua versi Compose secara otomatis
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))

    // Gunakan TANPA versi — BOM yang atur
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.9.2")

    debugImplementation("androidx.compose.ui:ui-tooling")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

// Compose UI Testing (HARUS pakai versi eksplisit)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.7")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.7")
}