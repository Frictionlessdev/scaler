package com.sb.learning.scaler.productservice.model.DTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class ElectronicsTest {

    @Test(expected = NullPointerException.class)
    public void createElectronics(){
        Electronics electronics = Electronics.electronicsBuilder().build();
    }

    @Test
    public void createValidElectronics(){
        Electronics electronics = Electronics.electronicsBuilder()
                .id("mockId")
                .name("mockName")
                .description("mockDescription")
                .price(10.0f)
                .image("mockImageUrl")
                .rating(Rating.builder().build())
                .modelCode("mockModelCode").build();
    }

}