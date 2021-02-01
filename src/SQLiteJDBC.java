import java.sql.*;
/**
 * Реализация базы данных. Класс имеет методы для создания и редактирования базы данных.
 * <p>
 * Вызывать, если нужно работать с базой данных.
 *  */
public class SQLiteJDBC {

    Connection connection;
    Statement statement;
    ResultSet rs;
    /**
     * Метод создает подключение к базе данных (или файлу с базами данных, еще сам не знаю) с именем <code>test.db</code>
     * */
    public void getConnection(){
        try{Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Connection successful.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed.");
        }
    }

    /**
     * Метод создает объект <code>statement</code>
     */
    public void createStatement(){
        try {
            statement = connection.createStatement();
            System.out.println("Statement created.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Statement create fell.");
        }
    }

    /**
     * Отличается от метода {@link #executeUpdate(String)} только тем,
     * что выводится надпись <i>Table create successfully</i>
     * вместо надписи <i>Update executed</i>
     * @param sql Команда для выполнения на языке sql.
     */
    public void createTable(String sql){
        try{

            statement.executeUpdate(sql);
            System.out.println("Table create successfully.");
        } catch (Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
    }

    /**
     * Метод для выполнения команд на языке sql.
      * @param sql Команда для выполнения на языке sql.
     */
    public void executeUpdate(String sql){
        try {
            statement.executeUpdate(sql);
            System.out.println("Update executed.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet executeQuery(){
        try {
            rs = statement.executeQuery("SELECT * FROM TV where id = 1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    /**
     * Метод закрывает соединение.
     */
    public void closeConnection(){
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection close fell.");
        }
    }

    /**
     * Метод закрывает <code>statement</code>
     */
    public void closeStatement(){
        try {
            statement.close();
            System.out.println("Statement closed.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Statement close fell.");
        }
    }

    /**
     * Метод проверяет закрыто ли подключение.
     */
    public void checkConnectionClose(){
        try {
            if (connection.isClosed())
                System.out.println("Connection is closed.");
            else
                System.out.println("Connection is opened.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
