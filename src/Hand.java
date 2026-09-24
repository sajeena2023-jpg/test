import java.util.*;

/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 *
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT,
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;




    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String c) {

        cards= new ArrayList<Card>();
        String[] cut = c.trim().split("\\s+");

        for (int j=0; j<cut.length; j+=1) {
            Card card = new Card(cut[j]);
            cards.add(card);
        }
    }

    /**
     * @returns true if the hand has n cards of the same rank
     * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
        //counts how many cards have each rank
        // checks whether any rank appears exactly n times
        HashMap<Card.Rank, Integer> count = new HashMap<Card.Rank, Integer>();

        for (Card card: cards) {
            Card.Rank rank = card.getRank();
            if (count.containsKey(rank)) {
                count.put(rank, count.get(rank) + 1);}

            else {
                count.put(rank,1);
            }
        }
        return count.containsValue(n); //

    }

    /**
     * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
        HashMap<Card.Rank, Integer> countRank = new HashMap<Card.Rank, Integer>();
        int paircount = 0;
        for (Card card: cards){
            Card.Rank rank = card.getRank();

            if (countRank.containsKey(rank)){
                countRank.put(rank,countRank.get(rank) +1);
            }
            else {
                countRank.put(rank,1);
            }
        }

        for (int count: countRank.values()){
            if (count == 2){
                paircount += 1;
            }
        }
        return paircount == 2;
    }

    /**
     * @returns true if the hand is a straight //2 3 5 6 7
     */

    public boolean isStraight() {
        ArrayList<Integer> hand = new ArrayList<Integer>(); //hand is the list of ranks

        for (Card card: cards) {
            hand.add(card.getRank().ordinal()); //0,1,2 that rank's position in the Rank enum
        }

        Collections.sort(hand); //lowest to highest


        //only if there is a,1,2,3,4
        if(hand.get(0) ==0 && hand.get(1) ==1 && hand.get(2) == 2 &&
        hand.get(3) == 3 && hand.get(4) ==12) {
            return true;
        }


        //compare with num before it
        for (int i =1; i<hand.size(); i++) {
            if (hand.get(i) != hand.get(i-1) + 1){
                return false;
            }
        }
        return true;

    }

    /**
     * @returns true if the hand is a flush // all the same suit
     */
    public boolean isFlush() {

        Card.Suit f = cards.get(0).getSuit();

        for (int i=0; i< cards.size(); i++) {
            if(cards.get(i).getSuit() != f) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Hand h) {
        return this.kind().ordinal() - h.kind().ordinal(); //return the position of an enum value starting from 0
        //hint: delegate!
        //and don't worry about breaking ties
    }

    /**
     * This method is already implemented and could be useful!
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND;
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR;
        else return Kind.HIGH_CARD;
    }



}
