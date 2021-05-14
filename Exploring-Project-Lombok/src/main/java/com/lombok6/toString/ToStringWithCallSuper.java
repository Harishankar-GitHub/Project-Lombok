package com.lombok6.toString;

import lombok.ToString;

@ToString(callSuper = true)
public class ToStringWithCallSuper
{
    private String employeeName;
    private String companyName;
    private int yearsOfExperience;
    private String teamName;
    private String managerName;

    public ToStringWithCallSuper()
    {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
