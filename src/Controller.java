/** Класс содержит все методы, которые должны быть у пульта*/
public interface Controller {
    /**
     * Показать всю информацию по выбранному телевизору.
     */
    void showInfo();

    /**
     * Включить телевизор.
     * <p>Планируется также, что без включения телевизора нельзя будет взаимодействовать с остальными параметрами.</p>
     */
    void pressPowerButton();

    /**
     * Повысить громкость телевизора.
      */
    void pressSoundUpButton();

    /**
     * Понизить громкость телевизора.
     */
    void pressSoundDownButton();

    /**
     * Следуйщий канал.
      */
    void pressNextChannelButton();

    /**
     * Предыдущий канал.
      */
    void pressPreviousChannelButton();
}
