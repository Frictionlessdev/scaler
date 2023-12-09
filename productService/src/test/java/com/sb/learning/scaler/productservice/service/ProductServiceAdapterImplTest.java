package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.config.TestConfig;
import com.sb.learning.scaler.productservice.exception.ProductServiceException;
import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;
import com.sb.learning.scaler.productservice.model.DTO.RemoteRating;
import com.sb.learning.scaler.productservice.service.mock.MockProductServiceAdapterImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.MockServerRestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MockProductServiceAdapterImpl.class, ProductTransformerImpl.class})
@Import(TestConfig.class)
public class ProductServiceAdapterImplTest {

    @Autowired
    private ProductServiceAdapter<Product, RemoteProduct> productServiceAdapter;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void get() throws ProductServiceException {
        assertNotNull(productServiceAdapter.get("1"));
    }

    @Test
    public void getAll() {
        assertNotNull(productServiceAdapter.getAll());
    }

    @Test
    public void transform() {
        ProductServiceAdapter<Product, RemoteProduct> productServiceAdapterSpy =
                Mockito.spy(productServiceAdapter);
        productServiceAdapterSpy.transform(RemoteProduct.builder()
                .id("mock")
                .title("mockTitle")
                .description("mockDescription")
                .price(0.0f)
                .image("mockImageUrl")
                .rating(Mockito.mock(RemoteRating.class))
                .build());
        verify(productServiceAdapterSpy, times(1)).transform(Mockito.any());

    }
}