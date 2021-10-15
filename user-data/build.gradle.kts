apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    "api"(project(Modules.user_domain))
    "implementation"(project(Modules.core))

    //FireStore
    "implementation" (platform(Firebase.firebaseBom))
    "implementation" (Firebase.firebaseFirestoreKtx)
}

