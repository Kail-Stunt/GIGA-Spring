package org.skypro.skyshop.model.product;


import org.skypro.skyshop.model.search.Searchable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {

    private static final Logger log = LoggerFactory.getLogger(Product.class);
    public final String productName;
    private final UUID id;

    public Product(String productName, UUID id) throws IllegalArgumentException {
        this.id = id;
        if ((productName == null) || productName.isBlank()) {
            throw new IllegalArgumentException("Название товара не может быть пустым!");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product: " + productName;
    }

    @Override
    public String searchTerm() {
        log.info("Имя продукта {}", productName);
        return productName;
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
