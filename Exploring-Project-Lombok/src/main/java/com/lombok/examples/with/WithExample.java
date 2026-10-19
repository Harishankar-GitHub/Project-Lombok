package com.lombok.examples.with;

import lombok.Value;
import lombok.With;

@Value
@With
// @With generates a withFieldName(value) method for each field.
// It returns a copy of the object with only that field changed, so immutable (@Value) objects can still be "modified".
// If the new value is the same as the current one, the same object is returned.
public class WithExample {
    String employeeName;
    String companyName;
    int yearsOfExperience;
}
