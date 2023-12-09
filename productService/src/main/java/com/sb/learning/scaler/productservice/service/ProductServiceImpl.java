package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.exception.ProductServiceException;
import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.service.mock.MockProductServiceAdapterImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService<Product> {

    ProductServiceAdapter productServiceAdapter;
    
    public ProductServiceImpl(@Qualifier("MockProductServiceAdapterImpl") ProductServiceAdapter productServiceAdapter){
        this.productServiceAdapter = productServiceAdapter;
    }

    @Override
    public Product get(String id) throws ProductServiceException {
        return productServiceAdapter.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productServiceAdapter.getAll();
    }
}
