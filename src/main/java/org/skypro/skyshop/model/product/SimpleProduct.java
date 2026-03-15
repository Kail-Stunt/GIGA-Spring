package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int productPrice;
    private final UUID id;

    public SimpleProduct(String productName, int productPrice, UUID id) throws IllegalArgumentException {
        super(productName, id);
        this.productPrice = productPrice;
        this.id = id;
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля!");
        }
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Продукт - " + productName + ", цена - " + productPrice + ".";
    }

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String contentType() {

        return null;
    }


    @Override
    public String getStringRepresentation() {
        return toString();
    }

    @Override
    public UUID getId() {
        return id;
    }
}
