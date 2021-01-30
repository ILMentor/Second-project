import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        try {
            ResultSet rs = sqLiteJDBC.statement.executeQuery( "SELECT * FROM COMPANY;" );
            while (rs.next()) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sqLiteJDBC.closeConnection();
        sqLiteJDBC.closeStatement();
    }
}
