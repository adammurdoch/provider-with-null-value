plugins {
    id("java-gradle-plugin")
}

gradlePlugin {
    plugins {
        create("java-api") {
            id = "org.gradle.sample.java-api"
            implementationClass = "org.gradle.sample.plugins.JavaApiPlugin"
        }
    }
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.gradle.sample:api:1.0")
}
