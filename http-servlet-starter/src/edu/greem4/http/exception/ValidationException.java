package edu.greem4.http.exception;

import edu.greem4.http.validator.Error;
import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException{

    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
