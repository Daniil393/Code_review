package ru.maltsev;

import java.util.Scanner;

/**
 * Утилитный класс для работы с вводом пользователя.
 * <p>
 * Предоставляет методы для безопасного считывания данных
 * с консоли с проверкой формата.
 */
public class InputHelper {

    /**
     * Считывает строку, содержащую целое число, с консоли.
     * <p>
     * Метод повторяет запрос до тех пор, пока пользователь
     * не введёт корректное целое число.
     *
     * @param sc     объект {@link Scanner} для чтения ввода
     * @param prompt сообщение, которое выводится пользователю
     * @return строка, содержащая корректное целое число
     */
    public static String readNumberString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                Integer.parseInt(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }
}