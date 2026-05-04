/*
https://chatgpt.com/share/69d51cbb-e934-8333-a00a-4139f61f153e

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
#include <fstream>
#include <vector>
#include <algorithm>
#include <windows.h>

int main() {

  /*
  FIX_ME: добавлено для корректной работы с русским текстом в консоли
  (установка кодировки Windows - 1251 для ввода и вывода)
  */
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);

  /*
  FIX_ME: Исключения выбрасываются, но не перехватываются.
  Необходимо использовать try-catch в main
  */
  try {
    std::ifstream file("filename.txt");

    /*
    FIX_ME: Ошибки обрабатывались через код возврата.
    По код-стайлу необходимо использовать исключения.

    if (!file.is_open()) {
      std::cout << "Ошибка открытия файла\n";
      return 1;
    }
    */
    if (!file.is_open()) {
      throw std::runtime_error("Файл невозможно открыть");
    }

    int n;
    file >> n;

    std::vector<std::vector<int>> matrix(n, std::vector<int>(n));

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        file >> matrix[i][j];
      }
    }

    int K, L;
    std::cout << "Введите K и L: ";

    //FIX_ME: вызов функции для проверки ввода и решения задачи.
    check_input(K, L, n);

    solve(n, matrix, K, L);
  }
  catch (const std::exception& error) {
    std::cout << "Ошибка: " << error.what() << std::endl;
    return 1;
  }

  return 0;
}