plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinter) // lintKotlin, formatKotlin
}

android {
    namespace = "com.livinglifetechway.quickpermissions_kotlin"
    compileSdk = 35
    defaultConfig {
        minSdk = 21
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
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
}
