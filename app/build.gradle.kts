plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.gms.google-services")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")

}

android {
    namespace = "com.leandro.whitelabelstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.leandro.whitelabelstore"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = false
        viewBinding = true
        dataBinding = true
    }

    productFlavors {
        flavorDimensions.addAll(arrayListOf("product", "side"))
        create("bike") {
            dimension = "product"
            applicationIdSuffix = ".bike"
            manifestPlaceholders["appName"] = "Bike"
        }
        create("car") {
            dimension = "product"
            applicationIdSuffix = ".car"
            manifestPlaceholders["appName"] = "Car"

        }
        create("client") {
            dimension = "side"
            manifestPlaceholders["appNameSuffix"] = ""
        }
        create("admin") {
            dimension = "side"
            applicationIdSuffix = ".admin"
            manifestPlaceholders["appNameSuffix"] = ".Admin"
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.swiperefreshlayout)

    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.legacy.support.v4)


    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation (libs.material)

    implementation(platform(libs.firebase.bom))

    implementation ("com.google.firebase:firebase-firestore-ktx")
    implementation ("com.google.firebase:firebase-storage-ktx")

    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-compiler:2.44")


    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    implementation (libs.kotlinx.coroutines.android)

    implementation (libs.glide)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

