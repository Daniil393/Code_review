package task_5_1;

/**
 * Класс, представляющий пистолет с патронами.
 */
public class Pistol {

    /** Количество патронов. */
    private int bullets;

    /**
     * Создаёт пистолет с заданным количеством патронов.
     *
     * @param bullets количество патронов
     */

    /*
    FIX_ME: упрощена обработка отрицательного количества патронов
    с использованием Math.max().

    public Pistol(int bullets) {
        if (bullets < 0) {
            System.out.println("Нельзя создать пистолет с отрицательным количеством патронов." +
                    "Устанавливается 0.");
            this.bullets = 0;
        }

        else
            this.bullets = bullets;
    }
     */
    public Pistol(int bullets) {
        this.bullets = Math.max(bullets, 0);
    }

    /**
     * Конструктор по умолчанию.
     *
     * <p>Создаёт пистолет с 5 патронами.
     */
    public Pistol() {
        this.bullets = 5;
    }

    /**
     * Выполняет выстрел.
     *
     * <p>Если патроны есть - выводится "Бах!".
     * <p>Иначе выводится "Клац!".
     */

    /*
    FIX_ME: упрощена логика метода shoot().
    Метод реализован без лишнего else.

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        }

        else
            System.out.println("Клац!");
    }
     */
    public void shoot() {
        if (bullets == 0) {
            System.out.println("Клац!");
            return;
        }

        System.out.println("Бах!");
        bullets--;
    }

    /**
     * Возвращает количество патронов.
     *
     * @return количество патронов
     */
    public int getBullets() {
        return bullets;
    }

    /**
     * Возвращает строковое представление пистолета.
     *
     * @return строка с количеством патронов
     */
    @Override
    public String toString() {
        return "Пистолет [патроны: " + bullets + "]";
    }
}