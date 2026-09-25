import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Builds the report for a deck and saves it to a file. I did not manage my time correctly while working on this assignment,
 * therefore I was unable to successfully implement a PDF library. So, I chose to pivot and will write the report as text.
 */
public class ReportWriter {

    /**
     * Writes the report for a deck and returns the file name it used.
     * Input:  deck - the deck to report on, histogram - its cost counts
     * Output: the name of the file that was written
     * Steps:  1. Work out the file name from the deck id.
     *         2. Add (VOID) to the name if the deck is void.
     *         3. Open the file for writing.
     *         4. Write the title.
     *         5. Write VOID on its own if the deck is void, otherwise write
     *            the id, the totals, the histogram and the invalid cards.
     *         6. Close the file and return its name.
     * A void report only says VOID, because requirement 7 says it shows that instead of the normal information.
     */
    public String writeReport(Deck deck, Histogram histogram) throws IOException {
        String fileName = "SpireDeck_" + deck.getId() + ".txt";
        if (deck.isVoid()) {
            fileName = "SpireDeck_" + deck.getId() + "(VOID).txt";
        }

        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        out.println("Slay the Spire Deck Report");
        out.println();

        if (deck.isVoid()) {
            out.println("VOID");
            out.close();
            return fileName;
        }

        out.println("Deck ID: " + deck.getId());
        out.println("Cards counted: " + deck.getCards().size());
        out.println("Total cost: " + deck.getTotalCost() + " energy");
        out.println();

        out.println("Cost distribution");
        String[] lines = histogram.getLines();
        for (int i = 0; i < lines.length; i++) {
            out.println(lines[i]);
        }
        out.println();

        out.println("Invalid cards ignored");
        if (deck.getInvalidLines().size() == 0) {
            out.println("None, every line in the file was a valid card.");
        } else {
            for (int i = 0; i < deck.getInvalidLines().size(); i++) {
                out.println(deck.getInvalidLines().get(i));
            }
        }

        out.close();
        return fileName;
    }
}
