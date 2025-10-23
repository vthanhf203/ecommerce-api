package com.web.ecommerce_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column (length = 500)
    private String description;

    @Column (nullable = false)
    private Integer stock;

    @Column (name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
