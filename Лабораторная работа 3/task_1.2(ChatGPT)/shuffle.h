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
void processWord(const std::string& word);
*/
void process_word(const std::string& word);

// FIX_ME: добавлена функция для проверки ввода.
bool is_word_valid(const std::string& word);

#endif