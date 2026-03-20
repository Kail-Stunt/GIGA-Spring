package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;
import org.skypro.skyshop.model.service.StorageService;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storage;

    public SearchService(StorageService storage) {
        this.storage = storage;
    }

    public Collection<SearchResult> search(String pattern) {
        if (pattern == null || pattern.trim().isEmpty()) {
            return storage.getAllSearchableItems().stream()
                    .map(SearchResult::fromSearchable)
                    .collect(Collectors.toList());
        }

        return storage.getAllSearchableItems().stream()
                .filter(item -> item.searchTerm() != null &&
                        item.searchTerm().toLowerCase().contains(pattern.trim().toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
