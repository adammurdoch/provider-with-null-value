package org.gradle.sample.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.sample.api.Providers;

public class JavaApiPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("javaApi", JavaApiModel.class, new Providers());
    }
}
