/** Класс содержит все методы, которые должны быть у пульта.
 * */
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
     * Повысить громкость телевизора на 1.
      */
    void pressSoundUpButton();

    /**
     * Повысить громкость телевизора на <code>count</code>
     * @param count - изменение громкости
     */
    void pressSoundUpButton(int count);

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

    /**
     * Метод устанавливает стандратные значение переменных.
     * <pre>
     *
     *     power - false
     *     sound - 0
     *     channel - 1
     * </pre>
     */
    void setDefault();
}
