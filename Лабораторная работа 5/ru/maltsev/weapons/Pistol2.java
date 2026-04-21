package ru.maltsev.weapons;

/**
 * Класс {@code Pistol2} представляет пистолет,
 * реализованный на основе абстрактного класса {@code Weapon}.
 * <p>
 * Пистолет имеет ограниченную вместимость магазина,
 * поддерживает перезарядку, разрядку и выполнение выстрелов.
 */
public class Pistol2 extends Weapon {

    /** Максимальная вместимость магазина. */
    private final int capacity;

    /**
     * Создаёт пистолет с указанной вместимостью.
     * Начальное количество патронов равно 0.
     *
     * @param capacity максимальное количество патронов
     * @throws IllegalArgumentException если {@code capacity < 0}
     */
    public Pistol2(int capacity) {
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
     * Производит выстрел.
     * <p>
     * Если есть патроны — выводится "Бах!".
     * Если патронов нет — выводится "Клац!".
     */
    @Override
    public void shoot() {
        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (getAmmo())
            System.out.println("Бах!");
        else
            System.out.println("Клац!");
        */
        if (getAmmo()) {
            System.out.println("Бах!");
        }
        else {
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

        for (int i = 0; i < times; i++)
            shoot();
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

        int currentAmmo = ammo();
        int spaceleft = capacity - currentAmmo;

        if (bulletsToLoad <= spaceleft) {
            load(currentAmmo + bulletsToLoad);
            return 0;

        /*
        FIX_ME: else должен находиться на той же строке что и }.

        }
        else {
            load(capacity);
            return bulletsToLoad - spaceleft;
        }
        */
        } else {
            load(capacity);
            return bulletsToLoad - spaceleft;
        }
    }

    /**
     * Разряжает пистолет.
     *
     * @return количество извлечённых патронов
     */
    public int unload() {
        int currentAmmo = ammo();
        load(0);
        return currentAmmo;
    }

    /**
     * Проверяет, заряжен ли пистолет.
     *
     * @return {@code true}, если есть хотя бы один патрон,
     *         иначе {@code false}
     */
    public boolean isLoaded() {
        return ammo() > 0;
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
        return "Пистолет [патроны: " + ammo() + "]";
    }
}