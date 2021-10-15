apply{
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    "implementation"(project(Modules.core))
    "api"(project(Modules.meal_domain))

    //FireStore
    "implementation" (platform(Firebase.firebaseBom))
    "implementation" (Firebase.firebaseFirestoreKtx)
}