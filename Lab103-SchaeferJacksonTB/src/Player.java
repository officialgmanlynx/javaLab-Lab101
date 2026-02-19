//Added only to remove pesky override flags in IDE.
import java.util.Objects;

/**
 *@Author Taylor B. Schaefer-Jackson
 *@version 02.07.2026
 *@Player
 * a player class that has instance variables for name, position, and number.
 * Has a constructor, override constructor, and fulfills all the functions of
 * the interface while implementing additional methods as needed.
 */
public class Player {
    //name of player.
    private String name;
    //position player plays.
    private String position;
    //number on player's jersey.
    private int jerseyNum;
    //consructor
    public Player(String name, String position, int jerseyNum){
        this.name = name;
        this.position = position;
        this.jerseyNum = jerseyNum;
    }
    //accessors
    //gets the players name.
    public String getName(){
        return this.name;
    }
    //get position of player.
    public String getPosition(){
        return this.position;
    }
    //get jerseyNum of player.
    public int get_jerseyNum(){
        return this.jerseyNum;
    }
    
    //mutators
    //change name of player.
    public void setName(String newName){
        this.name = newName;
    }
    //change position of player.
    public void setPosition(String newPosition){
        this.position = newPosition;
    }
    //change jerseyNum of player.
    public void set_jerseyNum(int jerseyNum){
        this.jerseyNum = jerseyNum;
    }
    
    //toString - return string; baseball card for player.
    // see https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
    // see https://docs.oracle.com/javase/specs/jls/se14/preview/specs/text-blocks-jls.html#jls-3.10.6
    @Override
    //to string method that createds formatted player cards.
    public String toString(){
        return """
               ----- PLAYER CARD -----
               Name: """ + name + "\n" +
           "Position: " + position + "\n" +
           "Jersey #: " + jerseyNum + "\n" +
           "-----------------------";
    }
    
    //equals() see if two players are the same.
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player other = (Player) o;

        return jerseyNum == other.jerseyNum &&
               name.equals(other.name) &&
               position.equals(other.position);
    }

    @Override
    //Just appeasing my OCD.
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.position);
        hash = 11 * hash + this.jerseyNum;
        return hash;
    }
    
}
