/*
https://chat.deepseek.com/share/br53zwn45ckoe3m1rw

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
*/

#include "shuffle.h"

#include <iostream>
#include <string>
#include <windows.h>

int main() {

  /*
  FIX_ME: добавлено для корректной работы с русским текстом в консоли
  (установка кодировки Windows - 1251 для ввода и вывода)
  */
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);

  /*
  FIX_ME: часть кода была вынесена в функцию process_word,
  добавлен вызов функции для проверки ввода;
  Также изменены названия переменных, так как
  они не соответствовали стилю lower_case_with_underscores;

  std::string originalWord;
  std::string currentWord;
  int attempts = 0;

  // Ввод слова
  std::cout << "Введите слово: ";
  std::cin >> originalWord;

  currentWord = originalWord;

  // Переставляем буквы до совпадения с исходным словом
  do {
    currentWord = shuffle_word(currentWord);
    std::cout << currentWord << std::endl;
    attempts++;
  } while (!is_word_match(originalWord, currentWord));

  // Выводим количество попыток
  std::cout << attempts << " попыток" << std::endl;
  */
  std::string original_word;

  while (true) {

    std::cout << "Введите слово: ";
    std::cin >> original_word;

    try {
      is_word_valid(original_word);
      process_word(original_word);
      break;
    }
    catch (const std::invalid_argument& e) {
      std::cout << e.what() << std::endl;
    }
  }

  return 0;
}