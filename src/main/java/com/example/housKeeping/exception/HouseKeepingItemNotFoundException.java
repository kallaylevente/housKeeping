package com.example.housKeeping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HouseKeepingItemNotFoundException extends RuntimeException {
    public HouseKeepingItemNotFoundException(String message) {
        super("Given type of housekeepingitem does not found: " + message);
    }
}
