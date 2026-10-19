package com.lombok.examples.equalshashcode;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
// Parent class of EqualsAndHashCodeWithCallSuper and EqualsAndHashCodeWithoutCallSuper.
public class EqualsAndHashCodeParent {
    private String employeeName;

    public EqualsAndHashCodeParent(String employeeName) {
        this.employeeName = employeeName;
    }
}
