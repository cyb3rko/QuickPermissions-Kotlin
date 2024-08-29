plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jmailen.kotlinter") version "3.15.0" // lintKotlin, formatKotlin
}

android {
    namespace = "com.livinglifetechway.quickpermissionssample"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.livinglifetechway.quickpermissionssample"
        minSdk = 16
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        resourceConfigurations.add("en")
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.9.0")
    implementation(project(":quickpermissions-kotlin"))
}

configurations.all {
    exclude(group = "com.android.support")
}
