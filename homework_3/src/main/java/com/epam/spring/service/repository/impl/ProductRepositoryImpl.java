package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.ProductNotFoundException;
import com.epam.spring.exception.ReceiptNotFoundException;
import com.epam.spring.service.model.Product;
import com.epam.spring.service.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    @Override
    public Product getProduct(String name) {
        Optional<Product> optional = productList.stream()
                .filter(p -> p.getProductDescriptionList().stream().anyMatch(pp -> pp.getName().equals(name)))
                .findFirst();
        if (!optional.isPresent()) {
            throw new ProductNotFoundException();
        }
        return optional.get();
    }

    @Override
    public Product getProduct(int id) {
        Optional<Product> optional = productList.stream().filter(p -> p.getId() == id).findFirst();
        if (!optional.isPresent()) {
            throw new ProductNotFoundException();
        }
        return optional.get();
    }

    @Override
    public List<Product> listProducts() {
        return new ArrayList<>(productList);
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        product.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        product.setId(productList.size() + 1);
        productList.add(product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Optional<Product> optional = productList.stream().filter(p -> p.getId() == id).findFirst();
        if (!optional.isPresent()) {
            throw new ReceiptNotFoundException();
        }
        productList.removeIf(p -> p.getId() == id);
        Product oldProduct = optional.get();
        product.setCreateDate(oldProduct.getCreateDate());
        product.setId(oldProduct.getId());
        product.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        productList.add(product);
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productList.removeIf(p -> p.getId() == id);
    }
}
