package com.lombok15.lazyGetter;

import lombok.Getter;

public class LazyGetterExample {
    // @Getter(lazy = true) computes the value the first time the getter is called, caches it,
    // and returns the cached value on every later call. It is thread-safe.
    // The field must be private final.
    @Getter(lazy = true) private final String expensiveValue = computeExpensiveValue();

    private String computeExpensiveValue() {
        System.out.println("Computing the expensive value... (printed only once)");
        return "I'm an expensive value!";
    }
}
