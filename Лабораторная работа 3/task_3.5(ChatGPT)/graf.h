#ifndef GRAF_H
#define GRAF_H

#include <vector>
#include <iostream>
#include <fstream>
#include <algorithm>

class Graph {
private:
  int n;

  /*
  FIX_ME: имя переменной должно
  соответствовать стилю lower_case_with_underscores.
  std::vector<std::vector<int>> adjMatrix;
  */
  std::vector<std::vector<int>> adj_matrix;

public:
  Graph(int size);

  /*
  FIX_ME: имя функции должно соответствовать стилю lower_case_with_underscores.
  void setMatrix(const std::vector<std::vector<int>>& matrix);
  */
  void set_matrix(const std::vector<std::vector<int>>& matrix);

  /*
  FIX_ME: имена переменной и функции должны
  соответствовать стилю lower_case_with_underscores.
  std::vector<int> findCities(int start, int maxTransfers);
  */
  std::vector<int> find_cities(int start, int max_transfers);
};

/*
FIX_ME: Логика решения задания выведена в отдельную функцию.
Добавлена функция для проверки ввода.
*/
void solve(int n, const std::vector<std::vector<int>>& matrix, int K, int L);

void check_input(int& K, int& L, int& n);

#endif
