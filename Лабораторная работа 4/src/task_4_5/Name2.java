package task_4_5;

/**
 * Класс, представляющий полное имя человека.
 */
public class Name2 {

    /*
    FIX_ME: добавлен модификатор final для полей,
    чтобы сделать объект неизменяемым.

    private String lastName;
    private String firstName;
    private String patronymic;
     */

    /** Фамилия человека. */
    private final String lastName;
    /** Имя человека. */
    private final String firstName;
    /** Отчество человека. */
    private final String patronymic;

    /**
     * Создаёт объект с полным именем.
     *
     * @param firstName имя
     * @param patronymic отчество
     * @param lastName фамилия
     */

    /*
    FIX_ME: добавлена проверка параметров
    для предотвращения некорректных данных.

    public Name2(String firstName, String patronymic, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }
     */
    public Name2(String firstName, String patronymic, String lastName) {
        validateName(firstName);
        validateName(patronymic);
        validateName(lastName);

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    /**
     * Создаёт объект с именем и фамилией.
     *
     * @param firstName имя
     * @param lastName фамилия
     */

    /*
    FIX_ME: добавлена проверка параметров
    для предотвращения некорректных данных.
    добавлена инициализация final-полей.

    public Name2( String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
     */
    public Name2( String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = null;
    }

    /**
     * Создаёт объект только с именем.
     *
     * @param firstName имя
     */

    /*
    FIX_ME: добавлена проверка параметров
    для предотвращения некорректных данных.
    добавлена инициализация final-полей.

    public Name2(String firstName) {
        this.firstName = firstName;
    }
    */
    public Name2(String firstName) {
        validateName(firstName);

        this.firstName = firstName;
        this.lastName = null;
        this.patronymic = null;
    }

    /**
     * Проверяет корректность имени.
     *
     * @param value строка для проверки
     */

    // FIX_ME: добавлена функция для проверки параметров.
    private void validateName(String value) {
        if (value == null || value.isBlank()) {
            return;
        }

        if (!value.matches("[a-zA-Zа-яА-ЯёЁ\\- ]+")) {
            throw new IllegalArgumentException("имя содержит недопустимые символы");
        }
    }

    /**
     * Возвращает строковое представление имени.
     *
     * <p>В результат включаются только непустые части имени.
     *
     * @return строка с именем человека
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null) {
            sb.append(lastName).append(" ");
        }
        if (firstName != null) {
            sb.append(firstName).append(" ");
        }
        if (patronymic != null) {
            sb.append(patronymic);
        }

        return sb.toString().trim();
    }
}