package edu.greem4.http.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
