import java.util.ArrayList;
import java.util.List;
// JUnit 4 Imports for Ant Compatibility
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*; // Using Assert instead of Assertions

public class CardTest {

    @BeforeClass // was @BeforeAll
    public static void setUpClass() {
    }

    @AfterClass // was @AfterAll
    public static void tearDownClass() {
    }

    @Before // was @BeforeEach
    public void setUp() {
    }

    @After // was @AfterEach
    public void tearDown() {
    }

    private Card makeCard(Card.Rank rank, Card.Suit suit) {
        return new Card(rank, suit) {};
    }

    @Test
    public void testGetRank() {
        Card card = makeCard(Card.Rank.A, Card.Suit.SPADES);
        assertEquals(Card.Rank.A, card.getRank());
    }

    @Test
    public void testGetRankTen() {
        Card card = makeCard(Card.Rank.TEN, Card.Suit.CLUBS);
        assertEquals(Card.Rank.TEN, card.getRank());
    }

    @Test
    public void testGetSuit() {
        Card card = makeCard(Card.Rank.Q, Card.Suit.HEARTS);
        assertEquals(Card.Suit.HEARTS, card.getSuit());
    }

    @Test
    public void testGetSuitDiamonds() {
        Card card = makeCard(Card.Rank.J, Card.Suit.DIAMONDS);
        assertEquals(Card.Suit.DIAMONDS, card.getSuit());
    }

    @Test
    public void testToString() {
        Card card = makeCard(Card.Rank.A, Card.Suit.SPADES);
        assertEquals("A of SPADES", card.toString());
    }

    @Test
    public void testToStringKingHearts() {
        Card card = makeCard(Card.Rank.K, Card.Suit.HEARTS);
        assertEquals("K of HEARTS", card.toString());
    }

    @Test
    public void testToStringTwoClubs() {
        Card card = makeCard(Card.Rank.TWO, Card.Suit.CLUBS);
        assertEquals("TWO of CLUBS", card.toString());
    }
}