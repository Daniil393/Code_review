#ifndef HEADER_H
#define HEADER_H

#include <vector>
#include <string>

/*
FIX_ME: имена переменных не используют стиль lower_case_with_underscores
и названия переменных должны отображать их смысл.

bool read_file(const std::string& filename, int& N, int& Z,
  std::vector<int>& wes, std::vector<int>& nalogi);
*/
bool read_file(const std::string& filename, int& artifact_count, int& weight_limit,
  std::vector<int>& weight, std::vector<int>& tax);

/*
FIX_ME: имена переменных не используют стиль lower_case_with_underscores
и названия переменных должны отображать их смысл.

void solve(int N, int Z, std::vector<int>& wes, std::vector<int>& nalogi,
  std::vector<int>& selectart, int& totalwes, int& minNalogivalue);
*/
void solve(int artifact_count, int weight_limit, std::vector<int>& weight, std::vector<int>& tax,
  std::vector<int>& select_art, int& total_weight, int& min_tax_value);

#endif