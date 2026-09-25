// Counts how many cards there are at each energy cost from 0 to 6.
public class Histogram {

    private int[] counts;

    /**
     * Counts up the cards in a deck by cost.
     * Input:  deck - the deck to count
     * Output: a new Histogram
     * Steps:  1. Make an array of 7 counters, one per cost.
     *         2. Go through every card and add 1 to the counter for its cost.
     * Using the cost as the array index is safe because DeckReader already threw out anything that was not between 0 and 6.
     */
    public Histogram(Deck deck) {
        counts = new int[7];
        for (int i = 0; i < deck.getCards().size(); i++) {
            int cost = deck.getCards().get(i).getCost();
            counts[cost] = counts[cost] + 1;
        }
    }

    /**
     * Gets how many cards have a certain cost.
     * Input:  cost - a cost from 0 to 6
     * Output: the number of cards at that cost
     * Return that spot in the array.
     */
    public int getCount(int cost) {
        return counts[cost];
    }

    /**
     * Builds the histogram as lines of text with stars.
     * Input:  none
     * Output: an array of 7 lines, one per cost
     * Steps:  1. For each cost from 0 to 6, start the line with the label.
     *         2. Add one star for each card at that cost.
     *         3. Put the number in brackets at the end.
     */
    public String[] getLines() {
        String[] lines = new String[7];
        for (int cost = 0; cost < 7; cost++) {
            String line = cost + " energy | ";
            for (int i = 0; i < counts[cost]; i++) {
                line = line + "*";
            }
            line = line + "  (" + counts[cost] + ")";
            lines[cost] = line;
        }
        return lines;
    }
}
