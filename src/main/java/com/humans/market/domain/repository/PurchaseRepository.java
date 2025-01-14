package com.humans.market.domain.repository;

import com.humans.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);

    Optional<Purchase> getPurchase(int purchaseId);

    Purchase save(Purchase purchase);

}
