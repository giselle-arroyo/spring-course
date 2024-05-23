package com.spring.springcourse.persistence;

import com.spring.springcourse.domain.Product;
import com.spring.springcourse.domain.repository.ProductRepository;
import com.spring.springcourse.persistence.crud.ProductoCrudRepository;
import com.spring.springcourse.persistence.entity.Producto;
import com.spring.springcourse.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //indicamos a Spring que esta clase se encarga de interactuar con la base de datos
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;


    public List<Product> getAll(){
       List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();
    return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int catedoryId) {
        List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(catedoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

    //REpostirio fue orientado al dominiio
}
