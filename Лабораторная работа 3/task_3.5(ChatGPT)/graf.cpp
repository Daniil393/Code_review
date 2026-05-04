#include "graf.h"

#include <queue>
#include <iostream>
#include <fstream>
#include <algorithm>

Graph::Graph(int size) {
  n = size;
  adj_matrix.resize(n, std::vector<int>(n));
}

void Graph::set_matrix(const std::vector<std::vector<int>>& matrix) {
  adj_matrix = matrix;
}

std::vector<int> Graph::find_cities(int start, int max_transfers) {
  std::vector<int> dist(n, -1);
  std::queue<int> q;

  start--;
  dist[start] = 0;
  q.push(start);

  while (!q.empty()) {
    int current = q.front();
    q.pop();

    for (int i = 0; i < n; i++) {
      if (adj_matrix[current][i] == 1 && dist[i] == -1) {
        dist[i] = dist[current] + 1;
        q.push(i);
      }
    }
  }

  std::vector<int> result;

  for (int i = 0; i < n; i++) {
    if (i != start && dist[i] != -1 && dist[i] < max_transfers) {
      result.push_back(i + 1);
    }
  }

  return result;
}

void solve(int n, const std::vector<std::vector<int>>& matrix, int K, int L) {
  Graph g(n);
  g.set_matrix(matrix);

  std::vector<int> result = g.find_cities(K, L);

  if (result.empty()) {
    std::cout << -1;
  }
  else {
    std::sort(result.begin(), result.end());
    for (int city : result) {
      std::cout << city << " ";
    }
  }
}

//FIX_ME: реализация функции проверки ввода.
void check_input(int& K, int& L, int& n) {
  while (true) {
    if (!(std::cin >> K >> L)) {
      std::cout << "Ошибка: K и L должны быть целыми числами\n";
      std::cin.clear();
      std::cin.ignore(10000, '\n');

      std::cout << "Введите K и L: ";
      continue;
    }

    if (K < 1 || K > n) {
      std::cout << "Ошибка: номер города K вне допустимого диапазона\n";
      std::cout << "Введите K и L: ";
      continue;
    }

    break;
  }
}
