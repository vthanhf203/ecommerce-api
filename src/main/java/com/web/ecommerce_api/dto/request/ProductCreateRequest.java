package com.web.ecommerce_api.dto.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductCreateRequest {
    @NotBlank(message = "name khong duoc de trong")
    private String name;

    @NotNull(message = "price khong duoc de trong")
    private Double price;

    @NotBlank(message = "description khong duoc de trong")
    private String description;

    @NotNull @Min(value = 0, message = "stock > 0")
    private Integer stock;
}
