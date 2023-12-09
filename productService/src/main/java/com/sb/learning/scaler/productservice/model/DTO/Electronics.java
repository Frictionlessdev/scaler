package com.sb.learning.scaler.productservice.model.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class Electronics extends Product {

    @NonNull
    private String modelCode;

    @Builder(builderMethodName = "electronicsBuilder")
    public Electronics(String id, @NonNull String name, @NonNull String description,
                       @NonNull float price, @NonNull String image, @NonNull Rating rating,
                       @NonNull String modelCode) {
        super(id, name, description, price, image, rating);
        this.modelCode = modelCode;
    }
}
