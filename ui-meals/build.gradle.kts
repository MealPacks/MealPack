apply{
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.meal_data))

    //FireStore
    "implementation" (platform(Firebase.firebaseBom))
    "implementation" (Firebase.firebaseFirestoreKtx)
}