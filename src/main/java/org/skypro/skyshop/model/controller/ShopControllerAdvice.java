package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.exeption.NoSuchProductException;
import org.skypro.skyshop.model.exeption.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler({NoSuchProductException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ShopError handleException(NoSuchProductException ex) {
        ShopError error = new ShopError("Продукт не найден!", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error).getBody();
    }
}