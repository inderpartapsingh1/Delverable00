import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {

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

    @Test
    public void testAddCardNullIgnored() {
        Hand hand = new Hand();
        hand.addCard(null);
        assertFalse(hand.hasRank(Card.Rank.A));
    }

    @Test
    public void testAddCardAddsCard() {
        Hand hand = new Hand();
        hand.addCard(makeCard(Card.Rank.A, Card.Suit.HEARTS));
        assertTrue(hand.hasRank(Card.Rank.A));
    }

    @Test
    public void testAddCardsMultiple() {
        Hand hand = new Hand();
        List<Card> cards = new ArrayList<Card>();
        cards.add(makeCard(Card.Rank.TWO, Card.Suit.CLUBS));
        cards.add(makeCard(Card.Rank.THREE, Card.Suit.DIAMONDS));
        hand.addCards(cards);
        assertTrue(hand.hasRank(Card.Rank.TWO));
        assertTrue(hand.hasRank(Card.Rank.THREE));
    }

    @Test
    public void testRemoveCards() {
        Hand hand = new Hand();
        Card card = makeCard(Card.Rank.K, Card.Suit.SPADES);
        hand.addCard(card);
        List<Card> toRemove = new ArrayList<Card>();
        toRemove.add(card);
        hand.removeCards(toRemove);
        assertFalse(hand.hasRank(Card.Rank.K));
    }

    @Test
    public void testHasRankFalseWhenEmpty() {
        Hand hand = new Hand();
        assertFalse(hand.hasRank(Card.Rank.Q));
    }

    @Test
    public void testHasRankTrueAfterAdd() {
        Hand hand = new Hand();
        hand.addCard(makeCard(Card.Rank.J, Card.Suit.HEARTS));
        assertTrue(hand.hasRank(Card.Rank.J));
    }

    @Test
    public void testGetCardsOfRankEmpty() {
        Hand hand = new Hand();
        List<Card> result = hand.getCardsOfRank(Card.Rank.A);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetCardsOfRankReturnsCorrect() {
        Hand hand = new Hand();
        hand.addCard(makeCard(Card.Rank.FIVE, Card.Suit.HEARTS));
        hand.addCard(makeCard(Card.Rank.FIVE, Card.Suit.CLUBS));
        hand.addCard(makeCard(Card.Rank.K, Card.Suit.SPADES));
        List<Card> result = hand.getCardsOfRank(Card.Rank.FIVE);
        assertEquals(2, result.size());
    }

    @Test
    public void testShowHandDoesNotThrow() {
        Hand hand = new Hand();
        hand.addCard(makeCard(Card.Rank.A, Card.Suit.SPADES));
        hand.showHand();
    }

    @Test
    public void testShowHandEmptyDoesNotThrow() {
        Hand hand = new Hand();
        hand.showHand();
    }
}