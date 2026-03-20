package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> productMap;
    private final Map<UUID, Article> articleMap;

    public StorageService(Map<UUID, Product> productMap, Map<UUID, Article> articleMap) {
        this.productMap = productMap;
        this.articleMap = articleMap;
        fillData();
    }

    private void fillData() {
        Product gumpUmbrella = new DiscountedProduct("Большой зонт", 1500, 15, UUID.randomUUID());
        Product grill = new DiscountedProduct("Гриль", 4500, 25, UUID.randomUUID());
        Product matches = new FixPriceProduct("Спички", UUID.randomUUID());
        Product umbrella = new SimpleProduct("Зонт", 1500, UUID.randomUUID());
        Product socks = new SimpleProduct("Носки", 500, UUID.randomUUID());
        Product mur = new SimpleProduct("Неизвестен", 2000, UUID.randomUUID());

        productMap.put(gumpUmbrella.getId(), gumpUmbrella);
        productMap.put(grill.getId(), grill);
        productMap.put(matches.getId(), matches);
        productMap.put(umbrella.getId(), umbrella);
        productMap.put(socks.getId(), socks);
        productMap.put(mur.getId(), mur);

        Article gumpArticle = new Article("Большой зонт", "Большой, закрывающий не только голову, но и плечи зонт.", UUID.randomUUID());
        Article grillArticle = new Article("Гриль", "Специальное устройство для приготовления продуктов на углях или на огне.", UUID.randomUUID());
        Article matchesArticle = new Article("Спички", "Спички детям не игрушка!", UUID.randomUUID());
        Article umbrellaArticle = new Article("Зонт", "Просто зонт.", UUID.randomUUID());
        Article socksArticle = new Article("Носки", "Носки незаменимый атрибут современного мужчины.", UUID.randomUUID());
        Article murArticle = new Article("Неизвестен", "Проверить же надо!", UUID.randomUUID());

        // Добавляем в хранилище статей
        articleMap.put(gumpArticle.getId(), gumpArticle);
        articleMap.put(grillArticle.getId(), grillArticle);
        articleMap.put(matchesArticle.getId(), matchesArticle);
        articleMap.put(umbrellaArticle.getId(), umbrellaArticle);
        articleMap.put(socksArticle.getId(), socksArticle);
        articleMap.put(murArticle.getId(), murArticle);
    }

    public Collection<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public Collection<Article> getAllArticles() {
        return new ArrayList<>(articleMap.values());
    }

    public Collection<Searchable> getAllSearchableItems() {
        List<Searchable> searchableItems = new ArrayList<>();
        searchableItems.addAll(productMap.values());
        searchableItems.addAll(articleMap.values());
        return Collections.unmodifiableCollection(searchableItems);
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public String toString() {
        return "StorageService{" +
                "productMap=" + productMap +
                ", articleMap=" + articleMap +
                '}';
    }
}

