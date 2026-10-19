package com.lombok.examples.constructors;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class NoArgsConstructorExample {
    private String employeeName;
    private String companyName;
    private int yearsOfExperience;
    private String teamName;
    private String managerName;
}
