#ifndef GRAF_H
#define GRAF_H

#include <vector>
#include <string>

class Graf {
private:
  int n;
  std::vector<std::vector<int>> matrix;

public:
  Graf(const std::string& filename);

  ~Graf();

  /*
  FIX_ME: имена функций должны соответствовать
  стилю lower_case_with_underscores.

  std::vector<int> findCitiesWithLessTransfers(int K, int L);
  void printResult(int K, int L);
  */

  std::vector<int> find_cities_with_less_transfers(int K, int L);

  void print_result(int K, int L);

  // FIX_ME: добавлен геттер для n.
  int get_n() const;
};

//FIX_ME: Добавлена функция для проверки ввода.
void check_input(int& K, int& L, int& n);

#endif