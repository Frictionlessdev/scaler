package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.exception.ProductServiceException;
import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;

import java.util.List;

public interface ProductServiceAdapter<T extends Product, U extends RemoteProduct> {
    T get(String id) throws ProductServiceException;
    List<T> getAll();
    T transform (U remoteProduct);
}
