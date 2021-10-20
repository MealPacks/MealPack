apply{
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.core))
    "api"(project(Modules.meal_data))

    //Coil
    "implementation"(Coil.coil)

    //LiveData with compose
    "implementation"(AndroidX.runtimeComposeLivedata)


    //FireStore
    "implementation" (platform(Firebase.firebaseBom))
    "implementation" (Firebase.firebaseFirestoreKtx)
}