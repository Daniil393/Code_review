package ru.maltsev.weapons;

/**
 * Класс {@code AutomaticGun} представляет автоматическое оружие,
 * являющееся расширением класса {@code Pistol}.
 * <p>
 * Автомат стреляет очередями с заданной скорострельностью
 * (количество выстрелов в секунду).
 */
public class AutomaticGun extends Pistol {

    /** Скорострельность (выстрелов в секунду). */
    private final int fireRate;

    /**
     * Создаёт автомат с магазином на 30 патронов
     * и скорострельностью 30 выстрелов в секунду.
     */
    public AutomaticGun() {
        super(30);
        this.fireRate = 30;
    }

    /**
     * Создаёт автомат с указанной вместимостью магазина.
     * Скорострельность устанавливается равной половине вместимости.
     *
     * @param capacity вместимость магазина (количество патронов)
     */
    public AutomaticGun(int capacity) {
        super(capacity);
        this.fireRate = capacity / 2;
    }

    /**
     * Создаёт автомат с заданной вместимостью магазина
     * и скорострельностью.
     *
     * @param capacity вместимость магазина
     * @param fireRate скорострельность (выстрелов в секунду),
     *                 должна быть положительной
     * @throws IllegalArgumentException если {@code fireRate <= 0}
     */
    public AutomaticGun(int capacity, int fireRate) {
        super(capacity);

        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (fireRate <= 0)
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        */
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }

        this.fireRate = fireRate;
    }

    /**
     * Выполняет очередь выстрелов.
     * Количество выстрелов равно скорострельности.
     */
    @Override
    public void shoot() {
        super.shoot(fireRate);
    }

    /**
     * Выполняет стрельбу в течение указанного количества секунд.
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

        super.shoot(seconds * fireRate);
    }

    /**
     * Возвращает скорострельность автомата.
     *
     * @return количество выстрелов в секунду
     */
    public int getFireRate() {
        return fireRate;
    }
}