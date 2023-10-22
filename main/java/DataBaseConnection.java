import java.sql.*;
import java.text.SimpleDateFormat;

public class DataBaseConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app",
                "", ""
        );

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM app.user");

        System.out.println("row\tid\temployee\tcreated_date");
        // ------------------------------Работаем с данными таблицы
        SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date date = resultSet.getDate("created_date");
            System.out.println(resultSet.getRow() + ".\t" + id + "\t" +
                    (name.length() < 5? (name + "   ").substring(0, 5): name.substring(0, 5))
                    + "\t\t" + format.format(date));
        }
        // ------------------------------Работаем с метаданными таблицы
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.println("------------------------------------------");
        for (int column = 1; column <= columnCount; column++) {
            String name = metaData.getColumnName(column);
            String className = metaData.getColumnClassName(column);
            String typeName = metaData.getColumnTypeName(column);
            int type = metaData.getColumnType(column);

            System.out.printf("%s\t%s\t%s\t%d%n", name, className, typeName, type);
        }
        connection.close();
    }
}
