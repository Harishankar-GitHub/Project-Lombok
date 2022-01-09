package com.lombok5.getterAndSetter;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
public class GetterAndSetterOnClass {
    private long id;
    private String name;
    private LocalDate dateOfBirth;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetterAndSetterOnClassLevel{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append('}');
        return sb.toString();
    }
}
