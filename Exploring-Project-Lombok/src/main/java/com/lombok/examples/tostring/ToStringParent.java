package com.lombok.examples.tostring;

import lombok.ToString;

@ToString
// Parent class of ToStringWithCallSuper, with its own @ToString.
public class ToStringParent {
    private String employeeName;
    private String companyName;

    public ToStringParent(String employeeName, String companyName) {
        this.employeeName = employeeName;
        this.companyName = companyName;
    }
}
