import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс для работы с базой данных на языке MySQL. Класс похожий на SQLiteJDBC, но там используется SQLite.
 * SQLite вроде бы проще в техническом плане, поэтому я решил работать с ним. MySQL тяжелый, не подходит для моего проекта.
 */
public class ConnectionUtil {
    Statement statement;
    Connection connection;
    public Connection getConnection(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=Europe/Moscow",
                    "root", "Bujhm18Tdf13");
            System.out.println("Connection successful.");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            System.out.println(e);
        }
        return connection;
    }

    public void createStatement(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            statement = getConnection().createStatement();
            System.out.println("Statement created.");
        }
        catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public void updateSound() {
        try {
            System.out.printf("Updated %d rows\n",
                    statement.executeUpdate("update tvconfig set Sound = Sound + 1 where TV = 'TV'"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection = null;
    }

    public void checkConnection() {
        try {
            System.out.println("Connection closed: " + statement.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
