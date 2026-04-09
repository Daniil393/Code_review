#ifndef HEADER_H
#define HEADER_H

#include <string>

/*
FIX_ME: имена функций и переменных должны использовать стиль lower_case_with_underscores

int NumRead(std::string& s, int& symb, int currentNumber = 0);
int CalculateTerm(std::string& s, int& symb);
int CalculateS(std::string& s, int& symb);
*/
int number_read(std::string& s, int& symb, int current_number = 0);
int calculate_term(std::string& s, int& symb);
int calculate_s(std::string& s, int& symb);

#endif