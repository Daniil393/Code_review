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
N -> artifact_count
Z -> weight_limit
wes -> weight
nalogi -> tax
maxWes -> max_weight
wes1 -> weight1
minNalog -> min_tax
minNalogivalue -> min_tax_value
totalwes -> total_weight
selectart -> select_art
