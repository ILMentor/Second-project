import java.sql.*;
public class SQLiteJDBC {
    Connection connection;
    Statement statement;

    // todo Реализовать базу данных. Добавить комманды.
    // todo Сохранять результаты работы программы в базу данных
    // todo Добавить документацию к классу

    public void getConnection(){
        try{Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Connection successful.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed.");
        }
    }

    public void createStatement(){
        try {
            statement = connection.createStatement();
            System.out.println("Statement created.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Statement create fell.");
        }
    }

    public void createTable(String sql){
        try{

            statement.executeUpdate(sql);
            System.out.println("Table create successfully.");
        } catch (Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
    }

    public void executeUpdate(String sql){
        try {
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection close fell.");
        }
    }

    public void closeStatement(){
        try {
            statement.close();
            System.out.println("Statement closed.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Statement close fell.");
        }
    }

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
