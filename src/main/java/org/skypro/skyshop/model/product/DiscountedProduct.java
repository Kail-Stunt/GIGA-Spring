package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int discount;
    private final UUID id;

    public DiscountedProduct(String productName, int basePrice, int discount, UUID id) throws IllegalArgumentException {
        super(productName, id);
        this.basePrice = basePrice;
        this.discount = discount;
        this.id = id;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена товара должна быть больше нуля!");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка на товар должна быть больше нуля и меньше 100!");
        }
    }

    @Override
    public int getProductPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт (есть скидка) - " + productName + ", цена со скидкой - " + getProductPrice() + " (скидка " + discount + "%).";
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
