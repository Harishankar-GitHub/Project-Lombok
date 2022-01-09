package com.lombok3.nonNull;

import lombok.NonNull;

public class NonNullExampleWithConstructor {
    private String str;

    public NonNullExampleWithConstructor(@NonNull String str) {
        this.str = str;
        System.out.println(str);
    }
}
