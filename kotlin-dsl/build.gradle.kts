plugins {
    id("org.gradle.sample.java-api")
    id("org.gradle.sample.kotlin-api")
}

//
// Define and use from Kotlin DSL
//

val providers = org.gradle.sample.api.Providers()

val a = providers.provider(String::class.java, "abc")
val b = providers.nullableProvider(String::class.java)

// OK: no warnings or errors
a.get().length

// OK: without the null check - red highlight and compilation fails
a.orNull?.length

// BROKEN: without the null check - red highlight but compilation does not fail
b.get()?.length

// OK: without the null check - red highlight and compilation fails
b.orNull?.length

val c = a.map { 12 }
val d = a.map { 12 as Int? }

// OK: no warnings or errors
c.get().plus(11)

// OK: without the null check - red highlight and compilation fails
c.orNull?.plus(11)

// BROKEN: without the null check - red highlight but compilation does not fail
d.get()?.plus(11)

//
// plugin API defined in Java
//

// OK: no warnings or errors
javaApi.prop.get().length

// BROKEN: without the null check - no highlighting or compilation failure
javaApi.nullableProp.get()?.length

//
// plugin API defined in Kotlin
//

// OK: no warnings or errors
kotlinApi.prop.get().length

// red highlight and compilation fails without null check
kotlinApi.nullableProp.get()?.length
