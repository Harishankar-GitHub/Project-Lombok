package com.lombok6.toString;

import lombok.ToString;

@ToString
public class ToStringExclude
{
    private String employeeName;
    private String companyName;
    private int yearsOfExperience;
    @ToString.Exclude private String teamName;
    @ToString.Exclude private String managerName;

    public ToStringExclude()
    {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
