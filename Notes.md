# Java Basics — 20-Minute Study Guide

---

## 1. Variables

A variable is a named container for a value. In Java, every variable must have a declared type.

```java
int age = 25;          // declare + initialize
String name;            // declare only
name = "Alice";         // assign later
final double PI = 3.14; // 'final' = constant, cannot change
``` 

**Rules of thumb:**
- Names are case-sensitive, start with a letter/`_`/`$`, use `camelCase`.
- `final` variables can only be assigned once.

---

## 2. Data Types

Java has **primitive** types (stored directly, fast) and **reference** typesS (objects, like `String`).

| Type      | Size    | Example              |
|-----------|---------|----------------------|
| `byte`    | 1 byte  | `byte b = 10;`       |
| `short`   | 2 bytes | `short s = 300;`     |
| `int`     | 4 bytes | `int x = 100;`       |
| `long`    | 8 bytes | `long l = 100000L;`  |
| `float`   | 4 bytes | `float f = 3.14f;`   |
| `double`  | 8 bytes | `double d = 3.14159;`|
| `char`    | 2 bytes | `char c = 'A';`      |
| `boolean` | 1 bit   | `boolean flag = true;`|

Reference types: `String`, arrays, and any class (e.g., `Scanner`).

```java
int wholeNumber = 42;
double price = 19.99;
char grade = 'B';
boolean isJavaFun = true;
String message = "Hello, Java!";
```

---

## 3. Operators

**Arithmetic:** `+  -  *  /  %`
```java
int sum = 5 + 3;      // 8
int mod = 10 % 3;     // 1 (remainder)
```

**Relational (comparison):** `==  !=  >  <  >=  <=` → return `boolean`

**Logical:** `&&` (AND), `||` (OR), `!` (NOT)
```java
if (age > 18 && hasID) { ... }
```

**Assignment:** `=  +=  -=  *=  /=  %=`
```java
int x = 10;
x += 5;   // x = 15
```

**Increment/Decrement:** `++  --`
```java
int i = 0;
i++;   // post-increment
++i;   // pre-increment
```

---

## 4. Input Using `Scanner`

`Scanner` reads user input from the console. Must import it.

```java
import java.util.Scanner;

public class InputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Hello " + name + ", age " + age);
        sc.close();
    }
}
```

Common methods: `nextInt()`, `nextDouble()`, `nextLine()`, `next()` (single word), `nextBoolean()`.

⚠️ **Gotcha:** calling `nextInt()` then `nextLine()` right after can grab a leftover newline — add an extra `sc.nextLine()` to consume it if needed.

---

## 5. if-else

```java
int score = 75;

if (score >= 90) {
    System.out.println("A");
} else if (score >= 75) {
    System.out.println("B");
} else {
    System.out.println("C");
}
```

- Curly braces `{}` group statements.
- Conditions must evaluate to `boolean`.

---

## 6. switch

Good alternative to long `if-else` chains when checking one variable against fixed values.

```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

Modern Java also supports the arrow form (Java 14+):
```java
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Invalid day");
}
```

---

## 7. Loops

### `for` — when you know how many times to repeat
```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

### `while` — repeat while a condition is true (checked before running)
```java
int count = 0;
while (count < 5) {
    System.out.println(count);
    count++;
}
```

### `do-while` — runs at least once (condition checked after)
```java
int n = 0;
do {
    System.out.println(n);
    n++;
} while (n < 5);
```

---

## 8. `break` and `continue`

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;      // exits the loop entirely
    if (i % 2 == 0) continue; // skips to next iteration
    System.out.println(i);
}
```

- `break` → stop the loop immediately.
- `continue` → skip the rest of this iteration, go to the next one.

---

## Quick Recap Table

| Concept   | Keyword/Syntax                  | Purpose                          |
|-----------|----------------------------------|-----------------------------------|
| Variable  | `type name = value;`             | Store data                        |
| Data type | `int, double, char, boolean...`  | Define kind of data               |
| Operator  | `+ - * / % == && ||`            | Compute/compare values             |
| Input     | `Scanner sc = new Scanner(System.in);` | Read from console            |
| Decision  | `if / else if / else`            | Branch logic                      |
| Decision  | `switch / case / default`        | Multi-way branch on one value     |
| Loop      | `for`                             | Fixed number of repetitions       |
| Loop      | `while`                           | Repeat while condition holds      |
| Loop      | `do-while`                        | Repeat at least once              |
| Control   | `break` / `continue`             | Exit loop / skip iteration        |

---

**Practice idea:** Write a program that uses `Scanner` to read a number, then uses `if-else` to check if it's even/odd, and a `for` loop to print its multiplication table (1–10), using `break` to stop early if the user enters 0.

---
---

# OOP Concepts — 45-Minute Study Guide

Learn in this order.

---

## 1. Class

A class is a blueprint for creating objects — it defines fields (data) and methods (behavior).

```java
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Driving at " + speed + " km/h");
    }
}
```

---

## 2. Object

An object is an actual instance of a class, created with `new`.

```java
Car myCar = new Car();
myCar.color = "Red";
myCar.speed = 120;
myCar.drive();  // Driving at 120 km/h
```

---

## 3. Constructor

A special method that runs when an object is created, usually to initialize fields. Same name as the class, no return type.

```java
class Car {
    String color;
    int speed;

    // Constructor
    Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }
}

