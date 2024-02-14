package com.digitalfutures.app;

import com.digitalfuturesacademy.app.Cohort;
import com.digitalfuturesacademy.app.Engineer;
import com.digitalfuturesacademy.app.Trainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CohortTest {

    @Nested
    @DisplayName("Cohort Constructor Tests")

    class CohortConstructorTests {

        @Test
        public void testConstructorReturnsExpectedValues() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            // Act
            // Assert
            assertAll(
                    () -> assertEquals("SE-1234-A", cohort.getCohortId()),
                    () -> assertEquals("Software Engineering", cohort.getPathway()),
                    () -> assertEquals(0, cohort.getEngineers().size()),
                    () -> assertEquals(3, cohort.getTrainers().length)
            );
        }

        @Nested
        @DisplayName(("Constructor CohortId tests"))
        class ConstructorCohortIdTests {
            @Test
            @DisplayName("Test cohort constructor throws IllegalArgumentException when cohortId is null")
            public void testCohortConstructorThrowsIllegalArgumentExceptionWhenCohortIdIsNull() {
                // Arrange
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Cohort(null, "Software Engineering");
                });
            }

            @Test
            @DisplayName("Test cohort constructor throws IllegalArgumentException when cohortId is empty string")
            public void testCohortConstructorThrowsIllegalArgumentExceptionWhenCohortIdIsEmptyString() {
                // Arrange
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Cohort("", "Software Engineering");
                });
            }

            @Test
            @DisplayName("Test cohort constructor throws IllegalArgumentException when cohortId is whitespace")
            public void testCohortConstructorThrowsIllegalArgumentExceptionWhenPathwayIsWhitespace() {
                // Arrange
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Cohort(" ", "JavSoftware Engineering");
                });
            }
        }

        @Nested
        @DisplayName(("Constructor Pathway tests"))
        class ConstructorPathwayTests {
            @Test
            @DisplayName("Test cohort constructor throws IllegalArgumentException when pathway is null")
            public void testCohortConstructorThrowsIllegalArgumentExceptionWhenPathwayIsNull() {
                // Arrange
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Cohort("SE-1234-A", null);
                });
            }

            @Test
            @DisplayName("Test cohort constructor throws IllegalArgumentException when pathway is empty string")
            public void testCohortConstructorThrowsIllegalArgumentExceptionWhenPathwayIsEmptyString() {
                // Arrange
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Cohort("SE-1234-A", "");
                });
            }

            @Test
            @DisplayName("Test cohort constructor throws IllegalArgumentException when pathway is whitespace")
            public void testCohortConstructorThrowsIllegalArgumentExceptionWhenPathwayIsWhitespace() {
                // Arrange
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Cohort("SE-1234-A", " ");
                });
            }
        }
    }

    @Nested
    @DisplayName("Cohort AddEngineer Tests")
    class CohortAddEngineerTests {
        @Test
        @DisplayName("Test addEngineer throws IllegalArgumentException when engineer is null")
        public void testAddEngineerThrowsIllegalArgumentExceptionWhenEngineerIsNull() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                cohort.addEngineer(null);
            });
        }

        @Test
        @DisplayName("Test addEngineer throws IllegalArgumentException when engineer cohort is null")
        public void testAddEngineerThrowsIllegalArgumentExceptionWhenEngineerCohortIsNull() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Engineer engineer = mock(Engineer.class);
            when(engineer.getCohort()).thenReturn(null);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                // Need to make sure the Engineer class returns null for getCohort()
                cohort.addEngineer(engineer);
            });
        }

        @Test
        @DisplayName("Test addEngineer throws IllegalArgumentException when engineer cohort is empty string")
        public void testAddEngineerThrowsIllegalArgumentExceptionWhenEngineerCohortIsEmptyString() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Engineer engineer = mock(Engineer.class);
            when(engineer.getCohort()).thenReturn("");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                // Need to make sure the Engineer class returns null for getCohort()
                cohort.addEngineer(engineer);
            });
        }

        @Test
        @DisplayName("Test addEngineer throws IllegalArgumentException when engineer cohort is whitespace")
        public void testAddEngineerThrowsIllegalArgumentExceptionWhenEngineerCohortIsWhitespace() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Engineer engineer = mock(Engineer.class);
            when(engineer.getCohort()).thenReturn(" ");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                // Need to make sure the Engineer class returns null for getCohort()
                cohort.addEngineer(engineer);
            });
        }

        @Test
        @DisplayName("Test addEngineer adds engineer to cohort when engineer cohort matches cohortId")
        public void testAddEngineerAddsEngineerToCohortWhenEngineerCohortMatchesCohortId() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Engineer engineer = mock(Engineer.class);
            when(engineer.getCohort()).thenReturn("SE-1234-A");
            // Act
            cohort.addEngineer(engineer);
            // Assert
            assertEquals(1, cohort.getEngineers().size());
        }

        @Test
        @DisplayName("Test addEngineer does not add engineer to cohort when engineer cohort does not match cohortId")
        public void testAddEngineerDoesNotAddEngineerToCohortWhenEngineerCohortDoesNotMatchCohortId() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Engineer engineer = mock(Engineer.class);
            when(engineer.getCohort()).thenReturn("SE-1234-B");
            // Act
            cohort.addEngineer(engineer);
            // Assert
            assertEquals(0, cohort.getEngineers().size());
        }

        @Test
        @DisplayName("Test addEngineer does not add engineer to cohort when engineer is already in cohort")
        public void testAddEngineerDoesNotAddEngineerToCohortWhenEngineerIsAlreadyInCohort() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Engineer engineer = mock(Engineer.class);
            when(engineer.getCohort()).thenReturn("SE-1234-A");
            // Act
            cohort.addEngineer(engineer);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                cohort.addEngineer(engineer);
            });
        }
    }

    @Nested
    @DisplayName("Cohort AddTrainer Tests")
    class CohortAddTrainerTests {

        @Test
        public void testAddTrainerAddsTrainerWithValidCohortId() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Trainer trainer = mock(Trainer.class);
            when(trainer.getCurrentCohort()).thenReturn("SE-1234-A");

            // Act
            cohort.addTrainer(trainer);

            // Assert
            assertAll(
                    () -> assertEquals(cohort.getTrainers().length, 3),
                    () -> assertEquals(cohort.getTrainers()[0], trainer)
            );
        }

        @Test
        @DisplayName("Test addTrainer throws IllegalArgumentException when trainer is null")
        public void testAddTrainerThrowsIllegalArgumentExceptionWhenTrainerIsNull() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                cohort.addTrainer(null);
            });
        }

        @Test
        @DisplayName("Test addTrainer throws IllegalArgumentException when trainer currentCohort is null")
        public void testAddTrainerThrowsIllegalArgumentExceptionWhenTrainerCurrentCohortIsNull() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Trainer trainer = mock(Trainer.class);
            when(trainer.getCurrentCohort()).thenReturn(null);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                // Need to make sure the Trainer class returns null for getCurrentCohort()
                cohort.addTrainer(trainer);
            });
        }

        @Test
        @DisplayName("Test addTrainer throws IllegalArgumentException when trainer currentCohort is empty string")
        public void testAddTrainerThrowsIllegalArgumentExceptionWhenTrainerCurrentCohortIsEmptyString() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Trainer trainer = mock(Trainer.class);
            when(trainer.getCurrentCohort()).thenReturn("");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                // Need to make sure the Trainer class returns null for getCurrentCohort()
                cohort.addTrainer(trainer);
            });
        }

        @Test
        @DisplayName("Test addTrainer throws IllegalArgumentException when trainer currentCohort is whitespace")
        public void testAddTrainerThrowsIllegalArgumentExceptionWhenTrainerCurrentCohortIsWhitespace() {
            // Arrange
            Cohort cohort = new Cohort("SE-1234-A", "Software Engineering");
            Trainer trainer = mock(Trainer.class);
            when(trainer.getCurrentCohort()).thenReturn(" ");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                // Need to make sure the Trainer class returns null for getCurrentCohort()
                cohort.addTrainer(trainer);
            });
        }
    }
}
