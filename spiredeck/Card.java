/**
 * One card from a Slay the Spire deck: a name and an energy cost.
 */
public class Card {

    private String name;
    private int cost;

    /**
     * Builds a card.
     * Input:  name - the card's name, cost - its energy cost (0 to 6)
     * Output: a new Card
     * Steps:  1. Save the name.  2. Save the cost.
     */
    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Gets the card's name.
     * Input:  none
     * Output: the name
     * Steps:  1. Return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the card's energy cost.
     * Input:  none
     * Output: the cost
     * Steps:  1. Return the cost.
     */
    public int getCost() {
        return cost;
    }
}
