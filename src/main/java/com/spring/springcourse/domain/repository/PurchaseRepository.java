package com.spring.springcourse.domain.repository;

import com.spring.springcourse.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    //Optional en caso de que el cliente no tenga compas no marque error
    Purchase save(Purchase purchase);
}
