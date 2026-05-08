package task_3_4;

import java.util.List;

/**
 * Класс, представляющий сотрудника компании (расширенная версия).
 */
public class Employee2 {

    /** Имя сотрудника */
    private String name;
    /** Отдел сотрудника */
    private Department2 department;

    /**
     * Создаёт сотрудника с указанным именем и отделом.
     *
     * <p>После создания сотрудник автоматически добавляется в список
     * сотрудников отдела.
     *
     * @param name имя сотрудника
     * @param department отдел сотрудника
     * @throws IllegalArgumentException если имя null, пустое или содержит не только буквы
     * @throws IllegalArgumentException если department равен null
     */

    /*
    FIX_ME: добавлена валидация входных данных.
    Запрещены null и пустые значения.

    public Employee2(String name, Department2 department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }
     */
    public Employee2(String name, Department2 department) {
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

        department.addEmployee(this);
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
    public Department2 getDepartment() {
        return department;
    }

    /**
     * Возвращает список всех сотрудников отдела,
     * включая самого сотрудника.
     *
     * @return список сотрудников отдела
     */
    public List<Employee2> getColleagues() {
        return department.getEmployees();
    }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * <p>Учитывает роль сотрудника:
     * <ul>
     *     <li>если сотрудник является начальником - выводится соответствующая информация</li>
     *     <li>если начальник не назначен - это также отражается в строке</li>
     * </ul>
     *
     * @return строка с информацией о сотруднике
     */

    /*
    FIX_ME: защита от null значения.
    Нет фигурных скобок в if (chief == this)

    @Override
    public String toString() {
        Employee2 chief = department.getChief();

        if (chief == this)
            return name + " начальник отдела " + department.getName();

        return name + " работает в отделе " + department.getName() +
                ", начальник которого " + chief.getName();
    }
     */
    @Override
    public String toString() {
        Employee2 chief = department.getChief();

        if (chief == this) {
            return name + " начальник отдела " + department.getName();
        }

        if (chief == null) {
            return name + " работает в отделе " + department.getName()
                    + ", начальник не назначен";
        }

        return name + " работает в отделе " + department.getName()
                + ", начальник которого " + chief.getName();
    }
}