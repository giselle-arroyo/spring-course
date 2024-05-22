package com.spring.springcourse.persistence.crud;

import com.spring.springcourse.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {//tabla y el tipo de la llave primaria
    //---SQL query----
    //@Query(value="SELECT + FROM productos WHERE id_categorya =?", nativeQuery = true)
    //----Query methods----, siempre respetando camel case
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
