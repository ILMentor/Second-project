import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        // todo Научиться вызывать данные из базы данных
        // todo Исправить ошибки
        try {
            ResultSet rs = sqLiteJDBC.statement.executeQuery("SELECT * FROM COMPANY;");
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));
            System.out.println("AGE = " + rs.getInt("AGE"));
            System.out.println("ADDRESS = " + rs.getString("ADDRESS"));
            System.out.println("SALARY = " + rs.getInt("SALARY"));
            System.out.println("NAME = " + rs.getString("NAME"));
            System.out.println("NAME = " + rs.getString("NAME"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sqLiteJDBC.closeConnection();
        sqLiteJDBC.closeStatement();
    }
}
