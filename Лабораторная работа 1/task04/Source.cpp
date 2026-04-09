#include <iostream>
#include <cctype>
#include <cstdlib>
#include "header.h"

/*
FIX_ME: Использование using namespace std запрещено код-стайлом
using namespace std;
удалено using namespace std; , используются полные имена std::
*/

int number_read(std::string& s, int& symb, int current_number) {
  if (symb >= s.length() || !isdigit(s[symb])) {
    return current_number;
  }
  current_number = current_number * 10 + (s[symb] - '0');
  symb++;

  return number_read(s, symb, current_number);
}

int calculate_term(std::string& s, int& symb) {

  int value = number_read(s, symb);

  /*
  FIX_ME: по условию задачи нельзя использовать оператор цикла.
  Цикл while заменён на рекурсию.

  while (symb < s.length() && (s[symb] == '*' || s[symb] == '/')) {
  */
  if (symb < s.length() && (s[symb] == '*' || s[symb] == '/')) {

    /*
    FIX_ME: имя переменной не отображает ее смысл.
    char znak = s[symb];
    */
    char operator_char = s[symb];

    symb++;
    int next_number = calculate_term(s, symb);

    if (operator_char == '*') {
      return value * next_number;
    }

    else {

      /*
      FIX_ME: для обработки ошибки нужно использовать исключения.

      if (number == 0) {
        std::cout << "ошибка при делении на ноль!" << std::endl;
        exit(1);
      }
      */
      if (next_number == 0) {
        throw std::runtime_error("Ошибка при делении на ноль!");
      }
      return value / next_number;
    }
  }

  return value;
}

int calculate_s(std::string& s, int& symb) {

  int value = calculate_term(s, symb);

  /*
  FIX_ME: по условию задачи нельзя использовать оператор цикла.
  Цикл while заменён на рекурсию.

  while (symb < s.length() && (s[symb] == '+' || s[symb] == '-')) {
  */
  if (symb < s.length() && (s[symb] == '+' || s[symb] == '-')) {

    /*
    FIX_ME: имя переменной не отображает ее смысл.
    char znak = s[symb];
    */
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