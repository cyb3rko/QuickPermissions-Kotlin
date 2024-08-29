plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jmailen.kotlinter") version "3.15.0" // lintKotlin, formatKotlin
}

android {
    namespace = "com.livinglifetechway.quickpermissions_kotlin"
    compileSdk = 34
    defaultConfig {
        minSdk = 16
        targetSdk = 34
        resourceConfigurations.add("en")
    }
    buildTypes {
        release {
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
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
}
