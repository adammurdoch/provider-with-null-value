package org.gradle.sample.api;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
        // Blows up with a NPE when used via Kotlin DSL
//        for (Type superInterface : function.getClass().getGenericInterfaces()) {
//            if (superInterface instanceof ParameterizedType) {
//                ParameterizedType type = (ParameterizedType) superInterface;
//                if (type.getRawType().equals(ValueProvider.MappingFunction.class) && type.getActualTypeArguments()[1] instanceof Class) {
//                    return (Class<S>) type.getActualTypeArguments()[1];
//                }
//            }
//        }
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
