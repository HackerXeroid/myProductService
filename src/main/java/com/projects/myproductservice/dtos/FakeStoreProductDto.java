package com.projects.myproductservice.dtos;

import com.projects.myproductservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String image;
    private String description;
}
