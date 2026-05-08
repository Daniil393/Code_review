package task_3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Класс, представляющий отдел компании (расширенная версия).
 */
public class Department2 {

    /** Название отдела. */
    private String name;
    /** Руководитель отдела. */
    private Employee2 chief;
    /** Список сотрудников отдела. */
    private List<Employee2> employees = new ArrayList<>();

    /**
     * Создаёт отдел с заданным названием.
     *
     * @param name название отдела
     * @throws IllegalArgumentException если название null или пустое
     */

    /*
    FIX_ME: добавлена валидация названия отдела.
    Запрещены null и пустые строки.

    public Department2(String name) {
        this.name = name;
    }
     */
    public Department2(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("название отдела не может быть пустым");
        }
        this.name = name;
    }

    /**
     * Назначает руководителя отдела.
     *
     * @param chief сотрудник, назначаемый руководителем
     * @throws IllegalArgumentException если chief равен null
     */

    /*
    FIX_ME: добавлена проверка на null

    public void setChief(Employee2 chief) {
        this.chief = chief;
    }
     */
    public void setChief(Employee2 chief) {
        if (chief == null) {
            throw new IllegalArgumentException("руководитель не может быть null");
        }
        this.chief = chief;
    }

    /**
     * Возвращает руководителя отдела.
     *
     * @return руководитель отдела
     */
    public Employee2 getChief() {
        return chief;
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
     * Устанавливает новое название отдела.
     *
     * @param name новое название
     * @throws IllegalArgumentException если название null или пустое
     */

    /*
    FIX_ME: валидация имени отдела.

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
     * Добавляет сотрудника в отдел.
     *
     * @param e сотрудник
     * @throws IllegalArgumentException если сотрудник null
     * или уже добавлен в отдел
     */

    /*
    FIX_ME: защита от null и дубликатов сотрудников.

    public void addEmployee(Employee2 e) {
        employees.add(e);
    }
     */
    public void addEmployee(Employee2 e) {
        if (e == null) {
            throw new IllegalArgumentException("сотрудник не может быть null");
        }

        if (employees.contains(e)) {
            throw new IllegalArgumentException("сотрудник уже добавлен в отдел");
        }
        employees.add(e);
    }

    /**
     * Возвращает список сотрудников отдела.
     *
     * <p>Список является неизменяемым - попытка изменить его приведёт к ошибке.
     *
     * @return неизменяемый список сотрудников
     */

    /*
    FIX_ME: возвращаем неизменяемый список (инкапсуляция).

    public List<Employee2> getEmployees() {
        return employees;
    }
     */
    public List<Employee2> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    /**
     * Возвращает строковое представление отдела.
     *
     * @return название отдела
     */
    @Override
    public String toString() {
        return name;
    }
}