package task_2_4;

/**
 * Класс, представляющий сотрудника компании.
 */
public class Employee {

    /** Имя сотрудника. */
    private String name;
    /** Отдел, в котором работает сотрудник. */
    private Department department;

    /**
     * Создаёт сотрудника с указанным именем и отделом.
     *
     * @param name имя сотрудника
     * @param department отдел сотрудника
     */

    /*
    FIX_ME: добавлена валидация входных данных.
    Запрещено создание сотрудника с пустым именем или
    с другими символами кроме букв алфавита.

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
     */
    public Employee(String name, Department department) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя сотрудника не может быть пустым");
        }

        if (!name.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
            throw new IllegalArgumentException("имя должно содержать только буквы");
        }

        if (department == null) {
            throw new IllegalArgumentException("отдел не может быть null");
        }

        this.name = name;
        this.department = department;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает отдел сотрудника.
     *
     * @return отдел сотрудника
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * <p>Учитывает роль сотрудника (начальник или обычный работник)
     * и защищён от null-значений.
     *
     * @return строка с информацией о сотруднике
     */
    @Override
    public String toString() {
        Department dep = department;
        Employee chief = dep.getChief();

        if (chief == this) {
            return name + " начальник отдела " + dep.getName();
        }

        return name + " работает в отделе " + dep.getName()
                + ", начальник которого " + chief.getName();
    }
}