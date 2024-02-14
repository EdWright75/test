package com.digitalfuturesacademy.app;

public class Engineer extends DigitalFuturesPerson {

    private static int nextId = 1;
    private double testScoreAverage;
    private String cohort;

    public Engineer(String name, byte age, double testScoreAverage, String cohort) {
        super(nextId++, name, age);
        validateCohort(cohort);
        validateTestScoreAverage(testScoreAverage);
        this.testScoreAverage = testScoreAverage;
        this.cohort = cohort;
    }

    public double getTestScoreAverage() {
        return testScoreAverage;
    }

    public void setTestScoreAverage(double testScoreAverage) {
        validateTestScoreAverage(testScoreAverage);
        this.testScoreAverage = testScoreAverage;
    }

    public String getCohort() {
        return cohort;
    }

    private static void validateCohort(String cohort) {
        if(cohort == null || cohort.isEmpty() || !cohort.trim().matches("^[a-zA-Z]{2}-\\d{4}-[a-zA-Z]$")) {
            throw new IllegalArgumentException("cohort cannot be null or empty or must match the patten 'LL-NNNN-L'");
        }
    }

    private static void validateTestScoreAverage(double testScoreAverage) {
        if(testScoreAverage < 0 || testScoreAverage > 100) {
            throw new IllegalArgumentException("testScoreAverage must be between 0 and 100");
        }
    }

}
