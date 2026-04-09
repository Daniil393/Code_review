# Отчет по код-ревью, лабораторная работа №1

> Задание №1
1. Использование using namespace std

Проблема:
В исходном коде использовалась директива
```C++
using namespace std;
```

Исправление:
Директива удалена.
Во всех местах используются полные имена из пространства имен std.

&nbsp;

2. Обработка ошибок при открытии файла

Проблема:
Ошибка открытия файла обрабатывалась через код возврата
```C++
  if (!read_file("file.txt", artifact_count, weight_limit, weight, tax)) {
    std::cout << "Файл не открылся!!";
    return 1;
  }
```

Исправление:
Добавлена обработка через try / catch и std::runtime_error.
```C++
if (!file.is_open()) {
    throw std::runtime_error("Файл не открылся");
}
```

&nbsp;

3. Несоответствие имен переменных стилю

Проблема:
По код-стайлу переменные должны использовать стиль
lower_case_with_underscores. Также не все названия переменных отображали их смысл.

Исправление:
- N -> artifact_count
- Z -> weight_limit
- wes -> weight
- nalogi -> tax
- maxWes -> max_weight
- wes1 -> weight1
- minNalog -> min_tax
- minNalogivalue -> min_tax_value
- totalwes -> total_weight
- selectart -> select_art

&nbsp;

4. Неверный размер вектора налогов

Проблема:
В исходном коде вектор налогов создавался размером Z
Однако налог задан для каждого артефакта, поэтому размер должен быть N.

Исправление:
 - tax.resize(artifact_count);

&nbsp;

5. Добавлена обработка исключений

Добавлен блок:
```C++
try {
    ...
}
catch (const std::exception& error) {
    std::cout << "Ошибка: " << error.what() << std::endl;
    return 1;
}
```

&nbsp;

6. Исправление восстановления артефактов

Добавлен массив take[i][w] для корректного восстановления предметов.
Также проверяется переполнение при расчёте нового налога:
обновление min_tax[w] происходит только если новое значение меньше.

```C++
  std::vector<std::vector<bool>> take(artifact_count, std::vector<bool>(max_weight + 1, false));

  for (int i = 0; i < artifact_count; i++) {
    for (int w = max_weight; w >= weight[i]; w--) {
      if (min_tax[w - weight[i]] != std::numeric_limits<int>::max()) {

        int new_tax = min_tax[w - weight[i]] + tax[i];

        if (new_tax < min_tax[w]) {
          min_tax[w] = new_tax;
          take[i][w] = true;
        }
      }
    }
  }
```

&nbsp;

> Задание №2
1. Использование using namespace std

Проблема:
В исходном коде использовалась директива
```C++
using namespace std;
```

Исправление:
Директива удалена.
Во всех местах используются полные имена из пространства имен std.

&nbsp;

2. Добавлена обработка исключений

Добавлен блок:
```C++
try {
    ...
}
  catch (const std::exception& e) {
    std::cerr << "\nОшибка: " << e.what() << std::endl;
    return 1;
}
```

&nbsp;

3. Несоответствие имен переменных стилю

Проблема:
По код-стайлу переменные должны использовать стиль
lower_case_with_underscores. Также не все названия переменных отображали их смысл.

Исправление:
- fin -> input_file
- fout -> output_file
- n -> board_size

&nbsp;

4. Обработка ошибок при открытии файла

Проблема:
Ошибка открытия файла обрабатывалась через код возврата
```C++
if (!fin.is_open()) {
std::cerr << "Ошибка! Не удалось открыть input.txt\n";
return 1;
```

Исправление:
Добавлена обработка через throw.
```C++
if (!input_file.is_open()) {
  throw std::runtime_error("Не удалось открыть input.txt\n");
}
```

&nbsp;

5. Обработка ошибок при создании файла

Проблема:
Ошибка открытия файла обрабатывалась через код возврата
```C++
if (!fout.is_open()) {
std::cerr << "Ошибка! Не удалось создать output.txt\n";
return 1;
```

Исправление:
Добавлена обработка через throw.
```C++
if (!output_file.is_open()) {
  throw std::runtime_error("Ошибка! Не удалось создать output.txt\n");
}
```

&nbsp;

6. Обработка ошибки некорректного размера доски

Проблема:
Ошибка обрабатывалась через код возврата
```C++
  if (n <= 1 || n >= 80) {
  std::cerr << "Некорректный размер доски! Допустимый диапазон: 1 < N < 80\n";
  return 1;
}
```

Исправление:
Добавлена обработка через throw.
```C++
if (board_size <= 1 || board_size >= 80) {
  throw std::runtime_error("Некорректный размер доски! Допустимый диапазон: 1 < N < 80\n");
}
```

&nbsp;

7. Обработка ошибки некорректного размера входных данных

Проблема:
Ошибка обрабатывалась через код возврата
```C++
return 1;
```

Исправление:
Добавлена обработка через throw.
```C++
throw std::runtime_error("Входные данные содержат значения вне диапазона [0,100]");
```

&nbsp;

> Задание №3
1. Использование using namespace std

Проблема:
В исходном коде использовалась директива
```C++
using namespace std;
```

Исправление:
Директива удалена.
Во всех местах используются полные имена из пространства имен std.

&nbsp;

2. Имя функции не отображает ее смысл

