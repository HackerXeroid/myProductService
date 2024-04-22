package com.projects.myproductservice.services;

import com.projects.myproductservice.exceptions.CategoryNotFoundException;
import com.projects.myproductservice.exceptions.ProductNotFoundException;
import com.projects.myproductservice.models.Category;
import com.projects.myproductservice.models.Product;
import com.projects.myproductservice.repositories.CategoryRepository;
import com.projects.myproductservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new ProductNotFoundException(id, "Product not found");

        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category.getId() == null) {
            product.setCategory(categoryRepository.save(category));
        }

        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Invalid category id passed");
        }

        Product product1 = productRepository.save(product);
        product1.setCategory(optionalCategory.get());
        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
