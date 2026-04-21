# Отчет по код-ревью, лабораторная работа №5

> 1) public class AutomaticGun extends Pistol, public AutomaticGun2(int ammo, int rateOfFire)
и public class AutomaticGun3 extends Weapon2.

1. Отсутствуют фигурные скобки в нескольких условиях if.
Старый код:
```Java
      if (fireRate <= 0)
          throw new IllegalArgumentException("Скорострельность должна быть положительной");
```

&nbsp;

```Java
      if (seconds <= 0)
          throw new IllegalArgumentException("Время должно быть положительным");
```

Исправление:
```Java
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }
```

&nbsp;

```Java
        if (seconds <= 0) {
            throw new IllegalArgumentException("Время должно быть положительным");
        }
```

&nbsp;

> 2) public class Pistol.
1. Отсутствуют фигурные скобки в нескольких условиях if.
Старый код:
```Java
      if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
```

&nbsp;

```Java
      if (times < 0)
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");
```

&nbsp;

```Java
      if (bulletsToLoad < 0)
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
```

Исправление:
```Java
if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        }
```

&nbsp;

```Java
    if (times < 0) {
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");
        }
```

&nbsp;

```Java
      if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
```

&nbsp;

2. else должен находиться на той же строке что и }.
Старый код:
```Java
          }
            else {
                System.out.println("Клац!");
```

&nbsp;

```Java
      else {
            bullets = capacity;
            return total - capacity;
        }
```

&nbsp;

Исправление:
```Java
        } else {
                System.out.println("Клац!");
            }
```

&nbsp;

```Java
    } else {
            bullets = capacity;
            return total - capacity;
        }
```

&nbsp;

3. Дублирование логики.
Проблема: Дублирование логики стрельбы в методах shoot() и shoot(int times).
Нарушение принципа DRY (Don't Repeat Yourself).

&nbsp;

```Java
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }
```

&nbsp;

Исправление:

```Java
  public void shoot() {
        shoot(1);
    }
```
