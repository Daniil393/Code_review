#include "header.h"
#include <fstream>
#include <iostream>
#include <iomanip>
#include <stdexcept>
#include <algorithm>

/*
FIX_ME: Использование using namespace std запрещено код-стайлом
using namespace std;
удалено using namespace std; , используются полные имена std::
*/

void read_data(const std::string& filename, int& board_size, std::vector<std::vector<int>>& board) {

  /*
  FIX_ME: Имя переменной не отражает смысл
  std::ifstream fin("input.txt");
  */
  std::ifstream input_file("input.txt");

  /*
  FIX_ME: Ошибки обрабатывались через код возврата.
  По код-стайлу необходимо использовать исключения.

  if (!fin.is_open()) {
    std::cerr << "Ошибка! Не удалось открыть input.txt\n";
  return 1;
  }
  */
  if (!input_file.is_open()) {
    throw std::runtime_error("Не удалось открыть input.txt\n");
  }

  input_file >> board_size;


  /*
  FIX_ME: Ошибка обрабатывалась через return
  
  if (n <= 1 || n >= 80) {
    std::cerr << "Некорректный размер доски!
    Допустимый диапазон: 1 < N < 80\n";
    return 1;
    }
  */
  if (board_size <= 1 || board_size >= 80) {
    throw std::runtime_error("Некорректный размер доски! Допустимый диапазон: 1 < N < 80\n");
  }

  board.resize(board_size, std::vector<int>(board_size));

  for (int i = 0; i < board_size; ++i) {
    for (int j = 0; j < board_size; ++j) {
      input_file >> board[i][j];
    }
  }
}

void validate_board(const std::vector<std::vector<int>>& board, std::vector<std::pair<int, int>>& errors) {

  int board_size = board.size();

  for (int i = 0; i < board_size; ++i) {
    for (int j = 0; j < board_size; ++j) {
      if (board[i][j] < 0 || board[i][j] > 100) {
        errors.push_back(std::make_pair(i, j));
      }
    }
  }
}

void print_board(const std::vector<std::vector<int>>& board, const std::vector<std::pair<int, int>>& errors,
  bool highlight_errors) {

  int board_size = board.size();

  std::cout << "Входная доска (" << board_size << "x" << board_size << "):\n";

  std::cout << "     ";
  for (int j = 0; j < board_size; ++j)
    std::cout << std::setw(highlight_errors ? 6 : 4) << j;

  std::cout << "\n    +" << std::string(board_size * (highlight_errors ? 6 : 4), '-') << "\n";

  for (int i = 0; i < board_size; ++i) {
    std::cout << std::setw(2) << i << " |";

    for (int j = 0; j < board_size; ++j) {

      bool is_error = false;

      if (highlight_errors) {
        for (const auto& error : errors) {
          if (error.first == i && error.second == j) {
            is_error = true;
            break;
          }
        }
      }

      if (highlight_errors && is_error) {
        std::cout << " !" << std::setw(3) << board[i][j] << "!";
      }
      else {
        std::cout << std::setw(highlight_errors ? 6 : 4) << board[i][j];
      }
    }
    std::cout << "\n";
  }
}

int solve_task(const std::vector<std::vector<int>>& board) {

  int board_size = board.size();

  std::vector<std::vector<int>> dp(board_size,
    std::vector<int>(board_size));

  dp[board_size - 1][0] = board[board_size - 1][0];

  for (int j = 1; j < board_size; ++j) {
    dp[board_size - 1][j] =
      dp[board_size - 1][j - 1] + board[board_size - 1][j];
  }

  for (int i = board_size - 2; i >= 0; --i) {
    dp[i][0] = dp[i + 1][0] + board[i][0];
  }

  for (int i = board_size - 2; i >= 0; --i) {
    for (int j = 1; j < board_size; ++j) {
      dp[i][j] =
        std::min(dp[i + 1][j], dp[i][j - 1]) + board[i][j];
    }
  }

  return dp[0][board_size - 1];
}