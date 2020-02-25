package org.gradle.sample.plugins

import org.gradle.sample.api.Providers
import org.gradle.sample.api.ValueProvider
import javax.inject.Inject

open class KotlinApiModel @Inject constructor(providers: Providers) {
    val prop: ValueProvider<String> = providers.provider(String::class.java, "abc")
    val nullableProp: ValueProvider<String?> = providers.nullableProvider(String::class.java)
}
