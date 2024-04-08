package com.projects.myproductservice.services;

import com.projects.myproductservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
