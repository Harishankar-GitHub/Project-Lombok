package com.lombok11.builder;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder(toBuilder = true)
// Generates a static builder() method and a BuilderExampleBuilder class with a fluent method per field.
// toBuilder = true also generates toBuilder(), which returns a builder pre-filled with this object's values.
@ToString
public class BuilderExample {
    private String employeeName;
    private String companyName;

    @Builder.Default private int yearsOfExperience = 1;
    // Without @Builder.Default, the initializer is ignored and the field is 0 when not set on the builder.

    @Singular private List<String> skills;
    // @Singular generates skill(String) to add one element, skills(Collection) to add many,
    // and clearSkills(). The built list is immutable.
}
