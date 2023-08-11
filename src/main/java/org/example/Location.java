package org.example;

public enum Location {
    HOBBITON("Хоббитон"),
    TAVERN("Таверна"),
    LONELY_MOUNTAIN("Одинокая гора");


    private final String title;

    public String getTitle() {
        return title;
    }

    Location(String title) {
        this.title = title;
    }

}
