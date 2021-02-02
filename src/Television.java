import java.sql.SQLException;

/**
 * Класс телевизора. Идея состоит в том, что он должен хранить данные телевизора (не в пульте же это делать).
 * Мой проект маленький, но если бы он был больше, то такое разделение было бы очень кстати.
 * <p>
 * Класс имеет стандартные методы и два подкласса {@link TV} и {@link TV2}
 * как два разных телевизора - наследника этого класса, с которыми сможет взаимодействовать пульт.
 */
public class Television {
    SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
    private int channel;
    private int sound;
    private boolean power;


    {
        sqLiteJDBC.getConnection();
        sqLiteJDBC.createStatement();
        try {
            power = sqLiteJDBC.executeQuery().getBoolean("power");
            sound = sqLiteJDBC.executeQuery().getInt("sound");
            channel = sqLiteJDBC.executeQuery().getInt("channel");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setPower(){
        power = !power;
        if (power){
            sqLiteJDBC.executeUpdate("UPDATE TV set power = 1 where ID = 1");
        } else {
            sqLiteJDBC.executeUpdate("UPDATE TV set power = 0 where ID = 1");
        }
    }
    public boolean getPower(){
        try {
            power = sqLiteJDBC.executeQuery().getBoolean("power");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return power;
    }


    public void setSound(int soundChange){
        sound += soundChange;
        if (sound > 100)
            sound = 100;
        if (sound < 0)
            sound = 0;
        sqLiteJDBC.executeUpdate("UPDATE TV set SOUND = " + sound + " where ID = 1");
    }
    public int getSound(){
        try {
            sound = sqLiteJDBC.executeQuery().getInt("sound");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sound;
    }


    public void setChannel(int channelChange){
        channel += channelChange;
        if (channel > 20)
            channel = 20;
        if (channel < 1)
            channel = 1;
        sqLiteJDBC.executeUpdate("UPDATE TV set channel = " + channel + " where ID = 1");
    }
    public int getChannel(){
        try {
            channel = sqLiteJDBC.executeQuery().getInt("channel");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return channel;
    }
}

class TV extends Television{

}

class TV2 extends Television{
}
