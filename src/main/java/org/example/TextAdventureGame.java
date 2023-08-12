package org.example;

import java.util.Random;

public class TextAdventureGame {

    private final SceneContainer sceneContainer = new SceneContainer();
    private Scene currentScene;
    private boolean isDwarfsMet = false;
    private boolean gameEnded = false;
    private Random random = new Random();

    public TextAdventureGame() {
        resetGame();
        currentScene = changeScene("пойти в хоббитон");

    }

    public void resetGame() {
        gameEnded = false;
        isDwarfsMet = false;

    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public boolean isDwarfsMet() {
        return isDwarfsMet;
    }

    public Scene changeScene(String action) {
        Scene outScene = sceneContainer.getScene(action.toLowerCase(), 0);
        if (action.equalsIgnoreCase("выпить пива")) {
            isDwarfsMet = false;
        }

        if (action.equalsIgnoreCase("дождаться друзей")) {
            isDwarfsMet = true;
        }

        if (action.equalsIgnoreCase("пойти к одинокой горе")) {
            if (isDwarfsMet) {
                outScene = sceneContainer.getScene(action.toLowerCase(), 1);
            }
        }

        if (action.equalsIgnoreCase("рискнуть и забрать сокровища у дракона")) {

            int chance = random.nextInt(10);

            if (chance > 8) {

                outScene = sceneContainer.getScene(action.toLowerCase(), 1);
            }
            gameEnded = true;
        }

        this.currentScene = outScene;
        return outScene;

    }
}