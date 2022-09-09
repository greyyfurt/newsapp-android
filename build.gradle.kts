buildscript {
    val compose_version by extra ("1.0.0")

    dependencies {
        classpath(Config.Dependencies.hiltGradlePlug)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Config.Plugins.androidApp) version (Versions.Plugins.androidAppVers) apply (false)
    id(Config.Plugins.androidLib) version (Versions.Plugins.androidLibVers) apply (false)
    id(Config.Plugins.kotlinPlug) version (Versions.Plugins.kotlinPlugVers) apply (false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}