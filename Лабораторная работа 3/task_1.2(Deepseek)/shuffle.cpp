#include "shuffle.h"

#include <regex> // FIX_ME: библиотека для функции проверки ввода.
#include <string>
#include <random>
#include <algorithm>
#include <ctime>
#include <iostream>

std::string shuffle_word(const std::string& word) {
  std::string shuffled = word;

  static std::mt19937 gen(static_cast<unsigned>(time(nullptr)));
  std::shuffle(shuffled.begin(), shuffled.end(), gen);

  return shuffled;
}

bool is_word_match(const std::string& original, const std::string& shuffled) {
  return original == shuffled;
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
void process_word(const std::string& original_word) {
  std::string current_word = original_word;
  int attempts = 0;

  do {
    current_word = shuffle_word(current_word);
    std::cout << current_word << std::endl;
    attempts++;
  } while (!is_word_match(original_word, current_word));

  std::cout << attempts << " попыток" << std::endl;
}
