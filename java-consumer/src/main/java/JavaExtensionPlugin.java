import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.sample.api.Providers;
import org.gradle.sample.api.ValueProvider;
import org.gradle.sample.plugins.JavaApiModel;
import org.gradle.sample.plugins.KotlinApiModel;
import org.jetbrains.annotations.Nullable;

public class JavaExtensionPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        //
        // Direct usage in Java
        //

        Providers providers = new Providers();

        ValueProvider<String> a = providers.provider(String.class, "abc");
        ValueProvider<@Nullable String> b = providers.nullableProvider(String.class);

        // OK: no warnings or errors
        int a1 = a.get().length();

        // OK: Warns about potential NPE
        int b1 = b.get().length();

        // OK: no warnings or errors
        int a2 = a.map(s -> 123).get();

        // BROKEN: no warnings or errors
        int a3 = a.map(s -> nullableInteger()).get();

        //
        // API defined in Java
        //

        JavaApiModel javaApi = project.getExtensions().getByType(JavaApiModel.class);

        // OK: no warnings or errors
        int javaA1 = javaApi.getProp().get().length();

        // OK: Warns about potential NPE
        int javaB1 = javaApi.getNullableProp().get().length();

        //
        // API defined in Kotlin
        //

        KotlinApiModel kotlinApi = project.getExtensions().getByType(KotlinApiModel.class);

        // OK: no warnings or errors
        int kotlinA1 = kotlinApi.getProp().get().length();

        // BROKEN: Does not warn about potential NPE
        int kotlinB1 = kotlinApi.getNullableProp().get().length();

        // OK: no warnings or errors
        int kotlinA2 = kotlinApi.getProp().map(s -> 123).get();

        // BROKEN: no warnings or errors
        int kotlinA3 = kotlinApi.getProp().map(s -> nullableInteger()).get();
    }

    @Nullable Integer nullableInteger() {
        return 123;
    }
}
