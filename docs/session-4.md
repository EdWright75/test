# Session 4 - JUnit Testing using Maven, Exceptions and Test Coverage

In this session, we will complete the following tasks:

1. [Add the JUnit dependency to the Project](#1-add-the-junit-dependency-to-the-project)
2. [Add Test Coverage to the Project](#2-add-test-coverage-to-the-project)
3. [Create a Test Class and Test Methods](#3-create-a-test-class-and-test-methods)
4. [Explore Test Coverage](#4-explore-test-coverage)
5. [Create Edge Case Tests and Implement Exceptions and Defensive Programming](#5-create-edge-case-tests-and-implement-exceptions-defensive-programming-and-organise-the-tests)
6. [Create Further Test Cases and Classes](#6-create-further-test-cases-and-classes)

---

## 1. Add the JUnit dependency to the Project

Like in JavaScript, we need additional tools to help with the testing of our code.  JUnit is a testing framework for Java that allows us to write tests for our code.  We will be using JUnit 5, which is the latest version of JUnit.

JUnit is not included in the default Maven project, so we need to add it as a dependency.  We can do this by following these steps:

1. Open the `pom.xml` file, right click and select `Generate -> Dependency`
2. In the search box, type `junit-jupiter`
3. From the list of results select `org.junit.jupiter:junit-jupiter:5.XX.XX`, choosing the latest version
4. Click `Add`
5. Save the `pom.xml` file
6. Update the dependencies by right-clicking on the project and selecting `Maven -> Update Project...` or by clicking on the Maven icon update in the top right of the screen
7. You can verify that the dependent files have been downloaded by looking in the `External Libraries` folder in the project

---

## 2. Add Test Coverage to the Project

It is always useful to know how much of our code is covered by tests.  This is known as test coverage.  JUnit does not produce detailed coverage reports, so we need to add another dependency to the project to do this.

> The steps here are taken from [here](https://www.codementor.io/@noelkamphoa/how-to-generate-code-coverage-report-using-jacoco-in-a-java-application-2a3at1ts4l)

1.  After the `</dependencies>` tage but before the `</project>` tag, add the following:

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.11</version>  <!-- Replace with the latest version -->
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
 ```

> It may not be evident that this plugin has been made available in the project
>
> Later, we will use Maven commands to generate the coverage report - either `mvn clean test` or `mvn clean verify` or `mvn jacoco:report`
>
> The report will be generated in the `target/site/jacoco` folder as `index.html`

---

## 3. Create a Test Class and Test Methods

We have an `Engineer` class but no tests for it.  We will create a test class for this class and add some tests for "normal" cases.

1. Create a new package called `com.digitalfuturesacademy.app` in the `src/test/java` folder
2. Create a new class called `EngineerTest` in the new package

> By convention, test classes are named the same as the class they are testing but with the word `Test` appended to it
> 
> They are also usually placed in the same package structure as the `src/main/java` classes but in the `src/test/java` folder

3. Add an _**annotation**_ of `@Test` inside the `EngineerTest` class

> Annotations are a special type of interface that are used to provide metadata about the class or method they are attached to
> The `@Test` annotation is used to indicate that the method is a test method
> It should be imported from `org.junit.jupiter.api.Test`

On the face of it, there appears to be nothing to test in the `Engineer` class as conventionally, _standard constructors_ and _getters_ and _setters_ do not need to be tested.

However, some of the inputs to the constructor and methods will be supplied for the user, so we should definitely ensure that our code can handle erroneous inputs.

For demonstration purposes here, we're going to write a test to check that name is the same as the name set when `constructor` is called.  This is not a test worth writing, but it will demonstrate the process.

4. Under the `@Test` annotation, add the following code:

```java
    import com.digitalfuturesacademy.app.Engineer;

@Test
void testNameSetByConstructor() {
    // Arrange
    String testName = "Jaidon Smith";
    Engineer testEngineer = new Engineer(testName, 25, 74,5, "SE-XXXX-A");
    
    // Act
    String actualName = testEngineer.getName();
    
    // Assert
    assertEquals(testName, actualName);
}
```

You may find that you need to import the `Engineer` class.  You can do this by hovering over the class name and selecting `Import 'Engineer' (com.digitalfuturesacademy.app)` or by pressing `Alt + Enter` and selecting the same option.

You find that you need to import the `assertEquals` method.  You can do this by hovering over the method name and selecting `Import static method 'assertEquals' (org.junit.jupiter.api.Assertions)` or by pressing `Alt + Enter` and selecting the same option.

5. Run the test by right-clicking on the test class and selecting `Run 'EngineerTest'` or using the play button next to the class or method name
6. The test WILL fail...WHY? Fix the error and run the test again to obtain a pass.

---

## 4. Explore Test Coverage

> You will notice that the coverage report has not been generated
> This is because running in IntelliJ like this does not run the Maven commands

1. Right-click on the project, select `Maven -> Run Maven -> test`
2. After the terminal reports `Process finished with exit code 0`, refresh the project and open the `target/site/jacoco/index.html` file in the browser (right-click for `Open with` options)
3. View the report - this will only update when tests are run using Maven commands
4. Add another test that checks that the _engineer's_ **cohort** is set by the constructor:

```java
@Test
public void testCohortIsSetByConstructor() {
    // Arrange
    String testCohort = "SE-XXXX-A";
    Engineer testEngineer = new Engineer("Jaidon Smith", (byte) 25, 74.5, testCohort);

    // Act
    String actualCohort = testEngineer.getCohort();

    // Assert
    assertEquals(testCohort, actualCohort);
}
```

> What effect has this had on the coverage report?

It would be much more efficient at this point to write a test that checks that all the constructor parameters are set correctly.

> The `assertAll` method allows us to group multiple assertions together
> If one of the assertions fails, the others will still be executed
> This is useful when we want to check multiple things about an object
> It should be imported from `org.junit.jupiter.api.Assertions`
> It uses a Java feature called _**lambdas**_ which are not needed for the exam
> - They are akin to Arrow Functions in JavaScript and are used to create anonymous functions that are called in order
> - They are used in the `assertAll` method to create a list of assertions that are executed in order

5. Replace the two tests above with the following:

```java
    @Test
    public void testConstructorSetsValuesWhenValid() {
        // Arrange
        String testName = "Jaidon Smith";
        byte testAge = 25;
        double testTestScoreAverage = 74.5;
        String testCohort = "SE-XXXX-A";
        
        // Act
        Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);
        
        // Assert
        assertAll("Constructor sets values when valid",
                () -> assertEquals(testName, testEngineer.getName()),
                () -> assertEquals(testAge, testEngineer.getAge()),
                () -> assertEquals(testTestScoreAverage, testEngineer.getTestScoreAverage()),
                () -> assertEquals(testCohort, testEngineer.getCohort()));
    }
```

> You should find that this significantly increases the coverage!

---

## 5. Create Edge Case Tests and Implement Exceptions, Defensive Programming and Organise the Tests

We have tested the "normal" cases for the `Engineer` class, but we have not tested the "edge" cases.  These are the cases where the inputs are not what we expect.

For example, would we expect:

- the user's test score average to be greater than 100 or negative?
- the user's cohort to be an empty string, or null or be whitespace?

> _**SIDE-NOTE: Why are we not testing the name or age here???**_  (Hint: `super` must be the first call, so where should we test `name` and `age`?)

We need to decide what we want to happen in these cases.  We could:

- throw an exception
- set the value to a default value
- set the value to null
- set the value to an empty string
- set the value to a random value
- set the value to a value that indicates an error
- set the value to a value that indicates an error and throw an exception

In this instance we will throw an _**EXCEPTION**_ and make sure that this is handled by the caller.

> But what is an _**EXCEPTION**_ and how do we throw one?
> 
> We'll defer to the _**Noodle**_ resources on [Exceptions](https://noodle.digitalfutures.com/mod/page/view.php?id=1646)
> Also, the Java Documentation on [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

1. Write a test in the class that checks that an `IllegalArgumentException` is thrown when the user's cohort is an empty string:

```java
    @Test
    public void testConstructorThrowsExceptionWhenCohortIsEmpty() {
        // Arrange
        String testName = "Jaidon Smith";
        byte testAge = 25;
        double testTestScoreAverage = 74.5;
        String testCohort = "";

        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Engineer(testName, testAge, testTestScoreAverage, testCohort));
    }
```

> The `assertThrows` method allows us to check that an exception is thrown when a method is called
> It should be imported from `org.junit.jupiter.api.Assertions`
> It again uses a Java feature called _**lambdas**_ (which are not needed for the exam but good to know about)

2. Run the test - it SHOULD fail:

```error
   org.opentest4j.AssertionFailedError: Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown.

	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:152)
	at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:73)
	at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:35)
	at org.junit.jupiter.api.Assertions.assertThrows(Assertions.java:3111)
	at com.digitalfutures.app.EngineerTest.testConstructorThrowsExceptionWhenCohortIsEmpty(EngineerTest.java:65)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)


    Process finished with exit code 255
```

IntelliJ suggests why we have the test failure!

> We have no code to do this - we're back in our happy TDD place!

3. Write the code to pass the test - in the `Engineer` class, add the following code to the constructor:

```java
    if (cohort == null || cohort.trim().isEmpty()) {
        throw new IllegalArgumentException("Cohort cannot be null or empty");
    }
```

Here, we check to see if the value of `cohort` is null - which is an acceptable value for a String.
We also use the `trim` string method to remove any trailing or leading whitespace, and use the `isEmpty` method to see if there are any characters left in the string.

> It would be good practice to surround any call the Engineer constructor with a `try...catch` block to handle the exception
> If an Exception is not handled, the program will crash and the user will see a stack trace
> This is known as defensive programming

4. Re-run the test, it should pass and the coverage should be good too!

> We should now write tests for the other edge cases BUT the test class will start to feel unwieldy and the test method names are becoming difficult to read

#### Organise the tests using _**Test Suites**_ and _**Display Names**_

**JUnit** provides 2 annotations that can help the readability and organisation of the tests.

- `@DisplayName` allows us to give a more descriptive name to the test method.  This is useful when the method name is not enough to describe what the test is doing.
- `@Nested` allows us to group tests together in a nested class.  This is useful when we have a lot of tests for a class and we want to group them together.
  - We can also use `@DisplayName` on the nested class to give it a more descriptive name
  - We declare a class inside the outer test class to create a test suite

The `@DisplayName` annotation is used in the Test Report window in IntelliJ and in reports.

1. Create a suite of tests for the constructor by surrounding the current tests in a nested class called `ConstructorTests` and adding the `@Nested` annotation to the class
2. Add a `@DisplayName` annotation to the class with the value `Constructor Tests` in brackets after the annotation
3. Add a `@DisplayName` annotation to each test method with a more readable name (i.e. including whitespace and punctuation)
4. Run the tests and view the report(s)

---

## 6. Create Further Test Cases and Classes

### The `Engineer` Class

We have done some of the testing of the `Engineer` class, but there are still some tests that we need to write:

- Test that the `cohort` is not whitespace in the constructor
- Test that the cohort is in the format `LL-NNNN-L` where `L` is a letter and `N` is a number in the constructor
- Test that the `testScoreAverage` is not less than 0 or greater than 100 in the constructor
- Test that the `testScoreAverage` is not set when an invalid value is passed to the setter

These will cover all the edge and corner cases for the `Engineer` class and should provide us with a good level of confidence in the class.

Obviously we should fix any test failures as we introduce new tests.

> Hint: If available, Copilot is your friend here!

### The `Trainer` Class

We have not tested the `Trainer` class at all.  We should write tests for this class to ensure that it works as expected.

We would follow a similar pattern to that for the `Engineer` class.

### What about INHERITED fields and methods in the `DigitalFuturesPerson` class?

The problem we have here is that we cannot instantiate an abstract class and therefore, _we cannot test the class as a unit_.

The solution is to create an instance of an inheriting class and make sure that any unwanted values throw an exception in the same way as before.

Essentially, follow the same pattern as for `Engineer` and `Trainer` using one of the inheriting classes to instantiate and assert on.

> The full set of tests here can be found in the `src/test/java/com.digitalfuturesacademy.app` folder

---

## Additional Notes

### Test - Constructor rejects cohort when invalid format supplied

The code added to the conditions in the `Engineer` constructor here is similar to:

```java
    if (!cohort.matches("^[a-zA-Z]{2}-\d{4}-[a-zA-Z]$")) {
        throw new IllegalArgumentException("Cohort must be in the format LL-NNNN-L");
    }
```

This uses a _**[regular expression](https://docs.oracle.com/javase/tutorial/essential/regex/index.html)**_ to check that the cohort is in the format `LL-NNNN-L` where `L` is a letter and `N` is a number.

Note: Regular Expression knowledge is not needed for the exam, but it is a useful skill to have.

To explain the regular expression used `^[a-zA-Z]{2}-\\d{4}-[a-zA-Z]$`:

- `^` - the start of the string
- `[a-zA-Z]` - any letter from a to z or A to Z
- `{2}` - exactly 2 of the preceding character
- `-` - a hyphen (must be a hyphen)
- `\d` - any digit
- `{4}` - exactly 4 of the preceding character
- `-` - a hyphen (must be a hyphen)
- `[a-zA-Z]` - any letter from a to z or A to Z
- `$` - the end of the string


