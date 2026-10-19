package com.lombok2.var;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class Var {
    // var works exactly like val.
    // But it is not marked as final.

    // Syntax:
    // Vanilla Java : dataType variableName
    // With Lombok  : var variableName

    // NOTE: Since Java 10, var is part of the Java language itself.
    // This project runs on Java 21, so the var below is Java's own var, not Lombok's
    // (there is no "import lombok.var"). Lombok's var is only useful on Java 8 and 9.

    public void example() {
        var s = "I'm a String from var";
        var i = 123;
        var list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);

        System.out.println(s);
        System.out.println("I'm an int from var! " + i);
        System.out.println("I'm a list from var! Here are the elements..");
        list.forEach(System.out::println);
    }
}
