import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Главный класс. Постоянно меняется, нужен для того, чтобы тестить работу программы.
 */
public class Main {

    public static void main(String[] args) {
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        Controller controller = new ControllerRealization(new TV());
        Main main = new Main();
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        controller.showInfo();
        main.showInfo();
        controller.pressPowerButton();
        controller.showInfo();
        main.showInfo();
        sqLiteJDBC.closeConnection();
        sqLiteJDBC.closeStatement();
    }

    public void showInfo(){
        try {
            SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
            ResultSet rs = sqLiteJDBC.statement.executeQuery( "SELECT * FROM TV;" );
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
    }
}
