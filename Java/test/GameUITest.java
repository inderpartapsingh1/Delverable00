import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class GameUITest {

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testPromptReturnsInput() {
        System.setIn(new ByteArrayInputStream("hello\n".getBytes()));
        GameUI ui = new GameUI();
        String result = ui.prompt("Enter: ");
        assertEquals("hello", result);
    }

    @Test
    public void testPromptReturnsWord() {
        System.setIn(new ByteArrayInputStream("Alice\n".getBytes()));
        GameUI ui = new GameUI();
        assertEquals("Alice", ui.prompt("Name: "));
    }

    @Test
    public void testGetIntInput() {
        System.setIn(new ByteArrayInputStream("42\n".getBytes()));
        GameUI ui = new GameUI();
        assertEquals(42, ui.getIntInput());
    }

    @Test
    public void testGetIntInputZero() {
        System.setIn(new ByteArrayInputStream("0\n".getBytes()));
        GameUI ui = new GameUI();
        assertEquals(0, ui.getIntInput());
    }

    @Test
    public void testShowMessagePrintsToConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(new ByteArrayInputStream("".getBytes()));
        GameUI ui = new GameUI();
        ui.showMessage("Test message");
        assertTrue(out.toString().contains("Test message"));
    }

    @Test
    public void testShowMessageEmpty() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(new ByteArrayInputStream("".getBytes()));
        GameUI ui = new GameUI();
        ui.showMessage("");
    }
}