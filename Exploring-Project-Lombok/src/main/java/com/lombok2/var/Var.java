package com.lombok2.var;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class Var
{
    // var works exactly like val.
    // But it is not marked as final.

    // Syntax:
    // Vanilla Java : dataType variableName
    // With Lombok  : var variableName

    public void example()
    {
        var s = "I'm a String from var";
        var i = 123;
        var list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);

        System.out.println(s);
        System.out.println("I'm an int from var! " + i);
        System.out.println("I'm a list from var! Here are the elements..");
        list.stream().forEach(System.out::println);
    }
}
