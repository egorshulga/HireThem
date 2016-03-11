package com.github.hirethem.dao.connectionpool;

import com.github.hirethem.dao.connectionpool.exception.ConnectionPoolException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;

public interface ConnectionPool {

    Connection getConnection() throws ConnectionPoolException;

    void returnConnection(Connection connection) throws ConnectionPoolException;

    @PreDestroy
    void releasePool() throws ConnectionPoolException;

    @PostConstruct
    void initialize() throws ConnectionPoolException;
}
