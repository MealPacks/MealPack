apply{
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    //Modules
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.core))
    "api"(project(Modules.user_data))
    "api"(project(Modules.drawer_data))
    "api"(project(Modules.drawer_domain))

}