Исправление:
kichnye ->  count_k_base_numbers

&nbsp;

3. Имена переменных не отображают их смысл

Исправление:
 - nz -> non_zero_end
 - oz -> one_zero_end
 - tz -> two_zero_end
 - nz_ -> new_non_zero_end
 - oz_ -> new_one_zero_end
 - tz_ -> new_two_zero_end
 - bebe -> result

&nbsp;

4. Исправлена инициализация состояний

корректная начальная инициализация:
- long long one_zero_end = 1; -> long long one_zero_end = 0;

&nbsp;

5. Логика перехода состояний неверная

формулы вычисления новых состояний были некорректны.
Добавлено правильное вычисление:
- long long new_non_zero_end = (K - 1) * (non_zero_end + one_zero_end + two_zero_end);
- long long new_one_zero_end = non_zero_end;
- long long new_two_zero_end = one_zero_end;

&nbsp;

6. Исправлено вычисление итогового результата

раньше не учитывалось состояние с двумя нулями подряд  
теперь результат:
```C++
non_zero_end + one_zero_end + two_zero_end
```

&nbsp;

7. Изменён тип возвращаемого значения

результат приведён к типу double (по условию задачи ответ должен быть вещественным):
```C++
return static_cast<double>(non_zero_end + one_zero_end + two_zero_end);
```

&nbsp;

8. Добавлена обработка исключений

добавлен блок try-catch в функции main
```C++
try {
...
  }
  catch (const std::exception& e) {
    std::cerr << "Ошибка: " << e.what() << std::endl;
    return 1;
  }
```

&nbsp;

9. Обработка ошибок через исключения

проверки входных данных ранее завершали программу через return 1.
теперь используется throw std::runtime_error.

Старый вариант:
```C++
    if (N <= 1 || N >= 20) {
      std::cout << "Некорректные входные данные" << std::endl;
      return 1;
    }
```

```C++
      if (K < 2 || K > 10 || N + K ≥ 26) {
      std::cout << "Некорректные значения" << std::endl;
      return 1;
    }
```

Исправление:
```C++
if (N <= 1 || N >= 20) {
  throw std::runtime_error("Некорректные входные данные для N (1 < N < 20)");
}
```

```C++
if (K < 2 || K > 10 || N + K >= 26) {
  throw std::runtime_error("Некорректные значения K (2 <= K <= 10, N + K < 26)");
}
```

&nbsp;

> Задание №4
1. Использование using namespace std

Проблема:
В исходном коде использовалась директива
```C++
using namespace std;
```

Исправление:
Директива удалена.
Во всех местах используются полные имена из пространства имен std.

&nbsp;

2. Обработка ошибки

Проблема:
Ошибка деления на ноль обрабатывалась через exit(1)
```C++
if (number == 0) {
  std::cout << "ошибка при делении на ноль!" << std::endl;
  exit(1);
}
```

Исправление:
Добавлена обработка через try / catch и std::runtime_error.
```C++
if (next_number == 0) {
  throw std::runtime_error("Ошибка при делении на ноль!");
}
```

&nbsp;

3. Добавлена обработка исключений

добавлен блок try-catch в функции main
```C++
try {
...
  }
  catch (const std::exception& e) {
    std::cerr << "Ошибка: " << e.what() << std::endl;
    return 1;
  }
```

&nbsp;

4. Несоответствие имен переменных и функций стилю

Проблема:
По код-стайлу переменные и функции должны использовать стиль
lower_case_with_underscores. Также не все названия переменных отображали их смысл.

Исправление:
 - int NumRead(...); -> int number_read(...);
 - int CalculateTerm(...); -> int calculate_term(...);
 - int CalculateS(...); -> int calculate_s(...);
 - int currentNumber -> int current_number
 - char znak -> char operator_char

&nbsp;

5. Несоответствие условию задания

Проблема:
В функциях calculate_term и calculate_s использовался цикл while.

Исправление:
```C++
int calculate_term(std::string& s, int& symb) {
  int value = number_read(s, symb);

  if (symb < s.length() && (s[symb] == '*' || s[symb] == '/')) {

    char operator_char = s[symb];

    symb++;
    int next_number = calculate_term(s, symb);

    if (operator_char == '*') {
      return value * next_number;
    }

    else {
      if (next_number == 0) {
        throw std::runtime_error("Ошибка при делении на ноль!");
      }
      return value / next_number;
    }
  }

  return value;
}
```

```C++
int calculate_s(std::string& s, int& symb) {
  int value = calculate_term(s, symb);

  if (symb < s.length() && (s[symb] == '+' || s[symb] == '-')) {

    char operator_char = s[symb];

    symb++;
    int next_term = calculate_s(s, symb);

    if (operator_char == '+') {
      value += next_term;
    }

    else {
      value -= next_term;
    }
  }

  return value;
}
```

&nbsp;

6. Объявление, вывод и ввод записанны в одну строку

нужно разделить объявление переменной, вывод сообщения и считывание ввода на отдельные строки.
Также записать переменную S так чтобы она соответствовала стилю lower_case_with_underscores.

Исходный вариант:
```C++
std::string S; std::cout << "Введите выражение -> "; std::getline(std::cin, S);
```

Исправление:
```C++
std::string s;
std::cout << "Введите выражение -> ";
std::getline(std::cin, s);
```
