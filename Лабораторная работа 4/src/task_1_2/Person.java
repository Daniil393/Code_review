package task_1_2;

/**
 * Класс, представляющий человека с именем и ростом.
 */
public class Person {

    /*
    FIX_ME: добавлен модификатор final для полей,
    чтобы сделать объект неизменяемым.

    private String name;
    private int height;
     */
    /** Имя человека. */
    private final String name;
    /** Рост человека (в сантиметрах). */
    private final int height;

    /**
     * Создаёт объект человека с заданными параметрами.
     *
     * <p>Инициализирует имя и рост переданными значениями.
     *
     * @param name имя человека
     * @param height рост человека (в сантиметрах)
     */

    /*
    FIX_ME: добавлена проверка параметров
    для предотвращения некорректных данных.

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
     */
    public Person(String name, int height) {
        if (name == null || name.isBlank() || !name.matches("[a-zA-Zа-яА-ЯёЁ\\- ]+")) {
            throw new IllegalArgumentException("имя содержит недопустимые символы");
        }

        if (height < 0) {
            throw new IllegalArgumentException("рост не может быть отрицательным");
        }

        this.name = name;
        this.height = height;
    }

    /**
     * Конструктор по умолчанию.
     *
     * <p>Создаёт объект с пустым именем и нулевым ростом.
     */
    public Person() {
        this.name = "";
        this.height = 0;
    }

    /**
     * Возвращает имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает рост человека.
     *
     * @return рост человека (в сантиметрах)
     */
    public int getHeight() {
        return height;
    }

    /**
     * Возвращает строковое представление объекта.
     *
     * <p>Формат: "имя, рост: значение".
     *
     * @return строка с информацией о человеке
     */
    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}