package com.lombok14.sneakyThrows;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URLEncoder;

public class SneakyThrowsExample {
    // @SneakyThrows lets a method throw checked exceptions without declaring them in a throws clause
    // and without wrapping them in a RuntimeException.

    @SneakyThrows
    public String encode(String text) {
        // URLEncoder.encode(String, String) declares the checked UnsupportedEncodingException.
        // It can never happen for "UTF-8", so @SneakyThrows saves a try/catch that is never used.
        return URLEncoder.encode(text, "UTF-8");
    }

    @SneakyThrows
    public void fail() {
        // The checked IOException is thrown as it is, even though fail() has no "throws IOException".
        // Callers can't catch IOException directly (the compiler doesn't know it can be thrown),
        // so they have to catch Exception and check the type.
        throw new IOException("I'm a checked exception thrown without a throws clause!");
    }
}
