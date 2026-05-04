# **Отчет по код-ревью, лабораторная работа №3**

## Задание №1 (ChatGPT)

Ввести с клавиатуры любое слово. Используя генерацию случайных чисел,  
переставить буквы этого слова в случайном порядке. Делать это до тех пор,  
пока полученное слово не совпадёт с начальным словом. Выводить слово после  
каждой перестановки и посчитать общее количество выведенных слов (не считая  
исходного). Пример выполнения программы:  

Введите слово: корова  
воакро  
вокроа  
ароовк  
краоов  
крваоо  
оокавр  
ооквра  
вкраоо  
корова  
9 попыток
___

### 1. Несоответствие имен фунций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `shuffleWord(...) → shuffle_word(...)`
- `processWord(...) → process_word(...)`

&nbsp;

### 2. Добавлена функция `bool is_word_valid` для проверки ввода.

**Реализация добавленной функции:**
```C++
bool is_word_valid(const std::string& word) {
  static const std::regex pattern("^[A-Za-zА-Яа-яЁё]+$");

  if (!std::regex_match(word, pattern)) {
    throw std::invalid_argument("Ошибка: только буквы (русские или английские)");
  }
  return true;
}
```

&nbsp;

### 3. Установка кодировки Windows - 1251 для ввода и вывода

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 4. Добавлена обработка исключений

**Добавлен блок:**
```C++
try {
    ...
}
catch (const std::exception& e) {
    std::cout << e.what() << std::endl;
}
```
---
&nbsp;

## Задание №1 (Copilot)

### 1. Несоответствие имени фунции стилю

**Проблема:**  
Имя функции не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `shuffleWord(...) → shuffle_word(...)`

&nbsp;

### 2. Добавлена функция `bool is_word_valid` для проверки ввода.

**Реализация добавленной функции проверки ввода:**
```C++
bool is_word_valid(const std::string& word) {
  static const std::regex pattern("^[A-Za-zА-Яа-яЁё]+$");

  if (!std::regex_match(word, pattern)) {
    throw std::invalid_argument("Ошибка: только буквы (русские или английские)");
  }
  return true;
}
```

&nbsp;

### 3. Добавлена функция `void process_word` для вывода слов и подсчета попыток.

**Эта часть кода перенесена из `main` в функцию `process_word`:**
```C++
std::cout << "Введите слово: ";
  std::cin >> word;

  int attempts = 0;
  std::string shuffled;

  do {
      shuffled = shuffleWord(word);
      std::cout << shuffled << std::endl;
      attempts++;
  } while (shuffled != word);

  std::cout << attempts << " попыток" << std::endl;
```

**Реализация добавленной функции:**
```C++
void process_word(const std::string& word) {
  int attempts = 0;
  std::string shuffled;

  do {
    shuffled = shuffle_word(word);
    std::cout << shuffled << std::endl;
    attempts++;
  } while (shuffled != word);

  std::cout << attempts << " попыток" << std::endl;
}
```

&nbsp;

### 4. Установка кодировки Windows - 1251 для ввода и вывода

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 5. Добавлена обработка исключений

**Добавлен блок:**
```C++
try {
    ...
}
catch (const std::exception& e) {
    std::cout << e.what() << std::endl;
}
```
---
&nbsp;

## Задание №1 (Deepseek)

### 1. Несоответствие имен фунций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `shuffleWord(...) → shuffle_word(...)`
- `isWordMatch(...) → is_word_match(...)`

&nbsp;

### 2. Несоответствие имени переменной стилю

**Проблема:**  
Имя переменной не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `originalWord → original_word`

&nbsp;

### 3. добавлена функция `is_word_valid` для проверки ввода.

**Проблема:**  
Отсутствовала проверка пользовательского ввода.

**Исправление:**  
Добавлена функция `is_word_valid(...)`, которая проверяет, что введены только буквы (русские или английские), с использованием регулярного выражения.

**Реализация:**
```C++
bool is_word_valid(const std::string& word) {
  static const std::regex pattern("^[A-Za-zА-Яа-яЁё]+$");

  if (!std::regex_match(word, pattern)) {
    throw std::invalid_argument("Ошибка: только буквы (русские или английские)");
  }
  return true;
}
```

&nbsp;

### 4. Выделение логики в отдельные функции

