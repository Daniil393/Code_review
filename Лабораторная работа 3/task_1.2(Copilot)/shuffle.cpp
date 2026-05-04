#include "shuffle.h"

#include <regex> // FIX_ME: библиотека для функции проверки ввода.
#include <algorithm>
#include <random>
#include <iostream>

std::string shuffle_word(const std::string& word) {
  static std::random_device rd;
  static std::mt19937 gen(rd());

  std::string shuffled = word;
  std::shuffle(shuffled.begin(), shuffled.end(), gen);

  return shuffled;
}

// FIX_ME: реализация добавленной функции проверки ввода.
bool is_word_valid(const std::string& word) {
  static const std::regex pattern("^[A-Za-zА-Яа-яЁё]+$");

  if (!std::regex_match(word, pattern)) {
    throw std::invalid_argument("Ошибка: только буквы (русские или английские)");
  }
  return true;
}

// FIX_ME: реализация функции вывода слов и подсчета попыток.
void process_word(const std::string& word) {
  int attempts = 0;
  std::string shuffled;

  do {
    shuffled = shuffle_word(word);
    std::cout << shuffled << std::endl;
    attempts++;
  } while (shuffled != word);

  std::cout << attempts << " попыток" << std::endl;
}
