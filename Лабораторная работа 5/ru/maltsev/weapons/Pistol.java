package ru.maltsev.weapons;

/**
 * Класс {@code Pistol} представляет пистолет с ограниченной вместимостью магазина.
 * <p>
 * Пистолет может быть перезаряжен, разряжен и выполнять одиночные
 * или множественные выстрелы.
 */
public class Pistol {

    /** Текущее количество патронов в магазине. */
    private int bullets;

    /** Максимальная вместимость магазина. */
    private final int capacity;

    /**
     * Создаёт пистолет с указанной вместимостью магазина.
     *
     * @param capacity максимальное количество патронов (не может быть отрицательным)
     * @throws IllegalArgumentException если {@code capacity < 0}
     */
    public Pistol(int capacity) {
        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        */
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        }

        this.capacity = capacity;
        this.bullets = 0;
    }

    /**
     * Производит выстрел.
     * <p>
     * Если патроны есть — выводится "Бах!" и количество уменьшается.
     * Если патронов нет — выводится "Клац!".
     */

    /*
    FIX_ME: Дублирование логики стрельбы в методах shoot() и shoot(int times).
    Нарушение принципа DRY (Don't Repeat Yourself).

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }
    */
    public void shoot() {
        shoot(1);
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

        for (int i = 0; i < times; i++) {
            if (bullets > 0) {
                System.out.println("Бах!");
                bullets--;
            /*
            FIX_ME: else должен находиться на той же строке что и }.

            }
            else {
                System.out.println("Клац!");
            }
            */
            } else {
                System.out.println("Клац!");
            }
        }
    }

    /**
     * Загружает патроны в магазин.
     *
     * @param bulletsToLoad количество патронов для загрузки
     *                      (не может быть отрицательным)
     * @return количество патронов, которые не поместились в магазин
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

        int total = bullets + bulletsToLoad;

        if (total <= capacity) {
            bullets = total;
            return 0;
        /*
        FIX_ME: else должен находиться на той же строке что и }.

        }
        else {
            bullets = capacity;
            return total - capacity;
        }
        */
        } else {
            bullets = capacity;
            return total - capacity;
        }
    }

    /**
     * Разряжает пистолет.
     *
     * @return количество извлечённых патронов
     */
    public int unload() {
        int returned = bullets;
        bullets = 0;
        return returned;
    }

    /**
     * Проверяет, заряжен ли пистолет.
     *
     * @return {@code true}, если есть хотя бы один патрон,
     *         иначе {@code false}
     */
    public boolean isLoaded() {
        return bullets > 0;
    }

    /**
     * Возвращает максимальную вместимость магазина.
     *
     * @return вместимость
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Возвращает текущее количество патронов.
     *
     * @return количество патронов
     */
    public int getBullets() {
        return bullets;
    }

    /**
     * Возвращает строковое представление пистолета.
     *
     * @return строка в формате:
     * "Пистолет [патроны: X]"
     */
    @Override
    public String toString() {
        return "Пистолет [патроны: " + bullets + "]";
    }
}