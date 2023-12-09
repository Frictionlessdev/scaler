package com.sb.learning.scaler.productservice.service;

import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.Rating;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;
import com.sb.learning.scaler.productservice.model.DTO.RemoteRating;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ProductTransformerImplTest {

    public ProductTransformer productTransformer = new ProductTransformerImpl();

    public RemoteProduct remoteProduct = this.mockRemoteProduct();

    @Test
    public void transformRemoteProduct() {
        Product product = productTransformer.apply(remoteProduct);
        assertNotNull(product);
        assertEquals(product.getId(), remoteProduct.getId());
        assertEquals(product.getName(), remoteProduct.getTitle());
        assertEquals(product.getPrice(), remoteProduct.getPrice(), 0);
        assertEquals(product.getDescription(), remoteProduct.getDescription());
        assertEquals(product.getImage(), remoteProduct.getImage());
        assertEquals(product.getRating().getRate(), remoteProduct.getRating().getRate());
        assertEquals(product.getRating().getCount(), remoteProduct.getRating().getCount());
    }

    public RemoteProduct mockRemoteProduct() {
        return RemoteProduct.builder()
                .id("mock")
                .title("mockTitle")
                .description("mockDescription")
                .price(0.0f)
                .image("mockImageUrl")
                .rating(Mockito.mock(RemoteRating.class))
                .build();
    }

}