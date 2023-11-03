import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionWorkWithUser {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app",
                "", ""
        );

//        User user = new User(1, "Kolya", "DIRECTOR", 100000, Timestamp.valueOf(LocalDateTime.now()));
//        addUser(connection, user);

//        removeUserById(connection, 3);

        System.out.println("getUserById(connection, 1): " + getUserById(connection, 1));
        System.out.println("_".repeat(100));
        getAllUsers(connection).forEach(System.out::println);
        connection.close();
    }

    public static boolean addUser(Connection connection, User user) throws SQLException {
        // Создаём и подготавливаем запрос на вставку в таблицу user
        String insertQuery = "INSERT INTO app.user(id, name, occupation, salary, join_date)" +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        // Заполняем запрос данными из объекта User
        statement.setInt(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getOccupation());
        statement.setInt(4, user.getSalary());
        statement.setTimestamp(5, user.getJoinDate());

        int count  = statement.executeUpdate();
        return count > 0;
    }

    public static boolean removeUserById(Connection connection, int id) throws SQLException {
        // Создаём и подготавливаем запрос на удаление строки из таблицы user
        String deleteQuery = "DELETE FROM app.user WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);

        statement.setInt(1, id);
        int count = statement.executeUpdate();
        return count > 0;
    }

    public static User getUserById(Connection connection, int id) throws SQLException {
        // Создаём запрос на выборку данных из таблицы user по id
        String selectQuery = "SELECT * FROM app.user WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setInt(1, id);

        // Выполняем наш запрос, и он возвращает null, если строк в результате запроса нет
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;

        // Заполняем объект User данными из ResultSet
        return getUser(resultSet);
    }

    public static List<User> getAllUsers(Connection connection) throws SQLException {
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT * FROM app.user;";
        PreparedStatement statement = connection.prepareStatement(selectQuery);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            userList.add(getUser(resultSet));
        }
        return userList;
    }

    private static User getUser(ResultSet resultSet) throws SQLException{
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("occupation"),
                resultSet.getInt("salary"),
                resultSet.getTimestamp("join_date")
        );
    }
}
