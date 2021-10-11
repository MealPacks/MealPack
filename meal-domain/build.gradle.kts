apply{
    from("$rootDir/library-build.gradle")
}

dependencies{

    //Modules
    "implementation"(project(Modules.core))
}