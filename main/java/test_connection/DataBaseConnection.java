package test_connection;

import lombok.NonNull;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBaseConnection {
    private final Connection connection;
    private Statement statement = null;
    private PreparedStatement prStm;
    private ResultSet resultSet = null;

    public DataBaseConnection(Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app",
                "", ""
        );
//        test_connection.DataBaseConnection dataBaseConnection = new test_connection.DataBaseConnection(connection);

        String sql = "UPDATE app.test_tab t SET t.Blob = ? WHERE t.id = 3;";
        PreparedStatement prSt = connection.prepareStatement(sql);

        // Создаем объект Blob и получаем у него OutputStream для записи в него данных
        Blob blob = connection.createBlob();

        // Заполняем Blob данными ...
        try {
            Path file1TXT = Paths.get("C:/ForTest/file1.txt");
            byte[] content = Files.readAllBytes(file1TXT);
            blob.setBytes(1, content);
        } catch (IOException e) {
            connection.close();
            throw new RuntimeException(e);
        }

        prSt.setBlob(1, blob);
        prSt.execute();

//        dataBaseConnection.printTable();
//        dataBaseConnection.printResultMetaData();
//        dataBaseConnection.updateSalaryOfAllEmployeesOnPercent((float) (Math.random() + 0.5) );


        /*dataBaseConnection.insertRowWithPrepareStatementInEmployeeTable("Petya", "GUEST", 0, 10);

        dataBaseConnection.executeAndPrintSqlQuery("SELECT id, name FROM app.employee;");*/

        connection.close();
    }

    public void insertRowWithPrepareStatementInEmployeeTable(@NonNull String name, String role, int salary, int level)
            throws SQLException{
        String sql = "INSERT INTO app.employee (name, emp_role, salary, level, created_date) " +
                "VALUES (?, ?, ?, ?, ?);";
        //  Prepare for INSERTING
        prStm = connection.prepareStatement(sql);

        //  INSERT
        prStm.setString(1, name);
        prStm.setString(2, role);
        prStm.setInt(3, salary);
        prStm.setInt(4, level);
        prStm.setDate(5, new java.sql.Date(new Date().getTime()));

        //  Update prepareStatement
        prStm.executeUpdate();
    }


    public void insertRowInEmployeeTable(@NonNull String name, String role, int salary, int level) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = String.format(
                "INSERT INTO app.employee (name, emp_role, salary, level, created_date) " +
                "VALUES ('%s', '%s', %d, %d, '%s');", name, role, salary, level, format.format(new Date()));
        int rows = statement.executeUpdate(sql);
        System.out.println(rows + " was changed!");
    }

    public void executeAndPrintSqlQuery(String sql){
        try {
            boolean hasResults = statement.execute(sql);
            if (hasResults){
                ResultSet result = statement.getResultSet();
                System.out.println("Строки вашего запроса ниже: ");

                while (result.next()){
                    System.out.printf("%d. %s\t%s%n", result.getRow(), result.getInt(1), result.getString(2));
                }
            } else {
                System.out.println("Changed rows count: " + statement.getUpdateCount());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateSalaryOfAllEmployeesOnPercent(float index) throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM app.employee");
        int rowCount = statement.executeUpdate(String.format("UPDATE app.employee SET salary = salary * %s;", index));
        System.out.println();
        System.out.println("rowCount = " + rowCount + " | index = " + index);
    }

    private void printTable() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM app.employee");
        System.out.println("row\tid\temployee\tcreated_date");
        // ------------------------------Работаем с данными таблицы
        SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date date = resultSet.getObject("created_date", Date.class);
            System.out.println(resultSet.getRow() + ".\t" + id + "\t" +
                    (name.length() < 5? (name + "   ").substring(0, 5): name.substring(0, 5))
                    + "\t\t" + format.format(date));
        }
    }

    private void printResultMetaData() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM app.employee");
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
    }
}
