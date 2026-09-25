import java.util.ArrayList;
import java.util.Random;

/**
 * A whole deck: the cards that were valid, the lines that were not, and a random 9 digit id. Also decides whether the deck is void.
 */
public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<String> invalidLines;
    private int id;

    /**
     * Builds a deck and gives it an id.
     * Input:  cards - the valid cards, invalidLines - the lines that failed
     * Output: a new Deck
     * Steps:  1. Save both lists. 
     *         2. Make a random 9 digit id.
     */
    public Deck(ArrayList<Card> cards, ArrayList<String> invalidLines) {
        this.cards = cards;
        this.invalidLines = invalidLines;

        Random random = new Random();
        // Starting at 100000000 makes sure the number always has 9 digits.
        this.id = 100000000 + random.nextInt(900000000);
    }

    /**
     * Gets the deck id.
     * Input:  none
     * Output: the 9 digit id
     * Return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the valid cards.
     * Input:  none
     * Output: the list of cards
     * Return the list.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Gets the lines that were not valid cards.
     * Input:  none
     * Output: the list of invalid lines
     * Return the list.
     */
    public ArrayList<String> getInvalidLines() {
        return invalidLines;
    }

    /**
     * Adds up the cost of every valid card.
     * Input:  none
     * Output: the total cost in energy
     * Steps:  1. Start the total at 0.  
     *         2. Add each card's cost. 
     *         3. Return it.
     */
    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < cards.size(); i++) {
            total = total + cards.get(i).getCost();
        }
        return total;
    }

    /**
     * Checks whether this deck should get a void report.
     * Input:  none
     * Output: true if the deck is void, false if not
     * Steps:  1. Check if there are more than 10 invalid cards.
     *         2. Check if the file had more than 1000 cards in total.
     *         3. Return true if either one is true.
     * The 1000 limit counts valid and invalid together, because requirement 7 talks about cards in the file, not just the good ones.
     */
    public boolean isVoid() {
        int totalLines = cards.size() + invalidLines.size();
        return invalidLines.size() > 10 || totalLines > 1000;
    }
}
