package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {
    @Test
    public void testConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/webdb",
                "root",
                "1234"
        );

        Assertions.assertNotNull(connection);
        connection.close();
    }
}
