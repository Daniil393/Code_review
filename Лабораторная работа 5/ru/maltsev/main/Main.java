package ru.maltsev.main;

import ru.maltsev.directory.TelephoneDirectory;
import ru.maltsev.people.Name;
import ru.maltsev.weapons.AutomaticGun;
import ru.maltsev.weapons.AutomaticGun2;
import ru.maltsev.weapons.AutomaticGun3;
import ru.maltsev.weapons.Pistol;
import ru.maltsev.weapons.Pistol2;
import ru.maltsev.weapons.Pistol3;
import ru.maltsev.geometry.Point;
import ru.maltsev.InputHelper;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/*
FIX_ME: Используется wildcard import для java.util.
Необходимо импортировать только используемые классы.

import java.util.*;
*/
import java.util.Scanner;
import java.util.Arrays;


/**
 * Основной класс программы для демонстрации лабораторной работы №3.
 * <p>
 * Включает меню с различными задачами:
 *     Работа с пистолетами (Pistol, Pistol2, Pistol3)
 *     Проверка непустых имён (Name)
 *     Телефонный справочник (TelephoneDirectory)
 *     Автоматы (AutomaticGun, AutomaticGun2, AutomaticGun3)
 *     Сравнение точек (Point)
 *     Возведение в степень с проверкой 0^0
 * <p>
 * Все операции выводят результаты на консоль.
 */
public class Main {

