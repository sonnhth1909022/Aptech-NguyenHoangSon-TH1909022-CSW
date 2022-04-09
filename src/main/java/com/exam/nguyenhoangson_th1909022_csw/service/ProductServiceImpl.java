package com.exam.nguyenhoangson_th1909022_csw.service;

import com.exam.nguyenhoangson_th1909022_csw.entity.Product;
import com.exam.nguyenhoangson_th1909022_csw.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findProductById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Optional<Product> findProductByName(String productName) {
        return productRepository.findProductByProductName(productName);
    }
}
