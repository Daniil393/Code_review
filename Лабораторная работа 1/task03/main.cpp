/*
К-ичные числа. Среди чисел в системе счисления с основанием K (2≤K≤10)
определить сколько имеется чисел из N (1<N<20, N+K<26) разрядов таких,
что в их записи не содержится более двух подряд идущих нулей. Для того, чтобы
избежать переполнения, ответ представьте в виде вещественного числа.
*/

#include <iostream>
#include <windows.h>
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

    int N, K;

    std::cout << "Введите количество разрядов N (1 < N < 20): ";
    std::cin >> N;

    /*
    FIX_ME: Ошибка обрабатывалась через код возврата.
    По код-стайлу необходимо использовать исключение.

    if (N <= 1 || N >= 20) {
      std::cout << "Некорректные входные данные" << std::endl;
      return 1;
    }
    */

    if (N <= 1 || N >= 20) {
      throw std::runtime_error("Некорректные входные данные для N (1 < N < 20)");
    }

    std::cout << "Введите систему счисления К (2 <= K <= 10, N + K < 26): ";
    std::cin >> K;

    /*
    FIX_ME: Ошибка обрабатывалась через код возврата.
    По код-стайлу необходимо использовать исключение.
    
    if (K < 2 || K > 10 || N + K >= 26) {
      std::cout << "Некорректные значения" << std::endl;
      return 1;
    }
    */
    if (K < 2 || K > 10 || N + K >= 26) {
      throw std::runtime_error("Некорректные значения K (2 <= K <= 10, N + K < 26)");
    }

    /*
    FIX_ME: имя переменной не отображает ее смысл.
    double bebe = count_k_base_numbers(N, K);
    */
    double result = count_k_base_numbers(N, K);
    std::cout << "Количество чисел, в которых не содержится более двух подряд идущих нулей: " << result << std::endl;

  }
  catch (const std::exception& e) {
    std::cerr << "Ошибка: " << e.what() << std::endl;
    return 1;
  }

  return 0;
}