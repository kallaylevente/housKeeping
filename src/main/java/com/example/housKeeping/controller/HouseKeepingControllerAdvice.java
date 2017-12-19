package com.example.housKeeping.controller;

import java.util.Optional;


import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.housKeeping.exception.HouseKeepingItemNotFoundException;

@ControllerAdvice
public class HouseKeepingControllerAdvice {
    private static final String VND_ERROR_CONTENT_TYPE = "application/vnd.error+json";

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<VndErrors> handleHouseKeepingItemNotFoundException(final HouseKeepingItemNotFoundException e) {
        return createVndErrorsResponseEntity(e);
    }

    private ResponseEntity<VndErrors> createVndErrorsResponseEntity(RuntimeException e) {
        return new ResponseEntity<VndErrors>(
                createVndError(e), getHttpStatusCode(e)
        );
    }

    private VndErrors createVndError(RuntimeException e) {
        return new VndErrors("dont know why this is here", e.getMessage());
    }

    private HttpStatus getHttpStatusCode(RuntimeException e) {
        return Optional.ofNullable(e.getClass().getAnnotation(ResponseStatus.class).code())
                .orElseThrow(() -> new RuntimeException("ResponseStatus annotation should be added to exception class.", e));
    }
}
