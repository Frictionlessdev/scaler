package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.exception.ProductServiceException;
import com.sb.learning.scaler.productservice.model.DTO.Product;

import java.util.List;

public interface ProductService<T extends Product> {
    T get(String id) throws ProductServiceException;
    List<T> getAll();
}
