import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

public class MainTest {

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testMainRunsWithValidInput() {
        String input = "2\nAlice\nBob\n";
        for (int i = 0; i < 200; i++) {
            input += "A\n0\nA\n1\n";
        }
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.main(new String[]{});
    }
}