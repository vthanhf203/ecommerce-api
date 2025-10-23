package com.web.ecommerce_api.mapper;

import com.web.ecommerce_api.dto.request.ProductCreateRequest;
import com.web.ecommerce_api.dto.request.ProductUpdateRequest;
import com.web.ecommerce_api.dto.response.ProductResponse;
import com.web.ecommerce_api.entity.Product;

public class ProductMapper {
    public static Product toEntity(ProductCreateRequest req) {
        Product p1 = new Product();
        p1.setName(req.getName());
        p1.setPrice(req.getPrice());
        p1.setDescription(req.getDescription());
        p1.setStock(req.getStock());
        return p1;
    }

    public static void updateEntity(Product entity, ProductUpdateRequest req) {
        entity.setName(req.getName());
        entity.setPrice(req.getPrice());
        entity.setDescription(req.getDescription());
        entity.setStock(req.getStock());
    }

    public static ProductResponse toResponse(Product p) {
        ProductResponse r = new ProductResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setPrice(p.getPrice());
        r.setDescription(p.getDescription());
        r.setStock(p.getStock());
        return r;
    }
}
