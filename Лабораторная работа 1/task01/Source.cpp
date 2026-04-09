#include "header.h"
#include <fstream>
#include <limits>
#include <algorithm>

/*
FIX_ME: Использование using namespace std запрещено код-стайлом
using namespace std;
удалено using namespace std; , используются полные имена std::
*/

bool read_file(const std::string& filename, int& artifact_count, int& weight_limit,
  std::vector<int>& weight, std::vector<int>& tax) {

  std::ifstream file(filename);
  if (!file.is_open()) return false;

  file >> artifact_count >> weight_limit;

  weight.resize(artifact_count);
  tax.resize(artifact_count);

  for (int i = 0; i < artifact_count; i++) {
    file >> weight[i];
  }
  for (int i = 0; i < artifact_count; i++) {
    file >> tax[i];
  }

  return true;
}

void solve(int artifact_count, int weight_limit, std::vector<int>& weight, std::vector<int>& tax,
  std::vector<int>& select_art, int& total_weight, int& min_tax_value) {

  /*
  FIX_ME: имя переменной не использует стиль lower_case_with_underscores.
  int maxWes = 0;
  */
  int max_weight = 0;

  /*
  FIX_ME: имя переменной не отображает ее смысл.
  for (int wes1 : weight) {
  */
  for (int weight1 : weight) {
    max_weight += weight1;
  }

  /*
  FIX_ME: имя переменной не использует стиль lower_case_with_underscores
  и не отображает ее смысл.
  
  std::vector<int> minNalog(max_weight + 1, std::numeric_limits<int>::max());
  minNalog[0] = 0;
  */
  std::vector<int> min_tax(max_weight + 1, std::numeric_limits<int>::max());
  min_tax[0] = 0;

  /*
  FIX_ME: добавлен массив take[i][w] для корректного восстановления предметов.
  Также проверяется переполнение при расчёте нового налога:
  обновление min_tax[w] происходит только если новое значение меньше.

  for (int i = 0; i < artifact_count; i++) {
    for (int w = max_weight; w >= weight[i]; w--) {
      if (min_tax[w - weight[i]] != std::numeric_limits<int>::max()) {
        min_tax[w] = std::min(min_tax[w], min_tax[w - weight[i]] + tax[i]);
      }
    }
  }
  */

  std::vector<std::vector<bool>> take(artifact_count, std::vector<bool>(max_weight + 1, false));

  for (int i = 0; i < artifact_count; i++) {
    for (int w = max_weight; w >= weight[i]; w--) {
      if (min_tax[w - weight[i]] != std::numeric_limits<int>::max()) {

        int new_tax = min_tax[w - weight[i]] + tax[i];

        if (new_tax < min_tax[w]) {
          min_tax[w] = new_tax;
          take[i][w] = true;
        }
      }
    }
  }

  /*
  FIX_ME: имя переменной не использует стиль lower_case_with_underscores
  и не отображает ее смысл.

  minNalogivalue = std::numeric_limits<int>::max();
  */
  min_tax_value = std::numeric_limits<int>::max();

  /*
  FIX_ME: имя переменной не отображает ее смысл.
  totalwes = 0;
  */
  total_weight = 0;

  for (int w = weight_limit + 1; w <= max_weight; w++) {
    if (min_tax[w] < min_tax_value) {
      min_tax_value = min_tax[w];
      total_weight = w;
    }
  }

  select_art.clear();

  /*
  FIX_ME: используется массив take[i][w] для точного восстановления артефактов.
  Добавлен std::reverse для вывода индексов в порядке возрастания.

  for (int i = artifact_count - 1, w = total_weight; i >= 0; --i) {
    if (w >= weight[i] && min_tax[w] == min_tax[w - weight[i]] + tax[i]) {
      select_art.push_back(i + 1);
      w -= weight[i];
    }
  }
  */
  int w = total_weight;

  for (int i = artifact_count - 1; i >= 0; --i) {
    if (w >= weight[i] && take[i][w]) {
      select_art.push_back(i + 1);
      w -= weight[i];
    }
  }

  std::reverse(select_art.begin(), select_art.end());
}