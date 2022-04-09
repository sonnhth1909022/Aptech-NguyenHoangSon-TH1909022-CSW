package com.exam.nguyenhoangson_th1909022_csw.service;

import com.exam.nguyenhoangson_th1909022_csw.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product saveProduct(Product product);
    Page<Product> getAllProduct(Pageable pageable);
    Optional<Product> findProductById(int productId);
    Optional<Product> findProductByName(String productName);
}
