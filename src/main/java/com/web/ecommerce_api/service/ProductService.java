package com.web.ecommerce_api.service;

import com.web.ecommerce_api.dto.request.ProductCreateRequest;
import com.web.ecommerce_api.dto.request.ProductUpdateRequest;
import com.web.ecommerce_api.dto.response.ProductResponse;
import com.web.ecommerce_api.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
//    List<Product> getAllProducts();
//    Product getProductById(Long id);
//    Product createProduct(Product product);
//    Product updateProduct(Long id, Product product);
//    void deleteProduct(Long id);
    ProductResponse create(ProductCreateRequest req);
    ProductResponse getById(Long id);
    Page<ProductResponse> list(int page, int size, String sortBy, String direction);
    ProductResponse update(Long id, ProductUpdateRequest req);
    void delete(Long id);
}
