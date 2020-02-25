package org.gradle.sample.api;

import org.jetbrains.annotations.Nullable;

public interface ValueProvider<T> {
    T get();

    @Nullable T getOrNull();

    <S> ValueProvider<S> map(MappingFunction<? super T, S> function);

    interface MappingFunction<IN, OUT> {
        OUT map(IN value);
    }
}
