# Лабораторна робота №1
## Проєкт
Online Library — система управління бібліотекою.

## Виконані завдання

### Завдання 1 — Принципи програмування
Описано у файлі [PROGRAMMING_PRINCIPLES.md](lab01/PROGRAMMING_PRINCIPLES.md).  
Принципи: SOLID, DRY, KISS, YAGNI, Fail Fast, Composition over Inheritance, Encapsulation.

### Завдання 2 — Issues
Створено 3 issues з описом запахів коду:
- **#1** — `LibraryService` залежить від конкретних класів репозиторіїв (DIP)
- **#2** — `Logger` є конкретним класом без інтерфейсу (Tight Coupling)
- **#3** — `BookRepository.save()` мовчки перезаписує дублікати

### Завдання 3 — Pull Requests
Кожен issue вирішено окремим pull request із позначкою `Closes #N`.

## Результат виконання програми

```
PS C:\...\software-design\lab01> java -cp out com.library.Main 
[INFO]  Book added: 978-0-13-110362-7
[INFO]  Book added: 978-0-201-63361-0
[INFO]  Book added: 978-0-13-468599-1
[INFO]  Book added: 978-0-7432-7356-5
[INFO]  User registered: u1
[INFO]  User registered: u2

=== Available books ===
Book{isbn='978-0-13-110362-7', title='The C Programming Language', author='Kernighan & Ritchie', genre='Programming', year=1978, available=true}
Book{isbn='978-0-201-63361-0', title='Design Patterns', author='GoF', genre='Programming', year=1994, available=true}
Book{isbn='978-0-13-468599-1', title='Clean Code', author='Robert C. Martin', genre='Programming', year=2008, available=true}
Book{isbn='978-0-7432-7356-5', title='1984', author='George Orwell', genre='Fiction', year=1949, available=true}

=== Borrow: Alice takes 'Clean Code' ===
[INFO]  User 'u1' borrowed book '978-0-13-468599-1'

=== Available books after borrow ===
Book{isbn='978-0-13-110362-7', title='The C Programming Language', author='Kernighan & Ritchie', genre='Programming', year=1978, available=true}
Book{isbn='978-0-201-63361-0', title='Design Patterns', author='GoF', genre='Programming', year=1994, available=true}
Book{isbn='978-0-7432-7356-5', title='1984', author='George Orwell', genre='Fiction', year=1949, available=true}

=== Return: Alice returns 'Clean Code' ===
[INFO]  User 'u1' returned book '978-0-13-468599-1'

=== Programming books ===
Book{isbn='978-0-13-110362-7', title='The C Programming Language', author='Kernighan & Ritchie', genre='Programming', year=1978, available=true}
Book{isbn='978-0-201-63361-0', title='Design Patterns', author='GoF', genre='Programming', year=1994, available=true}
Book{isbn='978-0-13-468599-1', title='Clean Code', author='Robert C. Martin', genre='Programming', year=2008, available=true}

=== Error handling demo ===
[INFO]  User 'u1' borrowed book '978-0-13-468599-1'
[WARN]  Expected error: Book is not available: 978-0-13-468599-1
```