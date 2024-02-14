package com.digitalfuturesacademy.app;

public abstract class DigitalFuturesPerson {

    protected int id;
    protected String name;
    protected byte age;
    protected boolean isActive;

    public DigitalFuturesPerson(int id, String name, byte age) {
        validateName(name);
        validateAge(age);
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setAge(byte age) {
        validateAge(age);
        this.age = age;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private static void validateName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if(!name.trim().matches("^[a-zA-Z][a-zA-Z'-]*[a-zA-Z] [a-zA-Z][a-zA-Z'-]*[a-zA-Z]$")) {
            throw new IllegalArgumentException("name must only contain letters, hyphens, apostrophes and spaces");
        }
    }

    private static void validateAge(byte age) {
        if(age <= 16 || age > 65) {
            throw new IllegalArgumentException("age must be between 16 and 65");
        }
    }
}
