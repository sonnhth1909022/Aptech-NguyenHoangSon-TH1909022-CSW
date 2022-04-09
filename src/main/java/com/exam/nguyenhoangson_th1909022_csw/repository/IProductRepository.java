package com.exam.nguyenhoangson_th1909022_csw.repository;

import com.exam.nguyenhoangson_th1909022_csw.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.name = :productName")
    Optional<Product> findProductByProductName(String productName);
}
