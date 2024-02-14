# Session 2 - Constructors, Casting, Overloading Constructors, Static Properties and Methods

In this session, we will complete the following tasks:

1. [Create a new constructor for a class](#1-create-a-new-constructor-for-a-class)
2. [Use the new constructor in the `main` method](#2-use-the-new-constructor-in-the-main-method)
3. [Create an overloaded constructor for a class](#3-create-an-overloaded-constructor-for-a-class)
4. [Setting unique `id` values for each instance using `static`](#4-setting-unique-id-values-for-each-instance-using-static)
5. [Using static properties in class instances](#5-using-static-properties-in-class-instances)

---

## 1. Create a new constructor for a class

1. In the `Engineer` class, add the following constructor method:

```java
    public Engineer(int id, String name, byte age, double testScoreAverage, String cohort, boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.testScoreAverage = testScoreAverage;
        this.cohort = cohort;
        this.isActive = isActive;
    }
```

> A constructor is a special method that is used to create an instance of a class. It is called when the `new` keyword is used to create an instance of a class.
> 
> Constructors always carry an access modifier (usually of `public`) and have the same name as the class.  There is no return type for a constructor.
> 
> Constructor arguments should match the type and order of the class properties (by rule and convention respectively)
> 
> The `this` keyword is used to refer to the current instance of the class.  It is used to differentiate between the constructor arguments and the class properties.
 
---

## 2. Use the new constructor in the `main` method

> Note that you are now seeing a error in the `App` class.
> 
> This is because the `Engineer` class now has a constructor that takes arguments.  The default constructor is no longer available and cannot be called.

1. In the `App` class, change the `main` method to the following:

```java
        Engineer engineer = new Engineer(1, "John Smith", (byte) 35, 82.5, "Cohort 12", true);
```

> We now have an error under the constructor arguments - WHY?
> 
> We need to cast the "integer" to a "byte" for the age argument.  This is because the literal value of `35` is an `int` by default.

2. Add the cast to the age argument:

```java
        Engineer engineer = new Engineer(1, "John Smith", (byte) 35, 75.5, "Cohort 12", true);
```

3. Run the program.  You should see that the `id` and the `cohort` are now set to the values we passed used the constructor.


```
Engineer ID: 1
Engineer Name: John Smith
Engineer Age: 21
Engineer Test Score Average: 75.5
Engineer Cohort: Cohort 12
Engineer Active: true
```
---

## 3. Create an overloaded constructor for a class

> We can create multiple constructors for a class.  This is called _**OVERLOADING**_ and it allows us to create instances of a class in different ways.
>
> The arguments for each constructor must be different.  This is called the _**SIGNATURE**_ of the constructor.

1. In the `Engineer` class, add a second constructor of:

```java
    public Engineer(String name, byte age, double testScoreAverage, String cohort, boolean isActive) {
        this.id = 0;
        this.name = name;
        this.age = age;
        this.testScoreAverage = testScoreAverage;
        this.cohort = cohort;
        this.isActive = isActive;
    }
```

> Note that the `id` property is not in the argument list of this constructor.  This is because we ultimately want to use the value the program supplies, not the class user.
> 
> The runtime will decide which constructor to use when called using the arguments supplied.

2. In both constructors, change the line that sets the `id` to the following:

```java
        this.id = 0;
```

3. In the `App` class, create another instance of the Engineer class using the new constructor and the following code:

```java
        Engineer engineer2 = new Engineer("Kaiden Jones", (byte) 21, 92.5, "Cohort 12", true);
```

3. Print out each of the properties of the new Engineer instance

> These values are set through the runtime selecting the correct constructor based on the arguments supplied.

---

## 4. Setting unique `id` values for each instance using `static`

At the moment, the `id` value is set to the default value for an `int` (i.e. `0`) or the supplied value for every instance.

We often want to set a unique value for each instance of a class.  We can do this using a `static` property and operating on the value in the constructor.

> `static` properties and methods are available to all instances of a class.  They are not unique to each instance.
> 
> Changing the value of a `static` property will change it for all instances of the class.
> 
> This can be useful for setting unique values for each instance!

1. In the `Engineer` class, add the following `static` property:

```java
    private static int nextId = 1;
```

2. As this values is `private`, we will need to provide a `static` getter method to access it:

```java
    public static int getNextId() {
        return nextId;
    }
```

3. In the `App` class print out the value of the `nextId` property:

```java
        System.out.println("Next Engineer ID: " + Engineer.getNextId());
```

> Notice how we use the class name to access the `static` property
> This is because the property is not unique to each instance - it belongs to the class itself.
> We could have accessed the value from either instance, `engineer` or `engineer2`, and it would have been the same.
> This is not best practice though as it is confusing to the reader, who may think the static property is unique to the instance.

4. In the `Engineer` class, add or replace the setting of `id` in both constructors:

```java
        this.id = nextId++;

```

> This will use the current `static` value of `nextId` and then increment it by `1` for the next instance.

5. Whilst you here, make sure that the `isActive` property of every instance is set to `true` in the constructor
6. Remove the `isActive` argument from the second constructor and to the instatiation of `engineer2`
7. Run the program and observe the output - if you put the output of `nextId` last, it should be `3`