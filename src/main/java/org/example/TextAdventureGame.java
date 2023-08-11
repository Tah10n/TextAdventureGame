package org.example;

import java.util.Random;

public class TextAdventureGame {

    private Scene currentScene;
    private boolean isDwarfsMet = false;
    private boolean gameEnded = false;
    private final SceneFactory sceneFactory = new SceneFactory();

    public TextAdventureGame() {
        resetGame();
        currentScene = changeScene("пойти в хоббитон");

    }

    private void resetGame() {
        gameEnded = false;
        isDwarfsMet = false;

    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
    public boolean isDwarfsMet() { return isDwarfsMet;}

    public Scene changeScene(String action) {
        Scene outScene = sceneFactory.getScene(action.toLowerCase(), 0);
        if (action.equalsIgnoreCase("выпить пива")) {
            isDwarfsMet = false;
        }

        if (action.equalsIgnoreCase("дождаться друзей")) {
            isDwarfsMet = true;
        }

        if (action.equalsIgnoreCase("пойти к одинокой горе")) {
            if(isDwarfsMet) {
                outScene = sceneFactory.getScene(action.toLowerCase(), 1);
            }
        }

        if (action.equalsIgnoreCase("рискнуть и забрать сокровища у дракона")) {
            Random random = new Random();
            int chance = random.nextInt(10);

            if(chance > 8) {
                gameEnded = true;
                outScene = sceneFactory.getScene(action.toLowerCase(), 1);
            }
        }

        this.currentScene = outScene;
        return outScene;

    }
}