# Принципи програмування

У цьому документі описано принципи програмування, яких дотримано в проєкті **Online Library**.

---

## 1. SOLID

### 1.1 Принцип єдиної відповідальності (SRP)

Кожен клас має лише одну причину для змін.

- [`Book`](src/main/java/com/library/model/Book.java) — зберігає лише дані про книгу, жодної бізнес-логіки чи роботи з базою.
- [`LibraryService`](src/main/java/com/library/service/LibraryService.java) — відповідає виключно за логіку видачі та повернення книг.
- [`Logger`](src/main/java/com/library/util/Logger.java) — відповідає лише за виведення повідомлень у консоль, повністю ізольований від бізнес-логіки.
- [`BookController`](src/main/java/com/library/controller/BookController.java) і [`BorrowController`](src/main/java/com/library/controller/BorrowController.java) розділені за відповідальністю: перший керує книгами, другий — операціями видачі.

### 1.2 Принцип відкритості/закритості (OCP)

Інтерфейс [`Repository<T, ID>`](src/main/java/com/library/repository/Repository.java) дозволяє додавати нові реалізації сховища (наприклад, `DatabaseBookRepository`) без жодних змін в існуючому коді.

`LibraryService` залежить від абстракцій репозиторіїв, тому заміна реалізації сховища не вимагає змін у сервісному шарі.

### 1.3 Принцип підстановки Лісков (LSP)

[`BookRepository`](src/main/java/com/library/repository/BookRepository.java) і [`UserRepository`](src/main/java/com/library/repository/UserRepository.java) реалізують `Repository<T, ID>` і можуть бути підставлені скрізь, де очікується цей інтерфейс, без порушення поведінки програми.

### 1.4 Принцип розділення інтерфейсів (ISP)

Інтерфейс [`Repository<T, ID>`](src/main/java/com/library/repository/Repository.java) містить лише чотири базові операції (`save`, `findById`, `findAll`, `delete`). Специфічні методи (`findByGenre`, `findAvailable`) винесено в окремий [`BookRepositoryInterface`](src/main/java/com/library/repository/BookRepositoryInterface.java), щоб реалізатори не були змушені реалізовувати непотрібні їм методи.

### 1.5 Принцип інверсії залежностей (DIP)

[`LibraryService`](src/main/java/com/library/service/LibraryService.java#L26-L34) отримує всі залежності через конструктор:

```java
public LibraryService(BookRepositoryInterface bookRepository,
                      Repository<User, String> userRepository,
                      ILogger logger) { ... }
```

Клас вищого рівня (сервіс) залежить від абстракцій, а не від конкретних реалізацій.

---

## 2. DRY (Don't Repeat Yourself — не повторюй себе)

Узагальнений інтерфейс [`Repository<T, ID>`](src/main/java/com/library/repository/Repository.java) визначає спільний CRUD-контракт один раз. І `BookRepository`, і `UserRepository` використовують його без дублювання сигнатур методів.

Логіка валідації зосереджена в конструкторах сутностей ([`Book.java#L14-L17`](src/main/java/com/library/model/Book.java#L14-L17), [`User.java#L15-L17`](src/main/java/com/library/model/User.java#L15-L17)) і ніколи не повторюється на місцях виклику.

---

## 3. KISS (Keep It Simple, Stupid — роби простіше)

- Зберігання в пам'яті через `Map<String, T>` робить реалізації репозиторіїв простими і без зайвих залежностей.
- `Logger` — звичайний клас з трьома методами, без зайвих фреймворків для логування.
- Контролери є тонкими делегаторами: [`BookController`](src/main/java/com/library/controller/BookController.java) займає менше 30 рядків.

---

## 4. YAGNI (You Aren't Gonna Need It — тобі це не знадобиться)

Проєкт містить лише те, що потрібно для поточного завдання:
- Немає пагінації, кешування, серіалізації, REST-шару — це було б передчасним ускладненням.
- `User` містить лише `id`, `name`, `email` та список ISBN взятих книг — без ролей, прав доступу чи журналу аудиту, які ще не потрібні.

---

## 5. Fail Fast (падай швидко)

Конструктори перевіряють аргументи одразу і кидають `IllegalArgumentException` до того, як об'єкт може потрапити в некоректний стан:

- [`Book.java#L14-L17`](src/main/java/com/library/model/Book.java#L14-L17) — відхиляє порожній ISBN або назву.
- [`User.java#L15-L17`](src/main/java/com/library/model/User.java#L15-L17) — відхиляє порожній id або некоректний email.

Порушення бізнес-правил у `LibraryService` кидають `IllegalStateException` якомога раніше, до будь-якої зміни стану ([`LibraryService.java#L49-L56`](src/main/java/com/library/service/LibraryService.java#L49-L56)).

---

## 6. Композиція замість наслідування

`LibraryService` складається з `BookRepository`, `UserRepository` і `Logger` — всі передаються через конструктор. Між сервісом і репозиторіями немає ієрархії наслідування, що зменшує зв'язність і спрощує тестування через підміну залежностей.

---

## 7. Інкапсуляція

- `Book` надає `isAvailable()` як булевий прапор, але тримає внутрішнє поле `available` приватним — зовнішній код не може зламати інваріанти напряму.
- `User.getBorrowedIsbns()` повертає [`unmodifiableList`](src/main/java/com/library/model/User.java#L27), щоб зовнішній код не міг змінити внутрішній список напряму:

```java
return Collections.unmodifiableList(borrowedIsbns);
```

Зміна списку дозволена лише через контрольовані методи `addBorrow` / `removeBorrow`.