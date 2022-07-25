import com.booksearch.Dependencies
import com.booksearch.Versions


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.6.20"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 32

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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    configurations.forEach {
        it.exclude(group = "com.intellij", module = "annotations")
    }
}

dependencies {
    // android
    implementation(Dependencies.androidCoreKtx)
    implementation(Dependencies.androidLifecycleRuntimeKtx)
    implementation(Dependencies.androidActivityKtx)
    implementation(Dependencies.androidAppcompat)

    // Hilt dependencies
    implementation(Dependencies.androidHiltAndroid)
    kapt(Dependencies.androidHiltAndroidCompiler)
    implementation(Dependencies.androidHiltLifecycleViewModel)
    kapt(Dependencies.androidHiltCompiler)
    implementation(Dependencies.androidHiltNavigationCompose)

    // Kotlin
    implementation(Dependencies.kotlinCoroutinesAndroid)
    implementation(Dependencies.kotlinSerializationJson)
    implementation(Dependencies.kotlinDatetime)

    // test
    implementation(Dependencies.androidComposeUiTestJunit4)
    implementation(Dependencies.androidRoomTesting)
    debugImplementation(Dependencies.androidUiTooling)
    testImplementation(Dependencies.libJunit)
    androidTestImplementation(Dependencies.androidTestJunit)
    androidTestImplementation(Dependencies.androidTestEspresso)

    // Hilt testing dependencies
    androidTestImplementation(Dependencies.androidHiltAndroidTesting)
    kaptAndroidTest(Dependencies.androidHiltAndroidCompiler)

    // retrofit
    implementation(Dependencies.libRetrofit)
    implementation(Dependencies.libRetrofitConverterGson)
    implementation(Dependencies.libRetrofitKotlinCoroutinesAdapter)

    // Logger
    implementation(Dependencies.libTimber)

    implementation(project(":core-common"))
    implementation(project(":core-model"))
    implementation(project(":core-network"))
}
