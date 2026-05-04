/*
https://chatgpt.com/share/69f5b203-b4ec-83eb-9de4-bd61d856c6f4

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
  FIX_ME: ошибка обрабатывались через код возврата.
  Добавлен повторный запрос имени файла при ошибки чтения.

  std::ifstream file("filename.txt");
  if (!file) {
    std::cout << "Ошибка открытия файла\n";
    return 1;
  }
  */
  std::string filename;
  std::ifstream file;

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

  std::string expr;
  std::getline(file, expr);
  if (expr.empty()) {
    std::getline(file, expr);
  }

  int pos = 0;
  Node* root = build_tree(expr, pos);

  //FIX_ME: добавлен вывод исходного дерева.
  std::cout << "Исходное дерево: ";
  print_tree(root);
  std::cout << std::endl;

  root = transform(root);
  
  //FIX_ME: добавлен вывод преобразованного дерева и результата вычислений.
  std::cout << "Преобразованное дерево: ";
  print_tree(root);
  std::cout << std::endl;

  long long result = evaluate(root);
  std::cout << "Результат: " << result << std::endl;

  std::cout << "Указатель на корень: " << root << std::endl;

  free_tree(root);

  return 0;
}