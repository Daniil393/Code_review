/*
Во всех заданиях данной подгруппы предполагается, что исходные строки,
определяющие выражения, не содержат пробелов.При выполнении заданий не
следует использовать оператор цикла. Вывести значение целочисленного выражения,
заданного в виде строки S. Выражение определяется следующим образом :
<выражение> :: = <терм> | <выражение> +<терм> | <выражение> − <терм>
<терм> :: = <цифра> | <терм> * <цифра>
*/

// FIX_ME: был закомментирован весь код.

#include <iostream>
#include <string>
#include <Windows.h>
#include "header.h"

/*
FIX_ME: Использование using namespace std запрещено код-стайлом
using namespace std;
удалено using namespace std; , используются полные имена std::
*/

int main() {

  SetConsoleOutputCP(CP_UTF8);
  SetConsoleCP(CP_UTF8);

  /*
  FIX_ME: Исключения выбрасываются, но не перехватываются.
  Необходимо использовать try-catch в main
  */

  try {
    /*
    FIX_ME: нужно разделить объявление переменной, вывод сообщения
    и считывание ввода на отдельные строки. Также записать S в нижнем регистре.

    std::string S; std::cout << "Введите выражение -> "; std::getline(std::cin, S);
    */

    std::string s;
    std::cout << "Введите выражение -> ";
    std::getline(std::cin, s);

    int symb = 0;
    int result = calculate_s(s, symb);

    std::cout << "Результат -> " << result << std::endl;
  }

  catch (const std::exception& e) {
    std::cerr << "Ошибка: " << e.what() << std::endl;
    return 1;
  }

  return 0;
}