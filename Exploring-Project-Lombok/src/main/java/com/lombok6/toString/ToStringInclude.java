package com.lombok6.toString;

import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true)
public class ToStringInclude {
    @ToString.Include private String employeeName;
    @ToString.Include private String companyName;
    @ToString.Include private int yearsOfExperience;
    private String teamName;
    private String managerName;

    public ToStringInclude() {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