**Проблема:**  
Основная логика программы находилась в функции main, что ухудшало читаемость и переиспользуемость кода.

**Исправление:**  
Часть логики вынесена в отдельную функцию:  
`process_word(...)` - для перемешивания слова и подсчёта попыток

**Реализация:**
```C++
void process_word(const std::string& original_word) {
  std::string current_word = original_word;
  int attempts = 0;

  do {
    current_word = shuffle_word(current_word);
    std::cout << current_word << std::endl;
    attempts++;
  } while (!is_word_match(original_word, current_word));

  std::cout << attempts << " попыток" << std::endl;
}
```

&nbsp;

### 5. Установка кодировки Windows - 1251 для ввода и вывода

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 6. Добавлена обработка исключений

**Добавлен блок:**
```C++
try {
    ...
}
catch (const std::invalid_argument& e) {
    std::cout << e.what() << std::endl;
}
```
---
&nbsp;

## Задание №3 (ChatGPT)

Юный путешественник решил изучить схему авиационного сообщения. Схема авиационного сообщения задана в текстовом файле с именем FileName. в виде матрицы смежности. Первая строка файла содержит количество городов (n) n<=25, связанных авиационным сообщением, а следующие n строк хранят матрицу (m), m[i][j]=0, если не имеется возможности перелета из города i в город j, иначе m[i][j]=1. Определить номера городов, в которые из города K можно долететь менее чем с L пересадками. Перечислите номера таких городов в порядке возрастания. Нумерация городов начинается с 1. Если таких городов нет, выведите число (-1).
___

### 1. Несоответствие имен переменных стилю

**Проблема:**  
Имена переменных не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `adjMatrix → adj_matrix`
- `maxTransfers → max_transfers`

&nbsp;

### 2. Несоответствие имен функций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `setMatrix → set_matrix`
- `findCities → find_cities`

&nbsp;

### 3. Выделение логики в отдельную функцию

**Проблема:**  
Основная логика программы находилась в функции main, что ухудшало читаемость и переиспользуемость кода.

**Исправление:**  
Часть логики вынесена в отдельную функцию:  
`solve(...)` - решение задачи и вывод результата

**Реализация:**  
```C++
void solve(int n, const std::vector<std::vector<int>>& matrix, int K, int L) {
  Graph g(n);
  g.set_matrix(matrix);

  std::vector<int> result = g.find_cities(K, L);

  if (result.empty()) {
    std::cout << -1;
  }
  else {
    std::sort(result.begin(), result.end());
    for (int city : result) {
      std::cout << city << " ";
    }
  }
}
```

&nbsp;

### 4. добавлена функция `check_input` для проверки ввода.

**Проблема:**  
Не проверялась корректность вводимых значений K и L.

**Исправление:**  
Добавлена функция `check_input(...)`, которая:  
- проверяет, что ввод — целые числа
- проверяет диапазон K

**Реализация:**
```C++
void check_input(int& K, int& L, int& n) {
  while (true) {
    if (!(std::cin >> K >> L)) {
      std::cout << "Ошибка: K и L должны быть целыми числами\n";
      std::cin.clear();
      std::cin.ignore(10000, '\n');

      std::cout << "Введите K и L: ";
      continue;
    }

    if (K < 1 || K > n) {
      std::cout << "Ошибка: номер города K вне допустимого диапазона\n";
      std::cout << "Введите K и L: ";
      continue;
    }

    break;
  }
}
```

&nbsp;

### 5. Установка кодировки Windows - 1251 для ввода и вывода.

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 6. Обработка ошибок через исключения.

**Проблема:**  
Ошибки обрабатывались через коды возврата.

**Исправление:**  
Добавлено использование исключений:
```C++
if (!file.is_open()) {
  throw std::runtime_error("Файл невозможно открыть");
}
```

И их обработка в main:
```C++
try {
    ...
}
catch (const std::exception& error) {
  std::cout << "Ошибка: " << error.what() << std::endl;
  return 1;
}
```

---
&nbsp;

## Задание №3 (Deepseek)

### 1. Несоответствие имен функций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `findCitiesWithLessTransfers(...) → find_cities_with_less_transfers(...)`
- `printResult(...) → print_result(...)`

&nbsp;

### 2. Несоответствие имен переменных стилю

