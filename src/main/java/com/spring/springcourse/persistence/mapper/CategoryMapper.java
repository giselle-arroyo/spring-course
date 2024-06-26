package com.spring.springcourse.persistence.mapper;

import com.spring.springcourse.domain.Category;
import com.spring.springcourse.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //conviertiendoc atedorias dentro de category
    @Mappings({

            @Mapping(source="idCategoria", target = "categoryId"),
            @Mapping(source="descripcion", target = "category"),
            @Mapping(source="estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    //conversion externa

    //indica a mapStruct que la conversion en inversa a al que ya hacemos, no se define mappins
    @InheritInverseConfiguration
    @Mapping(target="productos",ignore=true)
    Categoria toCategoria(Category category);
}
