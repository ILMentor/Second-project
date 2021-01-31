
/* todo Нужно закончить интеграцию моей базы данных в этот проект.
    Как записывать данные в базу я понял. Нужно теперь их оттуда достатьвать. */
    //todo Нужно реализовать запись данных для одного телика сначала, потом для двух.
    //todo Понять, что не так было с блоками try catch и return и понять как мне помог мой финт ушами.

/**
 * Класс телевизора. Идея состоит в том, что он должен хранить данные телевизора (не в пульте же это делать).
 * Мой проект маленький, но если бы он был больше, то такое разделение было бы очень кстати.
 * <p>
 * Класс имеет стандартные методы и два подкласса {@link TV} и {@link TV2}
 * как два разных телевизора - наследника этого класса, с которыми сможет взаимодействовать пульт.
 */
public class Television {
    SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
    private int channel = 0;
    private int sound = 0;
    private boolean power = false;
    ConnectionUtil connectionUtil = new ConnectionUtil();

    {
        connectionUtil.createStatement();
    }

    public void setPower(){
        int id = 0;
        sqLiteJDBC.executeUpdate("UPDATE TV set POWER = " + !power + "where id = " + id);
        power = !power;
    }
    public boolean getPower(){
        return power;
    }


    public void setSound(int soundChange){
        sound += soundChange;
        if (sound > 100)
            sound = 100;
        if (sound < 0)
            sound = 0;
        connectionUtil.updateSound();
    }
    public int getSound(){
        return sound;
    }


    public void setChannel(int channelChange){
        channel += channelChange;
        if (channel > 20)
            channel = 20;
        if (channel < 1)
            channel = 1;
    }
    public int getChannel(){
        return channel;
    }
}

class TV extends Television{

}

class TV2 extends Television{
}
