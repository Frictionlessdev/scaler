package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceAdapterImpl<T extends Product, U extends RemoteProduct> implements ProductServiceAdapter<T, U> {
    @Override
    public T get(String id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T transform(U remoteProduct) {
        return null;
    }
}
