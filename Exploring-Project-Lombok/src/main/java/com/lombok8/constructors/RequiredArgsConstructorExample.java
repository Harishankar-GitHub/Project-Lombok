package com.lombok8.constructors;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@ToString
public class RequiredArgsConstructorExample {
    private final String employeeName;
    private final String companyName;
    private final int yearsOfExperience;
    @NonNull private String teamName;
    @NonNull private String managerName;

    // All non-initialized final fields get a parameter, as well as any fields that are marked as @NonNull
    // that aren't initialized where they are declared.
}
