# Лабораторна робота №3
**Тема:** Структурні шаблони проєктування.  
**Мета:** Навчитися реалізовувати структурні шаблони: Адаптер, Декоратор, Міст, Компонувальник, Проксі, Легковаговик.

## Виконані завдання

### Завдання 1 — Адаптер (Adapter)
`FileLoggerAdapter` адаптує `FileWriter` під інтерфейс `Logger`. Повідомлення одночасно виводяться в консоль і записуються у файл.

### Завдання 2 — Декоратор (Decorator)
Герої RPG (`Warrior`, `Mage`, `Palladin`) декоруються інвентарем (`SwordDecorator`, `ArmorDecorator`, `RingOfPowerDecorator`). Декоратори можна комбінувати у довільній кількості.

### Завдання 3 — Міст (Bridge)
Фігури (`Circle`, `Square`, `Triangle`) відокремлені від способу рендерингу (`VectorRenderer`, `RasterRenderer`). Будь-яка фігура може рендеритись будь-яким рендерером.

### Завдання 4 — Проксі (Proxy)
- `SmartTextChecker` — проксі з логуванням: виводить інформацію про відкриття, читання і закриття файлу.
- `SmartTextReaderLocker` — проксі з обмеженням доступу за регулярним виразом.

### Завдання 5 — Компонувальник (Composite)
Власна мова розмітки `LightHTML`. `LightElementNode` може містити будь-які `LightNode`, `LightTextNode` — лише текст.

### Завдання 6 — Легковаговик (Flyweight)
`LightElementFactory` кешує екземпляри `LightElementNode` за ключем (тег + клас + тип). При розборі тексту книги повторно використовуються вже створені типи елементів.

## Результат виконання програми

### Task 01 — Adapter
```
![alt text](/lab03/image-1.png)
```

### Task 02 — Decorator
```
======================================
   TASK 02 - Decorator
======================================
Base: Warrior(Thor) ATK=15 DEF=10
+ Sword: Warrior(Thor) ATK=15 DEF=10 + Sword(ATK+10)
+ Armor: Warrior(Thor) ATK=15 DEF=10 + Sword(ATK+10) + Armor(DEF+15)
+ Ring:  Warrior(Thor) ATK=15 DEF=10 + Sword(ATK+10) + Armor(DEF+15) + RingOfPower(ATK+5 DEF+5)
Mage:    Mage(Gandalf) ATK=20 DEF=5 + Sword(ATK+10) + RingOfPower(ATK+5 DEF+5)
Palladin (2x Armor): Palladin(Arthur) ATK=12 DEF=15 + Armor(DEF+15) + Armor(DEF+15)
```

### Task 03 — Bridge
```
======================================
   TASK 03 - Bridge
======================================
Drawing Circle as vectors (radius=5.0)
Drawing Circle as pixels (radius=5.0)
Drawing Square as vectors (side=4.0)
Drawing Square as pixels (side=4.0)
Drawing Triangle as vectors (base=3.0 height=6.0)
Drawing Triangle as pixels (base=3.0 height=6.0)
```

### Task 04 — Proxy
```
======================================
   TASK 04 - Proxy
======================================
-- Logging Proxy --
[Proxy] Opening file: test.txt
[Proxy] File read successfully.
[Proxy] Closing file: test.txt
[Proxy] Lines: 3, Characters: 45
First line: Hello World

-- Access Control Proxy --
[Locker] Access denied! File matches restricted pattern: secret_data.txt
[Locker] Access denied! File matches restricted pattern: private_config.txt
```

### Task 05 — Composite
```
======================================
   TASK 05 - Composite (LightHTML)
======================================
innerHTML:
<tr><th>Name</th><th>Age</th><th>City</th></tr><tr><td>Alice</td><td>25</td><td>Kyiv</td></tr>
outerHTML:
<table class="data-table"><tr><th>Name</th><th>Age</th><th>City</th></tr><tr><td>Alice</td><td>25</td><td>Kyiv</td></tr></table>
```

### Task 06 — Flyweight
```
======================================
   TASK 06 - Flyweight
======================================
-- Without Flyweight --
Memory used (approx): 901 KB
Flyweight cache size (unique element types): 4
Total lines parsed: 10

First 300 chars of output:
<div class="book"><h1>Romeo and Juliet</h1><h2>ACT I</h2><p>Scene I. Verona. A public place.</p><blockquote>Two households, both alike in dignity,</blockquote><p>In fair Verona, where we lay our scene,</p><p>From ancient grudge break to new mutiny,</p><h2>ACT II</h2><p>Scene I. A lane by the wall of
```
