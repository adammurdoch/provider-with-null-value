
## Nullable providers in Gradle

This repo contains experiments that explore options for changing the Gradle API so that plugins can define a `Provider` 
which may carry a null value.
Verifies how IDEA and the Kotlin compiler behave when plugins define nullable providers in Java or Kotlin API and 
are used from the Kotlin DSL and by other plugins implemented in Java and Kotlin.

### What to look at?

Currently, there is a single pattern implemented, where APIs can declare a `Provider<@Nullable T>`. There is also
a factory method for creating such providers. 

This pattern works to some degree, however there are a number of cases that should fail or give warnings but do not.
Note that this pattern does not seem to work with the JSR-305 annotations.
This experiment uses the Jetbrains annotations instead.

A basic provider-like API is defined in the `api` included build. This is called `ValueProvider` and is implemented in Java, 
as if it were part of the Gradle distribution. The plan for this pattern is not to replace `Provider`; `ValueSupplier` is
simply a placeholder for `Provider` in this experiment. There is also a `Providers` factory that defines some factory methods.

The `plugins` included build defines a plugin implemented in Java and another implemented in Kotlin. Each defines a project
extension with a nullable and a non-nullable provider. The assumption here is that if this works well with a provider,
we should also be able to make properties work well (that assumption will be validated in a later experiment).

The `kotlin-dsl` project uses the API and the plugin models from the Kotlin DSL, to see how it behaves. Take a look at the
`build.gradle.kts` in that directory. The comments describe the behaviour for each usage and whether it is broken or not.

The `java-consumer` project defines a plugin implemented in Java, which uses these things. Take a look at the 
`JavaExtensionPlugin` class.

The `kotlin-consumer` project defines a plugin implemented in Kotlin, which uses these things. Take a look at the
`KotlinExtensionPlugin` class.