**Проблема:**  
Имена переменных не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `currentCity → current_city`
- `currentTransfers → current_transfers`
- `nextCity → next_city`
- `newTransfers → new_transfers`

&nbsp;

### 3. добавлена функция `check_input` для проверки ввода.

**Проблема:**  
Не проверялась корректность вводимых значений K и L.

**Исправление:**  
Добавлена функция `check_input(...)`, которая:  
- проверяет, что ввод — целые числа
- проверяет диапазон K

**Реализация:**
```C++
void check_input(int& K, int& L, int& n) {
  while (true) {
    if (!(std::cin >> K >> L)) {
      std::cout << "Ошибка: K и L должны быть целыми числами\n";
      std::cin.clear();
      std::cin.ignore(10000, '\n');

      std::cout << "Введите K и L: ";
      continue;
    }

    if (K < 1 || K > n) {
      std::cout << "Ошибка: номер города K вне допустимого диапазона\n";
      std::cout << "Введите K и L: ";
      continue;
    }

    break;
  }
}
```

&nbsp;

### 4. Использование `using namespace std`

**проблема:**  
Использование пространства имен `std` запрещено код-стайлом

**Исправление:**  
удалена строка `using namespace std;` , используются полные имена std::

&nbsp;

### 5. добавлен геттер для количества город.

**Проблема:**  
Необходимо получить количество городов из файла для функции `check_input(...)`

**Исправление:**  
Добавлен геттер `get_n()`, который:  
- берет значение из первой строки файла

**Реализация:**  
```C++
int Graf::get_n() const {
  return n;
}
```

&nbsp;

### 6. Установка кодировки Windows - 1251 для ввода и вывода.

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 7. Изменения кода в Main.cpp

Поскольку добавлена функция проверки ввода, меняем в `main`:  
```C++
  std::cout << "Введите номер города K: ";
  std::cin >> K;

  std::cout << "Введите максимальное количество пересадок L: ";
  std::cin >> L;
```

На:  
```C++
  int n = graf.get_n();

  std::cout << "Введите K и L: ";
  check_input(K, L, n);
```

---
&nbsp;

## Задание №3 (Copilot)

### 1. добавлена функция `check_input` для проверки ввода.

**Проблема:**  
Не проверялась корректность вводимых значений K и L.

**Исправление:**  
Добавлена функция `check_input(...)`, которая:  
- проверяет, что ввод — целые числа
- проверяет диапазон K

**Реализация:**
```C++
void check_input(int& K, int& L, int n) {
  while (true) {
    if (!(std::cin >> K >> L)) {
      std::cout << "Ошибка: K и L должны быть целыми числами\n";
      std::cin.clear();
      std::cin.ignore(10000, '\n');

      std::cout << "Введите K и L: ";
      continue;
    }

    if (K < 1 || K > n) {
      std::cout << "Ошибка: номер города K вне допустимого диапазона\n";
      std::cout << "Введите K и L: ";
      continue;
    }

    break;
  }
}
```

&nbsp;

### 2. Добавлен метод доступа к n.

**Проблема:**  
Необходимо получить количество городов из файла для функции `check_input(...)`

**Исправление:**  
Добавлен геттер `get_size()`, который:  
- берет значение из первой строки файла

**Реализация:**  
```C++
  int get_size() const {
    return n;
  }
```

&nbsp;

### 3. Обработка ошибок открытия файла.

**Проблема:**  
При невозможности открыть файл программа работала некорректно.

**Исправление:**  
Добавлена проверка и генерация исключения.  

```C++
  if (!fin) {
    throw std::runtime_error("Не удалось открыть файл");
  }
  ```

### 4. Установка кодировки Windows - 1251 для ввода и вывода.

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 5. Повторный ввод имени файла.

**Добавлен повторный запрос имени файла с обработкой ошибки:**  
```C++
  while (true) {
    std::cout << "Введите имя файла: ";
    std::cin >> filename;

    try {
      g = new Graf(filename);
      break;
    }
    catch (const std::exception& e) {
      std::cout << "Ошибка: " << e.what() << ". Попробуйте снова.\n";
    }
  }
```

---
&nbsp;

## Задание №2 (ChatGPT)

