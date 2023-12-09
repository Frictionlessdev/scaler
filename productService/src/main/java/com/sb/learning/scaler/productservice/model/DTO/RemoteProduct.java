package com.sb.learning.scaler.productservice.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoteProduct {
    private String id;
    private String title;
    private float price;
    private String description;
    private String image;
    private RemoteRating rating;
}
