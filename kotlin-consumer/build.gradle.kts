plugins {
    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm").version("1.3.60")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.gradle.sample:java:123")
    implementation("org.gradle.sample:kotlin:123")
}