    /**
     * Возводит число {@code x} в степень {@code y}.
     * <p>
     * Оба числа передаются как строки. Метод проверяет корректность ввода.
     *
     * @param xStr строковое представление основания
     * @param yStr строковое представление показателя степени
     * @return результат возведения в степень
     * @throws ArithmeticException если x=0 и y=0
     * @throws NumberFormatException если строки не могут быть преобразованы в целые числа
     */
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);

        if (x == 0 && y == 0) {
            throw new ArithmeticException("Выражение 0^0 не определено");
        }

        return pow(x, y);
    }

    /**
     * Точка входа в программу.
     * <p>
     * Запускает бесконечное меню с выбором различных лабораторных упражнений.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Лабораторная работа 3 ===");
            System.out.println("1 - Пистолет");
            System.out.println("2 - Непустые имена");
            System.out.println("3 - Желтые страницы");
            System.out.println("4 - Автомат");
            System.out.println("5 - Pistol, который наследует класс Weapon");
            System.out.println("6 - Лучший стрелок");
            System.out.println("7 - Сравнение точек");
            System.out.println("8 - Возведение в степень");
            System.out.println("9 - Патроны наследникам");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    Pistol m1911 = new Pistol(7);
                    m1911.reload(3);
                    m1911.shoot(5);

                    m1911.reload(8);
                    m1911.shoot(2);
                    m1911.unload();
                    m1911.shoot();
                    break;

                case "2":
                    System.out.println("\n=== Непустые имена ===");

                    try {
                        Name n1 = new Name("Даниил");
                        Name n2 = new Name("Даниил", "Мальцев");
                        Name n3 = new Name("Даниил", "Николаевич", "Мальцев");

                        System.out.println("Только имя: " + n1);
                        System.out.println("Имя и фамилия: " + n2);
                        System.out.println("Полное ФИО: " + n3);

                        System.out.println("\nПопытка создать пустой объект:");
                        Name n4 = new Name(" ", " ");
                        System.out.println(n4);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка создания: " + e.getMessage());
                    }

                    break;

                case "3":
                    TelephoneDirectory directory = new TelephoneDirectory();

                    System.out.println("\nДобавление записей: ");
                    directory.add("89305260169", "Маша");
                    directory.add("89577397333", "Даня");
                    directory.add("89116529990", "Артем");
                    directory.add("89116556782", "Анна");

                    System.out.println(directory);

                    System.out.println("\nУдаление контакта 'Анна': ");
                    directory.remove("Анна");
                    System.out.println(directory);

                    System.out.println("\nПоиск номера по имени 'Маша': ");
                    System.out.println(directory.getPhone("Маша"));

                    System.out.println("\nРазмер телефонного справочника: ");
                    System.out.println(directory.size());

                    System.out.println("\nВсе пары в виде массива: ");
                    System.out.println(directory.getAllPairs());

                    System.out.println("\nВсе телефоны в виде массива: ");
                    System.out.println(Arrays.toString(directory.getAllPhones()));

                    System.out.println("\nВсе имена в виде массива: ");
                    System.out.println(Arrays.toString(directory.getAllNames()));

                    System.out.println("\nПоиск имени по префиксу - 'А'");
                    System.out.println(Arrays.toString(directory.getNamesByPrefix("А")));
                    System.out.println("\nДобавим Анну обратно");
                    directory.add("89116556782", "Анна");
                    System.out.println("Поиск по префиксу после добавления Анны: ");
                    System.out.println(Arrays.toString(directory.getNamesByPrefix("А")));

                    System.out.println("\nЗамена номера Маши на другой: ");
                    String oldPhone = directory.add("89223891081", "Маша");
                    System.out.println("Старый номер Маши: " + oldPhone);
                    System.out.println("Текущий справочник:");
                    System.out.println(directory);

                    break;

                case "4":
                    System.out.println("\n=== Демонстрация автомата ===");

                    AutomaticGun ak = new AutomaticGun(30, 5);
                    ak.reload(20);
                    System.out.println(ak);

                    System.out.println("Одна очередь (должно быть 5 выстрелов): ");
                    ak.shoot();
                    System.out.println("Осталось патронов: " + ak.getBullets());

                    System.out.println("\nСтрельба 3 секунды (5 * 3 = 15 выстрелов): ");
                    ak.shoot(3);
                    System.out.println("Осталось патронов: " + ak.getBullets());

                    System.out.println("\nПопытка стрелять при пустом магазине:");
                    ak.shoot();

                    ak.reload(10);
                    System.out.println(ak);
                    System.out.println("Разрядка: ");
                    int returned = ak.unload();
                    System.out.println("Извлечено патронов: " + returned);

                    break;

                case "5":
                    System.out.println("\n=== Pistol2 (наследуется от Weapon) ===");

                    Pistol2 pistol2 = new Pistol2(10);

                    System.out.println("Начальное состояние: " + pistol2);

                    System.out.println("\nЗаряжаем 7 патронов");
                    int extra = pistol2.reload(7);
                    System.out.println("Лишних патронов: " + extra);
                    System.out.println(pistol2);

                    System.out.println("\nСтреляем 5 раз:");
                    pistol2.shoot(5);
                    System.out.println("После стрельбы: " + pistol2);

                    System.out.println("\nПробуем зарядить 10 патронов (вместимость 10):");
                    extra = pistol2.reload(10);
                    System.out.println("Лишних патронов: " + extra);
                    System.out.println(pistol2);

                    System.out.println("\nРазряжаем пистолет:");
                    int returned2 = pistol2.unload();
                    System.out.println("Извлечено патронов: " + returned2);
                    System.out.println(pistol2);

                    System.out.println("\nПробуем выстрелить при пустом магазине:");
                    pistol2.shoot();

                    break;

                case "6":
                    System.out.println("\n=== Лучший стрелок ===");

                    Shooter s1 = new Shooter("Gabriel");
                    Shooter s2 = new Shooter("john");
                    Shooter s3 = new Shooter("Arthur");

                    Pistol2 pistol3 = new Pistol2(10);
                    pistol3.reload(5);
                    s2.setWeapon(pistol3);

                    AutomaticGun2 ak2 = new AutomaticGun2(30, 5);
                    ak2.load(20);
                    s3.setWeapon(ak2);

                    s1.shoot();
                    s2.shoot();
                    s3.shoot();

                    break;

                case "7":
                    System.out.println("\n=== Сравнение точек ===");

                    Point p1 = new Point(1, 2);
                    Point p2 = new Point(1, 2);
                    Point p3 = new Point(3, 4);

                    System.out.println("Точка p1: " + p1);
                    System.out.println("Точка p2: " + p2);
                    System.out.println("Точка p3: " + p3);

                    System.out.println("\np1.equals(p2): " + p1.equals(p2));
                    System.out.println("p1.equals(p3): " + p1.equals(p3));

                    break;

                case "8":
                    System.out.println("\n=== Возведение в степень ===");

                    String x = InputHelper.readNumberString(sc, "Введите X: ");
                    String y = InputHelper.readNumberString(sc, "Введите Y: ");

                    try {
                        double result = power(x, y);
                        System.out.println("Результат: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }

                    break;

                case "9":
                    System.out.println("\n=== Патроны наследникам ===");


                    // -------- Пистолет --------
                    System.out.println("\n--- Pistol3 ---");

                    Pistol3 pistol = new Pistol3(7);
                    System.out.println("Создан пистолет. Вместимость: " + pistol.getCapacity());

                    System.out.println("\nСтрельба без патронов:");
                    pistol.shoot();

                    System.out.println("\nЗаряжаем 5 патронов...");
                    int extraBullets = pistol.reload(5);
                    System.out.println("Лишних патронов: " + extraBullets);
                    System.out.println("Текущее состояние: " + pistol);

                    System.out.println("\nСтреляем 6 раз:");
                    pistol.shoot(6);
                    System.out.println("После стрельбы: " + pistol);

                    System.out.println("\nРазряжаем пистолет...");
                    int unloaded = pistol.unload();
                    System.out.println("Извлечено патронов: " + unloaded);
                    System.out.println("После разрядки: " + pistol);


                    // -------- Автомат --------
                    System.out.println("\n--- AutomaticGun3 ---");

                    AutomaticGun3 gun = new AutomaticGun3(10, 3);
                    System.out.println("Создан автомат:");
                    System.out.println(gun);

                    System.out.println("\nСтреляем одной очередью:");
                    gun.shoot();
                    System.out.println("После очереди: " + gun);

                    System.out.println("\nСтреляем 2 секунды:");
                    gun.shoot(2);
                    System.out.println("После стрельбы: " + gun);

                    break;

                case "0":
                    System.out.println("Выход из программы");
                    sc.close();
                    return;

                default:
                    System.out.println("Ошибка: выберите пункт из меню (0-9) ");
            }
        }
    }
}