# Session 3 - Additional Classes, Inheritance, Abstract Classes, ArrayLists and Wrapper Classes

In this session, we will complete the following tasks:

1. [Add a second class to work with, including an Array as a field](#1-add-a-second-class-to-work-with-including-an-array-as-a-field)
2. [Explore Inheritance and Base Classes](#2-explore-inheritance-and-base-classes)
3. [Work with an Abstract Base Class](#3-work-with-an-abstract-base-class)
4. [Work with ArrayLists and Wrapper Classes](#4-work-with-arraylists-and-wrapper-classes)

---

## 1. Add a second class to work with, including an Array as a field

For the application, we need a class to store trainer information in.

Why can't we use the `Engineer` class for this?

1. Create a new class called `Trainer` in the `com.digitalfuturesacademy.app` package
2. Add the following properties to the class, with appropriate **getters** and **setters**:

```java
    private static int nextId = 1;
    private int id;
    private String name;
    private byte age;
    private String currentCohort;
    private String[] pathways;     
    private boolean isActive;
```

> What is the field `String[] pathways` going to store?
> 
> Arrays are declared in Java using square brackets `[]` after the type.
> 
> The array can only contain values of the type specified in the declaration.
> 
> The array can be initialized with values using curly braces `{}` after the declaration.
> OR
> The array can be initialized with a specific number of elements using square brackets `[]` after the declaration.
> 
> The array is fixed in size once initialized.

---

## 2. Explore Inheritance and Base Classes

What are the similarities and differences between the `Engineer` and `Trainer` classes?

- Are there any properties that are the same?
- Are there any properties that are different?

Does it make sense to be repeating declarations, methods and constructors that contain these properties?  Is that DRY?

> DRY stands for "Don't Repeat Yourself" and is a principle of software development that aims to reduce repetition of code.

We can use **Inheritance** to create a **Base Class** that contains the common properties and methods of the `Engineer` and `Trainer` classes.

> A **Base Class** is a class that is used to create other classes.  It is also called a **Super Class**.

1. Create a new class in the package called `DigitalFuturesPerson`
2. Add the following properties to the class:

```java
    protected int id;
    protected String name;
    protected byte age;
    protected boolean isActive;
```

> Note that the properties are declared as `protected`.  This means that they can be accessed by classes that inherit from this class, but not by other classes.

3. Add the following constructor to the class:

```java
    public DigitalFuturesPerson(int id, String name, byte age) {
        this.id = id;           // The id value will change based on the type of person being created so manually set here
        this.name = name;
        this.age = age;
        this.isActive = true;
    }
```

4. Add `public` **getters** and **setters** for each property as appropriate, using the `Engineer` class as a guide as to what is needed.

#### Modify the `Engineer` and `Trainer` classes to inherit from the `DigitalFuturesPerson` class

We can make classes in Java inherit from another class using the `extends` keyword.

> The `extends` keyword is used to create a **subclass** of a class.  The subclass inherits all of the `public` and `protected` properties and methods of the superclass.

1. In the `Engineer` and `Trainer` classes, add `extends DigitalFuturesPerson` to the class declaration:

```java
public class Engineer extends DigitalFuturesPerson {
    // Code unchanged for now
}

public class Trainer extends DigitalFuturesPerson {
    // Code unchanged for now
}
```

> Notice that the class declaration is indicating an error.  This is because the `DigitalFuturesPerson` class does not have a default constructor and we need to satisfy the call to it.

2. In the `Engineer` class, remove the 'all property' constructor, the fields that are now declared in the `DigitalFuturesPerson` class and their **getters** and **setters**.
3. In the `Engineer` and `Trainer` classes, add a call to the `DigitalFuturesPerson` constructor via `super` inside the subclass constructor, passing in the appropriate values:

```java
    public Engineer(String name, byte age, double testScoreAverage, String cohort, boolean isActive) {
        super(nextId++, name, age);
        this.testScoreAverage = testScoreAverage;
        this.cohort = cohort;
    }
    
    public Trainer(String name, byte age, String[] pathways, String currentCohort) {
        super(nextId++, name, age);
        this.pathways = pathways;
        this.currentCohort = currentCohort;
    }
```

#### Complete the `Trainer` class

1. Make sure that the `Trainer` class looks like this:

```java
public class Trainer extends DigitalFuturesPerson {
    private static int nextId = 1;
    private String[] pathways;
    private String currentCohort;

    public Trainer(String name, byte age, String[] pathways, String currentCohort) {
        super(nextId++, name, age);
        this.pathways = pathways;
        this.currentCohort = currentCohort;
    }

    public String[] getPathways() {
        return pathways;
    }

    public void setPathways(String[] pathways) {
        this.pathways = pathways;
    }

    public String getCurrentCohort() {
        return currentCohort;
    }

    public void setCurrentCohort(String currentCohort) {
        this.currentCohort = currentCohort;
    }
}
```

---

## 3. Work with an Abstract Base Class

An instance of `Engineer` or `Trainer` is a more specific type of `DigitalFuturesPerson`.

> Does it make sense to be able to create an instance of `DigitalFuturesPerson`?

If not, and for our purposes it doesn't, we can make the `DigitalFuturesPerson` class **abstract**.

> An **abstract** class is a class that cannot be instantiated.  It is used to create other classes.
> Calling the constructor of an abstract class will result in an error.

To make a class `abstract`, we simply add the `abstract` keyword to the class declaration:

1. Add the `abstract` keyword to the `DigitalFuturesPerson` class declaration:

```java
public abstract class DigitalFuturesPerson {
    // Code unchanged
}
```

> An `abstract` class can have both `abstract` and `concrete` methods.
> Abstract methods are declared without a body and are used to define a method that must be implemented by a subclass.
> A concrete method is a method that has a body and can be called directly - they can be overridden by a subclass if necessary (i.e. if the subclass needs to change the behaviour of the method).

There should be no errors and your `main` method should still work as before, as long as you have updated the constructor argument list for the call for the instance called `engineer`

You should also be able to create a couple of instances of the trainer class and print out their details.

---

## 4. Work with ArrayLists and Wrapper Classes

We can further extend the `Trainer` class by storing the cohorts that the trainer has worked with in the past.

You may be initially drawn to using an array to store data like this, but this array would need to be initialized with a specific size and would not be able to grow or shrink.

> Java provides the `Collection` framework to work with collections of data.  The `Collection` framework is a set of interfaces and classes that provide a standard way to store and manipulate data.
> We are able to use one of its implementations, the `ArrayList`, to store a list of cohorts that the trainer has worked with.
> This list will work in the same way as an array, but will be able to grow and shrink as needed.

1. In the `Trainer` class, add a new property called `previousCohorts` of type `ArrayList<String>`:

```java
    import java.util.ArrayList;

private ArrayList<String> cohortsTaught = new ArrayList<>(); // No need to repeat generic!
```

> In this declaration, we use the `ArrayList` class to create a new instance of an `ArrayList` that will store `String` values.
> The angle brackets `<>` are used to specify the type of data that the `ArrayList` will store.
> This is called a **generic** and is used to specify the type of data that a class will work with.
> The **generic** must be a **reference type** (i.e. a class or interface) and cannot be a **primitive type** (i.e. `int`, `double`, `boolean`, etc.).

So how do we deal with primitive values we might want to store in this way?

> Java provides **wrapper classes** for each of the primitive types that allow us to use them as reference types.
> The wrapper classes are:
>
> - `Byte`
> - `Short`
> - `Integer`
> - `Long`
> - `Float`
> - `Double`
> - `Boolean`
> - `Character` (`char` a primitive type in Java that can store a single character)
> - `Void` (used to represent the absence of a value and only included for completeness)
> 
> These wrapper classes are pretty much interchangeable with their primitive counterparts, but they are reference types and can be used in generic declarations - like in ArrayLists

As an ArrayList is a class, we can use the `.` operator to access its methods. You can see that some of the most popular methods are:

- `add()` - adds an item to the end of the list
- `get()` - gets an item from the list at a specified index
- `remove()` - removes an item from the list at a specified index
- `size()` - returns the number of items in the list
- `clear()` - removes all items from the list
- `contains()` - returns `true` if the list contains the specified item

> This list is not exhaustive.  You can find more information about the `ArrayList` class [here](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html).

3. Ensure that the currentCohort is added to the new ArrayList:

```java
    public Trainer(String name, byte age, String[] pathways, String currentCohort) {
        super(nextId++, name, age);
        this.pathways = pathways;
        this.currentCohort = currentCohort;
        this.cohortsTaught.add(currentCohort);
}
```

4. Add a **getter** for the ArrayList:

```java
    public ArrayList<String> getCohortsTaught() {
        return cohortsTaught;
    }
```

5. And a method to add a cohort to the ArrayList:

```java
    public void addCohort(String cohort) {
        this.cohortsTaught.add(cohort);
    }
```

> Note: There may be instances where we want to stop a cohort being added - we will discover these as we learn about testing our application.

6. In the `main` method, create instances of the `Trainer` class and see their methods working. 

If you want to iterate over the items in the ArrayList, you can use a `for` loop like this:

```java
    for (int i = 0; i < trainer.getCohortsTaught().size(); i++) {
        System.out.println(trainer.getCohortsTaught().get(i));
    }
```

You can use the enhanced `for` loop like this:

```java
    for (String cohort : trainer.getCohortsTaught()) {
        System.out.println(cohort);
    }
```

To access the list directly, get the cohorts taught list and use an ArrayList method to access (get) the item at the specified index:

```java
    System.out.println(trainer.getCohortsTaught().get(0));
```

And if you want to know how big the list is, use the size method:

```java
    System.out.println(trainer.getCohortsTaught().size());
```

