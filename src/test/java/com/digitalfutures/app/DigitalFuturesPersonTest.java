package com.digitalfutures.app;

import com.digitalfuturesacademy.app.Engineer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalFuturesPersonTest {

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
        @DisplayName("Name tests using Engineer")
        class NameTests {

            @Test
            @DisplayName("Constructor throws exception when name is null")
            public void testConstructorThrowsExceptionWhenNameIsNull() {
                // Arrange
                String testName = null;
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }


            @Test
            @DisplayName("Constructor throws exception when name is empty string")
            public void testConstructorThrowsExceptionWhenNameIsEmptyString() {
                // Arrange
                String testName = "";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when name is whitespace")
            public void testConstructorThrowsExceptionWhenNameIsWhitespace() {
                // Arrange
                String testName = " ";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when name does not meet pattern")
            public void testConstructorThrowsExceptionWhenNameDoesNotMeetPattern() {
                // Arrange
                String testName = "Jaidon Smith 123";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when name is too short")
            public void testConstructorThrowsExceptionWhenNameIsTooShort() {
                // Arrange
                String testName = "J";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when symbols are used in name other than hyphen or apostrophe")
            public void testConstructorThrowsExceptionWhenSymbolsAreUsedInNameOtherThanHyphenOrApostrophe() {
                // Arrange
                String testName = "Jaidon Smith!";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor accepts name with apostrophe after first character of first name")
            public void testConstructorAcceptsNameWithApostropheAfterFirstCharacterOfFirstName() {
                // Arrange
                String testName = "D'Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                // Assert
                assertEquals(testName, testEngineer.getName());
            }

            @Test
            @DisplayName("Constructor accepts name with apostrophe after first character of second name")
            public void testConstructorAcceptsNameWithApostropheAfterFirstCharacterOfSecondName() {
                // Arrange
                String testName = "Jaidon O'Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                // Assert
                assertEquals(testName, testEngineer.getName());
            }

            @Test
            @DisplayName("Constructor accepts name with hyphen after second character of first name")
            public void testConstructorAcceptsNameWithHyphenAfterSecondCharacterOfFirstName() {
                // Arrange
                String testName = "Jaidon Smi-th";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                // Assert
                assertEquals(testName, testEngineer.getName());
            }

            @Test
            @DisplayName("Constructor accepts name with hyphen after second character of second name")
            public void testConstructorAcceptsNameWithHyphenAfterSecondCharacterOfSecondName() {
                // Arrange
                String testName = "Jaidon Smi-th";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";

                // Act
                Engineer testEngineer = new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                // Assert
                assertEquals(testName, testEngineer.getName());
            }

            @Test
            @DisplayName("Constructor throws exception if first character of first name is apostrophe")
            public void testConstructorThrowsExceptionIfFirstCharacterOfFirstNameIsApostrophe() {
                // Arrange
                String testName = "'Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if first character of second name is apostrophe")
            public void testConstructorThrowsExceptionIfFirstCharacterOfSecondNameIsApostrophe() {
                // Arrange
                String testName = "Jaidon 'Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if first character of first name is hyphen")
            public void testConstructorThrowsExceptionIfFirstCharacterOfFirstNameIsHyphen() {
                // Arrange
                String testName = "-Jaidon Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if first character of second name is hyphen")
            public void testConstructorThrowsExceptionIfFirstCharacterOfSecondNameIsHyphen() {
                // Arrange
                String testName = "Jaidon -Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if last letter of first name is not a letter")
            public void testConstructorThrowsExceptionIfLastLetterOfFirstNameIsNotALetter() {
                // Arrange
                String testName = "Jaidon1 Smith";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if last letter of second name is not a letter")
            public void testConstructorThrowsExceptionIfLastLetterOfSecondNameIsNotALetter() {
                // Arrange
                String testName = "Jaidon Sm1th";
                byte testAge = 25;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });
            }
        }

        @Nested
        @DisplayName("Age tests")
        class AgeTests {

            @Test
            @DisplayName("Constructor throws exception when age is less than 16")
            public void testConstructorThrowsExceptionWhenAgeIsLessThan16() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 15;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);
                });

            }

            @Test
            @DisplayName("Constructor throws exception when age is greater than 65")
            public void testConstructorThrowsExceptionWhenAgeIsGreaterThan65() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 66;
                double testTestScoreAverage = 74.5;
                String testCohort = "SE-1234-A";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Engineer(testName, testAge, testTestScoreAverage, testCohort);

                });
            }
        }
    }
}
