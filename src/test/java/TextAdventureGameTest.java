import org.example.Scene;
import org.example.SceneContainer;
import org.example.TextAdventureGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextAdventureGameTest {

    private TextAdventureGame game;
    private SceneContainer container;


    @BeforeEach
    public void setUp() {
        game = new TextAdventureGame();
        container = new SceneContainer();
    }

    @Test
    public void testInitialGameState() {
        assertFalse(game.isGameEnded());
        assertFalse(game.isDwarfsMet());
        assertNotNull(game.getCurrentScene());
    }

    @Test
    public void testChangeSceneDrinkBeer() {
        String action = "выпить пива";
        Scene scene = game.changeScene(action);
        assertFalse(game.isDwarfsMet());
        assertEquals(scene, container.getScene(action, 0));
    }

    @Test
    public void testChangeSceneWaitForFriends() {
        String action = "дождаться друзей";
        Scene scene = game.changeScene(action);
        assertTrue(game.isDwarfsMet());
        assertEquals(scene, container.getScene(action, 0));
    }

    @Test
    public void testChangeSceneGoToTavern() {

        String action = "пойти в таверну";
        Scene scene = game.changeScene(action);

        assertEquals(scene, container.getScene(action, 0));
    }
    @Test
    public void testChangeSceneGoToLonelyMountainWithoutDwarfs() {

        String action = "пойти к одинокой горе";
        Scene scene = game.changeScene(action);
        assertFalse(game.isDwarfsMet());

        assertEquals(scene, container.getScene(action, 0));
    }

    @Test
    public void testChangeSceneGoToLonelyMountainWithDwarfs() {
        game.changeScene("дождаться друзей");
        String action = "пойти к одинокой горе";
        Scene scene = game.changeScene(action);
        assertTrue(game.isDwarfsMet());
        assertEquals(scene, container.getScene(action, 1));
    }


    @Test
    public void testChangeSceneEndGame() {

        String action = "рискнуть и забрать сокровища у дракона";
        Scene scene = game.changeScene(action);
        assertTrue(game.isGameEnded());
        assertEquals(scene, container.getScene(action, 0));
    }

    @Test
    public void testChangeSceneUnknownAction() {
        String action = "unknown";

        Scene scene = game.changeScene(action);

        assertEquals(scene, container.getScene(action, 0));
    }


}
