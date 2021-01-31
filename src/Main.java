import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        try {
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
        sqLiteJDBC.closeConnection();
        sqLiteJDBC.closeStatement();
    }
}
