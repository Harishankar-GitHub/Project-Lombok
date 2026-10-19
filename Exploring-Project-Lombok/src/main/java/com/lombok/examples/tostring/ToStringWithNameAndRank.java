package com.lombok.examples.tostring;

import lombok.ToString;

@ToString
// Members with a higher rank are printed first (default rank is 0).
// So, ranks 5 to 1 print the fields in the same order as they are declared.
public class ToStringWithNameAndRank {
    @ToString.Include(name = "Employee Name", rank = 5)       private String employeeName;
    @ToString.Include(name = "Company", rank = 4)              private String companyName;
    @ToString.Include(name = "Years of experience", rank = 3)  private int yearsOfExperience;
    @ToString.Include(name = "Team", rank = 2)                 private String teamName;
    @ToString.Include(name = "Manager", rank = 1)              private String managerName;

    public ToStringWithNameAndRank() {
        this.employeeName = "Jack";
        this.companyName = "XYZ Company";
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
