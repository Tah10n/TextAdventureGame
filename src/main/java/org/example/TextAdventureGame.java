package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextAdventureGame {

    private Scene currentScene;

    private boolean isDwarfsMet = false;
    private boolean gameEnded = false;


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


    public Scene changeScene(String action) {
        Location location;
        String description;
        List<String> actions = new ArrayList<>();

        switch (action.toLowerCase()) {
            case "пойти к таверне":
                location = Location.TAVERN;
                description = "Вы находитесь в таверне 'Подвесной Котел'.";
                actions.add("Выпить пива");
                actions.add("Пойти к Одинокой горе");
                actions.add("Пойти в Хоббитон");
                break;

            case "пойти к одинокой горе":
                location = Location.LONELY_MOUNTAIN;
                if (isDwarfsMet) {
                    description = "Благодаря собранной команде вы нашли вход в гору!";
                    actions.add("Рискнуть и забрать сокровища у дракона");
                    actions.add("Не рисковать");
                    break;
                } else {
                    description = "Вы стоите перед Одинокой Горой, где обитает дракон Смауг.";
                    actions.add("Пойти к таверне");
                    actions.add("Пойти в Хоббитон");
                    break;
                }

            case "закурить трубку":
                location = Location.HOBBITON;
                description = "Пока вы пускали колечки дыма, к вам подошел высокий незнакомец";
                actions.add("Пожелать доброго утра незнакомцу");
                actions.add("Не обращать на него внимания");
                break;

            case "пожелать доброго утра незнакомцу":
                location = Location.HOBBITON;
                description = "У вас произошел странный разговор, в процессе которого незнакомец предложил вам поучаствовать в приключении";
                actions.add("Принять приглашение");
                actions.add("Отказаться");
                break;

            case "принять приглашение":
                location = Location.TAVERN;
                description = "Незнакомец рассказал вам о сокровище, спрятанном в одинокой горе, но для его поисков надо дождаться друзей в таверне";
                actions.add("Дождаться друзей");
                actions.add("Выпить пива");
                actions.add("Пойти в Хоббитон");
                break;

            case "выпить пива":
                location = Location.HOBBITON;
                description = "После пива вы очнулись в своей кровати, не помня чем закончился вчерашний вечер";
                isDwarfsMet = false;
                actions.add("Пойти к таверне");
                actions.add("Пойти к Одинокой горе");
                actions.add("Закурить трубку");
                break;

            case "дождаться друзей":
                location = Location.TAVERN;
                description = "К вам присоеденились Двалин, Балин, Кили, Фили, Дори, Нори, Ори, Ойн, Глойн, Бифур, Бофур, Бомбур и Торин";
                actions.add("Пойти к Одинокой горе");
                actions.add("Выпить пива");
                actions.add("Пойти в Хоббитон");
                isDwarfsMet = true;
                break;

            case "рискнуть и забрать сокровища у дракона":
                location = Location.LONELY_MOUNTAIN;
                Random random = new Random();
                int chance = random.nextInt(10);
                if (chance < 8) {
                    gameEnded = true;
                    description = "У вас получилось забрать сокровище! Победа!";
                    break;
                } else {
                    gameEnded = true;
                    description = "К сожалению, вас съел дракон";
                    break;
                }

            case "пойти в хоббитон":

            default:
                location = Location.HOBBITON;
                description = "Вы находитесь в уютном доме в Хоббитоне.";
                actions = new ArrayList<>();
                actions.add("Пойти к таверне");
                actions.add("Пойти к Одинокой горе");
                actions.add("Закурить трубку");
                break;
        }
        Scene outScene = new Scene(location, description, actions);
        this.currentScene = outScene;
        return outScene;

    }
}