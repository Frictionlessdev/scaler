package com.sb.learning.scaler.productservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Product {
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private float price;
    @NonNull
    private String image;
    @NonNull
    private Rating rating;

    protected Product(){    }

    protected Product(String id, @NonNull String name, @NonNull String description, @NonNull float price,
                   @NonNull String image, @NonNull Rating rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.rating = rating;
    }
}
