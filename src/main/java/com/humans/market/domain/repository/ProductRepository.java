package com.humans.market.domain.repository;

import com.humans.market.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Product entities.
 */
public interface ProductRepository {

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    List<Product> getAll();

    /**
     * Retrieves products by category.
     *
     * @param categoryId the ID of the category
     * @return an optional list of products in the specified category
     */
    Optional<List<Product>> getByCategory(int categoryId);

    /**
     * Retrieves products that are scarce in quantity.
     *
     * @param quantity the threshold quantity
     * @return an optional list of products with quantity less than the specified threshold
     */
    Optional<List<Product>> getScarceProducts(int quantity);

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product
     * @return an optional product with the specified ID
     */
    Optional<Product> getProduct(int productId);

    /**
     * Saves a product.
     *
     * @param product the product to save
     * @return the saved product
     */
    Product save(Product product);

    /**
     * Deletes a product by its ID.
     *
     * @param productId the ID of the product to delete
     */
    void delete(int productId);
}