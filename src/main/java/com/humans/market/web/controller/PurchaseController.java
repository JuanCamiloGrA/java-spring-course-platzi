package com.humans.market.web.controller;

import com.humans.market.domain.Purchase;
import com.humans.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Purchase management APIs")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping()
    @Operation(summary = "Get all purchases", description = "Retrieve a list of all purchases")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    @Operation(summary = "Get purchases by client ID", description = "Retrieve purchases by client ID")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
        return new ResponseEntity<>(purchaseService.getByClient(clientId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get purchase by ID", description = "Retrieve a purchase by its ID")
    public ResponseEntity<Purchase> getPurchase(@PathVariable("id") int purchaseId) {
        return ResponseEntity.of(purchaseService.getPurchase(purchaseId));
    }

    @PostMapping
    @Operation(summary = "Save a new purchase", description = "Save a new purchase to the database")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}