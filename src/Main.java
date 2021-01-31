import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Главный класс. Постоянно меняется, нужен для того, чтобы тестить работу программы.
 */
public class Main {

    public static void main(String[] args) {
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        Controller controller = new ControllerRealization(new TV());
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        controller.showInfo();
        try {
            ResultSet rs = sqLiteJDBC.statement.executeQuery( "SELECT * FROM TV where ID = 1;" );
            while (rs.next()) {
                int id = rs.getInt("id");
                boolean power = rs.getBoolean("power");
                int channel  = rs.getInt("channel");
                int sound = rs.getInt("sound");

                System.out.println( "ID = " + id );
                System.out.println( "power = " + power );
                System.out.println( "channel = " + channel );
                System.out.println( "sound = " + sound );
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        controller.pressPowerButton();
        controller.showInfo();
        try {
            ResultSet rs = sqLiteJDBC.statement.executeQuery( "SELECT * FROM TV where ID = 1;" );
            while (rs.next()) {
                int id = rs.getInt("id");
                boolean power = rs.getBoolean("power");
                int channel  = rs.getInt("channel");
                int sound = rs.getInt("sound");

                System.out.println( "ID = " + id );
                System.out.println( "power = " + power );
                System.out.println( "channel = " + channel );
                System.out.println( "sound = " + sound );
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sqLiteJDBC.closeConnection();
        sqLiteJDBC.closeStatement();
    }
}
