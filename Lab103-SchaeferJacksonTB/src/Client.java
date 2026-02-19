 /**
 *@Author Taylor B. Schaefer-Jackson
 *@version 02.07.2026
 * @projectTime - 6.5 Hours
 * 
 * @Client
 * A client class used to access the projects contents.
 */
public class Client {
    public static void main(String[] args){
        //Create instance of ArrayBag.
        ArrayBag<Player> mensTeam = new ArrayBag<>(2);
        
        //an array of players - data taken from
        //https://gobison.com/sports/football/roster
        Player[] players = {
            new Player("Donovan Woolen","Linebacker",1),
            new Player("Jaylin Crumby","Safety",6),
            new Player("DJ Scott","Running Back",7),
            new Player("Jacob Kilzer","Wide Receiver",11),
            new Player("Trey Drake","Quarter Back",10),
            new Player("Nathan Hayes","Quarterback",12),
            new Player("Zander Smith","Quarterback",13),
            new Player("Noah Taylor","Linebacker",21)
        };
        //an enhanced for loop used to add the players to the team.
        //see the following for more info.
        //https://docs.oracle.com/javase/1.5.0/docs/guide/language/foreach.html
        for (Player player : players) {
            mensTeam.add(player);
        }
        
        //Display content of mens team
        System.out.println(mensTeam.toString());
        
        //remove a random player
        mensTeam.remove();
        
        //Display content of mens team
        System.out.println(mensTeam.toString());
        
        //get the player card stored at index 5 i.e 6th player
        System.out.println(mensTeam.get(5));
        //Added white space for easy reading
        System.out.println("\n\n\n");
        
        //add another player
        Player player = new Player("Gabriel Cunningham", "Tight End", 33);
        mensTeam.add(player);
        
        //Display content of mens team
        System.out.println(mensTeam.toString());
        
        //removePlayer at index 5
        mensTeam.remove(mensTeam.get(5));
        
        //Display content of mens team
        System.out.println(mensTeam.toString());
        
        //create a new instance of Array Bag called courses
        ArrayBag<String> courses = new ArrayBag<>();
        //add my current semester at Maine Maritime and NDUS.
        courses.add("CSCI 161: Computer Science II");
        courses.add("ENGR 327: Ethics, Engineering, and Technology");
        courses.add("MATH 129: Linear Algebra");
        courses.add("MATH 165: Calculus I");
        courses.add("BIW EG253: CAD Drawing Development and Technology");
        courses.add("BIW MS115: Pre-Calculus");
        //print contents of courses
        System.out.println(courses.toString());
        //remove a random course
        courses.remove();
        //print contents of courses
        System.out.println(courses.toString());
        
        linkedBag<Player> womensTeam = new linkedBag<>(2);
        //an array of players - data taken from
        //https://gobison.com/sports/womens-basketball/roster
        Player[] wPlayers = {
            new Player("Audrey Martinez-Stewart","Guard",5),
            new Player("Amelia Hobson","Guard",8),
            new Player("Abby Graham ","Guard",10),
            new Player("Karrington Asp","Forward",15),
            new Player("Avery Koenen","Foreward",22),
            new Player("McKenna Johnson","Foreward",35),
            new Player("Abby Krzewinski","Guard",40),
            new Player("Molly Lenz","Guard",1)
        };
        //an enhanced for loop used to add the players to the team.
        //see the following for more info.
        //https://docs.oracle.com/javase/1.5.0/docs/guide/language/foreach.html
        for (Player wPlayer : wPlayers) {
            womensTeam.add(wPlayer);
        }
        
        //Display content of mens team
        System.out.println(womensTeam.toString());
        
        //remove a random player
        womensTeam.remove();
        
        //Display content of mens team
        System.out.println(womensTeam.toString());
        
        //get the player card stored at index 5 i.e 6th player
        System.out.println(womensTeam.get(5));
        //Added white space for easy reading
        System.out.println("\n\n\n");
        
        //add another player
        Player Wplayer = new Player("Jocelyn Schiller", "Guard", 30);
        womensTeam.add(Wplayer);
        
        //Display content of mens team
        System.out.println(womensTeam.toString());
        
        //removePlayer at index 5
        womensTeam.remove(womensTeam.get(5));
        
        //Display content of mens team
        System.out.println(womensTeam.toString());
        
        
    }
}
