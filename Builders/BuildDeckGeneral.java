package Builders;

import java.util.ArrayList;
import java.util.List;

import Builder.Builder;
import BuiltDeck.DeckOfCards;
import Components.Card;

/**
 * Classe construtora de decks de carta normal.
 * 
 * @author diegocdbc
 */
public class BuildDeckGeneral implements Builder {
    private List<Card> buildDeck;
    private DeckOfCards result;
    private String suits[];
    private String faces[];
    private final int NUMBER_OF_CARDS = 52; // n�mero constante de Cards

    /**
     * Método que será utilizado para montar o deck completo.
     * 
     * @see Builder.Builder#mountDeck()
     */
    @Override
    public BuildDeckGeneral mountDeck() {
        // fazer o tratamento de excessões
        this.buildDeck = new ArrayList<Card>(); // cria List de objetos Card

        // preenche baralho com objetos Card
        for (int count = 0; count < this.NUMBER_OF_CARDS; count++) {
            this.buildDeck.add(new Card(this.faces[count % 13], this.suits[count / 13], (count % 13) + 1));
        }
        this.result = new DeckOfCards(this.buildDeck);
        return this;
    }

    /**
     * Método que será utilizado para montar os naipes que serão utilizados.
     * 
     * @see Builder.Builder#mountSuits()
     */
    @Override
    public BuildDeckGeneral mountSuits() {
        String possibleSuits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
        this.suits = possibleSuits;
        return this;
    }

    /**
     * Método que será utilizado para montas as faces das cartas que serão utilizadas.
     * 
     * @see Builder.Builder#mountFaces()
     */
    @Override
    public BuildDeckGeneral mountFaces() {
        String possibleFaces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        this.faces = possibleFaces;
        return this;
    }

    /**
     * Método que será utilizado para se obter o objeto construido.
     * 
     * @return
     */
    public DeckOfCards getResultDeck() {
        return this.result;
    }

    /**
     * Método que irá resetar o Builder.
     * 
     * @see Builder.Builder#reset()
     */
    @Override
    public void reset(){
        this.buildDeck = null;
        this.result = null;
        this.suits = null;
        this.faces = null;
    }
}
