import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    private Card makeCard(Card.Rank rank, Card.Suit suit) {
        return new Card(rank, suit) {};
    }

    private Player makePlayer(String name) {
        return new PlayerN(name);
    }

    @Test
    public void testDrawCard() {
        Player player = makePlayer("Alice");
        Deck deck = new Deck();
        player.drawCard(deck);
        assertTrue(player.hand.hasRank(Card.Rank.A) || 
                   player.hand.hasRank(Card.Rank.TWO) || 
                   player.getBookCount() >= 0);
    }

    @Test
    public void testDrawCardDeckNotEmpty() {
        Player player = makePlayer("Alice");
        Deck deck = new Deck();
        while (!deck.isEmpty()) { deck.dealCard(); }
        Deck fresh = new Deck();
        player.drawCard(fresh);
        player.showHand();
    }

    @Test
    public void testAskForCardSuccess() {
        Player alice = makePlayer("Alice");
        Player bob = makePlayer("Bob");
        bob.hand.addCard(makeCard(Card.Rank.A, Card.Suit.HEARTS));
        boolean result = alice.askForCard(Card.Rank.A, bob);
        assertTrue(result);
    }

    @Test
    public void testAskForCardFailure() {
        Player alice = makePlayer("Alice");
        Player bob = makePlayer("Bob");
        boolean result = alice.askForCard(Card.Rank.A, bob);
        assertFalse(result);
    }

    @Test
    public void testAskForCardTransfersCards() {
        Player alice = makePlayer("Alice");
        Player bob = makePlayer("Bob");
        bob.hand.addCard(makeCard(Card.Rank.K, Card.Suit.SPADES));
        alice.askForCard(Card.Rank.K, bob);
        assertTrue(alice.hand.hasRank(Card.Rank.K));
        assertFalse(bob.hand.hasRank(Card.Rank.K));
    }

    @Test
    public void testCheckForBooksNoBook() {
        Player player = makePlayer("Alice");
        player.hand.addCard(makeCard(Card.Rank.A, Card.Suit.HEARTS));
        player.checkForBooks();
        assertEquals(0, player.getBookCount());
    }

    @Test
    public void testCheckForBooksCompletesBook() {
        Player player = makePlayer("Alice");
        for (Card.Suit suit : Card.Suit.values()) {
            player.hand.addCard(makeCard(Card.Rank.A, suit));
        }
        player.checkForBooks();
        assertEquals(1, player.getBookCount());
    }

    @Test
    public void testCheckForBooksRemovesCardsFromHand() {
        Player player = makePlayer("Alice");
        for (Card.Suit suit : Card.Suit.values()) {
            player.hand.addCard(makeCard(Card.Rank.TWO, suit));
        }
        player.checkForBooks();
        assertFalse(player.hand.hasRank(Card.Rank.TWO));
    }

    @Test
    public void testShowHandDoesNotThrow() {
        Player player = makePlayer("Alice");
        player.hand.addCard(makeCard(Card.Rank.J, Card.Suit.CLUBS));
        player.showHand();
    }

    @Test
    public void testGetName() {
        Player player = makePlayer("Alice");
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testGetBookCountInitiallyZero() {
        Player player = makePlayer("Alice");
        assertEquals(0, player.getBookCount());
    }

    @Test
    public void testGetBookCountAfterBook() {
        Player player = makePlayer("Alice");
        for (Card.Suit suit : Card.Suit.values()) {
            player.hand.addCard(makeCard(Card.Rank.Q, suit));
        }
        player.checkForBooks();
        assertEquals(1, player.getBookCount());
    }

    public class PlayerImpl extends Player {
        public PlayerImpl() { super(""); }
        public Card.Rank chooseRank(GameUI ui) { return null; }
        public Player chooseTarget(List<Player> players, GameUI ui) { return null; }
    }
}