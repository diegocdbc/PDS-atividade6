import Builders.BuildDeckGeneral;
import Builders.BuildDeckOfSueca;
import BuiltDeck.DeckOfCards;
import BuiltDeck.DeckOfCardsForSueca;
import Director.Director;
import Prototype.PrototypeRegistry;

public class RunApplication {
    public static void main(String[] args) {
        Director director = new Director();

        System.out.println("Construindo deck normal...\n");

        // Contruindo Deck normal
        BuildDeckGeneral buildGeneralDeck = new BuildDeckGeneral();
        director.make(buildGeneralDeck);
        DeckOfCards deckNormal = buildGeneralDeck.getResultDeck();

        System.out.println("Contruindo deck para sueca...\n");
        // Construindo Deck para sueca
        BuildDeckOfSueca buildDeckOfSueca = new BuildDeckOfSueca();
        director.make(buildDeckOfSueca);
        DeckOfCardsForSueca deckSueca = buildDeckOfSueca.getResultDeck();

        //Registrando modelos de protótipos
        System.out.println("Registrando modelos de protótipos...");
        PrototypeRegistry prototypersRepository = new PrototypeRegistry();
        prototypersRepository.addPrototype("normal", deckNormal);
        prototypersRepository.addPrototype("sueca", deckSueca);

        // Gerando novos decks via clonagem(Recuperação do repositório)
        System.out.println("\nClonando deck normal...");
        DeckOfCards deck1 = (DeckOfCards) prototypersRepository.getPrototype("normal");
        System.out.println("Evidênciando a clonagem: \n");
        System.out.println("Primeira carta do deck normal clonado: "+deck1.getDeck().get(0));
        System.out.println("Primeira carta do deck normal original: "+deckNormal.getDeck().get(0));
        System.out.println();

        // Gerando novos decks via clonagem(Recuperação do repositório)
        System.out.println("Clonando deck para sueca...");
        DeckOfCardsForSueca deck2 = (DeckOfCardsForSueca) prototypersRepository.getPrototype("sueca");
        System.out.println("Evidênciando a clonagem: \n");
        System.out.println("Primeira carta do deck de sueca clonado: "+deck2.getDeck().get(0));
        System.out.println("Primeira carta do deck de sueca original: "+deckSueca.getDeck().get(0));
        System.out.println();

        //Validando a clonagem

        System.out.println("Primeira carta de ambos os decks, antes da mudança nos clones: \n");
        System.out.println("- Deck normal");
        System.out.println("Primeira carta do deck normal clonado: "+deck1.getDeck().get(0));
        System.out.println("Primeira carta do deck normal original: "+deckNormal.getDeck().get(0));
        System.out.println("- Deck para sueca");
        System.out.println("Primeira carta do deck de sueca clonado: "+deck2.getDeck().get(0));
        System.out.println("Primeira carta do deck de sueca original: "+deckSueca.getDeck().get(0));
        System.out.println("\nAlterando o valor da primeira carta de ambos os decks clonados de 'Ace' para 'Ás'\n");
        deck1.getDeck().get(0).setFace("Ás");
        deck2.getDeck().get(0).setFace("Ás");
        System.out.println("Alterações realizadas...\n");
        System.out.println("- Deck normal");
        System.out.println("Primeira carta do deck normal clonado: "+deck1.getDeck().get(0));
        System.out.println("Primeira carta do deck normal original: "+deckNormal.getDeck().get(0));
        System.out.println("- Deck para sueca");
        System.out.println("Primeira carta do deck de sueca clonado: "+deck2.getDeck().get(0));
        System.out.println("Primeira carta do deck de sueca original: "+deckSueca.getDeck().get(0));
        System.out.println();
        System.out.println("\nAlterando o valor da primeira carta de ambos os decks originais de 'Ace' para 'Acee'\n");
        deckNormal.getDeck().get(0).setFace("Acee");
        deckSueca.getDeck().get(0).setFace("Acee");
        System.out.println("Alterações realizadas...\n");
        System.out.println("- Deck normal");
        System.out.println("Primeira carta do deck normal clonado: "+deck1.getDeck().get(0));
        System.out.println("Primeira carta do deck normal original: "+deckNormal.getDeck().get(0));
        System.out.println("- Deck para sueca");
        System.out.println("Primeira carta do deck de sueca clonado: "+deck2.getDeck().get(0));
        System.out.println("Primeira carta do deck de sueca original: "+deckSueca.getDeck().get(0));
        System.out.println();

        // Realizando reset dos decks

        System.out.println("\nRealizando reset dos decks...");

        buildGeneralDeck.reset();
        director.make(buildGeneralDeck);
        deckNormal = (DeckOfCards)buildGeneralDeck.getResultDeck();
        deck1 = (DeckOfCards)buildGeneralDeck.getResultDeck();
        System.out.println("\nDecks de sueca pós reset");
        System.out.println("Primeira carta do deck normal clonado: "+deck1.getDeck().get(0));
        System.out.println("Primeira carta do deck normal original: "+deckNormal.getDeck().get(0));

        buildDeckOfSueca.reset();
        director.make(buildDeckOfSueca);
        deckSueca = (DeckOfCardsForSueca) buildDeckOfSueca.getResultDeck();
        deck2 = (DeckOfCardsForSueca) buildDeckOfSueca.getResultDeck();
        System.out.println("\nDecks de sueca pós reset");
        System.out.println("Primeira carta do deck de sueca clonado: "+deck2.getDeck().get(0));
        System.out.println("Primeira carta do deck de sueca original: "+deckSueca.getDeck().get(0));

    }
}
