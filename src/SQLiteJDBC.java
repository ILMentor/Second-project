import java.sql.*;
public class SQLiteJDBC {
    public static void main(){
        Connection connection;
        Statement statement;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            statement = connection.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " NAME           TEXT NOT NULL," +
                    " AGE            INT NOT NULL," +
                    " ADDRESS        CHAR(50)," +
                    " SALARY         REAL)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("Table create successfully.");
            // todo Реализовать базу данных. Добавить комманды.
            // todo Сохранять результаты работы программы в базу данных
        } catch (Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
    }
}
