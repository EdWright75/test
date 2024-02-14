package com.digitalfuturesacademy.app;


import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

//        Engineer engineer = new Engineer("Jordan Smith", (byte) 35, 75.5, "Cohort 12");
//
//        engineer.setName("John Smith");
//        engineer.setAge((byte) 21);
//        engineer.setTestScoreAverage(75.5);
//        engineer.setActive(true);
//
//        System.out.println("Engineer ID: " + engineer.getId());
//        System.out.println("Engineer Name: " + engineer.getName());
//        System.out.println("Engineer Age: " + engineer.getAge());
//        System.out.println("Engineer Test Score Average: " + engineer.getTestScoreAverage());
//        System.out.println("Engineer Cohort: " + engineer.getCohort());
//        System.out.println("Engineer Active: " + engineer.isActive());
//
//        Engineer engineer2 = new Engineer("Kaiden Jones", (byte) 21, 92.5, "Cohort 12");
//
//        System.out.println("Engineer ID: " + engineer2.getId());
//        System.out.println("Engineer Name: " + engineer2.getName());
//        System.out.println("Engineer Age: " + engineer2.getAge());
//        System.out.println("Engineer Test Score Average: " + engineer2.getTestScoreAverage());
//        System.out.println("Engineer Cohort: " + engineer2.getCohort());
//        System.out.println("Engineer Active: " + engineer2.isActive());
//
////        System.out.println("Next Engineer ID: " + Engineer.getNextId());
//
//        // Create instances of the Trainer class
//        String[] pathways = {"Software Engineering"};
//        Trainer trainer1 = new Trainer("Ash", (byte) 35, pathways, "Cohort 1");
//
//        pathways = new String[]{"Data Analysis", "Data Engineering"};
//        Trainer trainer2 = new Trainer("Finley", (byte) 28, pathways, "Cohort 2");
//
//        pathways = new String[]{"Cloud Engineering", "Data Engineering"};
//        Trainer trainer3 = new Trainer("Jude", (byte) 32, pathways, "Cohort 2");
//
//        pathways = new String[]{"Data Analysis"};
//        Trainer trainer4 = new Trainer("Riley", (byte) 32, pathways, "Cohort 3");
//
//        // Print out Trainer details
//        System.out.println("Trainer ID: " + trainer1.getId());
//        System.out.println("Trainer Name: " + trainer1.getName());
//        System.out.println("Trainer Age: " + trainer1.getAge());
//        System.out.println("Trainer Pathways: " + trainer1.getPathways());
//        System.out.println("Trainer Cohort: " + trainer1.getCurrentCohort());
//        System.out.println("Trainer Active: " + trainer1.isActive());
//
//        // Add cohorts to trainer1
//        trainer1.addCohort("Cohort 2");
//        trainer1.addCohort("Cohort 3");
//
//        // Print cohorts taught by trainer1
//        for(String cohort : trainer1.getCohortsTaught()) {
//            System.out.println("Trainer Cohort: " + cohort);
//        }
//
//        // What was the first cohort in the list?
//        System.out.println("Trainer First Cohort: " + trainer1.getCohortsTaught().get(0));
//
//        // How many cohorts has trainer1 taught?
//        System.out.println("Trainer Cohort Count: " + trainer1.getCohortsTaught().size());

        // Added in Session 5
        // Declare empties
        Cohort cohort1 = null;
        Cohort cohort2 = null;
        Cohort cohort3 = null;
        ArrayList<Engineer> softwareEngineers = new ArrayList<>();
        ArrayList<Engineer> dataEngineers = new ArrayList<>();
        ArrayList<Engineer> dataAnalysts = new ArrayList<>();
        Trainer[] seTrainers = null;
        Trainer[] deTrainers = null;
        Trainer[] daTrainers = null;

        // Create the new cohorts
        try {
            cohort1 = new Cohort("SE-1234-A", "Software Engineering");
            cohort2 = new Cohort("DE-1234-A", "Data Engineering");
            cohort3 = new Cohort("DA-1234-A", "Data Analytics");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        // Generate the engineers
        try {
            softwareEngineers = AppHelper.generateEngineerList("SE-1234-A");
            dataEngineers = AppHelper.generateEngineerList("DE-1234-A");
            dataAnalysts = AppHelper.generateEngineerList("DA-1234-A");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Add the software engineers to the software engineers cohort
        for(Engineer engineer : softwareEngineers) {
            try {
                if(cohort1 != null) {
                    cohort1.addEngineer(engineer);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Generate the trainers for SE
        seTrainers = AppHelper.generateTrainerArray("Software Engineering", "SE-1234-A");

        // Add the trainers to the cohort
        for(Trainer trainer : seTrainers) {
            try {
                if(cohort1 != null) {
                    cohort1.addTrainer(trainer);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        AppHelper.printCohortDetails(cohort1);

        // Add the data engineers to the data engineers cohort
        for(Engineer engineer : dataEngineers) {
            try {
                if(cohort2 != null) {
                    cohort2.addEngineer(engineer);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Generate the trainers for DE
        deTrainers = AppHelper.generateTrainerArray("Data Engineering", "DE-1234-A");

        // Add the trainers to the cohort
        for(Trainer trainer : deTrainers) {
            try {
                if(cohort2 != null) {
                    cohort2.addTrainer(trainer);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        AppHelper.printCohortDetails(cohort2);

        // Add the data analysts to the data analysts cohort
        for(Engineer engineer : dataAnalysts) {
                    try {
                        if(cohort3 != null) {
                            cohort3.addEngineer(engineer);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
        }

        // Generate the trainers for DA
        daTrainers = AppHelper.generateTrainerArray("Data Analytics", "DA-1234-A");

        // Add the trainers to the cohort
        for(Trainer trainer : daTrainers) {
            try {
                if(cohort3 != null) {
                    cohort3.addTrainer(trainer);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        AppHelper.printCohortDetails(cohort3);

    }
}
