pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.6.2"
}

stonecutter {
    kotlinController = true
    centralScript = "build.gradle.kts"

    create(rootProject) {
        versions("1.21.1", "1.21.8")
        vcsVersion  = "1.21.1"
    }
}

rootProject.name = "Titanium"