
## Nullable providers in Gradle

Experiments that explore options for defining a Gradle `Provider` which can carry a null value. Verifies how IDEA and
the Kotlin compilers behave when plugins that define Java or Kotlin API are used by the Kotlin DSL and by
other plugins implemented in Java and Kotlin.

### What to look at?

Currently, there is a single pattern implemented, where APIs can declare a `Provider<@Nullable T>` plus a factory method for creating such providers. 
This pattern works to some degree, however there are a number of cases that should fail or give warnings but do not.

A basic provider-like API is defined in the `api` included build. This is implemented in Java, as if it were part of the Gradle
distribution. 

The `plugins` included build defines a plugin implemented in Java and another implemented in Kotlin. Each defines a project
extension with a nullable and a non-nullable provider. The assumption here is that if this works well with a provider,
we should also be able to make properties work well also (that assumption would be validated in a later experiment if we
were to go ahead with one of these options).

The `kotlin-dsl` project uses the API and the plugin models from the Kotlin DSL, to see how it behaves. Take a look at the
`build.gradle.kts` in that directory. The comments describe the behaviour for each usage and whether it is broken or not.

The `java-consumer` project defines a plugin implemented in Java, which uses these things. Take a look at the `JavaExtensionPlugin` class.

The `kotlin-consumer` project defines a plugin implemented in Kotlin, which uses these things. Take a look at the
`KotlinExtensionPlugin` class.
