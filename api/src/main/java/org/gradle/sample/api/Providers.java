package org.gradle.sample.api;

import org.jetbrains.annotations.Nullable;

public class Providers {
    public <T> ValueProvider<T> provider(Class<T> type, T value) {
        return new ValueProvider<>() {
            @Override
            public T get() {
                return value;
            }

            @Nullable
            @Override
            public T getOrNull() {
                return value;
            }

            @Override
            public <S> ValueProvider<S> map(MappingFunction<? super T, S> function) {
                S result = function.map(value);
                Class<S> type = inferType(function);
                return provider(type, result);
            }
        };
    }

    private <S> Class<S> inferType(ValueProvider.MappingFunction<?, S> function) {
        // Reflection blows up with a NPE when used via Kotlin DSL
        return (Class<S>) Object.class;
    }

    public <T> ValueProvider<@Nullable T> nullableProvider(Class<T> type) {
        return new ValueProvider<>() {
            @Override
            public T get() {
                return null;
            }

            @Nullable
            @Override
            public T getOrNull() {
                return null;
            }

            @Override
            public <S> ValueProvider<S> map(MappingFunction<? super T, S> function) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
