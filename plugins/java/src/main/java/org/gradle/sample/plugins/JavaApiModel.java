package org.gradle.sample.plugins;

import org.gradle.sample.api.Providers;
import org.gradle.sample.api.ValueProvider;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class JavaApiModel {
    private final ValueProvider<String> prop;
    private final ValueProvider<String> nullableProp;

    @Inject
    public JavaApiModel(Providers providers) {
        this.prop = providers.provider(String.class, "abc");
        this.nullableProp = providers.nullableProvider(String.class);
    }

    public ValueProvider<String> getProp() {
        return prop;
    }

    public ValueProvider<@Nullable String> getNullableProp() {
        return nullableProp;
    }
}
