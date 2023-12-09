package com.sb.learning.scaler.productservice.exception;

public class ProductServiceException extends Throwable {
    ProductServiceError errorCode;
    public ProductServiceException(ProductServiceError error, String description) {
        super (description);
        this.errorCode = error;
    }
}
