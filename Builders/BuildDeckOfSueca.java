package Builders;

import java.util.ArrayList;
import java.util.List;

import Builder.Builder;
import BuiltDeck.DeckOfCardsForSueca;
import Components.Card;

/**
 * Classe construtora de decks para sueca.
 * 
 * @author diegocdbc
 */
public class BuildDeckOfSueca implements Builder {
    private List<Card> buildDeck;
    private DeckOfCardsForSueca result;
    private String suits[];
    private String faces[];
    private final int NUMBER_OF_CARDS = 40; // n�mero constante de Cards

    /**
     * Método que será utilizado para montar o deck completo.
     *
     * @see Builder.Builder#mountDeck()
     */
    @Override
    public BuildDeckOfSueca mountDeck() {
        // fazer o tratamento de excessões
        this.buildDeck = new ArrayList<Card>(); // cria List de objetos Card

        // preenche baralho com objetos Card
        for (int count = 0; count < this.NUMBER_OF_CARDS; count++) {
            this.buildDeck.add(new Card(this.faces[count % 10], this.suits[count / 10], this.getPontuation(this.faces[count % 10])));
        }
        this.result = new DeckOfCardsForSueca(this.buildDeck);
        return this;
    }

    /**
     * Método que será utilizado para montar os naipes que serão utilizados.
     * 
     * @see Builder.Builder#mountSuits()
     */
    @Override
    public BuildDeckOfSueca mountSuits() {
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
    public BuildDeckOfSueca mountFaces() {
        String possibleFaces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Jack", "Queen", "King" };
        this.faces = possibleFaces;
        return this;
    }

    /**
     * Método que será utilizado para se obter o objeto construido.
     * 
     * @return
     */
    public DeckOfCardsForSueca getResultDeck() {
        return this.result;
    }

    /**
     * Método que será utilizado na construção do deck, atribuindo a pontuação para cada carta.
     * 
     * @param face
     * @return
     */
    public int getPontuation(String face){
        if(face.equals("Ace")){
            return 11;
        }else if (face.equals("Seven")){
            return 10;
        }else if (face.equals("King")){
            return 4;
        }else if(face.equals("Jack")){
            return 3;
        }else if(face.equals("Queen")){
            return 2;
        }else{
            return 0;
        }
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
