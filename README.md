# Java-Spring-web-3

In this exercise you will refactor existing application and extract **service** and **repository** layers.

## Task 1: Clone this repository and import the application into your IDE

Take a look at all the given code. The `Application` class is our an entry point to the
application.

Run the application and make sure it works.

Take a look at `EmployeeController` file. There are CRUD methods to manipulate on `Employee` entity.

> In computer programming, create, read, update, and delete **(CRUD)** are the four basic operations of persistent storage.

But this code is not clean, it violates **single responsibility principle** - it has more than one responsibility, because it has additional logic related to operating on a storage (which is Set in our case).
Also, it has some sort of business logic, like not adding employees that first name starts with 'A':

```java
if (employee.getFirstName().startsWith("A")) {
  throw new UnsupportedOperationException();
}
```

> **Single responsibility principle** is a part of **[SOLID](https://en.wikipedia.org/wiki/SOLID)** rules. They tell us how to write a good code.

Your role here will be to make this code clean by extracting and delegating the logic to **service** and **repository** layers.


## Task 2: Extract **service** layer

Create a new class which will be annotated by a `@Service` annotation. Put there any business logic that is now implemented in `EmployeeController` class.

## Task 3: Extract **repository** layer

Create a new class which will be annotated by a `@Repository` annotation. Put there any logic related to persistent layer modification, which is in our case:

`private final Set<Employee> employees = new HashSet<>();`

> Normally, in the `Repository` layer you will implement methods that will communicate with some sort of database (SQL in most cases). In this exercise though you don't know how to work with databases yet, so that as a storage we use just a simple `Set`.


## Task 4: Test the Application!

Run your application.
You can use **Postman** for testing purposes.