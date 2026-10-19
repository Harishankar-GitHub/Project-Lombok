package com.lombok.examples.data;

import lombok.Data;

@Data
// @Data is a shortcut for @Getter, @Setter (on non-final fields), @RequiredArgsConstructor, @ToString and @EqualsAndHashCode.
// As equals() and hashCode() use every field and the setters make them mutable,
// the same HashSet caution as in EqualsAndHashCodeExample applies. Avoid @Data on JPA entities (see the README).
public class DataExample {
    private final String employeeName;
    private final String companyName;
    private final int yearsOfExperience;
    private String teamName;
    private String managerName;
}
