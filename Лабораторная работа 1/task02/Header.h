#ifndef HEADER_H
#define HEADER_H

#include <vector>
#include <string>

/*
FIX_ME: Функции должны быть вынесены из main
и использовать lower_case_with_underscores.
*/

void read_data(const std::string& filename, int& board_size, std::vector<std::vector<int>>& board);

void validate_board(const std::vector<std::vector<int>>& board, std::vector<std::pair<int, int>>& errors);

void print_board(const std::vector<std::vector<int>>& board, const std::vector<std::pair<int, int>>& errors,
  bool highlight_errors);

int solve_task(const std::vector<std::vector<int>>& board);

#endif