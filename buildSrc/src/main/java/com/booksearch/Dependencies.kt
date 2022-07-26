package com.booksearch

object Dependencies {
    //android
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val androidLifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"
    const val androidActivityKtx = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val androidAppcompat = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val androidPaging = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"

    //Compose
    const val androidComposeRuntime = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    const val androidComposeFoundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.COMPOSE}"
    const val androidComposeRuntimeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}"
    const val androidComposeUi = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val androidComposeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val androidComposeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val androidComposeMaterial = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val androidComposeMaterial3 = "androidx.compose.material3:material3:${Versions.MATERIAL3}"
    const val androidComposeMaterial3WindowSize = "androidx.compose.material3:material3-window-size-class:${Versions.MATERIAL3}"
    const val androidComposePaging = "androidx.paging:paging-compose:${Versions.PAGING_COMPOSE}"


    const val androidComposeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE}"
    const val androidComposeActivityCompose = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val androidComposeNavigationCompose = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}"
    const val androidComposeViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.VIEWMODEL_COMPOSE}"

    //room
    const val androidRoomRuntime = "androidx.room:room-runtime:${Versions.ROOM}"
    const val androidRoomKtx = "androidx.room:room-ktx:${Versions.ROOM}"
    const val androidRoomCompiler = "androidx.room:room-compiler:${Versions.ROOM}"
    const val androidRoomPaging = "androidx.room:room-paging:${Versions.ROOM}"
    const val androidRoomTesting = "androidx.room:room-testing:${Versions.ROOM}"

    //hilt
    const val androidHiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val androidHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val androidHiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_LIFECYCLE_VIEW_MODEL}"
    const val androidHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.HILT_COMPILER}"
    const val androidHiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE}"

    //Datastore
    const val androidDatastorePreferences = "androidx.datastore:datastore-preferences:${Versions.DATA_STORE}"
    const val androidDatastore = "androidx.datastore:datastore:${Versions.DATA_STORE}"

    //kotlin
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val kotlinSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLINX_SERIALIZATION}"
    const val kotlinDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.KOTLINX_DATETIME}"

    //Retrofit
    const val libRetrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val libRetrofitConverterGson ="com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val libRetrofitKotlinCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROUTINES}"

    //sandwich
    const val libSandwich = "com.github.skydoves:sandwich:${Versions.SANDWICH}"
    
    //coil
    const val libCoilCompose = "io.coil-kt:coil-compose:${Versions.COIL_COMPOSE}"

    //Logger
    const val libTimber = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    //Gson
    const val libGson = "com.google.code.gson:gson:${Versions.GSON}"

    //google
    const val googleMaterial = "com.google.android.material:material:${Versions.MATERIAL}"

    //lottie
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.LOTTIE}"

    //test
    const val libJunit = "junit:junit:${Versions.JUNIT}"
    const val androidTestJunit = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val androidTestEspresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val androidUiTooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val androidHiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.HILT}"
}
