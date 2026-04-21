# Отчет по код-ревью, лабораторная работа №5

> 1) public class AutomaticGun extends Pistol, public AutomaticGun2(int ammo, int rateOfFire)
и public class AutomaticGun3 extends Weapon2.
**1. Отсутствуют фигурные скобки в нескольких условиях if.**

&nbsp;

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

&nbsp;

1. Отсутствуют фигурные скобки в нескольких условиях if.

&nbsp;

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

&nbsp;

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

&nbsp;

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

&nbsp;

> 3) public class Pistol2 extends Weapon.

&nbsp;

1. Отсутствуют фигурные скобки в нескольких условиях if.

&nbsp;

Старый код:
```Java
      if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
```

&nbsp;

```Java
        if (getAmmo())
            System.out.println("Бах!");
        else
            System.out.println("Клац!");
```

&nbsp;

```Java
       if (times < 0)
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");
```

&nbsp;

Исправление:
```Java
      if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        }
```

&nbsp;

```Java
        if (getAmmo()) {
            System.out.println("Бах!");
        }
        else {
            System.out.println("Клац!");
        }
```

&nbsp;

```Java
       if (times < 0) {
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");
        }
```

&nbsp;

2. else должен находиться на той же строке что и }.

&nbsp;

Старый код:
```Java
      }
        else {
            load(capacity);
            return bulletsToLoad - spaceleft;
        }
```

&nbsp;

Новый код:
```Java
      } else {
            load(capacity);
            return bulletsToLoad - spaceleft;
        }
```

&nbsp;

> 4) public class Pistol3 extends Weapon2.

&nbsp;

1. Отсутствуют фигурные скобки в нескольких условиях if.

&nbsp;

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

&nbsp;

```Java
       for (int i = 0; i < times; i++)
            shoot();
```

&nbsp;

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

```Java
       for (int i = 0; i < times; i++) {
            shoot();
        }
```

&nbsp;

> 5) public final class Name.

&nbsp;

1. Отсутствуют фигурные скобки в нескольких условиях if.

&nbsp;

Старый код:
```Java
       if (s == null)
            return null;
```

&nbsp;

```Java
       if (firstName == null && lastName == null && patronymic == null)
            throw new IllegalArgumentException("Хотя бы одно из ФИО должно быть написано");
```

&nbsp;

```Java
        if (lastName != null) sb.append(lastName).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (patronymic != null) sb.append(patronymic);
```

&nbsp;

Исправление:
```Java
       if (s == null) {
            return null;
        }
```

&nbsp;

```Java
       if (firstName == null && lastName == null && patronymic == null) {
            throw new IllegalArgumentException("Хотя бы одно из ФИО должно быть написано");
        }
```

&nbsp;

```Java
       if (lastName != null) {
            sb.append(lastName).append(" ");
        }
        if (firstName != null) {
            sb.append(firstName).append(" ");
        }
        if (patronymic != null) {
            sb.append(patronymic);
        }
```

&nbsp;

> 6) public class Shooter.

&nbsp;

1. Отсутствуют фигурные скобки в нескольких условиях if.

&nbsp;

Старый код:
```Java
       if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
```

&nbsp;

```Java
       if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
```

&nbsp;

Исправление:
```Java
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
```

&nbsp;

```Java
       if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
```

&nbsp;

2. else должен находиться на той же строке что и }.

&nbsp;

Старый код:
```Java
      }
        else
            System.out.println(name + ": не могу участвовать в перестрелке");
```

&nbsp;

Исправление:
```Java
      } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
```

&nbsp;

> 7) 
