plugins {
    id("java-library")
}

group = "org.gradle.sample"

repositories {
    jcenter()
}

dependencies {
    api("org.jetbrains:annotations:19.0.0")
}
