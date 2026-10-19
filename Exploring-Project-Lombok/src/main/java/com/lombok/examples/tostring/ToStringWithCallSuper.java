package com.lombok.examples.tostring;

import lombok.ToString;

@ToString(callSuper = true)
// callSuper = true includes the parent's toString() output as super=...
// Without it, the parent's fields (employeeName, companyName) wouldn't be printed.
public class ToStringWithCallSuper extends ToStringParent {
    private int yearsOfExperience;
    private String teamName;
    private String managerName;

    public ToStringWithCallSuper() {
        super("Jack", "XYZ Company");
        this.yearsOfExperience = 3;
        this.teamName = "Awesome Team !";
        this.managerName = "Cool Manager";
    }
}
