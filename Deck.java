import java.util.*;

public class Deck
{
  public static final int numCards = 52;
  private static Card[] deckOfCards;
  private static int currentCard;   

  /**
   * Creates an array (deckOfCards) with 52 slots.
   * Creates and assigns cards to each of deck's slots.
   */
  public Deck()
  {
    deckOfCards = new Card[numCards];
    int i = 0;
    
    for (String cardSuit : Card.suitList) // Type of card (clover, heart, spaces, diamond)          
    {
      for (int value = 1; value <= 13; value++ ) // Card value (1-10, J-K)
      {
        deckOfCards[i++] = new Card(cardSuit, value);
      }
    }
  }

 /** gets the deck
  * @return deck of cards 
  */
  public static Card[] getDeck()
  {
    return deckOfCards;
  }

 /** shuffles the deck
  */
  public void shuffleDeck()
  {
		Random rand = new Random();
    for (int i = 0; i < deckOfCards.length; i++) 
    {
			int randomIndexToSwap = rand.nextInt(deckOfCards.length);
			Card temp = deckOfCards[randomIndexToSwap];
			deckOfCards[randomIndexToSwap] = deckOfCards[i];
			deckOfCards[i] = temp;
    } 
  }
  
 /** draw a card
  * @return a card 
  */
  public Card draw() 
  {
    if ( currentCard < numCards )
   	 {
   	    return ( deckOfCards[ currentCard++ ] );
   	 }
   	 else
   	 {
   	    System.out.println("Out of cards error");
   	    return ( null );  // Error;
   	 }
  }
}