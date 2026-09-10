package com.congreso.backend.exception.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
public class DataAlreadyExistsException extends RuntimeException {

    private String message;

    public DataAlreadyExistsException() {
        super();
    }

    public DataAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