В текстовом файле с именем filename дано арифметическое выражение в префиксной
форме. Операндами в выражении являются целые числа из промежутка от 0 до 9. Используемые 
операции: сложение (+), вычитание (-), умножение (*), деление нацело (/), целочисленный остаток 
от деления (%) и возведение в степень (^). Постройте дерево, соответствующее данному 
выражению. Знаки операций кодируйте числами: сложение(-1), вычитание(-2), умножение(-3), 
деление(-4), остаток от деления(-5), возведение в степень (-6). Преобразуйте дерево так, чтобы в 
нем не было операций возведения в степень (замените поддеревья, в которых есть возведение в 
степень, значением данного поддерева). Выведите указатель на корень полученного дерева.
___

### 1. Несоответствие имен функций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**
- `buildTree(...) → build_tree(...)`
- `opCode(...) → op_code(...)`
- `freeTree(...) → free_tree(...)`

&nbsp;

### 2. Замена типа int на long long в структуре Node и функции evaluate.

**Проблема:**  
Использование int могло приводить к переполнению при вычислении выражений
(особенно при возведении в степень и умножении).

**Исправление:**  
Тип значения узла и результата вычисления заменён на long long,
что увеличивает допустимый диапазон значений.

**Реализация:**  

```C++
struct Node {
  long long value;
  Node* left;
  Node* right;

  Node(long long val);
};
```

```C++
long long evaluate(Node* root) {
  if (!root) return 0;

  if (root->value >= 0) return root->value;

  long long l = evaluate(root->left);
  long long r = evaluate(root->right);

  switch (root->value) {
  case -1: return l + r;
  case -2: return l - r;
  case -3: return l * r;
  case -4: return r != 0 ? l / r : 0;
  case -5: return r != 0 ? l % r : 0;
```

&nbsp;

### 3. Добавлена функция вывода дерева `print_tree`.

**Проблема:**  
Отсутствовал удобный способ визуального представления структуры дерева.

**Исправление:**  
Реализован рекурсивный вывод дерева в инфиксной форме с использованием декодирования операций.

**Реализация:**

```C++
void CalcTree::print_tree(Node* root) {
  if (!root) {
    return;
  }

  if (root->value >= 0) {
    std::cout << root->value;
  }
  else {
    std::cout << "(";
    print_tree(root->left);
    std::cout << " " << decode_op(root->value) << " ";
    print_tree(root->right);
    std::cout << ")";
  }
}

char CalcTree::decode_op(int val) {
  switch (val) {
  case -1: return '+';
  case -2: return '-';
  case -3: return '*';
  case -4: return '/';
  case -5: return '%';
  case -6: return '^';
  }
  return '?';
}
```

&nbsp;

### 4. Вспомогательная функция декодирования операций `decode_op`.

**Проблема:**  
В узлах дерева операции хранятся в виде отрицательных чисел (например, -1 для +, -2 для -).
Без преобразования такие значения невозможно корректно вывести в читаемом виде при печати
дерева.

**Исправление:**  
Добавлена вспомогательная функция `decode_op`, которая используется внутри `print_tree` для
преобразования числового кода операции в соответствующий символ. Эта функция не является
самостоятельной частью логики вычисления, а служит только для корректного вывода.

**Реализация:**  

```C++
char decode_op(int val) {
  switch (val) {
  case -1: return '+';
  case -2: return '-';
  case -3: return '*';
  case -4: return '/';
  case -5: return '%';
  case -6: return '^';
  }
  return '?';
}
```

&nbsp;

### 5. Реализация ручного возведения в степень вместо pow.

**Проблема:**  
Функция `pow()` работает с типом `double`,
что приводит к потере точности при целочисленных вычислениях.

**Исправление:**  
Добавлена реализация возведения в степень через цикл с использованием `long long`.

**Реализация:**  

```C++
  case -6: {
    long long res = 1;
    for (long long i = 0; i < r; i++) res *= l;
    return res;
  }
```

&nbsp;

### 6. Установка кодировки Windows - 1251 для ввода и вывода.

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 7. Повторный ввод имени файла при ошибке открытия.

**Проблема:**  
При неверном имени файла программа работала некорректно.

**Исправление:**  
Добавлен цикл с обработкой исключений и повторным запросом имени файла.

**Реализация:**  

