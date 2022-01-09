package com.lombok6.toString;

import lombok.ToString;

@ToString
public class ToStringWithMethod {
    private String employeeName;
    private String companyName;
    private int yearsOfExperience;
    private String teamName;
    private String managerName;

    public ToStringWithMethod() {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }

    @ToString.Include
    public String someMethod() {
        return "I'm from a method!";
    }
}
