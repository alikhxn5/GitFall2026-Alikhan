import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Reads a deck file and turns it into a Deck. This is the only class that decides whether a card is valid.
public class DeckReader {

    /**
     * Reads the file and builds a Deck from it.
     * Input:  fileName - the name of the deck file
     * Output: a Deck holding the valid cards and the invalid lines
     * Steps:  1. Open the file with a Scanner.  2. Read it line by line.
     *         3. Skip blank lines.  4. Try to turn each line into a Card.
     *         5. Put good cards in one list and bad lines in another.
     *         6. Build and return the Deck.
     * Blank lines get skipped instead of counted as invalid, so an extra newline at the end of the file does not make a good deck go void.
     */
    public Deck readDeck(String fileName) throws FileNotFoundException {
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<String> invalidLines = new ArrayList<String>();

        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            Card card = parseLine(line);
            if (card != null) {
                cards.add(card);
            } else {
                invalidLines.add(line.trim());
            }
        }
        fileScanner.close();

        return new Deck(cards, invalidLines);
    }

    /**
     * Turns one line of the file into a Card.
     * Input:  line - one line, which should look like "name:cost"
     * Output: a Card if the line is good, or null if it is not
     * Steps:  1. Split the line at the first colon.
     *         2. Return null if there was no colon.
     *         3. Return null if the name is empty after trimming.
     *         4. Return null if the cost is not a whole number.
     *         5. Return null if the cost is not between 0 and 6.
     *         6. Otherwise build the Card and return it.
     * The 2 in split(":", 2) stops a name that contains a colon from getting chopped into three pieces.
     */
    public Card parseLine(String line) {
        String[] parts = line.split(":", 2);

        if (parts.length < 2) {
            return null;
        }

        String name = parts[0].trim();
        if (name.isEmpty()) {
            // trim() takes off spaces and tabs, so this catches both the empty name and the name that is only spaces or tabs.
            return null;
        }

        int cost;
        try {
            cost = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            return null;
        }

        if (cost < 0 || cost > 6) {
            return null;
        }

        return new Card(name, cost);
    }
}
