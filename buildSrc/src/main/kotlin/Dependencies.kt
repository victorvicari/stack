object Versions {
    const val androidxAppCompat = "1.1.0-beta01"
    const val androidxBrowser = "1.0.0"
    const val androidxLifecycleExtensions = "2.2.0-alpha01"
    const val androidxPreference = "1.1.0-rc01"
    const val androidxTestCore = "1.2.1-alpha02"
    const val constraintLayout = "2.0.0-beta2"
    const val crashlytics = "2.9.9"
    const val espresso = "3.1.0"
    const val fabric = "1.31.0"
    const val firebaseCore = "17.1.0"
    const val glide = "4.9.0"
    const val googleServices = "4.3.0"
    const val gradlePlugin = "3.5.0"
    const val gson = "2.8.5"
    const val jUnit = "4.12"
    const val kotlin = "1.3.50"
    const val kotlinxCoroutines = "1.2.2"
    const val ktxActivityExtensions = "1.0.0-rc01"
    const val ktxLifecycleExtensions = "2.2.0-alpha01"
    const val markwon = "4.1.0"
    const val materialComponents = "1.1.0-alpha09"
    const val okHttp = "4.0.0"
    const val retrofit = "2.6.0"
    const val robolectric = "4.3"
    const val room = "2.1.0-alpha04"
    const val testRunner = "1.1.0"
    const val timber = "4.7.1"
}

object Dep {
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val androidxBrowser = "androidx.browser:browser:${Versions.androidxBrowser}"
    const val androidxLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycleExtensions}"
    const val androidxPreference = "androidx.preference:preference:${Versions.androidxPreference}"
    const val androidxTestCore = "androidx.test:core:${Versions.androidxTestCore}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabric}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val googleServicesPlugin = "com.google.gms:google-services:${Versions.googleServices}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutines}"
    const val ktxActivityExtensions = "androidx.activity:activity-ktx:${Versions.ktxActivityExtensions}"
    const val ktxLiveDataExtensions = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktxLifecycleExtensions}"
    const val ktxViewModelExtensions = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktxLifecycleExtensions}"
    const val markwonCore = "io.noties.markwon:core:${Versions.markwon}"
    const val markwonGlide = "io.noties.markwon:image-glide:${Versions.markwon}"
    const val markwonStrikethrough = "io.noties.markwon:ext-strikethrough:${Versions.markwon}"
    const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCoroutines = "androidx.room:room-coroutines:${Versions.room}"
    const val roomProcessor = "androidx.room:room-compiler:${Versions.room}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
}
