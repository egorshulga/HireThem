package com.github.hirethem.dao;

import com.github.hirethem.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T> object type
 * @param <PK> primary key type
 */
public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {

    T create() throws DaoException;

    T persist(T object) throws DaoException;//returns new copy

    T getByPK(PK key) throws DaoException;

    void update(T object) throws DaoException;

    void delete(T object) throws DaoException;

    List<T> getAll() throws DaoException;
}
