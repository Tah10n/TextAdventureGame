package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private Location location;
    private String description;
    private List<String> actions;

    public Scene(Location location) {
        this.location = location;

        switch (this.location) {
            case TAVERN:
                description = "Вы находитесь в таверне 'Подвесной Котел'.";
                actions = new ArrayList<>();
                actions.add("пойти к Одинокой горе");
                actions.add("пойти в Хоббитон");
                break;
            case LONELY_MOUNTAIN:
                description = "Вы стоите перед Одинокой Горой, где обитает дракон Смауг.";
                actions = new ArrayList<>();
                actions.add("пойти к таверне");
                actions.add("пойти в Хоббитон");
                break;
            case HOBBITON:
                description = "Вы находитесь в уютном доме в Хоббитоне.";
                actions = new ArrayList<>();
                actions.add("пойти к таверне");
                actions.add("пойти к Одинокой горе");
                break;
            default:
                description = "Неизвестное местоположение.";
                actions = new ArrayList<>();
                actions.add("пойти к таверне");
                actions.add("пойти в Хоббитон");
        }
    }

    public Location getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getActions() {
        return actions;
    }
}
