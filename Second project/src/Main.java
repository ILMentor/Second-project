

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerRealization(new TV());
        controller.showInfo();
        controller.pressPowerButton();
        controller.pressNextChannelButton();
        controller.pressSoundUpButton();
    }
}