Car myCar = new Car("Blue", 100);
```

- If you don't write one, Java provides a free **default (no-arg) constructor**.
- You can have multiple constructors (constructor overloading).

---

## 4. `this` Keyword

Refers to the **current object**. Mainly used to:

**Distinguish fields from parameters with the same name:**
```java
Car(String color, int speed) {
    this.color = color;  // this.color = field, color = parameter
    this.speed = speed;
}
```

**Call another constructor in the same class:**
```java
Car() {
    this("White", 0);  // calls the two-arg constructor
}
```

---

## 5. `super` Keyword

Refers to the **parent class**. Used to:

**Call the parent's constructor:**
```java
class Vehicle {
    Vehicle(String type) {
        System.out.println("Vehicle type: " + type);
    }
}

class Car extends Vehicle {
    Car() {
        super("Car");  // must be the first line
    }
}
```

**Call a parent's overridden method:**
```java
@Override
void drive() {
    super.drive();  // run parent's version too
    System.out.println("Car-specific driving logic");
}
```

---

## 6. Inheritance

One class (subclass/child) acquires the fields and methods of another (superclass/parent), using `extends`.

```java
class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Woof!");
    }
}

Dog d = new Dog();
d.eat();   // inherited from Animal
d.bark();  // defined in Dog
```

Java supports **single inheritance** for classes (one direct parent only) — multiple inheritance is achieved via interfaces.

---

## 7. Method Overloading

Same method name, **different parameter lists**, in the **same class**. Decided at **compile time**.

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

---

## 8. Method Overriding

A subclass provides a **new implementation** of a method already defined in its parent, with the **same signature**. Decided at **runtime**.

```java
class Animal {
    void sound() {
        System.out.println("Some generic sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
```

`@Override` isn't required but is best practice — it lets the compiler catch mistakes.

---

## 9. Polymorphism

"Many forms" — the ability of an object to behave differently depending on context.

**Compile-time polymorphism** = method overloading (resolved by the compiler based on arguments).

**Runtime polymorphism** = method overriding, accessed via a parent reference:
```java
Animal a = new Cat();   // parent type reference, child object
a.sound();              // prints "Meow" — decided at runtime
```

---

## 10. Encapsulation

Bundling data (fields) and methods together, while **hiding internal details** using access modifiers (`private`), exposing controlled access via getters/setters.

```java
class BankAccount {
    private double balance;   // hidden from outside

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
}
```

Benefit: you control *how* data is read/modified — e.g., preventing negative deposits.

---

## 11. Abstraction

Hiding **implementation details** and showing only **essential features**. Achieved via **abstract classes** or **interfaces**.

```java
abstract class Shape {
    abstract double area();  // no body — subclasses must implement

    void describe() {
        System.out.println("This shape's area is " + area());
    }
}

class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
```

---

## 12. Interface

A fully abstract contract — a set of method signatures that implementing classes **must** provide. Supports multiple inheritance of type.

```java
interface Drivable {
    void drive();          // implicitly public & abstract
    default void honk() {  // default method, has a body
        System.out.println("Beep!");
    }
}

class Car implements Drivable {
    @Override
    public void drive() {
        System.out.println("Car is driving");
    }
}
```

- A class can `implements` **multiple** interfaces.
- Fields in interfaces are implicitly `public static final` (constants).

---

## 13. Abstract Class

A class that **cannot be instantiated** directly and can mix abstract methods (no body) with concrete methods (with body).

```java
abstract class Employee {
    String name;

    Employee(String name) { this.name = name; }

    abstract double calculateSalary();  // must be implemented by subclass

    void showName() {                   // concrete, shared method
        System.out.println("Name: " + name);
    }
}

class Manager extends Employee {
    Manager(String name) { super(name); }

    @Override
    double calculateSalary() {
        return 80000;
    }
}
```

---

## Key Questions to Be Able to Answer

### What is OOP?
Object-Oriented Programming is a paradigm that organizes code around **objects** (data + behavior) rather than functions and logic alone. It's built on four pillars: **Encapsulation, Abstraction, Inheritance, and Polymorphism.**

### Why use inheritance?
- **Code reuse** — avoid rewriting shared logic in every class.
- **Logical hierarchy** — models real-world "is-a" relationships (a `Dog` *is an* `Animal`).
- **Extensibility** — add new subclasses without touching existing parent code.
- Enables **runtime polymorphism** through overriding.

### Difference between Interface and Abstract Class

| Aspect | Interface | Abstract Class |
|---|---|---|
| Methods | All abstract by default (can have `default`/`static` methods too) | Can mix abstract and concrete methods |
| Fields | Only `public static final` constants | Any type of field (instance variables allowed) |
| Constructor | Cannot have one | Can have one (called via `super()`) |
| Inheritance | A class can implement **multiple** interfaces | A class can extend only **one** abstract class |
| Use case | Define a **capability/contract** (e.g., `Comparable`, `Runnable`) | Define a **common base** with shared state/behavior |

### Compile-Time vs Runtime Polymorphism

| | Compile-Time (Overloading) | Runtime (Overriding) |
|---|---|---|
| Also called | Static polymorphism | Dynamic polymorphism |
| Resolved by | Compiler, based on method signature/arguments | JVM, based on actual object type at runtime |
| Relationship | Same class, multiple methods, same name | Parent-child classes, same method signature |
| Example | `add(int, int)` vs `add(double, double)` | `Animal a = new Cat(); a.sound();` |

---

**Practice idea:** Model a small `Shape` hierarchy: an abstract class `Shape` with an abstract `area()` method and a concrete `describe()` method; subclasses `Circle`, `Rectangle`, and `Triangle` that override `area()`. Then create a `Drawable` interface with a `draw()` method, and have each shape implement it. Store all shapes in an `Shape[]` array and loop through calling `describe()` and `draw()` — that's polymorphism in action.

---
---

# Strings — 30-Minute Study Guide (Interview Prep)

---

## 1. String Pool

The **String Pool** (aka String Constant Pool) is a special memory region inside the JVM's heap where Java stores **string literals** so identical values can be reused instead of duplicated.

```java
String s1 = "hello";
String s2 = "hello";
```

Here, `s1` and `s2` point to the **same object** in the pool — Java doesn't create a second `"hello"`. This saves memory since strings are heavily reused in real programs.

```java
String s3 = new String("hello");  // forces a NEW object on the heap, NOT the pool
```

`s3` is a different object even though the content is the same. You can force a heap string back into the pool using `.intern()`:
```java
String s4 = s3.intern();  // now s4 refers to the pooled "hello"
```

**Interview point:** String pool exists because strings are immutable — it's only safe to share references because the value can never change underneath you.

---

## 2. Immutable String

Once a `String` object is created, its **value can never be changed**. Any "modification" method actually returns a **new** String object.

```java
String s = "Java";
s.concat(" Rocks");
System.out.println(s);  // still "Java" — original unchanged!

s = s.concat(" Rocks");  // must reassign
System.out.println(s);  // "Java Rocks"
```

**Why are Strings immutable? (common interview question)**
1. **String pool safety** — if strings were mutable, changing one variable's string could unexpectedly change every other variable sharing that pooled object.
2. **Security** — strings are used for things like file paths, network connections, class names; immutability prevents them from being altered after validation.
3. **Thread safety** — immutable objects are automatically safe to share across threads, no synchronization needed.
4. **Hashcode caching** — since the value never changes, `String` caches its hashcode once, making it fast to use as a `HashMap` key.

---

## 3. `==` vs `equals()`

This is one of the **most-asked** Java interview questions.

- `==` compares **references** (memory addresses) — "are these the exact same object?"
- `.equals()` compares **actual content/value** — "do these hold the same characters?"

```java
String a = "hello";
String b = "hello";
String c = new String("hello");

System.out.println(a == b);        // true  — both from pool, same object
System.out.println(a == c);        // false — c is a separate heap object
System.out.println(a.equals(c));   // true  — same content
```

| Comparison | `==` | `.equals()` |
|---|---|---|
| What it checks | Reference/memory address | Actual character content |
| `"a" == "a"` (literals) | `true` (pool) | `true` |
| `new String("a") == "a"` | `false` | `true` |
| Safe for value comparison? | ❌ No | ✅ Yes |

**Rule of thumb for interviews:** Always use `.equals()` (or `.equalsIgnoreCase()`) to compare string *values*. Only use `==` if you specifically want to check object identity.

---

## 4. String Methods

```java
String str = "  Hello, World!  ";
```

### `length()`
Returns number of characters.
```java
str.length();   // 17 (includes the spaces)
```

### `charAt(int index)`
Returns the character at a given index (0-based).
```java
"Hello".charAt(1);   // 'e'
```

### `substring(int begin)` / `substring(int begin, int end)`
Extracts part of a string. `end` is exclusive.
```java
"Hello World".substring(6);       // "World"
"Hello World".substring(0, 5);    // "Hello"
```

### `contains(CharSequence s)`
Checks if a substring exists.
```java
"Hello World".contains("World");  // true
```

### `replace(CharSequence old, CharSequence new)`
Replaces **all** occurrences.
```java
"Hello World".replace("o", "0");  // "Hell0 W0rld"
```

### `split(String regex)`
Splits into an array based on a delimiter (regex).
```java
String csv = "apple,banana,cherry";
String[] fruits = csv.split(",");
// ["apple", "banana", "cherry"]
```

### `trim()`
Removes leading/trailing whitespace (not internal).
```java
"  Hello  ".trim();   // "Hello"
```
*(Interview note: `strip()`, added in Java 11, is Unicode-aware and preferred over `trim()` in modern code.)*

### `indexOf(String str)`
Returns the index of first occurrence, or `-1` if not found.
```java
"Hello World".indexOf("World");   // 6
"Hello World".indexOf("xyz");     // -1
```

### `equals(Object obj)`
Compares content, case-sensitive.
```java
"Hello".equals("hello");   // false
"Hello".equalsIgnoreCase("hello");  // true
```

### `compareTo(String other)`
Lexicographically compares two strings; returns:
- `0` if equal
- negative number if the calling string comes **before** the other
- positive number if it comes **after**

```java
"apple".compareTo("banana");  // negative (a < b)
"banana".compareTo("apple");  // positive
"apple".compareTo("apple");   // 0
```
Useful for sorting strings alphabetically.

---

## 5. StringBuilder

A **mutable** sequence of characters — use it when you need to build/modify strings frequently (e.g., in a loop), since it avoids creating many throwaway String objects.

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ").append("World");
sb.insert(5, ",");
sb.reverse();

System.out.println(sb.toString());
```

Key methods: `append()`, `insert()`, `delete()`, `reverse()`, `replace()`, `toString()`.

**Not thread-safe** — no internal synchronization, so it's faster in single-threaded contexts.

---

## 6. StringBuffer

Functionally almost identical to `StringBuilder` (same methods), but its methods are **synchronized**, making it **thread-safe**.

```java
StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World");
```

---

## Quick Comparison: String vs StringBuilder vs StringBuffer

| | `String` | `StringBuilder` | `StringBuffer` |
|---|---|---|---|
| Mutable? | ❌ No | ✅ Yes | ✅ Yes |
| Thread-safe? | ✅ Yes (immutable, inherently safe) | ❌ No | ✅ Yes (synchronized) |
| Performance | Slow for repeated modification (creates new objects) | Fast | Slower than `StringBuilder` (sync overhead) |
| Use case | Fixed/rarely-changed text | Single-threaded string building (e.g., loops) | Multi-threaded string building |
| Introduced | Java 1.0 | Java 1.5 | Java 1.0 |

**Common interview one-liner:** *"Use `String` for constants, `StringBuilder` for heavy single-threaded concatenation, and `StringBuffer` only when thread safety is required."*

---

## Frequently Asked Interview Questions on Strings

**Q: Why is String immutable in Java?**
A: For security, thread-safety, string pool caching/reuse, and safe hashcode caching for use in hash-based collections.

**Q: What happens when you concatenate strings in a loop using `+`?**
A: Each `+` creates a new `String` object under the hood (via a hidden `StringBuilder`), which is inefficient for many iterations — use an explicit `StringBuilder` instead.
```java
// Inefficient:
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;   // creates a new String object each time
}

// Efficient:
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String result = sb.toString();
```

**Q: How many objects are created by `String s = new String("hello");`?**
A: Up to **two** — one in the string pool (if `"hello"` doesn't already exist there) and one on the heap for the `new String(...)` object.

**Q: Difference between `String.equals()` and `String.compareTo()`?**
A: `equals()` returns a `boolean` (equal or not); `compareTo()` returns an `int` indicating lexicographic ordering, useful for sorting.

---

**Practice idea:** Write a method that checks if a string is a palindrome (ignoring case and spaces) using `charAt()` and a loop, then rewrite it using `StringBuilder.reverse()` and compare the two approaches. Also write a small demo proving `==` vs `.equals()` behavior with pooled vs `new` strings.

---
---

# Arrays — 20-Minute Practice Guide (Interview Prep)

An array is a **fixed-size**, ordered collection of elements of the **same type**, stored in contiguous memory. Indexing starts at `0`.

```java
int[] arr = {5, 2, 9, 1, 7};
int n = arr.length;   // note: length is a FIELD, not a method (no parentheses)
```

Below are the classic interview practice problems, each with a clean solution and complexity notes.

---

## 1. Maximum Element

**Approach:** Track the largest value seen so far while scanning once.

```java
int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
```
**Time:** O(n) | **Space:** O(1)

---

## 2. Minimum Element

Same idea as max, just flip the comparison.

```java
int findMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    return min;
}
```
**Time:** O(n) | **Space:** O(1)

**Interview tip:** You can find both min and max in a single pass instead of two separate loops — good follow-up optimization to mention.

---

## 3. Reverse an Array

**Two-pointer swap approach** — reverse in place without extra array.

```java
void reverseArray(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```
**Time:** O(n) | **Space:** O(1) — in-place, no new array needed.

---

## 4. Sum of Elements

```java
int sumArray(int[] arr) {
    int sum = 0;
    for (int num : arr) {   // enhanced for-loop
        sum += num;
    }
    return sum;
}
```
**Time:** O(n) | **Space:** O(1)

⚠️ **Interview gotcha:** watch for integer overflow with `int` sum on very large arrays — mention using `long` if values could be huge.

---

## 5. Average of Elements

```java
double average(int[] arr) {
    int sum = sumArray(arr);
    return (double) sum / arr.length;   // cast to double BEFORE dividing
}
```

**Common mistake:** `sum / arr.length` without casting performs **integer division**, truncating any decimal — always cast at least one operand to `double`.

---

## 6. Frequency of Elements

Count how many times each value appears. `HashMap<Integer, Integer>` is the standard tool.

```java
import java.util.HashMap;
import java.util.Map;

Map<Integer, Integer> frequency(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : arr) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    return freqMap;
}
```
**Time:** O(n) | **Space:** O(n)

```java
// Example usage:
int[] arr = {1, 2, 2, 3, 3, 3};
Map<Integer, Integer> freq = frequency(arr);
// {1=1, 2=2, 3=3}
```

**Interview tip:** `getOrDefault(key, 0)` avoids a `null` check compared to manually checking `containsKey()` first.

---

## 7. Linear Search

Check each element one by one until a match is found. Works on **unsorted** arrays.

```java
int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;   // found — return index
        }
    }
    return -1;   // not found
}
```
**Time:** O(n) | **Space:** O(1)
**When to use:** Small arrays, unsorted data, or when simplicity matters more than speed.

---

## 8. Binary Search

Requires a **sorted** array. Repeatedly halves the search space by comparing the target to the middle element.

```java
int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;   // avoids overflow vs (low+high)/2

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            low = mid + 1;    // search right half
        } else {
            high = mid - 1;   // search left half
        }
    }
    return -1;   // not found
}
```
**Time:** O(log n) | **Space:** O(1)

**Recursive version** (common follow-up interview question):
```java
int binarySearchRecursive(int[] arr, int target, int low, int high) {
    if (low > high) return -1;

    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, high);
    else return binarySearchRecursive(arr, target, low, mid - 1);
}
```
**Time:** O(log n) | **Space:** O(log n) (recursion call stack)

---

## Quick Comparison: Linear vs Binary Search

| | Linear Search | Binary Search |
|---|---|---|
| Array must be sorted? | ❌ No | ✅ Yes |
| Time complexity | O(n) | O(log n) |
| Space complexity | O(1) | O(1) iterative / O(log n) recursive |
| Best for | Small or unsorted data | Large sorted datasets |

---

## Cheat Sheet: Complexity of All 8 Problems

| Problem | Time | Space |
|---|---|---|
| Maximum element | O(n) | O(1) |
| Minimum element | O(n) | O(1) |
| Reverse array | O(n) | O(1) |
| Sum | O(n) | O(1) |
| Average | O(n) | O(1) |
| Frequency count | O(n) | O(n) |
| Linear search | O(n) | O(1) |
| Binary search | O(log n) | O(1) / O(log n) |

---

**Practice idea:** Combine everything — write a program that takes an array via `Scanner`, then prints its max, min, sum, average, and frequency map, and lets the user search for a value using either linear or binary search (sorting the array first if binary search is chosen). This ties together arrays, loops, `Scanner`, and conditionals from earlier sections into one program — great as a mock interview warm-up.

---
---

# Exception Handling — 20-Minute Study Guide (Interview Prep)

An **exception** is an event that disrupts the normal flow of a program (e.g., dividing by zero, accessing an invalid array index, a file not found). Java handles these using a structured mechanism instead of letting the program crash silently.

---

## 1. `try`

Wraps code that **might** throw an exception.

```java
try {
    int result = 10 / 0;   // will throw ArithmeticException
}
```
A `try` block **must** be followed by at least one `catch` and/or a `finally`.

---

## 2. `catch`

Catches and handles a specific exception type thrown inside the `try` block.

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
}
```

**Multiple catch blocks** — Java checks them top to bottom, so order **specific → general**:
```java
try {
    int[] arr = new int[5];
    arr[10] = 50;   // ArrayIndexOutOfBoundsException
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index invalid: " + e.getMessage());
} catch (Exception e) {   // general catch-all, must come LAST
    System.out.println("Something else went wrong");
}
```

**Multi-catch (Java 7+)** — handle multiple types in one block if the handling logic is identical:
```java
catch (ArithmeticException | NullPointerException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 3. `finally`

A block that **always executes**, whether an exception was thrown or not, and whether it was caught or not (used for cleanup — closing files, releasing DB connections, etc.).

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Caught: " + e.getMessage());
} finally {
    System.out.println("This always runs — cleanup code goes here");
}
```

**Interview gotcha:** `finally` runs even if the `try` or `catch` block has a `return` statement:
```java
int test() {
    try {
        return 1;
    } finally {
        System.out.println("finally still runs before returning 1");
    }
}
```
The **only** case `finally` won't run is if the JVM exits via `System.exit()` or the thread is forcibly killed.

---

## 4. `throw`

Used to **manually throw** an exception (an instance) from within your code.

```java
void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or older");
    }
    System.out.println("Access granted");
}
```
`throw` is followed by an **object** (`new SomeException(...)`), and only ever throws **one** exception at a time.

---

## 5. `throws`

Used in a **method signature** to declare that the method **might throw** one or more checked exceptions, pushing the responsibility of handling it onto the caller.

```java
void readFile(String path) throws IOException {
    FileReader file = new FileReader(path);   // can throw IOException
}

// Caller must handle it:
void process() {
    try {
        readFile("data.txt");
    } catch (IOException e) {
        System.out.println("File error: " + e.getMessage());
    }
}
```

**`throw` vs `throws` (classic interview question):**

| | `throw` | `throws` |
|---|---|---|
| Used where | Inside a method body | In the method signature |
| Purpose | Actually throws an exception instance | Declares that a method *might* throw |
| Followed by | A single object (`new Exception(...)`) | One or more exception class names |
| Example | `throw new IOException("bad")` | `void read() throws IOException` |

---

## 6. Checked vs Unchecked Exceptions

### Checked Exception
- Checked **at compile time** — the compiler forces you to either `catch` it or declare it with `throws`.
- Represents conditions a well-written program **should anticipate and recover from** (e.g., a missing file, a network failure).
- Extends `Exception` (but not `RuntimeException`).

```java
import java.io.FileReader;
import java.io.IOException;

void readFile() throws IOException {
    FileReader fr = new FileReader("data.txt");  // IOException is CHECKED
}
```
Common examples: `IOException`, `SQLException`, `ClassNotFoundException`.

### Unchecked Exception
- **Not checked at compile time** — the compiler doesn't force handling; they surface at **runtime**.
- Usually indicate **programming bugs** (e.g., bad logic, invalid casting) rather than recoverable conditions.
- Extends `RuntimeException`.

```java
int[] arr = new int[5];
System.out.println(arr[10]);  // ArrayIndexOutOfBoundsException — UNCHECKED
```
Common examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`, `ClassCastException`, `IllegalArgumentException`, `NumberFormatException`.

### Quick Comparison

| | Checked Exception | Unchecked Exception |
|---|---|---|
| Checked when? | Compile time | Runtime |
| Must handle or declare? | ✅ Yes (`try-catch` or `throws`) | ❌ No (optional) |
| Parent class | `Exception` | `RuntimeException` |
| Represents | Recoverable external conditions | Programming/logic errors |
| Examples | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |

**Exception hierarchy (good to sketch in an interview):**
```
Throwable
├── Error                  (serious JVM-level problems — don't catch these, e.g. OutOfMemoryError)
└── Exception
    ├── RuntimeException    (UNCHECKED — NullPointerException, ArithmeticException, etc.)
    └── (everything else)   (CHECKED — IOException, SQLException, etc.)
```

---

## Custom Exceptions

You can define your own exception by extending `Exception` (checked) or `RuntimeException` (unchecked).

```java
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    double balance = 100;

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough balance!");
        }
        balance -= amount;
    }
}
```

---

## Frequently Asked Interview Questions

**Q: Can you have a `try` block without a `catch`?**
A: Yes, as long as it has a `finally` block: `try { ... } finally { ... }`.

**Q: What's the difference between `Error` and `Exception`?**
A: `Error` represents serious problems outside the application's control (e.g., `OutOfMemoryError`, `StackOverflowError`) that you generally shouldn't try to catch/recover from. `Exception` represents conditions an application can reasonably catch and handle.

**Q: Is `NullPointerException` checked or unchecked?**
A: Unchecked — it extends `RuntimeException`, and is almost always caused by a coding bug (using a reference before it's initialized), not something a caller is forced to handle.

**Q: What happens if an exception is thrown and never caught?**
A: It propagates up the call stack; if it reaches `main()` uncaught, the JVM prints a stack trace and terminates the program.

**Q: Can `finally` block override a return value from `try`?**
A: Yes — if `finally` also contains a `return`, it **overrides** the try/catch's return value (this is considered bad practice, but is a common trick interview question).
```java
int test() {
    try {
        return 1;
    } finally {
        return 2;   // this wins — method returns 2!
    }
}
```

---

**Practice idea:** Write a `withdraw(double amount)` method on a `BankAccount` class that throws a custom checked `InsufficientFundsException` if the amount exceeds the balance, and throws an unchecked `IllegalArgumentException` if the amount is negative. Write a `main()` method that tests both cases in `try-catch` blocks, and add a `finally` block that always prints the final balance.

---
---

# Step 6: Collections — 45-Minute Study Guide (Interview Prep)

The **Java Collections Framework** provides ready-made data structures (lists, sets, maps, queues) so you don't have to build them yourself.

## Collections Hierarchy

```
Iterable
└── Collection
    ├── List (ordered, allows duplicates)
    │   ├── ArrayList
    │   ├── LinkedList
    │   └── Vector
    │        └── Stack
    ├── Set (no duplicates)
    │   ├── HashSet
    │   │   └── LinkedHashSet
    │   └── SortedSet
    │        └── TreeSet
    └── Queue (FIFO-style processing)
        ├── LinkedList (also implements Queue)
        └── PriorityQueue

Map (separate hierarchy — NOT a Collection, key-value pairs)
├── HashMap
│   └── LinkedHashMap
└── SortedMap
     └── TreeMap
```

**Interview point:** `Map` does **not** extend `Collection` — it's a parallel hierarchy because it deals in key-value pairs, not single elements.

---

## List — Ordered, allows duplicates, indexed access

### ArrayList
Backed by a **dynamic (resizable) array**. Fast random access, slower inserts/deletes in the middle.

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add(1, "C");   // insert at index 1
System.out.println(list.get(0));   // fast, O(1)
```
- **Get by index:** O(1)
- **Insert/delete in middle:** O(n) — shifts elements
- **Not thread-safe**

### LinkedList
Backed by a **doubly linked list**. Fast inserts/deletes at the ends, slower random access.

```java
List<String> linked = new LinkedList<>();
linked.add("A");
linked.add("B");
((LinkedList<String>) linked).addFirst("Start");
```
- **Get by index:** O(n) — must traverse
- **Insert/delete at ends:** O(1)
- Also implements `Deque`, so it can act as a stack/queue.

### Vector
Legacy class (pre-dates the Collections Framework), functionally like `ArrayList` but **synchronized (thread-safe)**.

```java
Vector<String> vec = new Vector<>();
vec.add("A");
```
- Rarely used in modern code — `ArrayList` + explicit synchronization, or `CopyOnWriteArrayList`, is generally preferred.

### ArrayList vs LinkedList (classic interview question)

| | ArrayList | LinkedList |
|---|---|---|
| Backing structure | Dynamic array | Doubly linked list |
| Random access (`get(i)`) | O(1) — fast | O(n) — slow |
| Insert/delete at start/middle | O(n) — shifts elements | O(1) at ends, O(n) in middle to find the spot |
| Memory overhead | Lower | Higher (stores next/prev pointers per node) |
| Best for | Frequent reads, indexed access | Frequent insertions/deletions, queue/stack usage |

---

## Set — No duplicates

### HashSet
Backed by a `HashMap` internally. **No guaranteed order**, fastest general-purpose set.

```java
Set<String> set = new HashSet<>();
set.add("Banana");
set.add("Apple");
set.add("Apple");   // ignored — duplicate
System.out.println(set);   // order not guaranteed
```
- **Add/remove/contains:** O(1) average

### LinkedHashSet
Like `HashSet`, but maintains **insertion order** using an internal linked list.

```java
Set<String> lhs = new LinkedHashSet<>();
lhs.add("Banana");
lhs.add("Apple");
System.out.println(lhs);   // [Banana, Apple] — insertion order preserved
```

### TreeSet
Backed by a **Red-Black tree**. Keeps elements in **sorted (natural or custom) order**.

```java
Set<Integer> ts = new TreeSet<>();
ts.add(5);
ts.add(1);
ts.add(3);
System.out.println(ts);   // [1, 3, 5] — always sorted
```
- **Add/remove/contains:** O(log n)
- Elements must be `Comparable`, or you supply a `Comparator`.

### HashSet vs LinkedHashSet

| | HashSet | LinkedHashSet |
|---|---|---|
| Order | No guaranteed order | Insertion order preserved |
| Performance | Slightly faster | Slightly slower (extra linked-list bookkeeping) |
| Use case | Order doesn't matter, max speed | Need predictable iteration order |

---

## Map — Key-value pairs

### HashMap
**No guaranteed order.** Fastest general-purpose map. Allows one `null` key and multiple `null` values.

```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
map.put("Bob", 30);
System.out.println(map.get("Alice"));   // 25
```
- **get/put/remove:** O(1) average

### LinkedHashMap
Maintains **insertion order** (or optionally access order, for building simple LRU caches).

```java
Map<String, Integer> lhm = new LinkedHashMap<>();
lhm.put("Bob", 30);
lhm.put("Alice", 25);
System.out.println(lhm);   // {Bob=30, Alice=25} — insertion order kept
```

### TreeMap
Backed by a **Red-Black tree**. Keys are always kept in **sorted order**. Does **not** allow `null` keys.

```java
Map<String, Integer> tm = new TreeMap<>();
tm.put("Bob", 30);
tm.put("Alice", 25);
System.out.println(tm);   // {Alice=25, Bob=30} — sorted by key
```
- **get/put/remove:** O(log n)

### HashMap vs TreeMap

| | HashMap | TreeMap |
|---|---|---|
| Order | No guaranteed order | Sorted by key |
| Performance | O(1) average | O(log n) |
| Null keys | One `null` key allowed | Not allowed |
| Use case | Fast lookups, order irrelevant | Need sorted keys / range queries |

---

## Queue — FIFO-style processing

### PriorityQueue
Elements are ordered by **priority** (natural ordering or a custom `Comparator`), not insertion order. The **head** is always the smallest (or highest priority) element.

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);

System.out.println(pq.poll());   // 1 — smallest first
System.out.println(pq.poll());   // 3
```

**Custom ordering (max-heap example):**
```java
Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
maxHeap.add(5);
maxHeap.add(1);
maxHeap.add(3);
System.out.println(maxHeap.poll());   // 5 — largest first
```
- **Insert/remove:** O(log n)
- Backed by a **binary heap** internally.
- Common use: scheduling tasks by priority, Dijkstra's algorithm, "top-K" problems.

---

## Master Comparison Table

| Collection | Order | Duplicates | Null allowed | Typical access time |
|---|---|---|---|---|
| ArrayList | Insertion | ✅ Yes | ✅ Yes | O(1) get |
| LinkedList | Insertion | ✅ Yes | ✅ Yes | O(n) get |
| Vector | Insertion | ✅ Yes | ✅ Yes | O(1) get (synchronized) |
| HashSet | None | ❌ No | one `null` | O(1) |
| LinkedHashSet | Insertion | ❌ No | one `null` | O(1) |
| TreeSet | Sorted | ❌ No | ❌ No (usually) | O(log n) |
| HashMap | None | Keys unique | one `null` key | O(1) |
| LinkedHashMap | Insertion | Keys unique | one `null` key | O(1) |
| TreeMap | Sorted by key | Keys unique | ❌ No | O(log n) |
| PriorityQueue | Priority order | ✅ Yes | ❌ No | O(log n) insert/remove |

---

**Practice idea:** Given an array of words, use a `HashMap<String, Integer>` to count word frequency, then use a `PriorityQueue` (with a custom comparator on frequency) to find the top 3 most frequent words. This is a very common real interview question that combines Maps and Queues.

---
---

# Step 7: Keywords — 15-Minute Study Guide (Interview Prep)

## `static`
Belongs to the **class itself**, not to any individual object — shared across all instances.

```java
class Counter {
    static int count = 0;   // shared by ALL objects

    Counter() {
        count++;
    }
}

Counter c1 = new Counter();
Counter c2 = new Counter();
System.out.println(Counter.count);   // 2 — shared, accessed via class name
```
- Static methods can't use `this` and can only directly call other static members.
- Common uses: utility methods (`Math.max()`), constants, counters.

## `final`
Prevents further modification — meaning depends on context:
```java
final int x = 10;          // variable: value cannot be reassigned
final class MyClass { }    // class: cannot be extended/subclassed
final void show() { }      // method: cannot be overridden
```

## `finally`
A block that **always executes** after `try`/`catch`, regardless of whether an exception occurred (covered in Step 5 — used for cleanup).

## `finalize()`
A method (from `Object`) the **garbage collector** used to call before reclaiming an object's memory, to let it release resources.

```java
@Override
protected void finalize() throws Throwable {
    System.out.println("Object being garbage collected");
}
```
**Interview note:** `finalize()` is **deprecated since Java 9** and **removed in Java 18+** — its execution timing was never guaranteed, so modern code uses `try-with-resources` or explicit `close()` methods (`AutoCloseable`) instead.

## `this`
Refers to the **current object instance** (see Step 2, section 4) — used to resolve field/parameter naming conflicts or chain constructors.

## `super`
Refers to the **immediate parent class** (see Step 2, section 5) — used to call a parent constructor or access an overridden parent method/field.

## `new`
Allocates memory on the **heap** and creates a new object instance, then calls its constructor.

```java
Car myCar = new Car();   // 'new' allocates memory + invokes constructor
```

## `instanceof`
Checks whether an object is an instance of a specific class/interface — returns `boolean`. Commonly used before casting, to avoid `ClassCastException`.

```java
Object obj = "Hello";

if (obj instanceof String) {
    String s = (String) obj;   // safe to cast
    System.out.println(s.length());
}
```

**Pattern matching for `instanceof` (Java 16+)** — combines the check and cast:
```java
if (obj instanceof String s) {
    System.out.println(s.length());   // 's' already cast, ready to use
}
```

### Quick Reference

| Keyword | Applies to | Purpose |
|---|---|---|
| `static` | Field / method / block | Shared at class level, not per-instance |
| `final` | Variable / method / class | Prevents reassignment / overriding / extending |
| `finally` | try-catch block | Always executes (cleanup) |
| `finalize()` | Object method | Old GC cleanup hook (deprecated/removed) |
| `this` | Instance context | Refers to current object |
| `super` | Instance context | Refers to parent class |
| `new` | Object creation | Allocates memory, invokes constructor |
| `instanceof` | Type check | Tests object type before casting |

---
---

# Step 8: Access Modifiers — 10-Minute Study Guide (Interview Prep)

Access modifiers control **visibility** — what other classes/packages are allowed to see and use.

## `public`
Accessible from **anywhere** — any class, in any package.

```java
public class Car {
    public String model;
    public void drive() { }
}
```

## `private`
Accessible **only within the same class**. Not visible to subclasses or other classes, even in the same package.

```java
class Account {
    private double balance;   // only Account's own methods can touch this directly
}
```

## `protected`
Accessible within the **same package**, and also by **subclasses in other packages** (via inheritance).

```java
class Animal {
    protected void makeSound() { }
}
```

## `default` (no modifier / package-private)
If you write **no** access modifier, it's package-private — accessible only within the **same package**, not by subclasses in other packages.

```java
class Utility {
    void helper() { }   // no modifier = default access
}
```

## Access Modifier Visibility Table

| Modifier | Same Class | Same Package | Subclass (different package) | Different Package (non-subclass) |
|---|---|---|---|---|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `default` (none) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

**Interview tip:** Order from most to least restrictive: `private` → `default` → `protected` → `public`. A common design rule: keep fields `private` and expose behavior through `public` methods (encapsulation, see Step 2 §10).

---
---

# Step 9: JVM Basics — 15-Minute Study Guide (Interview Prep)

## JDK (Java Development Kit)
The full toolkit for **developing** Java applications — includes the compiler (`javac`), debugger, and other dev tools, **plus** the JRE.
```
JDK = JRE + Development Tools (compiler, debugger, javadoc, etc.)
```

## JRE (Java Runtime Environment)
Everything needed to **run** (but not develop) Java applications — includes the JVM and core class libraries, but no compiler.
```
JRE = JVM + Standard Class Libraries
```

## JVM (Java Virtual Machine)
An abstract machine that provides the runtime environment to **execute Java bytecode**. It's what makes Java "write once, run anywhere" — the same `.class` bytecode runs on any platform that has a compatible JVM.

**Responsibilities:** loading classes, verifying bytecode, executing it (via interpreter + JIT compiler), and managing memory (garbage collection).

### JDK vs JRE vs JVM (interview favorite)

| | Contains | Purpose |
|---|---|---|
| JVM | Bytecode execution engine | Runs compiled `.class` files |
| JRE | JVM + libraries | Run Java programs (no compiling) |
| JDK | JRE + compiler + dev tools | Develop AND run Java programs |

---

## Bytecode
When you compile a `.java` file with `javac`, it produces a `.class` file containing **bytecode** — a platform-independent, intermediate instruction set (not machine code, not raw source).

```
MyProgram.java  --(javac)-->  MyProgram.class (bytecode)  --(JVM)-->  Machine code (executed)
```
The JVM interprets this bytecode (or compiles hot paths to native machine code via the **JIT — Just-In-Time compiler** — for performance).

---

## Garbage Collection (GC)
The JVM's automatic process of **reclaiming heap memory** occupied by objects that are no longer reachable/referenced by the program — so developers don't manually free memory (unlike C/C++).

```java
Car myCar = new Car();
myCar = null;   // object now unreachable, eligible for garbage collection
```
- GC runs in the background; you can't force it, only *suggest* it with `System.gc()` (not guaranteed to run immediately).
- Common algorithm concepts: **mark-and-sweep** (mark reachable objects, sweep away the rest), generational collection (young/old generation heaps, since most objects die young).

---

## Stack Memory
Stores **method call frames** — local variables, method parameters, and partial results — in a **LIFO (last-in, first-out)** structure. Each thread has its own stack.

```java
void method1() {
    int x = 5;        // stored in stack frame for method1()
    method2();
}
void method2() {
    int y = 10;        // stored in a NEW stack frame for method2()
}
```
- Very fast access.
- Automatically cleaned up when a method returns (its frame is popped).
- Too much recursion → `StackOverflowError`.

## Heap Memory
Stores **all objects** and their instance variables (things created with `new`), shared across all threads.

```java
Car myCar = new Car();  // the Car OBJECT lives on the heap;
                          // 'myCar' the REFERENCE variable lives on the stack
```
- Managed by the Garbage Collector.
- Running out of heap space → `OutOfMemoryError`.

### Stack vs Heap

| | Stack | Heap |
|---|---|---|
| Stores | Method calls, local variables, references | Objects, instance variables |
| Lifetime | Per method call (popped on return) | Until garbage collected |
| Access speed | Faster | Slower |
| Thread-shared? | Each thread has its own stack | Shared across all threads |
| Overflow error | `StackOverflowError` | `OutOfMemoryError` |

---

## Frequently Asked Interview Questions

**Q: Can you run a Java program with just a JRE, no JDK?**
A: Yes — the JRE has everything needed to *run* compiled `.class` files; you only need the JDK if you're *compiling* source code.

**Q: What is JIT compilation?**
A: The Just-In-Time compiler within the JVM compiles frequently executed ("hot") bytecode into native machine code at runtime, improving performance over pure interpretation.

**Q: Where does a local primitive variable live vs an object it refers to?**
A: The variable itself (the reference, or the primitive value) lives on the **stack** inside its method's frame; if it's a reference type, the actual object it points to lives on the **heap**.

**Q: Why is Java considered platform-independent?**
A: Source code compiles to bytecode (not native machine code), and any machine with a compatible JVM can execute that same bytecode — "write once, run anywhere."

---

**Practice idea:** Draw the stack/heap diagram by hand for this snippet, labeling what lives where:
```java
public static void main(String[] args) {
    int a = 10;
    Car c = new Car();
    modify(c);
}
static void modify(Car c) {
    c.speed = 100;
}
```
(Answer to think through: `a`, the method frames for `main` and `modify`, and the reference variable `c` all live on the stack; the actual `Car` object lives on the heap and is shared by both frames' `c` reference.)