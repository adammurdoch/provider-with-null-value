buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("org.gradle.sample:api:1.0")
    }
}

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
