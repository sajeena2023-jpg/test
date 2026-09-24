
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

/**
 * A (playing) card is a rank and a suit.
 *
 * @author babak
 * @version 0.0
 */

public class HandTest {
    @Test
    public void testHighCard(){
        assertEquals(Hand.Kind.HIGH_CARD, new Hand("4C 6D 7H 9S KD").kind());
    }
    @Test
    public void testPair(){
        assertEquals(Hand.Kind.PAIR, new Hand("4C 4S 3H 8S KS").kind());
    }
    @Test
    public void testTwoPair(){
        assertEquals(Hand.Kind.TWO_PAIR, new Hand("9C 9D TD TS KS").kind());
    }

    //test for kinds
    @Test
    public void testThreeOfAKind() {
        assertEquals(Hand.Kind.THREE_OF_A_KIND, new Hand("4C 3D 3H 5S KD").kind());

    }



    @Test
    public void testFourOfAKind() {
        assertEquals(Hand.Kind.FOUR_OF_A_KIND,
                new Hand("4C 4D 4H 4S KD").kind());
    }



    //test cases for straight for normal and the special case
    @Test
    public void testStraight(){
        assertEquals(Hand.Kind.STRAIGHT, new Hand("4D 5D 6H 7S 8S").kind());
    }
    @Test
    public void testLowAceStraight() {
        assertEquals(Hand.Kind.STRAIGHT, new Hand("AC 2D 3D 4S 5C").kind());
    }


    //test for flush all same suit
    @Test
        public void testFlush() {
            assertEquals(Hand.Kind.FLUSH, new Hand("3D 8D 9D TD QD").kind());
    }


}
