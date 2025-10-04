pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
		maven("https://maven.kikugie.dev/snapshots") { name = "KikuGie Snapshots" }
    }
}

plugins {
	id("dev.kikugie.stonecutter") version "0.7.10"
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
