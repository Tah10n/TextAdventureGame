package org.example;

import java.util.*;

public class SceneFactory {
    private final Map<String, List<Scene>> scenes = new HashMap<>();

    {
        scenes.put("пойти к таверне", Arrays.asList(
                new Scene(Location.TAVERN,
                        "Вы находитесь в таверне 'Подвесной Котел'.",
                        List.of("Выпить пива", "Пойти к Одинокой горе", "Пойти в Хоббитон"))));

        scenes.put("пойти к одинокой горе", Arrays.asList(
                new Scene(Location.LONELY_MOUNTAIN,
                        "Вы стоите перед Одинокой Горой, где обитает дракон Смауг.",
                        List.of("Пойти к таверне", "Пойти в Хоббитон")),
                new Scene(Location.LONELY_MOUNTAIN,
                        "Благодаря собранной команде вы нашли вход в гору!",
                        List.of("Рискнуть и забрать сокровища у дракона", "Не рисковать"))));

        scenes.put("закурить трубку", Arrays.asList(
                new Scene(Location.HOBBITON,
                        "Пока вы пускали колечки дыма, к вам подошел высокий незнакомец",
                        List.of("Пожелать доброго утра незнакомцу", "Не обращать на него внимания"))));

        scenes.put("пожелать доброго утра незнакомцу", Arrays.asList(
                new Scene(Location.HOBBITON,
                        "У вас произошел странный разговор, в процессе которого незнакомец предложил вам поучаствовать в приключении",
                        List.of("Принять приглашение", "Отказаться"))));

        scenes.put("принять приглашение", Arrays.asList(
                new Scene(Location.TAVERN,
                        "Незнакомец рассказал вам о сокровище, спрятанном в одинокой горе, но для его поисков надо дождаться друзей в таверне",
                        List.of("Дождаться друзей", "Выпить пива", "Пойти в Хоббитон"))));

        scenes.put("выпить пива", Arrays.asList(
                new Scene(Location.HOBBITON,
                        "После пива вы очнулись в своей кровати, не помня чем закончился вчерашний вечер",
                        List.of("Пойти к таверне", "Пойти к Одинокой горе", "Закурить трубку"))));

        scenes.put("дождаться друзей", Arrays.asList(
                new Scene(Location.TAVERN,
                        "К вам присоеденились Двалин, Балин, Кили, Фили, Дори, Нори, Ори, Ойн, Глойн, Бифур, Бофур, Бомбур и Торин",
                        List.of("Пойти к Одинокой горе", "Выпить пива", "Пойти в Хоббитон"))));

        scenes.put("рискнуть и забрать сокровища у дракона", Arrays.asList(
                new Scene(Location.LONELY_MOUNTAIN,
                        "У вас получилось забрать сокровище! Победа!",
                        Collections.emptyList()),
                new Scene(Location.LONELY_MOUNTAIN,
                        "К сожалению, вас съел дракон",
                        Collections.emptyList())));

        scenes.put("пойти в хоббитон", Arrays.asList(
                new Scene(Location.HOBBITON,
                        "Вы находитесь в уютном доме в Хоббитоне.",
                        List.of("Пойти к таверне", "Пойти к Одинокой горе", "Закурить трубку"))));
    }

    public Scene getScene(String action, int sceneNumber) {
        return scenes.get(action).get(sceneNumber);
    }

}
