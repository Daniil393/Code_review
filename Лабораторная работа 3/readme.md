# Отчет по код-ревью, лабораторная работа №3

> Задание №1 (ChatGPT)

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
- `shuffleWord(...) -> shuffle_word(...)`
- `processWord(...) -> process_word(...)`

&nbsp;

2. Добавлена функция bool is_word_valid для проверки ввода.

Реализация добавленной функции проверки ввода:
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

3. Установка кодировки Windows - 1251 для ввода и вывода

Добавлено для корректной работы с русским текстом в консоли
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

4. Добавлена обработка исключений

Добавлен блок:
```C++
try {
    ...
}
catch (const std::exception& e) {
    std::cout << e.what() << std::endl;
}
```

&nbsp;

> Задание №1 (Copilot)

1. Несоответствие имени фунции стилю

Проблема:
По код-стайлу название функции должно использовать стиль
lower_case_with_underscores.

Исправление:
 - string shuffleWord(...) -> string shuffle_word(...)

&nbsp;

2. Добавлена функция bool is_word_valid для проверки ввода.

Реализация добавленной функции проверки ввода:
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

3. Добавлена функция void process_word для вывода слов и подсчета попыток.

Реализация добавленной функции:
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

  /*
  FIX_ME: часть кода была вынесена в функцию process_word.
  Также добавлен вызов функции для проверки ввода.

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
   */

&nbsp;

4. Установка кодировки Windows - 1251 для ввода и вывода

Добавлено для корректной работы с русским текстом в консоли
```C++
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
```

&nbsp;

5. Добавлена обработка исключений

Добавлен блок:
```C++
try {
    ...
}
catch (const std::exception& e) {
    std::cout << e.what() << std::endl;
}
```

&nbsp;
