import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceTestConnection {
    public static void main(String[] args) {


        try {
            MysqlDataSource msds = new MysqlDataSource();

            msds.setUrl("jdbc:mysql://localhost:3306/app");
            msds.setUser("root");
            msds.setPassword("secret");
            Connection connection = msds.getConnection();
            System.out.println("Connection successful!\n");

            String sql = "SELECT * FROM app.user;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("id\tname\toccup\tsalary\tjoin_date");
            while (resultSet.next()){
                System.out.printf("%d\t%s\t%s\t%d\t%s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("occupation"),
                        resultSet.getInt("salary"),
                        resultSet.getTimestamp("join_date"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}