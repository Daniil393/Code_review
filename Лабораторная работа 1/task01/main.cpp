/*
Археолог нашел N артефактов.Известны веса(сi) и налоговое бремя(di) находок.
Нужно выбрать такое подмножество находок, чтобы их суммарный вес превысил Z кг,
а их общее налоговое бремя оказалось минимальным. Известно, что решение
единственно. Укажите порядковые номера вещей, которые нужно взять. Исходный
данные находятся в текстовом файле, в первой строке указаны N и Z, а во второй
строке значения весов(в кг), в третьей - величина налога по каждой находке.
Вывести так же суммарный вес и общую ценность результата.
*/

#include <iostream>
#include <vector>
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

  int artifact_count, weight_limit;
  std::vector<int> weight;
  std::vector<int> tax;

  if (!read_file("file.txt", artifact_count, weight_limit, weight, tax)) {
    std::cout << "Файл не открылся!!";
    return 1;
  }

  std::vector<int> select_art;
  int total_weight = 0;
  int min_tax_value = 0;

  solve(artifact_count, weight_limit, weight, tax, select_art, total_weight, min_tax_value);

  std::cout << "Индексы артефактов: ";
  for (int index : select_art) {
    std::cout << index << " ";
  }

  std::cout << "\nСуммарный вес: " << total_weight << " кг";
  std::cout << "\nОбщая ценность: " << min_tax_value << std::endl;

  return 0;
}