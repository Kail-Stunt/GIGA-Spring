package org.skypro.skyshop.model.product;


import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 250;
    private final UUID id;

    public FixPriceProduct(String productName, UUID id) {
        super(productName, id);
        this.id = id;
    }

    @Override
    public int getProductPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт - " + productName + ", на данный продукт цена фиксированная - " + getProductPrice() + ".";
    }

    @Override
    public String searchTerm() {
        return null;
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
