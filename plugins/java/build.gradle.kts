plugins {
    id("java-gradle-plugin")
}

group = "org.gradle.sample"

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
    api("org.gradle.sample:api:1.0")
}
