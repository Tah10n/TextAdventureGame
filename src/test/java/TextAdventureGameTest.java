import org.example.Scene;
import org.example.TextAdventureGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextAdventureGameTest {

    private TextAdventureGame game;


    @BeforeEach
    public void setUp() {
        game = new TextAdventureGame();

    }

    @Test
    public void testInitialGameState() {
        assertFalse(game.isGameEnded());
        assertFalse(game.isDwarfsMet());
        assertNotNull(game.getCurrentScene());
    }

    @Test
    public void testChangeSceneDrinkBeer() {
        Scene scene = game.changeScene("выпить пива");
        assertFalse(game.isDwarfsMet());
        assertEquals(scene, game.getCurrentScene());
    }

    @Test
    public void testChangeSceneWaitForFriends() {
        Scene scene = game.changeScene("дождаться друзей");
        assertTrue(game.isDwarfsMet());
        assertEquals(scene, game.getCurrentScene());
    }

    @Test
    public void testChangeSceneGoToLonelyMountainWithoutDwarfs() {

        Scene scene = game.changeScene("пойти к одинокой горе");
        assertFalse(game.isDwarfsMet());

        assertEquals(scene, game.getCurrentScene());
    }

    @Test
    public void testChangeSceneGoToLonelyMountainWithDwarfs() {
        game.changeScene("дождаться друзей");
        Scene scene = game.changeScene("пойти к одинокой горе");
        assertTrue(game.isDwarfsMet());
        assertEquals(scene, game.getCurrentScene());
    }


    @Test
    public void testChangeSceneEndGame() {

        Scene scene = game.changeScene("рискнуть и забрать сокровища у дракона");
        assertTrue(game.isGameEnded());
        assertEquals(scene, game.getCurrentScene());
    }

}
