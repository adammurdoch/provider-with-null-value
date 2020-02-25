import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.sample.plugins.JavaApiModel
import org.gradle.sample.plugins.KotlinApiModel

class KotlinExtensionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val javaApi = project.extensions.getByType(JavaApiModel::class.java)

        javaApi.prop.get().length

        // Red highlight but no compilation error
        javaApi.nullableProp.get()?.length

        val kotlinApi = project.extensions.getByType(KotlinApiModel::class.java)

        kotlinApi.prop.get().length

        // Red highlight and compilation error
        kotlinApi.nullableProp.get()?.length
    }
}
