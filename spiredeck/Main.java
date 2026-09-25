import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Runs the program. Asks the user for a deck file, then builds the report.
public class Main {

    /**
     * Starts the program.
     * Input:  args - not used, the file name is typed in instead because
     *         requirement 1 says the program should ask for it
     * Output: nothing, but it prints a summary and writes the report
     * Steps:  1. Ask the user for the file name.
     *         2. Read the deck from that file.
     *         3. Count the cards by cost.
     *         4. Print a summary to the screen.
     *         5. Write the report and say where it went.
     *         6. Print a clear message if the file is missing.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the deck file name: ");
        String fileName = keyboard.nextLine().trim();

        try {
            DeckReader reader = new DeckReader();
            Deck deck = reader.readDeck(fileName);
            Histogram histogram = new Histogram(deck);

            printSummary(deck, histogram);

            ReportWriter writer = new ReportWriter();
            String reportName = writer.writeReport(deck, histogram);
            System.out.println("Report written to: " + reportName);

        } catch (FileNotFoundException e) {
            System.out.println("Could not find a file called: " + fileName);
            System.out.println("Check the name and the folder you are running from.");
        } catch (IOException e) {
            System.out.println("Could not write the report: " + e.getMessage());
        }
    }

    /**
     * Prints a summary of the deck to the screen.
     * Input:  deck - the deck, histogram - its cost counts
     * Output: nothing, it just prints
     * Steps:  1. Print the id.
     *         2. If the deck is void, say so and stop.
     *         3. Print the card count and the total cost.
     *         4. Print the histogram.
     *         5. Print any invalid cards that were ignored.
     */
    private static void printSummary(Deck deck, Histogram histogram) {
        System.out.println();
        System.out.println("Deck ID: " + deck.getId());

        if (deck.isVoid()) {
            System.out.println("This deck is VOID.");
            return;
        }

        System.out.println("Cards counted: " + deck.getCards().size());
        System.out.println("Total cost: " + deck.getTotalCost() + " energy");
        System.out.println();
        System.out.println("Cost distribution");

        String[] lines = histogram.getLines();
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }

        System.out.println();
        System.out.println("Invalid cards ignored: " + deck.getInvalidLines().size());
        for (int i = 0; i < deck.getInvalidLines().size(); i++) {
            System.out.println("  " + deck.getInvalidLines().get(i));
        }
    }
}
