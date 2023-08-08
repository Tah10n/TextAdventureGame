package org.example;

public class TextAdventureGame {

    private Location curLocation;
    private Scene curScene;
    private boolean dragonDefeated;

    public TextAdventureGame(Scene scene) {

        curLocation = scene.getLocation();
        curScene = scene;
        resetGame();
    }


    private void resetGame() {
        curLocation = Location.HOBBITON;
        dragonDefeated = false;
    }

    public Location getCurrentLocation() {
        return curLocation;
    }

    public Scene getCurScene() {
        return curScene;
    }

    public void setCurSceneAndLocation(Scene curScene) {
        this.curScene = curScene;
        this.curLocation = curScene.getLocation();
    }



    public boolean isDragonDefeated() {
        return dragonDefeated;
    }


    public Scene travelToScene(String action) {
        Location location = null;
        switch (action.toLowerCase()) {
            case "пойти к таверне":
                location = Location.TAVERN;
                break;
            case "пойти к одинокой горе":

                location = Location.LONELY_MOUNTAIN;


                break;
            case "пойти в хоббитон":
                location = Location.HOBBITON;
                break;

        }
        Scene outScene = new Scene(location);

        return outScene;
    }
}