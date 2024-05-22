package com.spring.springcourse.domain.repository;

import com.spring.springcourse.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    //Objetos de domonio nos ayudan a llevar la logica de nuestro proyecto
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int catedoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