```C++
while (true) {
    try {
      std::cout << "Введите имя файла: ";
      std::cin >> filename;

      file.open(filename);

      if (!file.is_open()) {
        throw std::runtime_error("Файл не найден");
      }
      break;
    }
    catch (const std::exception& e) {
      std::cout << e.what() << ". Попробуйте снова.\n";
    }
  }
```

&nbsp;

### 8. добавлен вывод деревьев и результата.

```C++
std::cout << "Исходное дерево: ";
  print_tree(root);
  std::cout << std::endl;
```

```C++
std::cout << "Преобразованное дерево: ";
  print_tree(root);
  std::cout << std::endl;

  int result = evaluate(root);
  std::cout << "Результат: " << result << std::endl;
```

---
&nbsp;

## Задание №2 (Copilot)

### 1. Несоответствие имен функций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**  
- `loadFromFile(...) → load_from_file(...)`
- `transformTree() → transform_tree()`
- `getRoot() → get_root()`
- `freeTree(...) → free_tree(...)`

&nbsp;

### 2. Добавлена функция вычисления выражения `evaluate`.

**Проблема:**  
Отсутствовал удобный интерфейс для получения результата вычисления.

**Исправление:**  
Добавлен метод

```C++
int CalcTree::evaluate() {
  return eval(root);
}
```

&nbsp;

### 3. Добавлена функция вывода дерева `print_tree`.

**Проблема:**  
Отсутствовал удобный способ визуального представления структуры дерева.

**Исправление:**  
Реализован рекурсивный вывод дерева в инфиксной форме с использованием декодирования операций.

**Реализация:**

```C++
void CalcTree::print_tree(Node* root) {
  if (!root) {
    return;
  }

  if (root->value >= 0) {
    std::cout << root->value;
  }
  else {
    std::cout << "(";
    print_tree(root->left);
    std::cout << " " << decode_op(root->value) << " ";
    print_tree(root->right);
    std::cout << ")";
  }
}

char CalcTree::decode_op(int val) {
  switch (val) {
  case -1: return '+';
  case -2: return '-';
  case -3: return '*';
  case -4: return '/';
  case -5: return '%';
  case -6: return '^';
  }
  return '?';
}
```

&nbsp;

### 4. Добавлены фигурные скобки в условных операторах.

**Проблема:**  
Отсутствие фигурных скобок в `if` и `else` ухудшало читаемость.

**Исправление:**  
Во всех условных конструкциях добавлены фигурные скобки.

&nbsp;

### 5. Улучшен разбор выражения.

**Проблема:**  
Разбор через std::string требовал пробелов между токенами.

**Исправление:**  
Реализовано посимвольное чтение

```C++
Node* CalcTree::parse(std::istream& in) {
  char ch;

  if (!(in >> ch)) {
    return nullptr;
  }

  if (isdigit(ch)) {
    return new Node(ch - '0');
  }

  int code = 0;

  if (ch == '+') {
    code = -1;
  }
  else if (ch == '-') {
    code = -2;
  }
  else if (ch == '*') {
    code = -3;
  }
  else if (ch == '/') {
    code = -4;
  }
  else if (ch == '%') {
    code = -5;
  }
  else if (ch == '^') {
    code = -6;
  }

  Node* node = new Node(code);
  node->left = parse(in);
  node->right = parse(in);
  return node;
}
```

&nbsp;

### 6. Обработка ошибок через исключения.

**Проблема:**  
Ошибки открытия файла обрабатывались через `cerr`.

```C++
if (!fin) {
  std::cerr << "Ошибка: не удалось открыть файл\n";
  return;
}
```

**Исправление:**  
Добавлено использование исключений:  

```C++
if (!fin) {
  throw std::runtime_error("Не удалось открыть файл: " + filename);
}
```

&nbsp;

### 7. Установка кодировки Windows - 1251 для ввода и вывода

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 8. Улучшена обработка ошибок при вводе имени файла.

**Проблема:**  
Загрузка файла выполнялась с обработкой ошибок через код возврата.
В случае неверного имени файла программа завершалась так будто введенное имя файла верное.

**Исправление:**  
Реализована обработка исключений с повторным запросом ввода имени файла.
Теперь при ошибке открытия файла пользователь получает сообщение и может повторить ввод.

**Реализация:**  

