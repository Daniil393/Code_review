package task_2_4;

/**
 * Класс, представляющий отдел компании.
 */
public class Department {

    /** Название отдела. */
    private String name;
    /** Руководитель отдела. */
    private Employee chief;

    /**
     * Создаёт отдел с заданным названием.
     *
     * @param name название отдела
     */

    /*
    FIX_ME: добавлена валидация входных данных.
    Запрещено создание отдела с пустым или null названием.

    public Department(String name) {
        this.name = name;
    }
     */
    public Department(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("название отдела не может быть пустым");
        }

        this.name = name;
    }

    /**
     * Устанавливает руководителя отдела.
     *
     * @param chief сотрудник, назначаемый руководителем
     */

    /*
    FIX_ME: добавлена проверка параметра.
    Запрещено устанавливать null в качестве руководителя.

    public void setChief(Employee chief) {
        this.chief = chief;
    }
     */
    public void setChief(Employee chief) {
        if (chief == null) {
            throw new IllegalArgumentException("руководитель не может быть пустым");
        }

        this.chief = chief;
    }

    /**
     * Устанавливает название отдела.
     *
     * @param name название отдела
     */

    /*
    FIX_ME: добавлена валидация входного параметра.
    Запрещено устанавливать пустое или null название отдела.

    public void setName(String name) {
        this.name = name;
    }
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("название отдела не может быть пустым");
        }

        this.name = name;
    }

    /**
     * Возвращает название отдела.
     *
     * @return название отдела
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает руководителя отдела.
     *
     * @return руководитель отдела
     */
    public Employee getChief() {
        return chief;
    }

    /**
     * Возвращает строковое представление отдела.
     *
     * <p>Включает название.
     *
     * @return строка с данными отдела
     */
    @Override
    public String toString() {
        return name;
    }
}