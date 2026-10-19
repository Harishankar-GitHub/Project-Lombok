package com.lombok.examples.equalshashcode;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EqualsAndHashCodeExclude {
    private long employeeId;
    private String employeeName;

    @EqualsAndHashCode.Exclude private int loginCount;
    // Excluded fields are ignored by equals() and hashCode().
    // So, two objects that only differ in loginCount are equal.

    public EqualsAndHashCodeExclude(long employeeId, String employeeName, int loginCount) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.loginCount = loginCount;
    }
}
