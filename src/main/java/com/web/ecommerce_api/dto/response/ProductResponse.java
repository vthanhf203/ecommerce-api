package com.web.ecommerce_api.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer stock;
}
