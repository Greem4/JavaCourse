package com.greem4.mapper;

public interface Mapper <F, T>{

    T mapFrom(F object);
}
