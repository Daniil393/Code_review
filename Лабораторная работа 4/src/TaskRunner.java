import task_1_2.Person;
import task_1_3.Name;
import task_2_4.Department;
import task_2_4.Employee;
import task_3_4.Department2;
import task_3_4.Employee2;
import task_4_5.Name2;
import task_5_1.Pistol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс TaskRunner содержит набор методов для выполнения заданий.
 * Каждый метод реализует отдельное задание
 * и взаимодействует с пользователем через Scanner.
 */
public class TaskRunner {

    /**
     * Задание 1.2: создание объекта Person.
     * Запрашивает у пользователя имя и рост, выполняет проверку ввода
     * и выводит созданный объект.
     *
     * @param sc Scanner для ввода данных с консоли
     */
    static void runTask1_2(Scanner sc) {
        System.out.println("\nЗадание 1.2: Person");

        String name;
        int height;

        while (true) {
            try {
                System.out.print("Введите имя: ");
                name = sc.nextLine();

                System.out.print("Введите рост: ");
                height = Integer.parseInt(sc.nextLine());

                Person person = new Person(name, height);
                System.out.println(person);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: рост должен быть числом");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    /**
     * Задание 1.3: работа с классом Name.
     * Запрашивает фамилию, имя и отчество, допускает пустые значения.
     *
     * @param sc Scanner для ввода данных с консоли
     */
    static void runTask1_3(Scanner sc) {
        System.out.println("\nЗадание 1.3: Name");

        String lastName;
        String firstName;
        String patronymic;

        while (true) {
            try {
                System.out.print("Введите фамилию (или оставьте пустым): ");
                lastName = sc.nextLine();

                System.out.print("Введите имя (или оставьте пустым): ");
                firstName = sc.nextLine();

                System.out.print("Введите отчество (или оставьте пустым): ");
                patronymic = sc.nextLine();

                Name name = new Name(lastName, firstName, patronymic);
                System.out.println("Результат: " + name);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    /**
     * Задание 2.4: работа с отделами и сотрудниками (Department/Employee).
     * Пользователь создаёт отдел, сотрудников и назначает начальника.
     *
     * @param sc Scanner для ввода данных с консоли
     */
    static void runTask2_4(Scanner sc) {
        System.out.println("\nЗадание 2.4: Department/Employee");

        Department department;

        // ===== 1. ВВОД ОТДЕЛА =====
        while (true) {
            try {
                System.out.print("Введите название отдела: ");
                String depName = sc.nextLine();
                department = new Department(depName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // ===== 2. КОЛИЧЕСТВО СОТРУДНИКОВ =====
        int n;
        while (true) {
            try {
                System.out.print("Введите количество сотрудников: ");
                n = Integer.parseInt(sc.nextLine());

                if (n <= 0) {
                    throw new IllegalArgumentException("количество должно быть > 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно число");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // ===== 3. СОТРУДНИКИ =====
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Введите фамилию сотрудника #" + (i + 1) + ": ");
                    String name = sc.nextLine();
                    employees[i] = new Employee(name, department);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        // ===== 4. ВЫБОР НАЧАЛЬНИКА =====
        while (true) {
            try {
                System.out.println("\nВыберите начальника:");
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " - " + employees[i].getName());
                }

                System.out.print("Введите номер: ");
                int index = Integer.parseInt(sc.nextLine()) - 1;

                if (index < 0 || index >= n) {
                    throw new IllegalArgumentException("неверный номер");
                }

                department.setChief(employees[index]);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно число");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // ===== 5. ВЫВОД =====
        System.out.println("\nРезультат:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    /**
     * Вспомогательный метод: создание отдела Department2 и сотрудников.
     *
     * @param sc Scanner для ввода данных
     * @param depNumber номер отдела
     * @return созданный Department2
     */
    static Department2 createDepartment(Scanner sc, int depNumber) {
        System.out.println("\n=== Ввод отдела #" + depNumber + " ===");

        Department2 department;

        // название отдела
        while (true) {
            try {
                System.out.print("Введите название отдела: ");
                department = new Department2(sc.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // количество сотрудников
        int n;
        while (true) {
            try {
                System.out.print("Введите количество сотрудников: ");
                n = Integer.parseInt(sc.nextLine());

                if (n <= 0) {
                    throw new IllegalArgumentException("количество должно быть > 0");
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // сотрудники
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Введите фамилию сотрудника #" + (i + 1) + ": ");
                    new Employee2(sc.nextLine(), department);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        // начальник
        while (true) {
            try {
                System.out.println("\nВыберите начальника:");
                for (int i = 0; i < department.getEmployees().size(); i++) {
                    System.out.println((i + 1) + " - " +
                            department.getEmployees().get(i).getName());
                }

                System.out.print("Введите номер: ");
                int index = Integer.parseInt(sc.nextLine()) - 1;

                if (index < 0 || index >= department.getEmployees().size()) {
                    throw new IllegalArgumentException("неверный номер");
                }

                department.setChief(department.getEmployees().get(index));
                break;

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        return department;
    }

    /**
     * Задание 3.4: работа с двумя отделами и выбором сотрудника
     * с целью узнать всех его коллег.
     *
     * @param sc Scanner для ввода данных
     */
    static void runTask3_4(Scanner sc) {
        System.out.println("\nЗадание 3.4: Department2/Employee2");

        Department2 dep1 = createDepartment(sc, 1);
        Department2 dep2 = createDepartment(sc, 2);

        // ===== ВЫВОД =====
        System.out.println("\n=== Результат ===");

        System.out.println("\nОтдел: " + dep1.getName());
        for (Employee2 e : dep1.getEmployees()) {
            System.out.println(e);
        }

        System.out.println("\nОтдел: " + dep2.getName());
        for (Employee2 e : dep2.getEmployees()) {
            System.out.println(e);
        }

        // ===== СОБИРАЕМ ВСЕХ СОТРУДНИКОВ =====
        List<Employee2> allEmployees = new ArrayList<>();
        allEmployees.addAll(dep1.getEmployees());
        allEmployees.addAll(dep2.getEmployees());

        // ===== ВЫБОР СОТРУДНИКА =====
        System.out.println("\n=== Выбор сотрудника ===");

        for (int i = 0; i < allEmployees.size(); i++) {
            System.out.println((i + 1) + ". " + allEmployees.get(i).getName());
        }

        System.out.print("\nВведите номер сотрудника: ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > allEmployees.size()) {
            System.out.println("Некорректный номер!");
            return;
        }

        Employee2 selected = allEmployees.get(choice - 1);

        // ===== ВЫВОД КОЛЛЕГ =====
        System.out.println("\nСотрудник: " + selected.getName());
        System.out.println("Весь отдел:");

        for (Employee2 e : selected.getColleagues()) {
            System.out.println("- " + e.getName());
        }
    }

    /**
     * Задание 4.5: работа с классом Name2.
     * Пользователь вводит имя, отчество и фамилию.
     * Пустые строки преобразуются в null.
     * Создаётся объект Name2 и выводится в консоль.
     *
     * @param sc Scanner для ввода данных с клавиатуры
     */
    static void runTask4_5(Scanner sc) {
        System.out.println("\nЗадание 4.5: Name2");

        while (true) {
            try {
                System.out.print("Введите имя: ");
                String firstName = sc.nextLine();

                System.out.print("Введите отчество (или оставьте пустым): ");
                String patronymic = sc.nextLine();

                System.out.print("Введите фамилию (или оставьте пустым): ");
                String lastName = sc.nextLine();

                // превращаем пустые строки в null
                firstName = firstName.isBlank() ? null : firstName;
                patronymic = patronymic.isBlank() ? null : patronymic;
                lastName = lastName.isBlank() ? null : lastName;

                Name2 name = new Name2(firstName, patronymic, lastName);

                System.out.println("\nРезультат:");
                System.out.println(name);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    /**
     * Задание 5.1: работа с классом Pistol.
     * Пользователь создаёт пистолет и выполняет выстрелы.
     *
     * @param sc Scanner для ввода данных
     */
    static void runTask5_1(Scanner sc) {
        System.out.println("\nЗадание 5.1: Pistol");

        while (true) {
            try {
                System.out.print("Введите количество патронов: ");
                int bullets = Integer.parseInt(sc.nextLine());

                Pistol pistol = new Pistol(bullets);

                System.out.println("\nСоздан объект:");
                System.out.println(pistol);

                System.out.print("\nСколько раз выстрелить? ");
                int shots = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < shots; i++) {
                    pistol.shoot();
                }

                System.out.println("\nПосле стрельбы:");
                System.out.println(pistol);

                break;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно число");
            }
        }
    }
}