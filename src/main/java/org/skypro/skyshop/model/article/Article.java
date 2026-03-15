package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleContent;
    private final UUID id;

    public Article(String articleName, String articleContent, UUID id) {
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Название статьи: " + articleName + " Содержание статьи: " + articleContent;
    }

    @Override
    public String searchTerm() {
        return articleName;
    }

    @Override
    public String contentType() {
        return articleContent;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }
}
