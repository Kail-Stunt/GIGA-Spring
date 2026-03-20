package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@Component
public class ProductBasket {
    private final Map<UUID, Integer> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(UUID productId) {
        products.merge(productId,1,Integer::sum);
    }

    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }
}
