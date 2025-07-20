plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.apuestas_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.apuestas_app"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.appcompat)

    // Dependencias adicionales necesarias para Android TV
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Dependencia específica para Android TV
    implementation("androidx.leanback:leanback:1.0.0")

    // Dependencias de prueba (opcionales)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}