package task_1_3;

/**
 * Класс, представляющий полное имя человека.
 */
public class Name {

    /*
    FIX_ME: добавлен модификатор final для полей,
    чтобы сделать объект неизменяемым.

    private String lastName;
    private String firstName;
    private String patronymic;
     */
    /** Фамилия. */
    private final String lastName;
    /** Имя. */
    private final String firstName;
    /** Отчество. */
    private final String patronymic;

    /**
     * Создаёт объект имени с заданными частями.
     * Один из параметров обязательно должен быть задан.
     *
     * @param lastName фамилия (может быть null или пустой)
     * @param firstName имя (может быть null или пустым)
     * @param patronymic отчество (может быть null или пустым)
     */

    /*
    FIX_ME: добавлена валидация входных данных.
    Запрещено создание объекта Name:
    - с полностью пустыми значениями;
    - с недопустимыми символами в имени.

    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }
     */
    public Name(String lastName, String firstName, String patronymic) {
        if ((lastName == null || lastName.isBlank()) &&
                (firstName == null || firstName.isBlank()) &&
                (patronymic == null || patronymic.isBlank())) {
            throw new IllegalArgumentException("хотя бы одно поле должно быть задано");
        }

        validatePart(lastName);
        validatePart(firstName);
        validatePart(patronymic);

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    /*
    FIX_ME: добавлен метод для проверки корректности частей имени.
    Метод запрещает использование цифр и недопустимых символов.
     */

    /**
     * Проверяет корректность части имени.
     *
     * <p>Допускаются только буквы, пробел и дефис.
     *
     * @param value строка для проверки
     */
    private void validatePart(String value) {

        if (value == null || value.isBlank()) {
            return;
        }

        if (!value.matches("[a-zA-Zа-яА-ЯёЁ\\- ]+")) {
            throw new IllegalArgumentException(
                    "имя должно содержать только буквы\n");
        }
    }

    /**
     * Возвращает строковое представление имени.
     *
     * <p>Формирует строку из доступных частей имени.
     * Пустые и null значения пропускаются.
     *
     * @return строковое представление имени в формате
     *         "Фамилия Имя Отчество" (в зависимости от заполненных полей)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName).append(" ");
        }
        if (firstName != null && !firstName.isEmpty()) {
            sb.append(firstName).append(" ");
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            sb.append(patronymic);
        }

        return sb.toString().trim();
    }
}