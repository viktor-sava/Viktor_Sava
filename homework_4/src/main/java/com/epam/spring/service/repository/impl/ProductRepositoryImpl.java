package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.ProductNotFoundException;
import com.epam.spring.service.model.Product;
import com.epam.spring.service.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    private static final Function<Integer, Predicate<Product>> isProductEqualsPredicate = l -> p -> p.getId() == l;

    @Override
    public Product getProduct(String name) {
        return productList.stream()
                .filter(p -> p.getProductDescriptionList()
                        .stream()
                        .anyMatch(pp -> pp.getName()
                                .equals(name)))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(name));
    }

    @Override
    public Product getProduct(int id) {
        return productList.stream()
                .filter(isProductEqualsPredicate.apply(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
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
        Product oldProduct = productList.stream()
                .filter(isProductEqualsPredicate.apply(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
        productList.remove(oldProduct);
        product.setCreateDate(oldProduct.getCreateDate());
        product.setId(oldProduct.getId());
        product.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        productList.add(product);
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productList.removeIf(isProductEqualsPredicate.apply(id));
    }
}
