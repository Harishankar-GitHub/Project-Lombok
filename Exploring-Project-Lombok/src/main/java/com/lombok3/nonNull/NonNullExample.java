package com.lombok3.nonNull;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class NonNullExample
{
    public void example(@NonNull String str)
    {
        System.out.println("I've passed through @NonNull annotation! Because I'm, " + str);
    }
    // NOTE: @NonNull by default throws NullPointerException.
    // We can configure it to throw IllegalArgumentException or other available options in lombok.config file.
}
