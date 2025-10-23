package com.web.ecommerce_api.service_impl;

import com.web.ecommerce_api.dto.request.ProductCreateRequest;
import com.web.ecommerce_api.dto.request.ProductUpdateRequest;
import com.web.ecommerce_api.dto.response.ProductResponse;
import com.web.ecommerce_api.entity.Product;
import com.web.ecommerce_api.exception.NotFoundException;
import com.web.ecommerce_api.mapper.ProductMapper;
import com.web.ecommerce_api.repository.ProductRepository;
import com.web.ecommerce_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductCreateRequest req) {
        Product entity = ProductMapper.toEntity(req);
        return ProductMapper.toResponse(productRepository.save(entity));
    }


    @Override
//    public Product getProductById(Long id) {
//        return productRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//    }
    public ProductResponse getById(Long id) {
        Product p = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product id=" + id + " không tồn tại"));
        return ProductMapper.toResponse(p);
    }

    @Override
//    public Product createProduct(Product product) {
//        return productRepository.save(product);
//    }
    public Page<ProductResponse> list(int page, int size, String sortBy, String direction) {
        Sort sort = "desc".equalsIgnoreCase(direction) ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable).map(ProductMapper::toResponse);
    }

    @Override
//    public Product updateProduct(Long id, Product newProduct) {
//        Product existing = getProductById(id);
//        existing.setName(newProduct.getName()); //existing--sanpham lay ra tu db
//        existing.setPrice(newProduct.getPrice());
//        existing.setDescription(newProduct.getDescription());
//        existing.setStock(newProduct.getStock());
//        return productRepository.save(existing);
//    }
    public ProductResponse update(Long id, ProductUpdateRequest req) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product id=" + id + " không tồn tại"));
        ProductMapper.updateEntity(existing, req);
        return ProductMapper.toResponse(productRepository.save(existing));
    }

    @Override
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Product id=" + id + " không tồn tại");
        }
        productRepository.deleteById(id);
    }
}
