package com.lombok5.getterAndSetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PACKAGE)
public class GetterAndSetterWithAccessLevel {
    private String developerName;
    private String role;
    private int yearsOfExperience;

    public GetterAndSetterWithAccessLevel(String developerName, String role, int yearsOfExperience) {
        this.developerName = developerName;
        this.role = role;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetterAndSetterWithAccessLevel{");
        sb.append("developerName='").append(developerName).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", yearsOfExperience=").append(yearsOfExperience);
        sb.append('}');
        return sb.toString();
    }
}
