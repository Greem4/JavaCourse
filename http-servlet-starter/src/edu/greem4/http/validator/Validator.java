package edu.greem4.http.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
