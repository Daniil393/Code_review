#ifndef GRAF_H
#define GRAF_H

#include <vector>
#include <string>

class Graf {
private:
  int n;                            
  std::vector<std::vector<int>> m;   

public:
  Graf(const std::string& filename);
  std::vector<int> reachable(int K, int L);

  // FIX_ME: добавлен метод для получения количества городов
  int get_size() const {
    return n;
  }
};

// FIX_ME: Добавлена функция для проверки ввода.

void check_input(int& K, int& L, int n);

#endif