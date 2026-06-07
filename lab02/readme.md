# Лабораторна робота №2
## Виконані завдання

### Завдання 1 — Фабричний метод (Factory Method)
Система підписок відео-провайдера. Три типи підписок (`DomesticSubscription`, `EducationalSubscription`, `PremiumSubscription`) створюються через три канали (`WebSite`, `MobileApp`, `ManagerCall`).  
Діаграма: [task01/diagram1.drawio.png](lab02/src/main/java/com/patterns/task01/diagram1.drawio.png)

### Завдання 2 — Абстрактна фабрика (Abstract Factory)
Фабрика виробництва техніки. Три бренди (`IProne`, `Kiaomi`, `Balaxy`) створюють чотири типи девайсів (`Laptop`, `Netbook`, `EBook`, `Smartphone`).  
Діаграма: [task02/diagram2.drawio.png](lab02/src/main/java/com/patterns/task02/diagram2.drawio.png)

### Завдання 3 — Одинак (Singleton)
Клас `Authenticator` реалізований через double-checked locking. Гарантує єдиний екземпляр у багатопотоковому середовищі.

### Завдання 4 — Прототип (Prototype)
Клас `Virus` з підтримкою глибокого клонування. Клонування батьківського вірусу рекурсивно клонує всіх дітей.

### Завдання 5 — Будівельник (Builder)
`HeroBuilder` і `EnemyBuilder` реалізують `CharacterBuilderInterface` з текучим інтерфейсом. `CharacterDirector` керує побудовою персонажів.  
Діаграма: [task05/diagram5.drawio.png](lab02/src/main/java/com/patterns/task05/diagram5.drawio.png)

## Результат виконання програми

### Task 01 — Factory Method
```
======================================
   TASK 01 - Factory Method
======================================
>> WebSite offers:
[WebSite] Creating Domestic subscription via website...
=== DomesticSubscription ===
  Monthly fee  : 99,00 UAH
  Min period   : 1 months
  Features     : [UA:Pershyi, UA:Kultura, UA:Sport, SD quality]
[WebSite] Creating Educational subscription via website...
=== EducationalSubscription ===
  Monthly fee  : 149,00 UAH
  Min period   : 3 months
  Features     : [Discovery, National Geographic, TED Talks, HD quality, No ads]
[WebSite] Creating Premium subscription via website (5% web discount applied)...
=== PremiumSubscription ===
  Monthly fee  : 299,00 UAH
  Min period   : 6 months
  Features     : [All channels, 4K quality, No ads, 4 devices simultaneously, Offline viewing]
>> MobileApp offers:
[MobileApp] Creating Domestic subscription via app...
=== DomesticSubscription ===
  Monthly fee  : 99,00 UAH
  Min period   : 1 months
  Features     : [UA:Pershyi, UA:Kultura, UA:Sport, SD quality]
[MobileApp] Creating Educational subscription via app...
=== EducationalSubscription ===
  Monthly fee  : 149,00 UAH
  Min period   : 3 months
  Features     : [Discovery, National Geographic, TED Talks, HD quality, No ads]
[MobileApp] Creating Premium subscription via app (push notification sent)...
=== PremiumSubscription ===
  Monthly fee  : 299,00 UAH
  Min period   : 6 months
  Features     : [All channels, 4K quality, No ads, 4 devices simultaneously, Offline viewing]
>> ManagerCall offers:
[ManagerCall] Manager creating Domestic subscription by phone...
=== DomesticSubscription ===
  Monthly fee  : 99,00 UAH
  Min period   : 1 months
  Features     : [UA:Pershyi, UA:Kultura, UA:Sport, SD quality]
[ManagerCall] Manager creating Educational subscription by phone...
=== EducationalSubscription ===
  Monthly fee  : 149,00 UAH
  Min period   : 3 months
  Features     : [Discovery, National Geographic, TED Talks, HD quality, No ads]
[ManagerCall] Manager creating Premium subscription by phone (VIP service)...
=== PremiumSubscription ===
  Monthly fee  : 299,00 UAH
  Min period   : 6 months
  Features     : [All channels, 4K quality, No ads, 4 devices simultaneously, Offline viewing]
```

### Task 02 — Abstract Factory
```
======================================
   TASK 02 - Abstract Factory
======================================
=== IProneFactory ===
  [IProne Laptop] IProne Laptop - flagship model 2024
  [IProne Netbook] IProne Netbook - flagship model 2024
  [IProne EBook] IProne EBook - flagship model 2024
  [IProne Smartphone] IProne Smartphone - flagship model 2024
=== KiaomiFactory ===
  [Kiaomi Laptop] Kiaomi Laptop - flagship model 2024
  [Kiaomi Netbook] Kiaomi Netbook - flagship model 2024
  [Kiaomi EBook] Kiaomi EBook - flagship model 2024
  [Kiaomi Smartphone] Kiaomi Smartphone - flagship model 2024
=== BalaxyFactory ===
  [Balaxy Laptop] Balaxy Laptop - flagship model 2024
  [Balaxy Netbook] Balaxy Netbook - flagship model 2024
  [Balaxy EBook] Balaxy EBook - flagship model 2024
  [Balaxy Smartphone] Balaxy Smartphone - flagship model 2024
```

### Task 03 — Singleton
```
======================================
   TASK 03 - Singleton
======================================
auth1 == auth2: true
[Authenticator] Invalid username or password.
[Authenticator] User 'admin' logged in.
Current user: admin
[Authenticator] User 'admin' logged out.
```

### Task 04 — Prototype
```
======================================
   TASK 04 - Prototype
======================================
--- Original ---
[Alpha] species=CoronaX, weight=0,0010, age=100
  [Beta] species=CoronaX, weight=0,0008, age=50
    [Delta] species=CoronaX, weight=0,0005, age=20
    [Epsilon] species=CoronaX, weight=0,0006, age=25
  [Gamma] species=CoronaX, weight=0,0009, age=60
    [Zeta] species=CoronaX, weight=0,0004, age=15
--- Clone (changes do not affect original) ---
[Alpha-CLONE] species=CoronaX, weight=0,0010, age=100
    [Delta] species=CoronaX, weight=0,0005, age=20
    [Epsilon] species=CoronaX, weight=0,0006, age=25
  [Gamma] species=CoronaX, weight=0,0009, age=60
    [Zeta] species=CoronaX, weight=0,0004, age=15
--- Original after cloning ---
[Alpha] species=CoronaX, weight=0,0010, age=100
  [Beta] species=CoronaX, weight=0,0008, age=50
    [Delta] species=CoronaX, weight=0,0005, age=20
    [Epsilon] species=CoronaX, weight=0,0006, age=25
  [Gamma] species=CoronaX, weight=0,0009, age=60
```

### Task 05 — Builder
```
======================================
   TASK 05 - Builder
======================================
=== Character: Artem the Bright [hero] ===
  Height    : 185 cm
  Build     : athletic
  Hair      : blond
  Eyes      : blue
  Outfit    : shining paladin armor
  Inventory : [Sword of Light, Shield of Truth, Healing potion x5]
  Deeds     : [[GOOD] Saved the city from a dragon, [GOOD] Helped villagers rebuild their homes, [GOOD] Defeated the dark wizard]

=== Character: Shadow the Dark [enemy] ===
  Height    : 200 cm
  Build     : massive
  Hair      : black
  Eyes      : red
  Outfit    : dark spiked armor
  Inventory : [Cursed sword, Amulet of darkness, Poison x10]
  Deeds     : [[EVIL] Destroyed three cities, [EVIL] Stole the artifact of Light, [EVIL] Commanded an army of undead]
```