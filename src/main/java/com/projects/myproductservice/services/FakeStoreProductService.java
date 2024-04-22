package com.projects.myproductservice.services;

import com.projects.myproductservice.dtos.FakeStoreProductDto;
import com.projects.myproductservice.exceptions.ProductNotFoundException;
import com.projects.myproductservice.models.Category;
import com.projects.myproductservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate = new RestTemplate();

    /*
     id;
    private String title;
    private String description;
    private Double price;
    private Category category;
    private String image;
    */
    public Product getProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Please pass a valid Product ID");
        };

        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        if (fakeStoreProductDtos == null) return null;

        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
            products.add(convertToProduct(fakeStoreProductDto));
        }

        return products;
    }

    public Product convertToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());

        Category category = new Category();
        product.setCategory(category);

        return product;
    }
}
