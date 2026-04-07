import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

public class PlayerNTest {

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

    private GameUI makeUI(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return new GameUI();
    }

    @Test
    public void testChooseRankValidRankInHand() {
        PlayerN player = new PlayerN("Alice");
        player.hand.addCard(makeCard(Card.Rank.A, Card.Suit.HEARTS));
        GameUI ui = makeUI("A\n");
        Card.Rank result = player.chooseRank(ui);
        assertEquals(Card.Rank.A, result);
    }

    @Test
    public void testChooseRankInvalidThenValid() {
        PlayerN player = new PlayerN("Alice");
        player.hand.addCard(makeCard(Card.Rank.K, Card.Suit.SPADES));
        GameUI ui = makeUI("INVALID\nK\n");
        Card.Rank result = player.chooseRank(ui);
        assertEquals(Card.Rank.K, result);
    }

    @Test
    public void testChooseRankNotInHandThenValid() {
        PlayerN player = new PlayerN("Alice");
        player.hand.addCard(makeCard(Card.Rank.Q, Card.Suit.CLUBS));
        GameUI ui = makeUI("A\nQ\n");
        Card.Rank result = player.chooseRank(ui);
        assertEquals(Card.Rank.Q, result);
    }

    @Test
    public void testChooseTargetValidChoice() {
        PlayerN alice = new PlayerN("Alice");
        PlayerN bob = new PlayerN("Bob");
        List<Player> players = new ArrayList<Player>();
        players.add(alice);
        players.add(bob);
        GameUI ui = makeUI("1\n");
        Player result = alice.chooseTarget(players, ui);
        assertEquals(bob, result);
    }

    @Test
    public void testChooseTargetInvalidThenValid() {
        PlayerN alice = new PlayerN("Alice");
        PlayerN bob = new PlayerN("Bob");
        List<Player> players = new ArrayList<Player>();
        players.add(alice);
        players.add(bob);
        GameUI ui = makeUI("0\n1\n");
        Player result = alice.chooseTarget(players, ui);
        assertEquals(bob, result);
    }
}