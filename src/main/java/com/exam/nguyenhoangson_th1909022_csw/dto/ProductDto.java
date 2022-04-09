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

    @NotBlank(message = "Tên không được để trống!")
    private String name;
    @NotNull(message = "Giá không được null!")
    private double price;
    @NotNull(message = "Số lượng không được null!")
    private int quantity;
}
