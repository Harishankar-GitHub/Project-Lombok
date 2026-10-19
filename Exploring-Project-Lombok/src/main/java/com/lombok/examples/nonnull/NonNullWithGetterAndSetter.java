package com.lombok.examples.nonnull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter     // Getters and Setters are generated for all the fields.
public class NonNullWithGetterAndSetter {
    @NonNull private String reviewTitle;
    // The Setter method of the above field will have @NonNull annotation.
    // So, null value can't be set to the above field using the Setter.
    // NOTE: @NonNull on a field only adds null checks to the generated Setter/Constructor.
    // It doesn't stop the field from being null, e.g. when the object is created
    // using a no-args constructor and the Setter is never called.
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
