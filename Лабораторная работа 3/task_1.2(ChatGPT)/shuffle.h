#ifndef SHUFFLE_H
#define SHUFFLE_H

#include <string>

/*
FIX_ME: èìÿ ôóíêöèè äîëæíî ñîîòâåòñòâîâàòü ñòèëþ lower_case_with_underscores.
std::string shuffleWord(const std::string& word);
*/
std::string shuffle_word(const std::string& word);

/*
FIX_ME: èìÿ ôóíêöèè äîëæíî ñîîòâåòñòâîâàòü ñòèëþ lower_case_with_underscores.
void processWord(const std::string& word);
*/
void process_word(const std::string& word);

// FIX_ME: äîáàâëåíà ôóíêöèÿ äëÿ ïðîâåðêè ââîäà.
bool is_word_valid(const std::string& word);

#endif
