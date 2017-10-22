package com.indigo.KRE_ART.models;

import java.sql.Connection;

public class BaseEntity {
    Connection connection;
    String tableName;

    public BaseEntity(){
    }

    public BaseEntity(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public Connection getConnection() {
        return connection;
    }

    public BaseEntity setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public BaseEntity setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getBaseStatement() {
        return "SELECT * FROM ".concat(tableName).concat(" ");
    }
}
