package com.projects.myproductservice;

import com.projects.myproductservice.models.Category;
import com.projects.myproductservice.models.Product;
import com.projects.myproductservice.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class MyProductServiceApplicationTests {
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testEagerVsLazyFetch() {
		Optional<Category> optionalCategory = categoryRepository.findById(2L);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();

			System.out.println("Listing all products of above category:");
			List<Product> products = category.getProducts();
			System.out.println(products.get(0));

			System.out.println("DEBUG");
		} else {
			System.out.println("Category with ID 2L not found.");
		}
	}

}
