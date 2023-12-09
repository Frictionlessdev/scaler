package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.model.DTO.Electronics;
import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.Rating;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformerImpl implements ProductTransformer {
    @Override
    public Product apply(RemoteProduct remoteProduct) {
        return Product.builder()
                .id(remoteProduct.getId())
                .name(remoteProduct.getTitle())
                .description(remoteProduct.getDescription())
                .price(remoteProduct.getPrice())
                .image(remoteProduct.getImage())
                .rating(Rating.builder()
                        .rate(remoteProduct.getRating().getRate())
                        .count(remoteProduct.getRating().getCount()).build()).build();
    }
}
