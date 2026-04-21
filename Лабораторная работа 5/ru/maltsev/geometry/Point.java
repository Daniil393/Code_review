package ru.maltsev.geometry;

/**
 * Класс {@code Point} представляет точку на двумерной плоскости
 * с координатами X и Y.
 */
public class Point {

    /*
    FIX_ME: Класс не является неизменяемым. Нужно сделать поля final.

    private double x;
    private double y;
    */
    /** Координата по оси X. */
    private final double x;

    /** Координата по оси Y. */
    private final double y;

    /**
     * Создаёт точку с заданными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату по оси X.
     *
     * @return значение X
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату по оси Y.
     *
     * @return значение Y
     */
    public double getY() {
        return y;
    }

    /**
     * Возвращает строковое представление точки
     * в формате {x;y}.
     *
     * @return строка с координатами точки
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает текущую точку с другим объектом.
     * Точки считаются равными, если их координаты X и Y совпадают.
     *
     * @param obj объект для сравнения
     * @return true, если объект является точкой с теми же координатами,
     *         иначе false
     */
    @Override
    public boolean equals(Object obj) {
        /*
        FIX_ME: Отсутствуют фигурные скобки в if.

        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        */
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;
        return Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
    }

    /*
    FIX_ME: Переопределён equals(), но не переопределён hashCode().
    Нарушение контракта equals/hashCode.
    */

    @Override
    public int hashCode() {
        return Double.hashCode(x) * 31 + Double.hashCode(y);
    }
}