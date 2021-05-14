package com.lombok6.toString;

import lombok.ToString;

@ToString()
public class ToStringWithNameAndRank
{
    @ToString.Include(name = "Employee Name", rank = -5)       private String employeeName;
    @ToString.Include(name = "Company", rank = -4)             private String companyName;
    @ToString.Include(name = "Years of experience", rank = -3) private int yearsOfExperience;
    @ToString.Include(name = "Team", rank = -2)                private String teamName;
    @ToString.Include(name = "Manager", rank = -1)             private String managerName;

    public ToStringWithNameAndRank()
    {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
