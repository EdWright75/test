package com.digitalfutures.app;

import com.digitalfuturesacademy.app.Engineer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest {

//    @Test
//    void testNameSetByConstructor() {
//        // Arrange
//        String testName = "Jaidon Smith";
//        Engineer testEngineer = new Engineer(testName, (byte)25, 74.5, "SE-XXXX-A");
//
//        // Act
//        String actualName = testEngineer.getName();
//
//        // Assert
//        assertEquals(testName, actualName);
//    }
//
//    @Test
//    public void testCohortIsSetByConstructor() {
//        // Arrange
//        String testCohort = "SE-XXXX-A";
//        Engineer testEngineer = new Engineer("Jaidon Smith", (byte)25, 74.5, testCohort);
//
//        // Act
//        String actualCohort = testEngineer.getCohort();
//
//        // Assert
//        assertEquals(testCohort, actualCohort);
//    }

    @Nested
    @DisplayName("Constructor tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor sets expected values when valid")
        public void testConstructorSetsValuesWhenValid() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            double testTestScoreAverage = 74.5;
            String testCohort = "SE-1234-A";

            // Act
            Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

            // Assert
            assertAll("Constructor sets values when valid",
                    () -> assertEquals(testName, testEngineer.getName()),
                    () -> assertEquals(testAge, testEngineer.getAge()),
                    () -> assertEquals(testTestScoreAverage, testEngineer.getTestScoreAverage()),
                    () -> assertEquals(testCohort, testEngineer.getCohort()));
        }

        @Nested
        @DisplayName("Constructor cohort tests")
        class ConstructorCohortTests {
            @Test
            @DisplayName("Constructor throws exception when cohort is null")
            public void testConstructorThrowsExceptionWhenCohortIsNull() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = null;

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Engineer(testName, testAge, testTestScoreAverage, testCohort));
            }

            @Test
            @DisplayName("Constructor throws exception when cohort is an empty string")
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

            @Test
            @DisplayName("Constructor throws exception when cohort is whitespace")
            public void testConstructorThrowsExceptionWhenCohortIsWhitespace() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = " ";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Engineer(testName, testAge, testTestScoreAverage, testCohort));
            }

            @Test
            @DisplayName("Constructor rejects cohort when invalid format supplied")
            public void testConstructorRejectsCohortWhenInvalidFormatSupplied() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-XXXX";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Engineer(testName, testAge, testTestScoreAverage, testCohort));
            }
        }

        @Nested
        @DisplayName("Constructor test score average tests")
        class ConstructorTestScoreAverageTests {

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when test score average is less than zero")
            public void testConstructorThrowsIllegalArgumentExceptionWhenTestScoreAverageIsLessThanZero() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = -1;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Engineer(testName, testAge, testTestScoreAverage, testCohort));
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when test score average is greater than one hundred")
            public void testConstructorThrowsIllegalArgumentExceptionWhenTestScoreAverageIsGreaterThanOneHundred() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 101;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Engineer(testName, testAge, testTestScoreAverage, testCohort));
            }
        }

        @Nested
        @DisplayName("Test Score Average Setter Tests")
        class TestScoreAverageSetterTests {

            @Test
            @DisplayName("Test Score Average setter sets expected value when valid")
            public void testTestScoreAverageSetterSetsExpectedValueWhenValid() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                double expectedTestScoreAverage = 75.5;

                // Act
                testEngineer.setTestScoreAverage(expectedTestScoreAverage);
                double actualTestScoreAverage = testEngineer.getTestScoreAverage();

                // Assert
                assertEquals(expectedTestScoreAverage, actualTestScoreAverage);
            }

            @Test
            @DisplayName("Test Score Average setter throws IllegalArgumentException when test score average is less than zero")
            public void testTestScoreAverageSetterThrowsIllegalArgumentExceptionWhenTestScoreAverageIsLessThanZero() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> testEngineer.setTestScoreAverage(-1));
            }

            @Test
            @DisplayName("Test Score Average setter throws IllegalArgumentException when test score average is greater than one hundred")
            public void testTestScoreAverageSetterThrowsIllegalArgumentExceptionWhenTestScoreAverageIsGreaterThanOneHundred() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> testEngineer.setTestScoreAverage(101));
            }
        }
    }
}
