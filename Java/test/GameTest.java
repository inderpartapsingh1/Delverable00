import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

public class GameTest {

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    private GameUI makeUI(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return new GameUI();
    }

    @Test
    public void testRegisterPlayersTwoPlayers() {
        GameUI ui = makeUI("2\nAlice\nBob\n");
        Game game = new Game();
        game.registerPlayers(ui);
    }

    @Test
    public void testRegisterPlayersRejectsInvalidThenAccepts() {
        GameUI ui = makeUI("1\n2\nAlice\nBob\n");
        Game game = new Game();
        game.registerPlayers(ui);
    }

    @Test
    public void testStartGameDealsCards() {
        GameUI ui = makeUI("2\nAlice\nBob\n");
        Game game = new Game();
        game.registerPlayers(ui);
        game.startGame();
    }

    @Test
    public void testStartGameWithMaxPlayers() {
        GameUI ui = makeUI("5\nA\nB\nC\nD\nE\n");
        Game game = new Game();
        game.registerPlayers(ui);
        game.startGame();
    }
}