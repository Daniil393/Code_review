package ru.maltsev.main;
import ru.maltsev.weapons.Weapon;

/**
 * Класс {@code Shooter} представляет стрелка,
 * который может иметь оружие и выполнять выстрел.
 */
public class Shooter {

    /** Имя стрелка. */
    private String name;

    /** Оружие стрелка (может быть {@code null}). */
    private Weapon weapon;

    /**
     * Создаёт стрелка с указанным именем.
     *
     * @param name имя стрелка (не может быть {@code null} или пустым)
     * @throws IllegalArgumentException если имя {@code null} или пустое
     */
    public Shooter(String name) {
        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        */
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        this.name = name;
    }

    /**
     * Возвращает имя стрелка.
     *
     * @return имя стрелка
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает новое имя стрелка.
     *
     * @param name новое имя (не может быть {@code null} или пустым)
     * @throws IllegalArgumentException если имя {@code null} или пустое
     */
    public void setName(String name) {

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        */
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        this.name = name;
    }

    /**
     * Возвращает текущее оружие стрелка.
     *
     * @return объект оружия или {@code null}, если оружие отсутствует
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Устанавливает оружие стрелку.
     *
     * @param weapon объект оружия (может быть {@code null})
     */

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Выполняет выстрел.
     * Если оружие установлено, стрелок объявляет себя и вызывает метод
     * {@code shoot()} у оружия.
     * Если оружие отсутствует, выводится сообщение о невозможности стрельбы.
     */
    public void shoot() {
        if (weapon != null) {
            System.out.println(name + ": ");
            weapon.shoot();

        /*
        FIX_ME: else должен находиться на той же строке что и }.
        Отсутствуют фигурные скобки в if.

        }
        else
            System.out.println(name + ": не могу участвовать в перестрелке");
        */
        } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
    }

    /**
     * Возвращает строковое представление стрелка.
     *
     * @return строка в формате:
     * "Стрелок: имя, оружие: тип оружия"
     */
    @Override
    public String toString() {
        return "Стрелок: " + name + ", оружие: " + (weapon == null ? "нет" : weapon.getClass().getSimpleName());
    }
}