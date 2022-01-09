package com.lombok10.value;

import lombok.Value;

@Value
// All fields are made private and final by default, and setters are not generated.
// The class itself is also made final by default.
public class ValueExample {
    String employeeName = "Harish";
    String companyName;
    int yearsOfExperience;
    String teamName;
    String managerName;
}
