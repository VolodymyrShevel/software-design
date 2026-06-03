# Drafts for Task 02 (3 Issues)

---

## Issue 1: `LibraryService` безпосередньо залежить від конкретних класів репозиторіїв (порушення DIP)

**Title:** `Refactor: inject Repository interfaces into LibraryService instead of concrete classes`

**Body:**

`LibraryService` оголошує залежності від конкретних реалізацій `BookRepository` і `UserRepository` замість абстракції `Repository<T, ID>`. Це порушує **Dependency Inversion Principle**: клас вищого рівня (service) прив'язаний до класів нижчого рівня (repository-implementations).

Наслідки:
- неможливо підставити альтернативну реалізацію (наприклад, `DatabaseBookRepository`) без зміни сигнатури `LibraryService`;
- юніт-тест LibraryService потребує реального `BookRepository`, а не mock-інтерфейсу.

**Підтвердження в коді:**

Конструктор приймає конкретні типи замість інтерфейсів:
[`src/main/java/com/library/service/LibraryService.java#L26-L34`](src/main/java/com/library/service/LibraryService.java#L26-L34)

```java
public LibraryService(BookRepository bookRepository,   // ← конкретний клас
                      UserRepository userRepository,   // ← конкретний клас
                      Logger logger) {
```

**Очікуване покращення:**

Змінити тип параметрів конструктора на `Repository<Book, String>` та `Repository<User, String>` (або на виділені інтерфейси `BookRepository` / `UserRepository`, що розширюють `Repository`), щоб `LibraryService` залежав виключно від абстракцій.

---

## Issue 2: `Logger` є конкретним класом — неможливо підмінити у тестах (порушення DIP + запах "Tight Coupling")

**Title:** `Extract Logger interface to decouple LibraryService from console output`

**Body:**

`LibraryService` та контролери залежать від конкретного класу [`Logger`](src/main/java/com/library/util/Logger.java), який завжди пише у `System.out` / `System.err`. Це "запах" **Tight Coupling**:
- у тестах побічний вивід засмічує консоль;
- не можна замінити логер на файловий або no-op без зміни коду, що використовує логер;
- будь-яка зміна формату логування вимагає правки всіх класів, що тримають `Logger`.

**Підтвердження в коді:**

Поле в `LibraryService` оголошене як конкретний тип:
[`src/main/java/com/library/service/LibraryService.java#L20`](src/main/java/com/library/service/LibraryService.java#L20)

```java
private final Logger logger;   // ← прив'язка до конкретної реалізації
```

Прямі виклики `System.err` в `Logger`:
[`src/main/java/com/library/util/Logger.java#L16`](src/main/java/com/library/util/Logger.java#L16)

**Очікуване покращення:**

1. Виділити інтерфейс `ILogger` з методами `info`, `warn`, `error`.
2. `Logger` реалізує `ILogger`.
3. `LibraryService` та контролери залежать від `ILogger`.
4. У тестах передавати `NoOpLogger implements ILogger`.

---

## Issue 3: Відсутня перевірка дублікатів при збереженні в `BookRepository.save()` (Code Smell: Silent Duplicate Overwrite)

**Title:** `Bug/Smell: BookRepository.save() silently overwrites existing books — add duplicate check`

**Body:**

Метод `save()` у [`BookRepository`](src/main/java/com/library/repository/BookRepository.java) беззастережно кладе книгу в `Map`, перезаписуючи будь-який існуючий запис з тим самим ISBN. Це "тихе" перезаписування є Code Smell категорії **"Inappropriate Intimacy / Missing Guard Clause"** і може призвести до непомітної втрати даних:

- якщо `addBook` викликається двічі з тим самим ISBN, другий виклик замінює першу книгу без жодного повідомлення;
- в `LibraryService.addBook` немає жодної перевірки на існування — вона покладається на коректність клієнтського коду.

**Підтвердження в коді:**

Безумовний `put` без перевірки:
[`src/main/java/com/library/repository/BookRepository.java#L15-L18`](src/main/java/com/library/repository/BookRepository.java#L15-L18)

```java
@Override
public void save(Book book) {
    Objects.requireNonNull(book, "Book must not be null");
    store.put(book.getIsbn(), book);  // ← завжди перезаписує
}
```

Відсутня перевірка на рівні сервісу:
[`src/main/java/com/library/service/LibraryService.java#L38-L41`](src/main/java/com/library/service/LibraryService.java#L38-L41)

**Очікуване покращення:**

Додати до `BookRepository.save()` перевірку:
```java
if (store.containsKey(book.getIsbn())) {
    throw new IllegalArgumentException("Book with ISBN " + book.getIsbn() + " already exists");
}
```
Або виділити окремий метод `update(Book book)` для явного оновлення.
