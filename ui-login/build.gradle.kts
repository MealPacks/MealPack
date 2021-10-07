apply{
    from("$rootDir/android-library-build.gradle")
}

plugins{
    id("com.google.gms.google-services")
}

dependencies{

    //Modules
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.core))


    //Auth
    "implementation"(platform(Firebase.firebaseBom))
    "implementation"(Firebase.firebaseAuth)
    "implementation"(Firebase.playServicesAuth)
    "implementation"(Firebase.firebaseFirestoreKtx)


    //kotlin coroutines
    "implementation"(Kotlin.kotlinxCoroutinesCore)
    "implementation"(Kotlin.kotlinxCoroutinesAndroid)
    "implementation"(Kotlin.kotlinxCoroutinesPlayServices)

}


//plugins {
//    id 'com.android.library'
//    id 'kotlin-android'
//}
//
//android {
//    compileSdk 31
//
//    defaultConfig {
//        minSdk 21
//        targetSdk 31
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles "consumer-rules.pro"
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//}
//
//dependencies {
//
//    implementation 'androidx.core:core-ktx:1.6.0'
//    implementation 'androidx.appcompat:appcompat:1.3.1'
//    implementation 'com.google.android.material:material:1.4.0'
//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
//}