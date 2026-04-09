/*
Черепашка. На квадратной доске расставлены целые неотрицательные числа, каждое
из которых не превосходит 100. Черепашка, находящаяся в левом нижнем углу,
мечтает попасть в правый верхний. При этом она может переползать только в
клетку справа или сверху и хочет, чтобы сумма всех чисел, оказавшихся у нее на
пути, была бы минимальной.Определить эту сумму.Ввод и вывод организовать при
помощи текстовых файлов.Формат входных данных : в первой строке входного файла
записано число N - размер доски(1 < N < 80).Далее следует N строк, каждая из
которых содержит N целых чисел, представляющих доску.В выходной файл нужно
вывести единственное число : минимальную сумму.
*/

#include <iostream>
#include <vector>
#include <fstream>
#include <stdexcept>
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

    /*
    FIX_ME: Имя переменной не отражает смысл
    int n;
    */
    int board_size;

    std::vector<std::vector<int>> board;
    std::vector<std::pair<int, int>> errors;

    read_data("input.txt", board_size, board);

    validate_board(board, errors);

    if (!errors.empty()) {
      std::cerr << "\nОШИБКИ В ДОСКЕ:\n";

      print_board(board, errors, true);

      std::cerr << "\nНекорректные значения:\n";
      for (const auto& error : errors) {
        std::cerr << "  Позиция (" << error.first << "," << error.second
          << "): " << board[error.first][error.second] << "\n";
      }

      /*
      FIX_ME: Ошибки обрабатывались через код возврата.
      По код-стайлу необходимо использовать исключения.
      return 1;
      */
      throw std::runtime_error("Входные данные содержат значения вне диапазона [0,100]");
    }

    print_board(board, errors, false);
    std::cout << std::endl;

    int result = solve_task(board);

    /*
    FIX_ME: Имя переменной не отражает смысл
    std::ofstream fout("output.txt");
    */
    std::ofstream output_file("output.txt");

    /*
    FIX_ME: Ошибки обрабатывались через код возврата.
    По код-стайлу необходимо использовать исключения.

    if (!fout.is_open()) {
      std::cerr << "Ошибка! Не удалось создать output.txt\n";
      return 1;
    }
    */
    if (!output_file.is_open()) {
      throw std::runtime_error("Ошибка! Не удалось создать output.txt\n");
    }

    output_file << result;

    std::cout << "Минимальная сумма пути: " << result << std::endl;
  }
  catch (const std::exception& e) {
    std::cerr << "\nОшибка: " << e.what() << std::endl;
    return 1;
  }

  return 0;
}