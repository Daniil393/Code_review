/*
https://copilot.microsoft.com/shares/vXeqKV4fi5jhmt4cZEWXE

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
#include <windows.h>

int main() {

  /*
  FIX_ME: некорректное отображение русских символов.

  setlocale(LC_ALL, "Russian");
  */
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);

  std::string word;

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
  while (true) {
    try {
      std::cout << "Введите слово: ";
      std::cin >> word;

      is_word_valid(word);

      break;
    }
    catch (const std::exception& e) {
      std::cout << e.what() << std::endl;
    }
  }

  process_word(word);

  return 0;
}