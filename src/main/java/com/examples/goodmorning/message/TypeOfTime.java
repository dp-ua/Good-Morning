package com.examples.goodmorning.message;

public enum TypeOfTime {
    MORNIGN("Good morning, World!"),
    DAY("Good day, World!"),
    EVENING("Good evening, World!"),
    NIGHT("Good night, World!");

    private String description;

    TypeOfTime(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
