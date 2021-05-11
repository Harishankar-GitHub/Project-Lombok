package com.lombok3.nonNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter     // Getters and Setters are generated for all the fields.
public class NonNullWithGetterAndSetter
{
    @NonNull private String reviewTitle;
    // The Setter method of the above field will have @NonNull annotation.
    // So, null value can't be set to the above field.
    private String reviewDescription;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NonNullWithGetterAndSetter{");
        sb.append("reviewTitle='").append(reviewTitle).append('\'');
        sb.append(", reviewDescription='").append(reviewDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
