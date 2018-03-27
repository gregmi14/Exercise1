package org.magenic.Exercise1;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ResultJDBCTemplate implements ResultDAO {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void insert(String request, String result) {
        try {
            String SQL = "INSERT INTO public.\"Results\"(\"Request\", \"Result\") VALUES (?, ?)";
            jdbcTemplate.update(SQL, request, result);
        }
        catch (DataAccessException e){
            System.out.println("Error in creating record; rolling back");
            throw e;
        }
    }
}
