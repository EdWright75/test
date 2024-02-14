package com.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AppHelper {

    public static void printEngineerDetails(Engineer engineer) {
        System.out.println("Engineer ID: " + engineer.getId());
        System.out.println("Engineer Name: " + engineer.getName());
        // Alternative: use the printf method
        // System.out.printf("Engineer Name: %s%n", engineer.getName());
        // This will print the name and place the cursor on a new line
        System.out.println("Engineer Age: " + engineer.getAge());
        // Alternative: use the printf method
        // System.out.printf("Engineer Age: %d%n", engineer.getAge());
        // This will print the age as an integer and place the cursor on a new line
        System.out.println("Engineer Test Score Average: " + engineer.getTestScoreAverage());
        // Alternative: use the printf method
        // System.out.printf("Engineer Test Score Average: %.2f%n", engineer.getTestScoreAverage());
        // This will print the test score average to 2 decimal places and place the cursor on a new line
        System.out.println("Engineer Cohort: " + engineer.getCohort());
        // Alternative: Use the String.format method
        // String engineerCohort = String.format("Engineer Cohort: %s", engineer.getCohort());
        // The print out the formatted string
        // System.out.println(engineerCohort);
        System.out.println("Engineer Active: " + engineer.isActive());
    }

    public static void printTrainerDetails(Trainer trainer) {
        System.out.println("Trainer ID: " + trainer.getId());
        System.out.println("Trainer Name: " + trainer.getName());
        System.out.println("Trainer Age: " + trainer.getAge());
        System.out.println("Trainer Pathways: " + Arrays.toString(trainer.getPathways()));
        System.out.println("Trainer Cohort: " + trainer.getCurrentCohort());
        System.out.println("Trainer Active: " + trainer.isActive());
    }

    public static void printCohortDetails(Cohort cohort) {
        System.out.println("Cohort ID: " + cohort.getCohortId());
        System.out.println("Cohort Pathway: " + cohort.getPathway());
        System.out.println("Cohort Engineers: ====================");
        for(Engineer engineer : cohort.getEngineers()) {
            if(engineer == null) continue;
            printEngineerDetails(engineer);
            System.out.println("--------------------");
        }
        System.out.println("Cohort Trainers: ====================");
        for(Trainer trainer : cohort.getTrainers()) {
            if(trainer == null) continue;
            printTrainerDetails(trainer);
            System.out.println("--------------------");
        }
    }

    public static ArrayList<Engineer> generateEngineerList (String cohortId) {
        ArrayList<Engineer> engineers = new ArrayList<>();
        engineers.add(new Engineer("Jordan Smith", (byte) 21, 75.5, cohortId));
        engineers.add(new Engineer("Kaiden Jones", (byte) 21, 92.5, cohortId));
        engineers.add(new Engineer("Riley Williams", (byte) 21, 85.5, cohortId));
        engineers.add(new Engineer("Finley Brown", (byte) 21, 65.5, cohortId));
        engineers.add(new Engineer("Charlie Taylor", (byte) 21, 75.5, cohortId));
        engineers.add(new Engineer("Jude Davies", (byte) 21, 75.5, cohortId));
        engineers.add(new Engineer("Ashley Evans", (byte) 21, 75.5, cohortId));
        engineers.add(new Engineer("Morgan Thomas", (byte) 21, 75.5, cohortId));
        engineers.add(new Engineer("Alex Johnson", (byte) 21, 75.5, cohortId));
        engineers.add(new Engineer("River Wilson", (byte) 21, 75.5, cohortId));
        return engineers;
    }

    public static Trainer[] generateTrainerArray(String pathway, String currentCohort) {
        if(pathway.equals("Software Engineering")) {
            return new Trainer[] {new Trainer("Ash Ahmed", (byte) 35, new String[]{pathway}, currentCohort)
            };
        }
        if(pathway.equals("Data Analytics")) {
            return new Trainer[] {
                    new Trainer("Finley Hitchin", (byte) 28, new String[]{pathway}, currentCohort),
                    new Trainer("Riley Lopez", (byte) 32, new String[]{pathway, "Data Engineering"}, currentCohort)
            };
        }
        if(pathway.equals("Data Engineering")) {
            return new Trainer[]{
                    new Trainer("Jude Witkiewicz", (byte) 32, new String[]{pathway}, currentCohort),
                    new Trainer("Riley Lopez", (byte) 32, new String[]{pathway, "Data Analysis"}, currentCohort),
                    new Trainer("Jai Sharma", (byte) 35, new String[]{pathway}, currentCohort)
            };
        }
        return new Trainer[3];
    }
}
