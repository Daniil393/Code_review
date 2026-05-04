#include "graf.h"

#include <fstream>
#include <queue>
#include <iostream>

Graf::Graf(const std::string& filename) {
  std::ifstream fin(filename);

  //FIX_ME: добавлена обработка ошибки открытия файла.
  if (!fin) {
    throw std::runtime_error("Не удалось открыть файл");
  }

  fin >> n;

  m.assign(n, std::vector<int>(n));

  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      fin >> m[i][j];
}

std::vector<int> Graf::reachable(int K, int L) {
  std::vector<int> dist(n, -1);
  std::queue<int> q;

  K--;
  dist[K] = 0;
  q.push(K);

  while (!q.empty()) {
    int v = q.front();
    q.pop();

    for (int u = 0; u < n; u++) {
      if (m[v][u] == 1 && dist[u] == -1) {
        dist[u] = dist[v] + 1;
        q.push(u);
      }
    }
  }

  std::vector<int> result;
  for (int i = 0; i < n; i++) {
    if (i != K && dist[i] != -1 && dist[i] < L + 1) {
      result.push_back(i + 1);
    }
  }

  return result;
}

//FIX_ME: реализация функции проверки ввода.
void check_input(int& K, int& L, int n) {
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