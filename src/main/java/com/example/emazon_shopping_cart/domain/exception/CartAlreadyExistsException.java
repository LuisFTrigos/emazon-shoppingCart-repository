package com.example.emazon_shopping_cart.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CartAlreadyExistsException extends RuntimeException{

    public CartAlreadyExistsException(String message) {
        super(message);
    }

    @ExceptionHandler(value = {CartAlreadyExistsException.class})
    public ResponseEntity<Object> handlerBadRequestExceptionCategory(CartAlreadyExistsException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse(getMessage());
        return new ResponseEntity<>(errorResponse, badRequest);
    }
}
