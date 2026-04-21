package ru.maltsev.weapons;

/**
 * Класс {@code AutomaticGun3} представляет автоматическое оружие,
 * наследуемое от {@code Weapon2}.
 * <p>
 * Автомат стреляет очередями с заданной скорострельностью.
 * При каждом выстреле количество патронов уменьшается.
 * Если патроны заканчиваются, выводится сообщение "Клац!",
 * и стрельба прекращается.
 */
public class AutomaticGun3 extends Weapon2 {

    /** Скорострельность (выстрелов в секунду). */
    private final int rateOfFire;

    /**
     * Создаёт автомат с указанным количеством патронов
     * и скорострельностью.
     *
     * @param ammo       начальное количество патронов
     * @param rateOfFire скорострельность (выстрелов в секунду),
     *                   должна быть положительной
     * @throws IllegalArgumentException если {@code rateOfFire <= 0}
     */
    public AutomaticGun3(int ammo, int rateOfFire) {
        super(ammo);

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (rateOfFire <= 0)
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        */
        if (rateOfFire <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }

        this.rateOfFire = rateOfFire;
    }

    /**
     * Производит очередь выстрелов.
     * Количество попыток выстрела равно скорострельности.
     * <p>
     * При наличии патронов выводится "Бах!" и патрон уменьшается.
     * При отсутствии патронов выводится "Клац!", после чего стрельба прекращается.
     */
    @Override
    public void shoot() {
        for (int i = 0; i < rateOfFire; i++) {
            if (ammo > 0) {
                ammo--;
                System.out.println("Бах!");
            } else {
                System.out.println("Клац!");
                break;
            }
        }
    }

    /**
     * Производит стрельбу в течение указанного количества секунд.
     *
     * @param seconds продолжительность стрельбы (в секундах),
     *                должна быть положительной
     * @throws IllegalArgumentException если {@code seconds <= 0}
     */
    public void shoot(int seconds) {
        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (seconds <= 0)
            throw new IllegalArgumentException("Время должно быть положительным");
        */
        if (seconds <= 0) {
            throw new IllegalArgumentException("Время должно быть положительным");
        }

        for (int i = 0; i < seconds * rateOfFire; i++) {
            if (ammo > 0) {
                ammo--;
                System.out.println("Бах!");
            } else {
                System.out.println("Клац!");
                break;
            }
        }
    }

    /**
     * Возвращает скорострельность автомата.
     *
     * @return количество выстрелов в секунду
     */
    public int getRateOfFire() {
        return rateOfFire;
    }

    /**
     * Возвращает строковое представление автомата.
     *
     * @return строка в формате:
     * "Автомат [патроны: X, скорострельность: Y]"
     */
    @Override
    public String toString() {
        return "Автомат [патроны: " + ammo + ", скорострельность: " + rateOfFire + "]";
    }
}