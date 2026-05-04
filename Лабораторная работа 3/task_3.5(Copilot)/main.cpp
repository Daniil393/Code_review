/*
https://copilot.microsoft.com/shares/GAtVq5X9E2erTqwwCZyHm

Юный путешественник решил изучить схему авиационного сообщения. Схема
авиационного сообщения задана в текстовом файле с именем FileName в виде
матрицы смежности. Первая строка файла содержит количество городов (n)
n<=25, связанных авиационным сообщением, а следующие n строк хранят матрицу
(m), m[i][j]=0, если не имеется возможности перелета из города i в город j,
иначе m[i][j]=1. Определить номера городов, в которые из города K можно
долететь менее чем с L пересадками. Перечислите номера таких городов в порядке
возрастания. Нумерация городов начинается с 1. Если таких городов нет,
выведите число (-1).
*/

#include "graf.h"

#include <iostream>
#include <windows.h>

int main() {
  /*
  FIX_ME: добавлено для корректной работы с русским текстом в консоли
  (установка кодировки Windows - 1251 для ввода и вывода)
  */
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);

  std::string filename;
  int K, L;

  Graf* g = nullptr;

  /*
  FIX_ME: добавлен цикл повторного ввода имени файла
  с обработкой ошибки открытия файла(через try / catch)
  */
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

  /*
  FIX_ME: добавлена проверка пользовательского ввода
  (вместо прямого ввода используется функция check_input)

  std::cin >> K >> L;
  */
  std::cout << "Введите K и L: ";
  check_input(K, L, g->get_size());

  std::vector<int> ans = g->reachable(K, L);

  if (ans.empty()) {
    std::cout << -1;
  }
  else {
    for (int x : ans)
      std::cout << x << " ";
  }

  return 0;
}