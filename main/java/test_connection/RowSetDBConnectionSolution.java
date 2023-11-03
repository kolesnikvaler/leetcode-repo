package test_connection;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;

public class RowSetDBConnectionSolution {
    public static void main(String[] args) throws SQLException {
        /*Connection connection = test_connection.MyConnection.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM app.user;");

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet crs = factory.createCachedRowSet();
        crs.populate(resultSet); // Испльзуем resultSet для заполнения

        connection.close(); // Закрываем соединение

        // Данные из кеша  всё ещё доступны
        while (crs.next()) {
            System.out.printf("%d\t%s\t%s\t%d\t%s%n",
                    crs.getInt("id"),
                    crs.getString("name"),
                    crs.getString("occupation"),
                    crs.getInt("salary"),
                    crs.getTimestamp("join_date"));
        }*/

        crsTest();
    }

    public static RowSet getRowSetDefaultConnection() throws SQLException {
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/app");
        rowSet.setUsername("root");
        rowSet.setPassword("password");

        rowSet.setCommand("SELECT * FROM app.user;");
        rowSet.execute();
        return rowSet;
    }

    public static void crsTest() throws SQLException {
        Connection connection = MyConnection.getInstance();
        connection.setAutoCommit(false); // Нужно для синхронизации

        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        crs.setUrl("jdbc:mysql://localhost:3306/app");
        crs.setUsername("root");
        crs.setPassword("secret");
        crs.setConcurrency(CachedRowSet.CONCUR_UPDATABLE);

        crs.setCommand("SELECT * FROM app.user;");
        crs.execute();

        // Этот тип операции может изменить только автономный RowSet
        // Сначала перемещаем указатель на пустую (новую) строку, текущая позиция запоминается
        crs.afterLast();
        crs.moveToInsertRow();
        crs.updateInt(1, 7);
        crs.updateString(2, "name");
        crs.updateString(3, "OCCUP");
        crs.updateInt(4, 12345);
        crs.insertRow();
        crs.moveToCurrentRow();

        crs.beforeFirst();
        while (crs.next()) {
            System.out.printf("%d\t%s\t%s\t%d\t%s%n",
                    crs.getInt("id"),
                    crs.getString("name"),
                    crs.getString("occupation"),
                    crs.getInt("salary"),
                    crs.getTimestamp("join_date"));
        }
        crs.beforeFirst();
        crs.moveToCurrentRow();

        // А теперь мы можем все наши изменения залить в базу
        crs.acceptChanges(connection);// Синхронизировать данные в базу данных
    }

    /*public static RowSet getRowSet(Connection connection) throws SQLException {
        JdbcRowSet rowSet = new JdbcRowSetImpl(connection);

        rowSet.setCommand("SELECT * FROM app.user;");
        rowSet.execute();
        return rowSet;
    }*/
}
