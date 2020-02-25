import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.sample.plugins.JavaApiModel;
import org.gradle.sample.plugins.KotlinApiModel;

public class JavaExtensionPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        //
        // API defined in Java
        //

        JavaApiModel javaApi = project.getExtensions().getByType(JavaApiModel.class);

        // OK: no warnings or errors
        int java1 = javaApi.getProp().get().length();

        // OK: Warns about potential NPE
        int java2 = javaApi.getNullableProp().get().length();

        //
        // API defined in Kotlin
        //

        KotlinApiModel kotlinApi = project.getExtensions().getByType(KotlinApiModel.class);

        // OK: no warnings or errors
        int kotlin1 = kotlinApi.getProp().get().length();

        // BROKEN: Does not warn about potential NPE
        int kotlin2 = kotlinApi.getNullableProp().get().length();
    }
}
