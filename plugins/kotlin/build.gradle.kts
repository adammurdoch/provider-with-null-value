plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.61")
    id("java-gradle-plugin")
}

gradlePlugin {
    plugins {
        create("kotlin-api") {
            id = "org.gradle.sample.kotlin-api"
            implementationClass = "org.gradle.sample.plugins.KotlinApiPlugin"
        }
    }
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.gradle.sample:api:1.0")
}
