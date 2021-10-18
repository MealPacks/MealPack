apply{
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.components))
    "api"(project(Modules.meal_domain))

    //FireStore
    "implementation" (platform(Firebase.firebaseBom))
    "implementation" (Firebase.firebaseFirestoreKtx)

    "implementation" ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

}