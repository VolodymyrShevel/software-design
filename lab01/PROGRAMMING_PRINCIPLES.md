# Programming Principles

This document describes the programming principles applied in the **Online Library** project.

---

## 1. SOLID

### 1.1 Single Responsibility Principle (SRP)

Each class has exactly one reason to change.

- [`Book`](src/main/java/com/library/model/Book.java) — stores book data only; no persistence or business logic.
- [`LibraryService`](src/main/java/com/library/service/LibraryService.java) — handles borrow/return business logic only.
- [`Logger`](src/main/java/com/library/util/Logger.java) — handles console output only; completely isolated from business logic.
- [`BookController`](src/main/java/com/library/controller/BookController.java) and [`BorrowController`](src/main/java/com/library/controller/BorrowController.java) are split by responsibility: one manages book CRUD, the other manages borrowing operations.

### 1.2 Open/Closed Principle (OCP)

The [`Repository<T, ID>`](src/main/java/com/library/repository/Repository.java) interface allows adding new repository implementations (e.g., `DatabaseBookRepository`) without modifying existing code.

`LibraryService` depends on repository abstractions, so swapping the storage implementation requires zero changes to the service layer.

### 1.3 Liskov Substitution Principle (LSP)

[`BookRepository`](src/main/java/com/library/repository/BookRepository.java) and [`UserRepository`](src/main/java/com/library/repository/UserRepository.java) both implement `Repository<T, ID>` and can be substituted wherever that interface is expected without altering program behavior.

### 1.4 Interface Segregation Principle (ISP)

The [`Repository<T, ID>`](src/main/java/com/library/repository/Repository.java) interface exposes only the four fundamental operations (`save`, `findById`, `findAll`, `delete`). Specific query methods (`findByGenre`, `findAvailable`) live in the concrete `BookRepository` class, not in the shared interface, so implementors are never forced to implement methods they don't need.

### 1.5 Dependency Inversion Principle (DIP)

[`LibraryService`](src/main/java/com/library/service/LibraryService.java#L26-L34) receives all its dependencies via constructor injection:

```java
public LibraryService(BookRepository bookRepository,
                      UserRepository userRepository,
                      Logger logger) { ... }
```

High-level policy (service) depends on abstractions passed from outside, not on concrete constructions.

---

## 2. DRY (Don't Repeat Yourself)

The generic [`Repository<T, ID>`](src/main/java/com/library/repository/Repository.java) interface captures the common CRUD contract once. Both `BookRepository` and `UserRepository` share this contract without duplicating method signatures.

Validation logic for entities is centralised inside constructors ([`Book.java#L14-L17`](src/main/java/com/library/model/Book.java#L14-L17), [`User.java#L15-L17`](src/main/java/com/library/model/User.java#L15-L17)) so it is never repeated at call sites.

---

## 3. KISS (Keep It Simple, Stupid)

- In-memory `Map<String, T>` storage keeps the repository implementations straightforward and dependency-free.
- `Logger` is a plain class with three methods — no third-party logging framework overhead for a demo project.
- Controllers are thin delegators: [`BookController`](src/main/java/com/library/controller/BookController.java) is under 30 lines.

---

## 4. YAGNI (You Aren't Gonna Need It)

The project contains only features required by the current task:
- No pagination, no caching, no serialisation, no REST layer — these would be premature additions.
- `User` holds only `id`, `name`, `email`, and a list of borrowed ISBNs; no roles, permissions, or audit trail that are not yet needed.

---

## 5. Fail Fast

Constructors validate their arguments immediately and throw `IllegalArgumentException` before an object can enter an invalid state:

- [`Book.java#L14-L17`](src/main/java/com/library/model/Book.java#L14-L17) — rejects blank ISBN or title.
- [`User.java#L15-L17`](src/main/java/com/library/model/User.java#L15-L17) — rejects blank id or malformed email.

Business-rule violations in `LibraryService` throw `IllegalStateException` at the earliest possible point before any state mutation occurs ([`LibraryService.java#L49-L56`](src/main/java/com/library/service/LibraryService.java#L49-L56)).

---

## 6. Composition Over Inheritance

`LibraryService` is composed of a `BookRepository`, a `UserRepository`, and a `Logger` — all injected via the constructor. There is no inheritance hierarchy between service and repository, which keeps coupling low and makes unit-testing straightforward by substituting any dependency.

---

## 7. Encapsulation

- `Book` exposes `isAvailable()` as a boolean flag but keeps the internal `available` field private; callers cannot break invariants by directly flipping it.
- `User.getBorrowedIsbns()` returns an [`unmodifiableList`](src/main/java/com/library/model/User.java#L27) so callers cannot mutate the internal list:

```java
return Collections.unmodifiableList(borrowedIsbns);
```

Mutation is only allowed through the controlled `addBorrow` / `removeBorrow` methods.
