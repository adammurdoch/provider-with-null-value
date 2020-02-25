package org.gradle.sample.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.sample.api.Providers

class KotlinApiPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("kotlinApi", KotlinApiModel::class.java, Providers())
    }
}
