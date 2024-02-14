package com.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Trainer extends DigitalFuturesPerson {

    private static int nextId = 1;
    private String[] pathways;
    private String currentCohort;
    private ArrayList<String> cohortsTaught = new ArrayList<>();


    public Trainer(String name, byte age, String[] pathways, String currentCohort) {
        super(nextId++, name, age);
        validatePathways(pathways);
        validateCohort(currentCohort);
        this.pathways = pathways;
        this.currentCohort = currentCohort;
        this.cohortsTaught.add(currentCohort);
    }

    public String[] getPathways() {
        return pathways;
    }

    public void setPathways(String[] pathways) {
        validatePathways(pathways);
        this.pathways = pathways;
    }

    public String getCurrentCohort() {
        return currentCohort;
    }

    public void setCurrentCohort(String currentCohort) {
        validateCohort(currentCohort);
        this.currentCohort = currentCohort;
    }

    public ArrayList<String> getCohortsTaught() {
        return cohortsTaught;
    }

    public void addCohort(String cohort) {
        validateCohort(cohort);
        this.cohortsTaught.add(cohort);
    }

    private static void validatePathways(String[] pathways) {
        if(pathways == null || pathways.length == 0 || Arrays.stream(pathways).anyMatch(str -> str == null || str.trim().isEmpty())) {
            throw new IllegalArgumentException("pathways cannot be null or empty");
        }
    }

    private static void validateCohort(String currentCohort) {
        if(currentCohort == null || currentCohort.trim().isEmpty()) {
            throw new IllegalArgumentException("currentCohort cannot be null or empty");
        }
    }
}
