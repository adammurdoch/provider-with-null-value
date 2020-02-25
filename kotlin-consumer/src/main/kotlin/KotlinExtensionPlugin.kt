import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.sample.plugins.JavaApiModel
import org.gradle.sample.plugins.KotlinApiModel

class KotlinExtensionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val javaApi = project.extensions.getByType(JavaApiModel::class.java)

        // OK: no warnings or errors
        javaApi.prop.get().length

        // BROKEN: without the null check - red highlight but compilation does not fail
        javaApi.nullableProp.get()?.length

        val kotlinApi = project.extensions.getByType(KotlinApiModel::class.java)

        // OK: no warnings or errors
        kotlinApi.prop.get().length

        // OK: without the null check - red highlight and compilation fails
        kotlinApi.nullableProp.get()?.length
    }
}
