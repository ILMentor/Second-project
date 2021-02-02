public class ControllerRealization implements Controller{
    Television tv;
    /**
     * Это класс пульта. Любое взаимодействие с пультом проходит через этот класс.
     * Результаты работы этого класса влияют на класс {@link Television} как пульт должен влият на телевизор.
     * <p>
     * Для правильной работы класса нужно подключить объект одного из подклассов класса {@link Television}:
     * {@link TV} или {@link TV2}.
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
        System.out.println("Sound: " + tv.getSound() + "\n");
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
    public void pressSoundUpButton(int count) {
        tv.setSound(count);
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

    @Override
    public void setDefault() {
        tv.setSound(-100);
        tv.setChannel(-20);
        if(tv.getPower())
        tv.setPower();
    }
}
