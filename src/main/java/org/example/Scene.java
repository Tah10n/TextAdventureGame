package org.example;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scene)) return false;

        Scene scene = (Scene) o;

        if (getLocation() != scene.getLocation()) return false;
        if (getDescription() != null ? !getDescription().equals(scene.getDescription()) : scene.getDescription() != null)
            return false;
        return getActions() != null ? getActions().equals(scene.getActions()) : scene.getActions() == null;
    }

    @Override
    public int hashCode() {
        int result = getLocation() != null ? getLocation().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getActions() != null ? getActions().hashCode() : 0);
        return result;
    }
}
