package com.lombok8.constructors;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@ToString
public class AllArgsConstructorExample
{
    private final String employeeName;
    private final String companyName;
    private final int yearsOfExperience;
    private String teamName;
    private String managerName;

    // If fields are marked with @NonNull, then null checks are generated.
    // Otherwise the constructor accepts null and non null values.
}
