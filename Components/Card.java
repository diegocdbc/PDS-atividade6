package Components;


import Prototype.Prototype;

/**
 * Classe Card representa uma carta de baralho.
 * 
 * @author diegocdbc
 */
public class Card implements Prototype{
   private String face; // face da carta ("Ace", "Deuce", ...)
   private String suit; // naipe da carta ("Hearts", "Diamonds", ...)
   private int value;

   /**
    * Construtor padrão.
    *
    * @param cardFace
    * @param cardSuit
    * @param cardValue
    */
   public Card(String cardFace, String cardSuit, int cardValue) {
      face = cardFace; // inicializa face da carta
      suit = cardSuit; // inicializa naipe da carta
      value = cardValue;
   } // fim do construtor Card de dois argumentos

   /**
    * Construtor que será utilizado no ato de clonagem do objeto Card.
    * 
    * @param card
    */
   public Card(Card card){
      this(card.getFace(),card.getSuit(),card.getValue());
   }

   // Getter's e Setter's
   
   public String getFace() {
      return face;
   }
   
   public void setFace(String face){
      this.face = face;
   }

   public int getValue() {
      return value;
   }
   
   public String getSuit() {
      return suit;
   }
   
   /**
    * Método de clonagem do objeto Card.
    * 
    * @see java.lang.Object#clone()
    */
   @Override
    public Card clone() {
        return new Card(this);
    }

   @Override
   public String toString() {
      return face + " of " + suit + ", value " + value;
   } // fim do m�todo toString
} // fim da classe Card
