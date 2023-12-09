package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.exception.ProductServiceException;
import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;
import com.sb.learning.scaler.productservice.service.mock.MockProductServiceAdapterImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @Mock
    ProductServiceAdapter productServiceAdapter;
    @InjectMocks
    ProductServiceImpl productService;

    @Before
    public void setup() throws ProductServiceException {
        doReturn(mock(Product.class)).when(productServiceAdapter).get(any());
        productService = new ProductServiceImpl(productServiceAdapter);
    }
    @Test
    public void get() throws ProductServiceException {
        productService.get("1");
        verify(productServiceAdapter, times(1)).get(Mockito.anyString());
    }

    @Test
    public void getAll() {
        productService.getAll();
        verify(productServiceAdapter, times(1)).getAll();
    }
}