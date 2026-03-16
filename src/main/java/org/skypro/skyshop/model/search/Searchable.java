package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface Searchable {

    @JsonIgnore
    String searchTerm();

    @JsonIgnore
    String contentType();

    UUID getId();

    default String getStringRepresentation() {
        return "Имя " + searchTerm() + " тип " + contentType() + " объекта";
    }
}
