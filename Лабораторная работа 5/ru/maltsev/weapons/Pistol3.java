package ru.maltsev.weapons;

/**
 * Класс {@code Pistol3} представляет пистолет,
 * реализованный на основе класса {@code Weapon2}.
 * <p>
 * Пистолет имеет ограниченную вместимость магазина,
 * поддерживает перезарядку, разрядку и выполнение выстрелов.
 * Управление количеством патронов осуществляется напрямую
 * через поле {@code ammo}, унаследованное от {@code Weapon2}.
 */
public class Pistol3 extends Weapon2 {

    /** Максимальная вместимость магазина. */
    private final int capacity;

    /**
     * Создаёт пистолет с указанной вместимостью магазина.
     * Начальное количество патронов равно 0.
     *
     * @param capacity максимальное количество патронов
     * @throws IllegalArgumentException если {@code capacity < 0}
     */
    public Pistol3(int capacity) {
        super(0);

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        */
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        }
        this.capacity = capacity;
    }

    /**
     * Производит выстрел
     * <p>
     * Если патроны есть — уменьшает их количество и выводит "Бах!".
     * Если патронов нет — выводит "Клац!".
     */
    @Override
    public void shoot() {
        if (ammo > 0) {
            ammo--;
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    /**
     * Производит несколько выстрелов подряд.
     *
     * @param times количество выстрелов (не может быть отрицательным)
     * @throws IllegalArgumentException если {@code times < 0}
     */
    public void shoot(int times) {

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (times < 0)
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");
        */
        if (times < 0) {
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");
        }

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        for (int i = 0; i < times; i++)
            shoot();
        */
        for (int i = 0; i < times; i++) {
            shoot();
        }
    }

    /**
     * Загружает патроны в магазин.
     *
     * @param bulletsToLoad количество патронов для загрузки
     *                      (не может быть отрицательным)
     * @return количество патронов, которые не поместились
     * @throws IllegalArgumentException если {@code bulletsToLoad < 0}
     */
    public int reload(int bulletsToLoad) {
        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (bulletsToLoad < 0)
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        */
        if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }

        int spaceLeft = capacity - ammo;

        if (bulletsToLoad <= spaceLeft) {
            ammo += bulletsToLoad;
            return 0;
        } else {
            ammo = capacity;
            return bulletsToLoad - spaceLeft;
        }
    }

    /**
     * Разряжает пистолет.
     *
     * @return количество извлечённых патронов
     */
    public int unload() {
        int currentAmmo = ammo;
        ammo = 0;
        return currentAmmo;
    }

    /**
     * Проверяет, заряжен ли пистолет.
     *
     * @return {@code true}, если есть хотя бы один патрон,
     *         иначе {@code false}
     */
    public boolean isLoaded() {
        return ammo > 0;
    }

    /**
     * Возвращает вместимость магазина.
     *
     * @return максимальное количество патронов
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Возвращает строковое представление пистолета.
     *
     * @return строка в формате:
     * "Пистолет [патроны: X]"
     */
    @Override
    public String toString() {
        return "Пистолет [патроны: " + ammo + "]";
    }
}