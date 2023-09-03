import java.util.*;

public class Card
{
  private int value;
  private String type;
  public static final String[] suitList = {"DIAMONDS","SPADES","CLOVERS","HEARTS"};

  /**
   * Constuctor: Created card with number of "value"
   * and type of "type"
   * @param type type of card
   * @param value number of the card
   */
  public Card(String type, int value)
  {
    this.type = type;
    this.value = value;
  }

  /** gets the type of the card
  * @return a string type 
  */
  public String getType()
  {
    return type;
  }

  /** gets the value of the card
  * @return int Value 
  */
  public int getValue()
  {
    return value;
  }

   /** makes objects into string form
  * @return string form of object  
  */
  public String toString()
  {
    if(value==1)
      return "\u001B[32m" + "Ace of "+type+"\u001B[0m \n";
    if(value==11)
      return "\u001B[32m" + "Jack of "+type+"\u001B[0m \n";
    if(value==12)
      return "\u001B[32m" + "Queen of "+type+"\u001B[0m \n";
    if(value==13)
      return "\u001B[32m" + "King of "+type+"\u001B[0m \n";
    return "\u001B[32m" + value+ " of "+type+"\u001B[0m \n";
  }

}
