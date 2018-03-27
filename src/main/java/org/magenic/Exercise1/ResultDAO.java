package org.magenic.Exercise1;

import javax.sql.DataSource;

public interface ResultDAO {
    void setDataSource(DataSource ds);
    void insert(String request, String result);
}