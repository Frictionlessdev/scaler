package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;

import java.util.function.Function;

public interface ProductTransformer extends Function<RemoteProduct, Product> {
}
