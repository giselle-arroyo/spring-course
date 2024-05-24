package com.spring.springcourse.persistence.mapper;

import com.spring.springcourse.domain.Purchase;
import com.spring.springcourse.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses={PurchaseMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source="idCompra", target="purchaseId"),
            @Mapping(source="idCliente", target="clientId"),
            @Mapping(source="fecha", target="date"),
            @Mapping(source="medioPago", target="paymentMethod"),
            @Mapping(source="comentario", target="comment"),
            @Mapping(source="estado", target="state"),
            @Mapping(source="productos", target="items"),

    })
    Purchase toPurchase(Compra compra);

    @InheritInverseConfiguration
    @Mapping(target="client", ignore=true)
    Compra toCompra(Purchase purchase);


}
