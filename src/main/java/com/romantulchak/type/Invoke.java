package com.romantulchak.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Invoke<T> {
    SelectiveType<T> linq(T... classes);
}
