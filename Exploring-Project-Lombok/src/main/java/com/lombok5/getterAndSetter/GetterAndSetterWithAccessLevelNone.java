package com.lombok5.getterAndSetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.NONE) @Setter
public class GetterAndSetterWithAccessLevelNone
{
    private String company;
    private String technology;
    private int openings;

    public GetterAndSetterWithAccessLevelNone(String company, String technology, int openings) {
        this.company = company;
        this.technology = technology;
        this.openings = openings;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetterAndSetterWithAccessLevelNone{");
        sb.append("company='").append(company).append('\'');
        sb.append(", technology='").append(technology).append('\'');
        sb.append(", openings=").append(openings);
        sb.append('}');
        return sb.toString();
    }
}
