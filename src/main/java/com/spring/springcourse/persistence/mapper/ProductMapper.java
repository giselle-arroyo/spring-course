package com.spring.springcourse.persistence.mapper;

import com.spring.springcourse.domain.Product;
import com.spring.springcourse.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={CategoryMapper.class})//Cuando use categoria va a usar la clase CategoryMapper
public interface ProductMapper {
    @Mappings({
            @Mapping(source="idProducto", target="productId"),
            @Mapping(source="nombre", target="name"),
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="precioVenta", target="price"),
            @Mapping(source="cantidadStock", target="stock"),
            @Mapping(source="estado", target="active"),
            @Mapping(source="categoria", target="category"),
    })
    Product toProduct(Producto producto);
    //Map Struct ya sabe que la List se debe comprar con los @Mappings de arriba sin necesidad de usar anotaciones de nuevo
    //mismo tipo de conversion
    List<Product> toProducts(List<Producto> products);

    @InheritInverseConfiguration
    @Mapping(target="codigoBarras", ignore=true)
    Producto toProducto(Product product);
}
