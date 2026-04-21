package ru.maltsev.weapons;

/**
 * Класс {@code AutomaticGun2} представляет автоматическое оружие,
 * наследуемое от {@code Weapon}.
 * <p>
 * Оружие стреляет очередями заданное количество времени
 */
public class AutomaticGun2 extends Weapon {

    /** Скорострельность (выстрелов в секунду). */
    private final int rateOfFire;

    /**
     * Создаёт автомат с заданным количеством патронов
     * и скорострельностью.
     *
     * @param ammo        начальное количество патронов
     * @param rateOfFire  скорострельность (выстрелов в секунду),
     *                    должна быть положительной
     * @throws IllegalArgumentException если {@code rateOfFire <= 0}
     */
    public AutomaticGun2(int ammo, int rateOfFire) {
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
     * При наличии патронов выводится "Бах!",
     * при их отсутствии — "Клац!" и стрельба прекращается.
     */
    @Override
    public void shoot() {
        for (int i = 0; i < rateOfFire; i++) {
            if (getAmmo()) {
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

            if (getAmmo()) {
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
        return "Автомат [патроны: " + ammo() + ", скорострельность: " + rateOfFire + "]";
    }
}