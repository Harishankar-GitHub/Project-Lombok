package com.lombok5.getterAndSetter;

import lombok.Getter;
import lombok.Setter;

public class GetterAndSetterOnFields
{
    @Getter @Setter private long id;
    @Getter @Setter private String productCategory;
    @Getter @Setter private String modelName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetterAndSetterOnFields{");
        sb.append("id=").append(id);
        sb.append(", productCategory='").append(productCategory).append('\'');
        sb.append(", modelName='").append(modelName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
