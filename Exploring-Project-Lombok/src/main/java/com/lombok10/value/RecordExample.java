package com.lombok10.value;

// A Java record (Java 16+) is the language's built-in alternative to Lombok's @Value.
// Like @Value, it is final, its fields are private final, and it gets a constructor,
// equals(), hashCode() and toString().
// Differences:
//  - Accessors are named after the fields, companyName() instead of getCompanyName().
//  - A record can't extend another class, and can't have instance fields other than its components.
//  - toString() uses square brackets: RecordExample[companyName=..., ...].
//  - There's no field like employeeName = "Harish" in ValueExample, as a record can't initialize its components.
public record RecordExample(String companyName, int yearsOfExperience, String teamName, String managerName) {
}
