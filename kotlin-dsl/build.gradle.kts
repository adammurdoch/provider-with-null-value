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

a.get().length

// red highlight and compilation fails without null check
a.orNull?.length

// red highlight but compilation does not fail without null check
b.get()?.length

// red highlight and compilation fails without null check
b.orNull?.length

val c = a.map { 12 }
val d = a.map { 12 as Int? }

c.get().plus(11)

// red highlight and compilation fails without null check
c.orNull?.plus(11)

// red highlight but compilation does not fail without null check
d.get()?.plus(11)

//
// plugin API defined in Java
//

javaApi.prop.get().length

// no highlighting or compilation failure
javaApi.nullableProp.get()?.length

//
// plugin API defined in Kotlin
//

kotlinApi.prop.get().length

// red highlight and compilation fails without null check
kotlinApi.nullableProp.get()?.length
