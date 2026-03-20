package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exeption.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        if (storageService.getProductById(id).isPresent()) {
            productBasket.addProduct(id);
        } else {
            throw new NoSuchProductException("Товар с ID " + id + " не найден");
        }
    }

    public UserBasket getUserBasket() {
        return new UserBasket(
                productBasket.getProducts().entrySet().stream()
                        .map(entry -> {
                            UUID productId = entry.getKey();
                            Integer quantity = entry.getValue();
                            Optional<Product> productOpt = storageService.getProductById(productId);
                            return productOpt.map(product -> new BasketItem(product, quantity)).orElse(null);
                        })
                        .filter(Objects::nonNull)
                        .toList()
        );
    }
}
