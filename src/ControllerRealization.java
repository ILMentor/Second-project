import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerRealization implements Controller{
    Television tv;
    /** Реализация интерфейса {@link Controller}.
     * Использует методы класса {@link Television}.
     * Для правильной работы класса нужно подключить объект одного из подклассов класса {@link Television}
     */
    ControllerRealization(Television tv){
        this.tv = tv;
    }

    @Override
    public void showInfo() {
        if(tv.getPower())
            System.out.println("TV is on.");
        else
            System.out.println("TV is off.");
        System.out.println("Channel is " + tv.getChannel());
        System.out.println("Sound: " + tv.getSound());
    }

    @Override
    public void pressPowerButton() {
        tv.setPower();
        if(tv.getPower())
            System.out.println("TV is on.");
        else
            System.out.println("TV is off.");

    }

    @Override
    public void pressSoundUpButton() {
        tv.setSound(1);
        System.out.println("Sound: " + tv.getSound());
    }

    @Override
    public void pressSoundDownButton() {
        tv.setSound(-1);
        System.out.println("Sound: " + tv.getSound());
    }

    @Override
    public void pressNextChannelButton() {
        tv.setChannel(1);
        System.out.println("Now you are looking at channel " + tv.getChannel());
    }

    @Override
    public void pressPreviousChannelButton() {
        tv.setChannel(-1);
        System.out.println("Now you are looking at channel " + tv.getChannel());
    }
}
