/*
https://chat.deepseek.com/share/zo72f2s5g0kvkdconj

В текстовом файле с именем filename дано арифметическое выражение в префиксной
форме. Операндами в выражении являются целые числа из промежутка от 0 до 9.
Используемые операции: сложение (+), вычитание (-), умножение (*), деление
нацело (/), целочисленный остаток от деления (%) и возведение в степень (^).
Постройте дерево, соответствующее данному выражению. Знаки операций кодируйте
числами: сложение(-1), вычитание(-2), умножение(-3), деление(-4), остаток от
деления(-5), возведение в степень (-6). Преобразуйте дерево так, чтобы в нем
не было операций возведения в степень (замените поддеревья, в которых есть
возведение в степень, значением данного поддерева). Выведите указатель на
корень полученного дерева.
*/

#include "calc_tree.h"

#include <iostream>
#include <fstream>
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
  FIX_ME: Чтение имени файла с повтором до корректного открытия.
  При ошибке используется throw.

  std::string filename;
  std::cout << "Введите имя файла: ";
  std::cin >> filename;

  // Чтение выражения из файла
  std::ifstream file(filename);
  if (!file.is_open()) {
    std::cerr << "Ошибка: не удалось открыть файл " << filename << std::endl;
    return 1;
  }
  file.close();
  */
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

  std::string expression;
  std::getline(file, expression);
  expression.erase(remove_if(expression.begin(), expression.end(), ::isspace), expression.end());
  std::cout << "Выражение: " << expression << std::endl << std::endl;

  CalcTree tree;
  tree.build_from_string(expression);

  /*
  FIX_ME: Исправлен вывод и добавлено вычисление результата.

  std::cout << "Исходное дерево:" << std::endl;
  tree.print();

  // Преобразуем дерево (заменяем возведение в степень)
  tree.transform();

  std::cout << "Дерево после преобразования:" << std::endl;
  tree.print();
  */
  std::cout << "Исходное дерево:\n";
  tree.print_tree(tree.get_root());
  std::cout << "\n";

  int result = tree.evaluate();

  tree.transform();

  std::cout << "Преобразованное дерево:\n";
  tree.print_tree(tree.get_root());
  std::cout << "\n";

  std::cout << "Результат вычисления: " << result << "\n";

  std::cout << "Указатель на корень: " << tree.get_root() << "\n";

  return 0;
}