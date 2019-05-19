package com.beastsoftware.beastfactions.mysql;

import java.sql.Connection;
import java.sql.Statement;

public interface IMySQL {

    Connection getConnection();

    void setUpConnection();

    Statement createStatement();

    void closeStatement(Statement statement);

    boolean isValidConnection();

}
