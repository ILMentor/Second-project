public class Main {

    public static void main(String[] args) {
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        sqLiteJDBC.closeConnection();
        sqLiteJDBC.closeStatement();
    }
}