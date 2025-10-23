package com.web.ecommerce_api.controller;

import com.web.ecommerce_api.dto.request.ProductCreateRequest;
import com.web.ecommerce_api.dto.request.ProductUpdateRequest;
import com.web.ecommerce_api.dto.response.ProductResponse;
import com.web.ecommerce_api.entity.Product;
import com.web.ecommerce_api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
//
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
//        return productService.updateProduct(id, product);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductCreateRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(req));
    }

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping
    public Page<ProductResponse> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return productService.list(page, size, sortBy, direction);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductUpdateRequest req) {
        return productService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

