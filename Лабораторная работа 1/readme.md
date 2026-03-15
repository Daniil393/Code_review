# Отчет по код-ревью, лабораторная работа №1

> Задание №1
1. Использование using namespace std

Проблема:
В исходном коде использовалась директива
```C++
using namespace std;
```

Исправление:
Директива удалена.
Во всех местах используются полные имена из пространства имен std.

2. Обработка ошибок при открытии файла

Проблема:
Ошибка открытия файла обрабатывалась через код возврата
```C++
if (!file.is_open()) {
    cout << "Файл не открылся!!";
    return 1;
}
```

Исправление:
Добавлена обработка через try / catch и std::runtime_error.
```C++
if (!file.is_open()) {
    throw std::runtime_error("Файл не открылся");
}
```

3. Несоответствие имен переменных стилю

Проблема:
По код-стайлу переменные должны использовать стиль
lower_case_with_underscores. Также не все названия переменных отображали их смысл.

Исправление:
int N, Z; -> int artifact_count, weight_limit;
vector <int> wes(artifact_count); -> std::vector<int> weight(artifact_count);
vector <int> nalogi(weight_limit); -> std::vector<int> tax(artifact_count);
int maxWes = 0; -> int max_weight = 0;
int wes1 -> int weight1
vector <int> minNalog(max_weight + 1, numeric_limits<int>::max()); -> std::vector<int> min_tax(max_weight + 1, std::numeric_limits<int>::max());
int minNalogivalue = numeric_limits<int>::max(); -> int min_tax_value = std::numeric_limits<int>::max();
int totalwes = 0; -> int total_weight = 0;
vector <int> selectart; -> std::vector<int> select_art;
