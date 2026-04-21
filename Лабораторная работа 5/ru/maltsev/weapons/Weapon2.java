package ru.maltsev.weapons;

/**
 * Абстрактный класс {@code Weapon2} представляет оружие с
 * защищённым количеством патронов.
 * <p>
 * Поддерживает стрельбу, проверку наличия патронов и управление боезапасом.
 * В отличие от {@code Weapon}, поле {@code ammo} имеет модификатор
 * {@code protected}, что позволяет подклассам напрямую изменять его.
 */
public abstract class Weapon2 {

    /** Текущее количество патронов. */
    protected int ammo;

    /**
     * Создаёт оружие с указанным количеством патронов.
     *
     * @param ammo начальное количество патронов (не может быть отрицательным)
     * @throws RuntimeException если {@code ammo < 0}
     */
    public Weapon2(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        this.ammo = ammo;
    }

    /**
     * Абстрактный метод для стрельбы.
     * <p>
     * Конкретная реализация должна быть предоставлена в подклассах.
     */
    public abstract void shoot();

    /**
     * Возвращает текущее количество патронов.
     *
     * @return количество патронов
     */
    public int ammo() {
        return ammo;
    }

    /**
     * Проверяет, есть ли патрон для выстрела.
     * <p>
     * Если патроны есть, уменьшает их количество на 1 и возвращает {@code true}.
     * Если патронов нет — возвращает {@code false}.
     *
     * @return {@code true}, если был патрон для выстрела, иначе {@code false}
     */
    public boolean getAmmo() {
        if (ammo == 0) {
            return false;
        }
        ammo--;
        return true;
    }

    /**
     * Загружает оружие новым количеством патронов.
     *
     * @param ammo количество патронов для загрузки (не может быть отрицательным)
     * @return предыдущие количество патронов
     * @throws RuntimeException если {@code ammo < 0}
     */
    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }
}