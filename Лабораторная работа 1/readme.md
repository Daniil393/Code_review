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

&nbsp;

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

&nbsp;

3. Несоответствие имен переменных стилю

Проблема:
По код-стайлу переменные должны использовать стиль
lower_case_with_underscores. Также не все названия переменных отображали их смысл.

Исправление:
- N -> artifact_count
- Z -> weight_limit
- wes -> weight
- nalogi -> tax
- maxWes -> max_weight
- wes1 -> weight1
- minNalog -> min_tax
- minNalogivalue -> min_tax_value
- totalwes -> total_weight
- selectart -> select_art

&nbsp;

4. Пробелы в шаблонах

Исправление:
- std::vector <int> weight(artifact_count) -> std::vector<int> weight(artifact_count);
- std::vector <int> tax(weight_limit); -> std::vector<int> tax(artifact_count);
- std::vector <int> min_tax(max_weight + 1, numeric_limits<int>::max()); -> std::vector<int> min_tax(max_weight + 1, std::numeric_limits<int>::max());
- std::vector <int> select_art; -> std::vector<int> select_art;

&nbsp;

5. Неверный размер вектора налогов

Проблема:
В исходном коде вектор налогов создавался размером Z:
```C++
vector<int> nalogi(Z);
```
Однако налог задан для каждого артефакта, поэтому размер должен быть N.

Исправление:
- std::vector<int> tax(artifact_count);

&nbsp;
