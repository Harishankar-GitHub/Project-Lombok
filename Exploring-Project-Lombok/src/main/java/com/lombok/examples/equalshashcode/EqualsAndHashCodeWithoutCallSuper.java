package com.lombok.examples.equalshashcode;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
// callSuper = false is the default: only this class's fields (companyName) are compared,
// and the parent's employeeName is ignored. So, Jack and Jill at the same company are "equal".
// Lombok warns about this at compile time when a class extends something other than Object,
// unless callSuper is set explicitly as it is here.
public class EqualsAndHashCodeWithoutCallSuper extends EqualsAndHashCodeParent {
    private String companyName;

    public EqualsAndHashCodeWithoutCallSuper(String employeeName, String companyName) {
        super(employeeName);
        this.companyName = companyName;
    }
}
