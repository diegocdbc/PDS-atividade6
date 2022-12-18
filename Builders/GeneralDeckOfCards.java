package Builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Builder.Builder;
import BuiltDeck.BuildDeck;
import Components.Card;

public class GeneralDeckOfCards implements Builder {
    private List<Card> buildDeck;
    private BuildDeck result;
    private String suits[];
    private String faces[];
    private final int NUMBER_OF_CARDS = 52; // n�mero constante de Cards
    // private Random randomNumbers = new Random(); // gerador de n�mero aleat�rio

    @Override
    public GeneralDeckOfCards mountDeck() {
        // fazer o tratamento de excessões
        this.buildDeck = new ArrayList<Card>(); // cria List de objetos Card

        // preenche baralho com objetos Card
        for (int count = 0; count < this.NUMBER_OF_CARDS; count++) {
            this.buildDeck.add(new Card(this.faces[count % 13], this.suits[count / 13], (count % 13) + 1));
        }
        this.result = new BuildDeck(this.buildDeck);
        System.out.println("Builder general ok!");
        return this;
    }

    @Override
    public GeneralDeckOfCards mountSuits() {
        String possibleSuits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
        this.suits = possibleSuits;
        return this;
    }

    @Override
    public GeneralDeckOfCards mountFaces() {
        String possibleFaces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        this.faces = possibleFaces;
        return this;
    }

    @Override
    public BuildDeck getResultDeck() {
        return this.result;
    }

}
