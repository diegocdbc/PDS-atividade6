package BuiltDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Components.Card;
import Prototype.Prototype;

/**
 * Classe DeckOfCards representa um  deck de cartas de baralho normal.
 * 
 * @author diegocdbc
 */
public class DeckOfCards implements Prototype {
    private List<Card> deck; // ArrayList usado como uma pilha de objetos
    private Random randomNumbers = new Random(); // gerador de n�mero aleat�rio

    /**
     * Construtor padrão.
     * 
     * @param deckBuilted
     */
    public DeckOfCards(List<Card> deckBuilted) {
        this.deck = deckBuilted;
    }

    /**
     * Construtor utilizado para clonar o objeto.
     * 
     * @param deck
     */
    public DeckOfCards(DeckOfCards deck){
        this(deck.cloneDeck());
    }

    /**
     * Método acessador ao atributo privado deck.
     * 
     * @return
     */
    public List<Card> getDeck(){
        return this.deck;
    }

    /**
     * Método de verificação que o deck não está vázio.
     * 
     * @return
     */
    public boolean hasCard() {
        return this.deck.size() > 0;
    }

    /**
     * Método que embaralha as cartas com um algoritmo de uma passagem.
     */
    public void shuffle() {
        // depois de embaralhar, a distribui��o deve iniciar em deck[ 0 ] novamente

        // para cada Card, seleciona outro Card aleat�rio e os compara
        for (int first = 0; first < this.deck.size(); first++) {
            // seleciona um n�mero aleat�rio entre 0 e 51
            int second = randomNumbers.nextInt(this.deck.size());

            // compara Card atual com Card aleatoriamente selecionado
            Card temp = this.deck.remove(second);
            this.deck.add(0, temp);
        } // for final
    } // fim do m�todo shuffle

    /**
     * Método que distribui um Card, do topo do monte
     * 
     * @return
     */
    public Card dealCard() {
        return deck.remove(deck.size() - 1); // retorna Card atual no array
    } // fim do m�todo dealCard

    /**
     * Método que retornar o tamanho atual do deck.
     * 
     * @return
     */
    public int size() {
        return deck.size();
    }

    /**
     * Método utilizado para clonar o Objeto.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DeckOfCards clone() {
        return new DeckOfCards(this);
    }

    /**
     * Método de apoio que realizará a clonagem do atributo deck(List<Card>)
     * 
     * @return
     */
    private List<Card> cloneDeck(){
        List<Card> newDeck = new ArrayList<Card>();
        for (int count = 0; count < this.getDeck().size(); count++) {
            newDeck.add(this.getDeck().get(count).clone());
        }
        return newDeck;
    }

    @Override
    public String toString() {
        String s = "Deck: ";
        for (int i = 0; i < this.deck.size(); i++) {
            s += this.deck.get(i).toString() + "\n";
        }
        return s;
    }

}
