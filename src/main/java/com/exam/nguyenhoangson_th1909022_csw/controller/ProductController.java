package com.exam.nguyenhoangson_th1909022_csw.controller;

import com.exam.nguyenhoangson_th1909022_csw.dto.ProductDto;
import com.exam.nguyenhoangson_th1909022_csw.entity.Product;
import com.exam.nguyenhoangson_th1909022_csw.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1.0/product/")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("list")
    public ResponseEntity<?> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pageable paging = PageRequest.of(page,size);
        Page<Product> products = productService.getAllProduct(paging);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addNew(@Valid @RequestBody ProductDto productDto){
        Optional<Product> checkProduct = productService.findProductByName(productDto.getName());
        if(checkProduct.isPresent()){
            return new ResponseEntity<>("Sản phẩm đã tồn tại!", HttpStatus.BAD_REQUEST);
        }
        Product productNew = new Product();
        productNew.setName(productDto.getName());
        productNew.setPrice(productDto.getPrice());
        productNew.setQuantity(productDto.getQuantity());
        productService.saveProduct(productNew);
        return new ResponseEntity<>("Thêm sản phẩm thành công!", HttpStatus.OK);
    }

    @PutMapping("sell")
    public ResponseEntity<?> sellProduct(@RequestParam int productId, @RequestParam int quantity){
        Optional<Product> product = productService.findProductById(productId);
        if (product.isPresent()){
            int productQuantity = product.get().getQuantity();
            if(productQuantity < quantity){
                return new ResponseEntity<>("Không đủ hàng!", HttpStatus.BAD_REQUEST);
            }
            else {
                product.get().setQuantity(productQuantity - quantity);
                productService.saveProduct(product.get());
                int quantityUpdate = product.get().getQuantity();
                return new ResponseEntity<>("Bán hàng thành công! Số lượng còn lại: " + quantityUpdate, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Không tìm thấy sản phẩm!", HttpStatus.NOT_FOUND);
    }
}
