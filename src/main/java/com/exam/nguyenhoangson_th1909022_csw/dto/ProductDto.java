package com.exam.nguyenhoangson_th1909022_csw.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {

    @NotBlank(message = "name must not be blank!")
    private String name;
    @NotNull(message = "price must not be null!")
    private double price;
    @NotNull(message = "quantity must not be null!")
    private int quantity;
}
