# Session 1 - Projects, Types, Classes, Objects, Fields, Methods, Access Modifiers, Getters and Setters

In this session, we will complete the following tasks:

1. [Create a new project](#1-create-a-new-project)
2. [Create a new package and class](#2-create-a-new-package-and-class)
3. [Add fields to a class](#3-add-fields-to-a-class)
4. [Create an `App` class](#4-create-an-app-class-to-run-the-program-from) (to run the program from)
5. [Create and use a class instance in the `main` method](#5-create-and-use-a-class-instance-in-the-main-method)
6. [Access class properties from the `main` method](#6-access-class-properties-from-the-main-method)
7. [Change class properties from the `main` method](#7-change-class-properties-from-the-main-method)
8. [Encapsulate the class properties](#8-encapsulate-the-class-properties-using-appropriate-access-modifiers) (using appropriate access modifiers)
9. [Create getters and setters for the class properties](#9-create-getters-and-setters-for-the-class-properties)
10. [Use the getters and setters in the `main` method](#10-use-the-getters-and-setters-in-the-main-method)

---

## 1. Create a new project

1. Create a new project in IntelliJ
2. Select Java as the project type
3. Select Java 17 as the SDK
4. Select Maven as the build tool
5. Select the project location - finishing with the name `java-cohort-demo`
6. Click Finish

---

## 2. Create a new package and class

1. Right-click on the `src` folder
2. Select New -> Package
3. Name the package `com.digitalfuturesacademy.app`
4. Right-click on the `com.digitalfuturesacademy.app` package
5. Select New -> Java Class
6. Name the class `Engineer`
7. Click OK

> A class can be seen as the _"blueprint"_ for creating objects.  It defines the properties and behaviours of the objects that will be created from it.

---

## 3. Add fields to a class

> _fields_ can also be referred to, interchangeably, as _members_ or _properties_

1. Add the following fields to the Engineer class:

```java
    int id;                     // could use long, short or byte here too - why choose int?
    String name;
    byte age;                   // could use int or short here too - why choose byte?
    double testScoreAverage;    // could use float here too
    String cohort;
    boolean isActive ;
```

An explanation of the different data types can be found [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html).

Why does the `cohort`'s data type not start with a small letter?  What does that tell you about the `String` type?

Does it help with working out what other data types are? 

---

## 4. Create an `App` class (to run the program from)

1. Right-click on the `com.digitalfuturesacademy.app` package
2. Select New -> Java Class
3. Name the class `App`
4. Click OK
5. Add the `main` method to the `App` class using the short-cut `psvm`:

```java
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
```
> The `System.out.println()` method accesses the `System` class and runs a method called `println` attached to the `out` property of the `System` class

6. Run the App class by right-clicking on the class name and selecting Run 'App.main()' or by clicking the green arrow next to the main method
7. Look at the program's output in the Console window

---

## 5. Create and use a class instance in the `main` method

1. Replace the current code with the following code in the main method:

```java
    Engineer engineer = new Engineer();
```

2. Make sure that you understand what this line of code is doing!

> It is creating an instance of the `Engineer` class local to this `main` method
> 
> The instance is called `engineer` and is of type `Engineer`
> 
>On the **STACK** the reference `engineer` will contain the memory address of the **HEAP** where the `Engineer` instance is stored

3. Run the App class with a _**breakpoint**_ set at the line that creates the `engineer` instance
4. Use the _**debugger**_ window to explore how `engineer` is referenced

---

## 6. Access class properties from the `main` method

1.  In the `main` method in the `App` class, add the following code:

```java
        System.out.println("Engineer ID: " + engineer.id);
        System.out.println("Engineer Name: " + engineer.name);
        System.out.println("Engineer Age: " + engineer.age);
        System.out.println("Engineer Test Score Average: " + engineer.testScoreAverage);
        System.out.println("Engineer Cohort: " + engineer.cohort);
        System.out.println("Engineer Active: " + engineer.isActive);
```

2. Run the program and observe the output
3. Be sure to understand _**HOW**_ the properties of the engineer are used!

> _**"dot-notation"**_ is used to access the properties of the `engineer` instance
>  
> The `engineer` instance is referenced by the `engineer` variable
> 
> The fields (or members or properties) available are those we specified in the `Engineer` class
 
4. What are the values that are being used, as we have never set them?

> It is important to know what the uninitialised values are for each data type
> 
> These can be found in the [documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

---

## 7. Change class properties from the `main` method

1. Still in the `main` method in the `App` class, add the following code:

```java
        engineer.id = 1;
        engineer.name = "John Smith";
        engineer.age = 21;
        engineer.testScoreAverage = 75.5;
        engineer.cohort = "Java";
        engineer.isActive = true;
```

2. Copy the previous `System.out.println()` statements and paste them below the new code
3. Run the program and observe the output

> We have directly accessed and changed properties from the `main` method!
> 
> Is this is a good idea? Why not? What principle of OOP are we breaking?
 
---

## 8. Encapsulate the class properties (using appropriate access modifiers)

1. In the `Engineer` class, add the `private` access modifier to all properties of the Engineer class
2. What were they before? This is default and implicit behaviour from Java!

> You need to make sure that you understand the different access modifiers that are available and what they mean for accessing class properties

3. Return to the `App` class and observe the errors that are now present - why are they there? How do we access the properties now?

---

## 9. Create getters and setters for the class properties

> We provide `public` methods to control access to the private properties of the class
> 
> A _**GETTER**_ allows read access to the property
> 
> A _**SETTER**_ allows write access to the property

1. In the `Engineer` class, add the following getters and setters (miss the setId and setCohort out):

```java
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public double getTestScoreAverage() {
        return testScoreAverage;
    }

    public void setTestScoreAverage(double testScoreAverage) {
        this.testScoreAverage = testScoreAverage;
    }

    public String getCohort() {
        return cohort;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
```
> _**PRO-TIP**_ IntelliJ (and most other IDEs) can generate getters and setters for you!
> 
> Right-click in the class and select Generate -> Getter and Setter

---

## 10. Use the getters and setters in the `main` method

1. In the `App` class, replace the code that sets the properties of the Engineer instance with the following code:

```java
        engineer.setName("John Smith");
        engineer.setAge((byte) 21);
        engineer.setTestScoreAverage(75.5);
        engineer.setActive(true);
```

2. What do you notice about the `setAge()` method? Why is this?

> You should understand WHY Java needs to using this here
> 
> It is called _**CASTING**_ and it is used to convert one data type to another - useful if are supplying the compiler with a value that is not explicitly the expected data type
> 
> In this case, we are supplying an `int` value to a method that expects a `byte` value, so we tell the compiler to convert the `int` to a `byte` using the `(byte)` syntax
> 
> This is a _**NARROWING**_ conversion as we are converting from a larger data type to a smaller data type (especially of an integral nature)
> 
> We can also _**WIDEN**_ convert from a smaller data type to a larger data type but there are specific rules that apply to this
> 
> You can read more about casting [here](https://docs.oracle.com/javase/specs/jls/se17/html/jls-5.html)

3. Add `System.out.println` calls for each `getter` for the `engineer` instance
4. Re-run the program.  You will notice that the id and cohort are still the default values and we have no mechanism to change their values!  What can we do?

>  The solution to this is to set them when we instantiate an instance of the `Engineer` class - this is done in a special class method called a _**CONSTRUCTOR**_

---






