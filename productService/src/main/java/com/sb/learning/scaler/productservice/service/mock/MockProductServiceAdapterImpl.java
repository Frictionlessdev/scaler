package com.sb.learning.scaler.productservice.service.mock;

import com.sb.learning.scaler.productservice.exception.ProductServiceError;
import com.sb.learning.scaler.productservice.exception.ProductServiceException;
import com.sb.learning.scaler.productservice.model.DTO.Product;
import com.sb.learning.scaler.productservice.model.DTO.RemoteProduct;
import com.sb.learning.scaler.productservice.service.ProductServiceAdapter;
import com.sb.learning.scaler.productservice.service.ProductTransformer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component ("MockProductServiceAdapterImpl")
public class MockProductServiceAdapterImpl implements ProductServiceAdapter<Product, RemoteProduct> {

    private final RestTemplate restTemplate;
    private final String fakeStoreUrl;
    private final ProductTransformer productTransformer;

    public MockProductServiceAdapterImpl(RestTemplateBuilder restTemplateBuilder,
                                         @Value("https://fakestoreapi.com/products/") String fakeStoreUrl,
                                         ProductTransformer productTransformer){
        this.restTemplate = restTemplateBuilder.build();
        this.fakeStoreUrl = fakeStoreUrl;
        this.productTransformer = productTransformer;
    }

    @Override
    public Product get(String id) throws ProductServiceException {
        try {
            ResponseEntity<RemoteProduct> responseEntity =
                    restTemplate.getForEntity(fakeStoreUrl + "{id}", RemoteProduct.class, id);
            return transform(responseEntity.getBody());
        } catch (NumberFormatException e) {
            throw new ProductServiceException(ProductServiceError.INVALIDINPUT, "Product id is invalid");
        }
    }

    @Override
    public List<Product> getAll() {
        ResponseEntity<RemoteProduct[]> responseEntity = restTemplate.getForEntity(
                fakeStoreUrl, RemoteProduct[].class);

        List<Product> products = new ArrayList<>();
        for (RemoteProduct remoteProduct : responseEntity.getBody()){
            products.add(transform(remoteProduct));
        }

        return products;
    }

    @Override
    public Product transform(RemoteProduct remoteProduct) {
        return productTransformer.apply(remoteProduct);
    }
}
