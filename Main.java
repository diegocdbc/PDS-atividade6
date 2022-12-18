import Builders.GeneralDeckOfCards;
import BuiltDeck.BuildDeck;
import Director.Director;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();

        //
        GeneralDeckOfCards buildGeneralDeck = new GeneralDeckOfCards();

        director.constructDeckForGeneralUsage(buildGeneralDeck);

        BuildDeck deck1 = buildGeneralDeck.getResultDeck();

        System.out.println("Deck: " + deck1);
    }
}
