package com.lombok7.equalsAndHashCode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter @Setter
public class EqualsAndHashCodeExample {
//    NOTE: @EqualsAndHashCode.Include and @EqualsAndHashCode.Exclude can also be used on fields/methods if required.

    private String employeeName;
    private String companyName;
    private int yearsOfExperience;
    private String teamName;
    private String managerName;

    public EqualsAndHashCodeExample(String employeeName, String companyName, int yearsOfExperience, String teamName, String managerName) {
        this.employeeName = employeeName;
        this.companyName = companyName;
        this.yearsOfExperience = yearsOfExperience;
        this.teamName = teamName;
        this.managerName = managerName;
    }

    public EqualsAndHashCodeExample() {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
