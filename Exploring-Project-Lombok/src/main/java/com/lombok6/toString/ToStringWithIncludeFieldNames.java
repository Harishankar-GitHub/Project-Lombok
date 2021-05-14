package com.lombok6.toString;

import lombok.ToString;

@ToString(includeFieldNames = false)    // Default is includeFieldNames = true
public class ToStringWithIncludeFieldNames
{
    private String employeeName;
    private String companyName;
    private int yearsOfExperience;
    private String teamName;
    private String managerName;

    public ToStringWithIncludeFieldNames()
    {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
