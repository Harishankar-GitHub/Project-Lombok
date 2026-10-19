package com.lombok.examples.equalshashcode;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
// callSuper = true makes equals() and hashCode() also call the parent's versions,
// so the parent's employeeName is compared too.
public class EqualsAndHashCodeWithCallSuper extends EqualsAndHashCodeParent {
    private String companyName;

    public EqualsAndHashCodeWithCallSuper(String employeeName, String companyName) {
        super(employeeName);
        this.companyName = companyName;
    }
}
