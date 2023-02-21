package com.vitali.hib.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
