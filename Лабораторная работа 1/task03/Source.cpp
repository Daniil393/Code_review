#include "header.h"

/*
FIX_ME: имена переменных не отображают их смысл.
long long nz, oz, tz;
*/
long long non_zero_end, one_zero_end, two_zero_end;

double count_k_base_numbers(int N, int K) {

  long long non_zero_end = K - 1;

  /*
  FIX_ME: неверная начальная инициализация
  long long one_zero_end = 1;
  */
  long long one_zero_end = 0;
  long long two_zero_end = 0;

  for (int i = 2; i <= N; i++) {

    /*
    FIX_ME: имена переменных не отображают их смысл
    и логика перехода состояний неверная.

    long long nz_ = (K - 1) * (non_zero_end + one_zero_end);
    long long oz_ = non_zero_end;
    long long tz_ = two_zero_end + one_zero_end * K;
    */
    long long new_non_zero_end = (K - 1) * (non_zero_end + one_zero_end + two_zero_end);
    long long new_one_zero_end = non_zero_end;
    long long new_two_zero_end = one_zero_end;

    non_zero_end = new_non_zero_end;
    one_zero_end = new_one_zero_end;
    two_zero_end = new_two_zero_end;
  }

  /*
  FIX_ME: неверное вычисление итогового результата
  и результат по условию задачи должен быть вещественным (тип double).
  return non_zero_end + one_zero_end;
  */
  return static_cast<double>(non_zero_end + one_zero_end + two_zero_end);
}