package com.epam.spring.service.repository;

import com.epam.spring.service.model.Product;

import java.util.List;

public interface ProductRepository {

    Product getProduct(String name);

    Product getProduct(int id);

    List<Product> listProducts();

    Product createProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);
}
