package com.spring.springcourse.domain.service;

import com.spring.springcourse.domain.Product;
import com.spring.springcourse.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio - es la logica de acceso a los datos desde la aplicacion
//Repositorio -  es la capa simple de acceso o de comunicación con el sistema de almacén de datos (comunicacion)
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        /*//Alternativa
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId)
            return true;
        }else{
            return false;
        }*/
    }

}
