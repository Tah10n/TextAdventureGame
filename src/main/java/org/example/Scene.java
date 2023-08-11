package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private final Location location;
    private final String description;
    private final List<String> actions;

    public Scene(Location location, String description, List<String> actions) {
        this.location = location;
        this.description = description;
        this.actions = actions;
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
