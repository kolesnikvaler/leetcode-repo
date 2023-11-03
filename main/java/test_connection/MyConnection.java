package test_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static class MyConnectionHolder{
        public static final Connection CONNECTION;

        static {
            try {
                CONNECTION = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app",
                        "root", "secret"
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Connection getInstance(){
        return MyConnectionHolder.CONNECTION;
    }
}
