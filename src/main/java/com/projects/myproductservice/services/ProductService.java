package com.projects.myproductservice.services;

import com.projects.myproductservice.exceptions.ProductNotFoundException;
import com.projects.myproductservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    Product createProduct(Product product);
    List<Product> getAllProducts();

}
