package com.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Cohort {

    private String cohortId;
    private ArrayList<Engineer> engineers;
    private String pathway;
    private Trainer[] trainers;

    public Cohort(String cohortId, String pathway) {
        validateString(cohortId);
        validateString(pathway);
        this.cohortId = cohortId;
        this.pathway = pathway;
        this.engineers = new ArrayList<>();
        this.trainers = new Trainer[3];
    }

    public String getCohortId() {
        return this.cohortId;
    }

    public ArrayList<Engineer> getEngineers() {
        return this.engineers;
    }

    public String getPathway() {
        return this.pathway;
    }

    public Trainer[] getTrainers() {
        return this.trainers;
    }

    public void addEngineer(Engineer engineer) {
        if(engineer == null) {
            throw new IllegalArgumentException("Engineer cannot be null");
        }
        validateEngineer(engineers, engineer);
        if(engineer.getCohort().equals(this.cohortId)) {
            this.engineers.add(engineer);
        }
    }

    public void addTrainer(Trainer trainer) {
        validateTrainer(trainers, trainer);
        if(this.cohortId.equals(trainer.getCurrentCohort())) {
            for (int i = 0; i < this.trainers.length; i++) {
                if (this.trainers[i] == null) {
                    this.trainers[i] = trainer;
                    break;
                }
            }
        }

    }

    private static void validateString(String toValidate) {
        if(toValidate == null || toValidate.trim().isEmpty()) {
            throw new IllegalArgumentException("Property cannot be null or empty");
        }
    }

    private static void validateEngineer(ArrayList<Engineer> engineers, Engineer engineer) {
        if(engineer == null) {
            throw new IllegalArgumentException("Engineer cannot be null");
        }
        validateString(engineer.getCohort());
        if(engineers.contains(engineer)) {
            throw new IllegalArgumentException("Engineer already exists in cohort");
        }
    }

    private static void validateTrainer(Trainer[] trainers, Trainer trainer) {
        if(trainer == null) {
            throw new IllegalArgumentException("Trainer cannot be null");
        }
        validateString(trainer.getCurrentCohort());
        spaceForTrainer(trainers, trainer);
        trainerAlreadyExists(trainers, trainer);
    }
    private static void spaceForTrainer(Trainer[] trainers, Trainer trainer) {
        if (Arrays.stream(trainers).allMatch(obj -> obj != null)) {
            throw new IllegalArgumentException("Cohort trainer allocation is full");
        }
    }

    private static void trainerAlreadyExists(Trainer[] trainers, Trainer trainer) {
        if(Arrays.stream(trainers).allMatch(obj -> obj == trainer)) {
            throw new IllegalArgumentException("Trainer already exists in cohort");
        }
    }

}
