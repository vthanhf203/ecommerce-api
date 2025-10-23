package com.web.ecommerce_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductUpdateRequest {
    @NotBlank private String name;
    @NotNull @Positive private Double price;
    @NotBlank private String description;
    @NotNull @Min(0) private Integer stock;
}
