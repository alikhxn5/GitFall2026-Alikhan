Slay the Spire Deck Cost Tally

How to run:
  cd spiredeck
  javac *.java
  java Main
Then type a file name, for example testdata/normal.txt

Classes:
  Card         - one card, a name and an energy cost
  DeckReader   - reads the file and decides which cards are valid
  Deck         - holds the cards, the invalid lines, the id, and the void check
  Histogram    - counts the cards at each cost from 0 to 6
  ReportWriter - writes the report out to a file
  Main         - asks for the file name and connects everything together

Note on the report format:
Requirement 3 asks for the report as a PDF. Making a PDF in Java needs a library like Apache PDFBox, and I could not install one in time to get this assignment submitted, so the report is written as a plain text file with the same contents and the same naming format.

Decisions I made where the spec was unclear:
- Valid costs are whole numbers 0 to 6. Section 2 says integers but
  requirement 9 gives 3.5 energy as an example, so I treated requirement 9 as being about the wording of the output rather than the allowed values.
- The 1000 card limit counts valid and invalid cards together, since requirement 7 talks about cards in the file.
- An empty file is not void. Requirement 5 says the program handles from 0 cards, so an empty deck gives a normal report with a total of 0 energy.
- Blank lines in the file are skipped rather than counted as invalid cards.

Testing:
testdata/ has six files covering the example from the assignment, an empty file, a file with invalid cards, both ways a deck can go void, and one with awkward input like a card name containing a colon.
