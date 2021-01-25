import java.io.FileWriter;
import java.io.IOException;
/** Класс хранит данные телевизора.
 * @see TV
 * @see TV2 */
public class Television {
    private int channel = 0;
    private int sound = 0;
    private boolean power = false;
    private String fileName;
    ConnectionUtil connectionUtil = new ConnectionUtil();

    {
        connectionUtil.createStatement();
    }
    /** Метод устанавливает и записывает значение переменной <b>boolean</b>
     * Получить значение переменной можно через */
    public void setPower(){
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
/**
 * @see TV2*/
class TV extends Television{
    private String fileName = "TVConfiguration.txt";
}
/**
 * @see TV*/

class TV2 extends Television{
    private String fileName = "TV2Configuration.txt";
}
