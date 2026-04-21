package ru.maltsev.people;

/**
 * Неизменяемый класс, представляющий ФИО человека.
 * Поля могут быть {@code null}, однако хотя бы одно из них
 * должно быть указано.
 */
public final class Name {

    /** Фамилия. */
    private final String lastName;

    /** Имя. */
    private final String firstName;

    /** Отчество. */
    private final String patronymic;

    /**
     * Создаёт объект ФИО с возможностью указания всех частей.
     *
     * @param firstName  имя (может быть {@code null} или пустым)
     * @param patronymic отчество (может быть {@code null} или пустым)
     * @param lastName   фамилия (может быть {@code null} или пустым)
     * @throws IllegalArgumentException если все части ФИО отсутствуют
     */
    public Name(String firstName, String patronymic, String lastName) {
        this.firstName = normalize(firstName);
        this.patronymic = normalize(patronymic);
        this.lastName = normalize(lastName);

        validate();
    }

    /**
     * Создаёт объект ФИО без отчества.
     *
     * @param firstName имя (может быть {@code null} или пустым)
     * @param lastName  фамилия (может быть {@code null} или пустым)
     */
    public Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    /**
     * Создаёт объект, содержащий только имя.
     *
     * @param firstName имя (может быть {@code null} или пустым)
     */
    public Name(String firstName) {
        this(firstName, null, null);
    }

    /**
     * Нормализует строку:
     * обрезает пробелы по краям
     * заменяет пустую строку на {@code null}
     *
     * @param s исходная строка
     * @return нормализованное значение или {@code null}
     */
    private String normalize(String s) {

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (s == null)
            return null;
        */
        if (s == null) {
            return null;
        }
        s = s.trim();
        return s.isEmpty() ? null : s;
    }

    /**
     * Проверяет корректность состояния объекта.
     *
     * @throws IllegalArgumentException если все поля равны {@code null}
     */
    private void validate() {

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (firstName == null && lastName == null && patronymic == null)
            throw new IllegalArgumentException("Хотя бы одно из ФИО должно быть написано");
        */
        if (firstName == null && lastName == null && patronymic == null) {
            throw new IllegalArgumentException("Хотя бы одно из ФИО должно быть написано");
        }
    }

    /**
     * Возвращает фамилию.
     *
     * @return фамилия или {@code null}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Возвращает имя.
     *
     * @return имя или {@code null}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Возвращает отчество.
     *
     * @return отчество или {@code null}
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Возвращает строковое представление ФИО.
     * Формат: "Фамилия Имя Отчество".
     * Отсутствующие части пропускаются.
     *
     * @return строковое представление ФИО
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (lastName != null) sb.append(lastName).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (patronymic != null) sb.append(patronymic);
        */
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