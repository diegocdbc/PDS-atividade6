package BuiltDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Components.Card;
import Prototype.Prototype;

/**
 * Classe representa um deck de cartas apropriado para sueca.
 * 
 * @author diegocdbc
 */
public class DeckOfCardsForSueca implements Prototype {
    private List<Card> deck; // ArrayList usado como uma pilha de objetos
    private Random randomNumbers = new Random(); // gerador de n�mero aleat�rio
    private Card trump; // Carta trunfo

    /**
     * Construtor Pardão.
     * 
     * @param deckBuilted
     */
    public DeckOfCardsForSueca(List<Card> deckBuilted) {
        this.deck = deckBuilted;
        this.trump = this.generateTrump();
    }

    /**
     * Construtor que será chamado no ato de clonagem.
     * 
     * @param deck
     */
    public DeckOfCardsForSueca(DeckOfCardsForSueca deck){
        this(deck.cloneDeck());
    }

    /**
     * Método que será utilizado para verificar se o deck está vázio ou não.
     * 
     * @return
     */
    public boolean hasCard() {
        return this.deck.size() > 0;
    }

    /**
     * Método acessador do atributo privado deck.
     * 
     * @return
     */
    public List<Card> getDeck(){
        return this.deck;
    }

    /**
     * Método que embaralha as cartas com um algoritmo de uma passagem.
     */
    public void shuffle() {
        // depois de embaralhar, a distribui��o deve iniciar em deck[ 0 ] novamente

        // para cada Card, seleciona outro Card aleat�rio e os compara
        for (int first = 0; first < this.deck.size(); first++) {
            // seleciona um n�mero aleat�rio entre 0 e 40
            int second = randomNumbers.nextInt(this.deck.size());

            // compara Card atual com Card aleatoriamente selecionado
            Card temp = this.deck.remove(second);
            this.deck.add(0, temp);
        } // for final
    } // fim do m�todo shuffle

    
    /**
     * Método que distribui um Card, do topo do monte.
     * 
     * @return
     */
    public Card dealCard() {
        return deck.remove(deck.size() - 1); // retorna Card atual no array
    } // fim do m�todo dealCard

    /**
     * Método que retorna o tamanho atual do deck.
     * 
     * @return
     */
    public int size() {
        return deck.size();
    }

    /**
     * Método utilizado para realizar a clonagem do objeto.
     *  
     * @see java.lang.Object#clone()
     */
    @Override
    public DeckOfCardsForSueca clone() {
        return new DeckOfCardsForSueca(this);
    }

    /**
     * Método utilizado para realizar a clonagem da lista de cartas.
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

    /**
     * Método gerador da carta trunfo.
     * 
     * @return
     */
    public Card generateTrump(){
        int randomNumb = randomNumbers.nextInt(this.deck.size());
        Card selectedTrump = this.deck.get(randomNumb);
        return selectedTrump;
    }

    /**
     * Método utilizado para acessar o atributo privado referente a carta trunfo.
     * 
     * @return
     */
    public Card getTrump(){
        return this.trump;
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
