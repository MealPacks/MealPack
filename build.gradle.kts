// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath (Build.androidBuildTools)
        classpath (Build.kotlinGradlePlugin)
        classpath (Google.googleServices)
        classpath (Build.hiltAndroid)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
