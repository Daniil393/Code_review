import java.util.Scanner;

/*
FIX_ME: main был перегружен.
Все методы выполнения заданий выведены в отдельный класс TaskRunner.
 */

/**
 * Главный класс.
 * Содержит точку входа и меню выбора заданий.
 */
public class Main {

    /**
     * Основной цикл программы.
     * Отображает меню, принимает ввод пользователя
     * и вызывает соответствующие методы из TaskRunner.
     *
     * Используется безопасный ввод через String + parseInt,
     * чтобы избежать InputMismatchException.
     */
    void main() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Задание 1.2 (Person)");
            System.out.println("2 - Задание 1.3 (Name)");
            System.out.println("3 - Задание 2.4 (Department/Employee)");
            System.out.println("4 - Задание 3.4 (Department2/Employee2)");
            System.out.println("5 - Задание 4.5 (Name2)");
            System.out.println("6 - Задание 5.1 (Pistol)");
            System.out.println("0 - Выход");

            System.out.print("Введите выбор: ");

            /*
            FIX_ME: Безопасный ввод выбора меню.

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    TaskRunner.runTask1_2(sc);
                    break;

                ...

                case 6:
                    sc.nextLine();
                    TaskRunner.runTask5_1(sc);
                    break;
             */
            String input = sc.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
                continue;
            }

            switch (choice) {
                case 1:
                    TaskRunner.runTask1_2(sc);
                    break;

                case 2:
                    TaskRunner.runTask1_3(sc);
                    break;

                case 3:
                    TaskRunner.runTask2_4(sc);
                    break;

                case 4:
                    TaskRunner.runTask3_4(sc);
                    break;

                case 5:
                    TaskRunner.runTask4_5(sc);
                    break;

                case 6:
                    TaskRunner.runTask5_1(sc);
                    break;

                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}