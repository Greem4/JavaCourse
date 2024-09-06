package com.greem4.jdbc.starter.dao;

import com.greem4.jdbc.starter.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {

    boolean delete(K id);

    E save(Ticket ticket);

    void update(E ticket);

    Optional<E> findById(K id);

    List<E> findAll();
}
