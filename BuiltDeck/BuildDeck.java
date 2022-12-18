package BuiltDeck;

import java.util.List;
import java.util.Random;

import Components.Card;
import Prototype.Prototype;

public class BuildDeck implements Prototype {
    private List<Card> deck; // ArrayList usado como uma pilha de objetos
    private Random randomNumbers = new Random(); // gerador de n�mero aleat�rio

    public BuildDeck(List<Card> deckBuilted) {
        this.deck = deck;
    }

    public boolean hasCard() {
        return this.deck.size() > 0;
    }

    // embaralha as cartas com um algoritmo de uma passagem
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

    // distribui um Card, do topo do monte
    public Card dealCard() {
        return deck.remove(deck.size() - 1); // retorna Card atual no array
    } // fim do m�todo dealCard

    public int size() {
        return deck.size();
    }

    @Override
    public BuildDeck clone() {
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.deck.size(); i++) {
            s += this.deck.get(i).toString() + "\n";
        }
        return s;
    }

}
