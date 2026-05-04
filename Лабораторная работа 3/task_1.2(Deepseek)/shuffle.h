#ifndef SHUFFLE_H
#define SHUFFLE_H

#include <string>

/*
FIX_ME: имя функции должно соответствовать стилю lower_case_with_underscores.
std::string shuffleWord(const std::string& word);
*/
std::string shuffle_word(const std::string& word);

/*
FIX_ME: имя функции должно соответствовать стилю lower_case_with_underscores.
bool isWordMatch(const std::string& original, const std::string& shuffled);
*/
bool is_word_match(const std::string& original, const std::string& shuffled);

// FIX_ME: добавлена функция для проверки ввода.
bool is_word_valid(const std::string& word);

// FIX_ME: добавлена функция для вывода слов и подсчета попыток.
void process_word(const std::string& original_word);

#endif