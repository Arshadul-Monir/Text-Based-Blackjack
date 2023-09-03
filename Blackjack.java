import java.util.*;
import java.io.*;

public class Blackjack 
{
  /** game deck
  */
  private static Deck deck = new Deck();
  
  /** the player score
  */
  public static int score = 0;
  
  /** the dealer score
  */
  public static int dealerScore = 0;

  /** the dealer's second card
  */
  private static Card secretDealerCard;
  // 


  /** boolean value used to stop program
  */
  public static boolean ender = true;


  /** The code that the game runs to play
  * @param deck the deck being used to play the game
  */
  public static void game() throws InterruptedException
  {
    deck.shuffleDeck();
    System.out.println("Welcome to BlackJack!");
    Thread.sleep(400);
    System.out.println("To play the game, type \"play\". To see the rules of blackjack, type \"rules\"");
    Thread.sleep(600);
    Scanner menu = new Scanner(System.in);
    String menuSelect = (String) menu.nextLine(); 
    PrintWriter writer = new PrintWriter(System.out);
    
    while (!(menuSelect.equalsIgnoreCase("play")))
    {
      // shows the rules 
      if(menuSelect.toLowerCase().equals("rules"))
      {
        System.out.println("-------------------------------------------------------------------\nUse commands \"hit\" and \"play\". The goal of blackjack is to beat the dealer's hand without going over 21. Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.Each player starts with two cards, one of the dealer's cards is hidden until the end.To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turnIf you go over 21 you bust, and the dealer wins regardless of the dealer's hand.If you are dealt 21 from the start (Ace & 10), you got a blackjack.\n-------------------------------------------------------------------");
        System.out.println("To play the game, type \"play\". To see the rules of blackjack, type \"rules\"");
      }
      else 
        System.out.println("Type \"play\" or \"rules\"");
      menuSelect = (String) menu.nextLine();
    }
    
     //plays the game
     if(menuSelect.toLowerCase().equals("play")) 
     {
      Card drawnDealerCard = deck.draw();
      int drawnDealerValue = drawnDealerCard.getValue();
      if(drawnDealerValue == 1 && score + dealerScore <=11)
        drawnDealerValue = 11;
      else if(drawnDealerValue == 11 || drawnDealerValue == 12 || drawnDealerValue == 13)
        drawnDealerValue = 10;
      
      System.out.println();
      System.out.print("Dealer cards: " + drawnDealerCard.toString() + " and \u001B[32m ? \u001B[0m");
      dealerScore += drawnDealerValue;
      hit();
      
      System.out.println("\u001B[31m Dealer Score: " + dealerScore + "\u001B[0m");     
      System.out.println(" Hit or Stand? ");
        Scanner play = new Scanner(System.in);
        String playSelect;
        while(ender ==true)
        {
          playSelect = (String) play.nextLine();
          // runs when you type "hit"
          if(playSelect.toLowerCase().equals("hit"))
          {
            hit();
            if(score >21)
            {
              stand();
              ender = false;
            }
          }
          // runs when you type "stand"
          if(playSelect.toLowerCase().equals("stand")) 
          {
            stand();
          if(dealerScore>21)
          {
            System.out.println("You win!");
            ender = false;
          }
          }

        }
      }
  }
  //the error is somewhere above this comment
  
  /** hit/draw a card 
  */
  public static void hit() 
  {
    Card drawnCard = deck.draw();
    int drawnScore = drawnCard.getValue();
    if(drawnScore == 1 && score + drawnScore <=11)
      drawnScore = 11;
    else if(drawnScore == 11 || drawnScore == 12 || drawnScore == 13)
      drawnScore = 10;
    score += drawnScore;
    
    System.out.println();
    System.out.println("================================================");
    System.out.print("Drawn card: "+drawnCard.toString());
    System.out.println("\u001B[96m Player Score: "+ score + "\u001B[0m");
    System.out.println("================================================");
    
    if(score == 21)
    {
      stand();
    }
     

  }
// stand or you don't draw a card and dealer reveals his 
  public static void stand()
  {
    secretDealerCard = deck.draw();
    if(secretDealerCard.getValue()==1 && dealerScore + 11<=21)
    {
      dealerScore+=11; 
    }
    else if(secretDealerCard.getValue() == 11 || secretDealerCard.getValue() == 12 || secretDealerCard.getValue() == 13)
    {  
      dealerScore += 10;
    }

    else
    {
      dealerScore+=secretDealerCard.getValue();
    }
     System.out.println("\u001B[31m Secret dealer card: "+secretDealerCard.toString());
     
    System.out.println();
    System.out.println("\u001B[31m Dealer score: "+ dealerScore + "\u001B[0m");
    System.out.println("\u001B[96m Player score: "+ score + "\u001B[0m");
    if(score>21)
    {
      System.out.println("You lose!");
      System.exit(0);
    }
    else if(dealerScore>score && dealerScore<=21)
    {
      System.out.println("You lose!");
      System.exit(0);
    }
    else if(score>dealerScore && score<=21)
    {
      System.out.println("You win!");
      System.exit(0);
    }
    else if(score==dealerScore)
    {
      System.out.println("Tie!");
      System.exit(0);
    }
  }
  
  
}
