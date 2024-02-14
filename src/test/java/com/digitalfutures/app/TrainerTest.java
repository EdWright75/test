package com.digitalfutures.app;

import com.digitalfuturesacademy.app.Trainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Nested
    @DisplayName("Constructor tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor sets expected values when valid")
        public void constructorSetsValuesWhenValid() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";

            // Act
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            //Assert
            assertAll("Constructor sets values when valid",
                    () -> assertEquals(testName, testTrainer.getName()),
                    () -> assertEquals(testAge, testTrainer.getAge()),
                    () -> assertEquals(testPathways, testTrainer.getPathways()),
                    () -> assertEquals(testCurrentCohort, testTrainer.getCurrentCohort()));
        }

        @Nested
        @DisplayName("Constructor Pathways Tests")
        class ConstructorPathwaysTests {

            @Test
            @DisplayName("Constructor throws exception if pathways array is null")
            public void testConstructorThrowsExceptionWhenPathwaysIsNull() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = null;
                String testCurrentCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });

            }

            @Test
            @DisplayName("Constructor throws exception if pathways array is empty")
            public void testConstructorThrowsExceptionWhenPathwaysIsEmpty() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {};
                String testCurrentCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });

            }

            @Test
            @DisplayName("Constructor throws exception if pathways array contains null")
            public void testConstructorThrowsExceptionWhenPathwaysContainsNull() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {"Java", null};
                String testCurrentCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if pathways array contains empty string")
            public void testConstructorThrowsExceptionWhenPathwaysContainsEmptyString() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {"Java", ""};
                String testCurrentCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });
            }

            @Test
            @DisplayName("Constructor throws exception if pathways array contains whitespace")
            public void testConstructorThrowsExceptionWhenPathwaysContainsWhitespace() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {"Java", " "};
                String testCurrentCohort = "SE-1234-A";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });
            }
        }

        @Nested
        @DisplayName("Constructor Current Cohort Tests")
        class ConstructorCurrentCohortTests {

            @Test
            @DisplayName("Constructor throws exception if current cohort is null")
            public void testConstructorThrowsExceptionWhenCurrentCohortIsNull() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {"Java", "C#"};
                String testCurrentCohort = null;

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });

            }

            @Test
            @DisplayName("Constructor throws exception if current cohort is empty string")
            public void testConstructorThrowsExceptionWhenCurrentCohortIsEmptyString() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {"Java", "C#"};
                String testCurrentCohort = "";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });

            }

            @Test
            @DisplayName("Constructor throws exception if current cohort is whitespace")
            public void testConstructorThrowsExceptionWhenCurrentCohortIsWhitespace() {
                // Arrange
                String testName = "Jaidon Smith";
                byte testAge = 25;
                String[] testPathways = {"Java", "C#"};
                String testCurrentCohort = " ";

                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Trainer(testName, testAge, testPathways, testCurrentCohort);
                });
            }
        }
    }

    @Nested
    @DisplayName("Set Pathways Tests")
    class SetPathwaysTests {

        @Test
        @DisplayName("Set Pathways throws exception if pathways array is null")
        public void testSetPathwaysThrowsExceptionWhenPathwaysIsNull() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setPathways(null);
            });
        }

        @Test
        @DisplayName("Set Pathways throws exception if pathways array is empty")
        public void testSetPathwaysThrowsExceptionWhenPathwaysIsEmpty() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setPathways(new String[]{});
            });
        }

        @Test
        @DisplayName("Set Pathways throws exception if pathways array contains null")
        public void testSetPathwaysThrowsExceptionWhenPathwaysContainsNull() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setPathways(new String[]{"Java", null});
            });
        }

        @Test
        @DisplayName("Set Pathways throws exception if pathways array contains empty string")
        public void testSetPathwaysThrowsExceptionWhenPathwaysContainsEmptyString() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setPathways(new String[]{"Java", ""});
            });
        }

        @Test
        @DisplayName("Set Pathways throws exception if pathways array contains whitespace")
        public void testSetPathwaysThrowsExceptionWhenPathwaysContainsWhitespace() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setPathways(new String[]{"Java", " "});
            });
        }

        @Test
        @DisplayName("Set Pathways changes with valid new pathways")
        public void testSetPathwaysChangesWithValidNewPathways() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);
            String[] newPaths = {"Data Engineering", "Data Analysis"};

            // Act
            testTrainer.setPathways(newPaths);

            // Assert
            assertEquals(newPaths, testTrainer.getPathways());
        }
    }

    @Nested
    @DisplayName("Set Current Cohort Tests")
    class SetCurrentCohortTests {

        @Test
        @DisplayName("Set Current Cohort throws exception if current cohort is null")
        public void testSetCurrentCohortThrowsExceptionWhenCurrentCohortIsNull() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setCurrentCohort(null);
            });
        }

        @Test
        @DisplayName("Set Current Cohort throws exception if current cohort is empty string")
        public void testSetCurrentCohortThrowsExceptionWhenCurrentCohortIsEmptyString() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setCurrentCohort("");
            });
        }

        @Test
        @DisplayName("Set Current Cohort throws exception if current cohort is whitespace")
        public void testSetCurrentCohortThrowsExceptionWhenCurrentCohortIsWhitespace() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.setCurrentCohort(" ");
            });
        }

        @Test
        @DisplayName("Set Current Cohort changes with valid new current cohort")
        public void testSetCurrentCohortChangesWithValidNewCurrentCohort() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java", "C#"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);
            String newCurrentCohort = "SE-1234-B";

            // Act
            testTrainer.setCurrentCohort(newCurrentCohort);

            // Assert
            assertEquals(newCurrentCohort, testTrainer.getCurrentCohort());
        }
    }

    @Nested
    @DisplayName("addCohort Tests")
    class AddCohortTaughtTests {

        @Test
        @DisplayName("addCohort throws exception if cohort is null")
        public void testAddCohortTaughtThrowsExceptionWhenCohortIsNull() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.addCohort(null);
            });
        }

        @Test
        @DisplayName("addCohort throws exception if cohort is empty string")
        public void testAddCohortTaughtThrowsExceptionWhenCohortIsEmptyString() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.addCohort("");
            });
        }

        @Test
        @DisplayName("addCohort throws exception if cohort is whitespace")
        public void testAddCohortTaughtThrowsExceptionWhenCohortIsWhitespace() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testTrainer.addCohort(" ");
            });
        }

        @Test
        @DisplayName("addCohort adds valid cohort")
        public void testAddCohortTaughtAddsValidCohort() {
            // Arrange
            String testName = "Jaidon Smith";
            byte testAge = 25;
            String[] testPathways = {"Java"};
            String testCurrentCohort = "SE-1234-A";
            Trainer testTrainer = new Trainer(testName, testAge, testPathways, testCurrentCohort);
            String newCohort = "SE-1234-B";

            // Act
            testTrainer.addCohort(newCohort);

            // Assert
            assertTrue(testTrainer.getCohortsTaught().contains(newCohort));
        }
    }
}