```C++
std::string filename;

  while (true) {
    std::cout << "Введите имя файла: ";
    std::cin >> filename;

    try {
      tree.load_from_file(filename);
      break;
    }
    catch (const std::exception& e) {
      std::cout << e.what() << "\nПопробуйте снова.\n";
    }
  }
```

&nbsp;

### 9. Добавлен вывод результата вычисления.

**Проблема:**  
Отсутствовал вывод результата вычисления выражения.

**Исправление:**  
Добавлен вывод результата вычисления выражения с помощью функции `evaluate`.

**Реализация:**  

```C++
std::cout << "\nРезультат вычисления: " << tree.evaluate() << "\n";
```

---
&nbsp;

## Задание №2 (Deepseek)

### 1. Несоответствие имен функций стилю

**Проблема:**  
Имена функций не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**  
- `buildTree(...) →  build_tree(...)`
- `replacePower(...) → replace_power(...)`
- `buildFromString(...) → build_from_string(...)`
- `getRoot() → get_root()`

&nbsp;

### 2. Несоответствие имен переменных стилю

**Проблема:**  
Имена переменных не соответствуют стилю `lower_case_with_underscores`.

**Исправление:**  
- `ADD, SUB, MUL, DIV, MOD, POW ? add, sub, mul, div_, mod, pow_`
- `opCode → op_code`
- `leftVal → left_val`
- `rightVal → right_val`

&nbsp;

### 3. Добавление недостающих библиотек.

**Проблема:**  
Отсутствовало подключение библиотеки для ввода/вывода.

**Исправление:**  

```C++
#include <iostream>
```

&nbsp;

### 4. Исправление вывода дерева.

**Проблема:**  
Дерево выводилось в виде структуры, а не математического выражения.

**Исправление:**  
Реализован инфиксный вывод:  

```C++
void CalcTree::print_tree(const std::shared_ptr<TreeNode>& node) {

  if (!node) {
    return;
  }

  if (node->value >= 0) {
    std::cout << node->value;
  }
  else {
    std::cout << "(";
    print_tree(node->left);
    std::cout << " " << decode_op(node->value) << " ";
    print_tree(node->right);
    std::cout << ")";
  }
}

char CalcTree::decode_op(int val) {
  switch (val) {
  case -1: return '+';
  case -2: return '-';
  case -3: return '*';
  case -4: return '/';
  case -5: return '%';
  case -6: return '^';
  }
  return '?';
}
```

&nbsp;

### 5. Реализация вычисления выражения.

**Проблема:**  
Отсутствовал метод для вычисления результата.

**Исправление:**  
Добавлен метод:  

```C++
int CalcTree::evaluate() {
  return evaluate(root);
}
```
&nbsp;

### 6. Добавлены фигурные скобки в условных операторах.

**Проблема:**  
Отсутствие фигурных скобок снижает читаемость.

**Исправление:**  
В `if` добавлены фигурные скобки:  

```C++
  if (!node) {
    return;
  }
```

&nbsp;

### 7. Установка кодировки Windows - 1251 для ввода и вывода.

**Добавлено для корректной работы с русским текстом в консоли:**
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

### 8. Улучшена обработка ввода файла.

**Проблема:**  
При ошибке открытия файла программа выполнялась дальше.

**Исправление:**  
Добавлен цикл с обработкой исключений:  

```C++
std::string filename;
  std::ifstream file;

  while (true) {
    try {
      std::cout << "Введите имя файла: ";
      std::cin >> filename;

      file.open(filename);

      if (!file.is_open()) {
        throw std::runtime_error("Не удалось открыть файл: " + filename);
      }

      break;

    }
    catch (const std::exception& e) {
      std::cerr << "Ошибка: " << e.what() << std::endl;
      file.clear();
    }
  }
```

&nbsp;

### 9. Исправлен вывод и добавлено вычисление результата.

**Проблема:**  
Использовались неверная функции вывода, отсутствовал результат вычисления.

**Исправление:**  

```C++
  std::cout << "Исходное дерево:\n";
  tree.print_tree(tree.get_root());
  std::cout << "\n";

  int result = tree.evaluate();

  tree.transform();

  std::cout << "Преобразованное дерево:\n";
  tree.print_tree(tree.get_root());
  std::cout << "\n";

  std::cout << "Результат вычисления: " << result << "\n";
```

---
