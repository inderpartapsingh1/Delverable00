import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testShuffleDoesNotThrow() {
        Deck deck = new Deck();
        try {
            deck.shuffle();
        } catch (Exception e) {
            fail("Shuffle threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testShuffleDeckStillDealsCards() {
        Deck deck = new Deck();
        deck.shuffle();
        assertNotNull(deck.dealCard());
    }

    @Test
    public void testDealCardNotNull() {
        Deck deck = new Deck();
        Card result = deck.dealCard();
        assertNotNull(result);
    }

    @Test
    public void testDealCardReducesDeck() {
        Deck deck = new Deck();
        deck.dealCard();
        int count = 0;
        while (deck.dealCard() != null) count++;
        assertEquals(51, count);
    }

    @Test
    public void testDealCardReturnsNullWhenEmpty() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) deck.dealCard();
        assertNull(deck.dealCard());
    }

    @Test
    public void testIsEmptyFalseOnNewDeck() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty());
    }

    @Test
    public void testIsEmptyTrueAfterAllDealt() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) deck.dealCard();
        assertTrue(deck.isEmpty());
    }

    @Test
    public void testDeckHas52Cards() {
        Deck deck = new Deck();
        int count = 0;
        while (!deck.isEmpty()) {
            deck.dealCard();
            count++;
        }
        assertEquals(52, count);
    }
}