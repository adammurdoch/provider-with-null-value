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

        int len1 = javaApi.getProp().get().length();

        // Warns about potential NPE
        int len2 = javaApi.getNullableProp().get().length();

        //
        // API defined in Kotlin
        //

        KotlinApiModel kotlinApi = project.getExtensions().getByType(KotlinApiModel.class);

        int len3 = kotlinApi.getProp().get().length();

        // Does not warn about potential NPE
        int len4 = kotlinApi.getNullableProp().get().length();
    }
}
