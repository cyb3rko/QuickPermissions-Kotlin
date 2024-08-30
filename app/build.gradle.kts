plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinter) // lintKotlin, formatKotlin
}

android {
    namespace = "com.livinglifetechway.quickpermissionssample"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.livinglifetechway.quickpermissionssample"
        minSdk = 21
        targetSdk = 35
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
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.google.material)
    implementation(project(":quickpermissions-kotlin"))
}

configurations.all {
    exclude(group = "com.android.support")
}
