#include "graf.h"

#include <iostream>
#include <fstream>
#include <queue>
#include <algorithm>
#include <set>

/*
FIX_ME: Использование using namespace std запрещено код-стайлом
using namespace std;
удалено using namespace std; , используются полные имена std::
*/

Graf::Graf(const std::string& filename) {
  std::ifstream file(filename);

  if (!file.is_open()) {
    std::cerr << "Ошибка открытия файла!" << std::endl;
    n = 0;
    return;
  }

  file >> n;

  matrix.resize(n, std::vector<int>(n, 0));

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      file >> matrix[i][j];
    }
  }

  file.close();
}

Graf::~Graf() {

}

std::vector<int> Graf::find_cities_with_less_transfers(int K, int L) {
  std::vector<int> result;

  if (n == 0 || K < 1 || K > n) {
    return result;
  }

  int start = K - 1;

  std::vector<int> transfers(n, -1);

  std::queue<std::pair<int, int>> q;

  transfers[start] = 0;
  q.push({ start, 0 });

  while (!q.empty()) {

    /*
    FIX_ME: имена переменных должны соответствовать
    стилю lower_case_with_underscores.

    int currentCity = q.front().first;
    int currentTransfers = q.front().second;
    */
    int current_city = q.front().first;
    int current_transfers = q.front().second;
    q.pop();

    /*
    FIX_ME: имена переменных должны соответствовать
    стилю lower_case_with_underscores.

    for (int nextCity = 0; nextCity < n; nextCity++) {

      if (matrix[current_city][nextCity] == 1 && transfers[nextCity] == -1) {
        int newTransfers = current_transfers + 1;
        transfers[nextCity] = newTransfers;
        q.push({ nextCity, newTransfers });
      }
    }
  }
    */
    for (int next_city = 0; next_city < n; next_city++) {
   
      if (matrix[current_city][next_city] == 1 && transfers[next_city] == -1) {
        int new_transfers = current_transfers + 1;
        transfers[next_city] = new_transfers;
        q.push({ next_city, new_transfers });
      }
    }
  }

  for (int i = 0; i < n; i++) {
    if (i != start && transfers[i] != -1 && transfers[i] < L) {
      result.push_back(i + 1);
    }
  }

  sort(result.begin(), result.end());

  return result;
}

void Graf::print_result(int K, int L) {
  std::vector<int> result = find_cities_with_less_transfers(K, L);

  if (result.empty()) {
    std::cout << -1 << std::endl;
  }
  else {
    for (size_t i = 0; i < result.size(); i++) {
      std::cout << result[i];
      if (i < result.size() - 1) {
        std::cout << " ";
      }
    }
    std::cout << std::endl;
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

// FIX_ME: реализация геттера.
int Graf::get_n() const {
  return n;
}