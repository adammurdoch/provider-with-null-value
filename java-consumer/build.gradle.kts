plugins {
    id("java-gradle-plugin")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.gradle.sample:java:123")
    implementation("org.gradle.sample:kotlin:123")
}
