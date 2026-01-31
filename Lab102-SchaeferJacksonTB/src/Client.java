/**
 * @Author Taylor B. Schaefer-Jackson
 * @version 01.27.2026
 */

import java.util.Random;

public class Client {
    public static void main(String args[]){
        // Creates an Object of type Scores using the overload constructor
        //with a value of 2 for the parameter.
        Scores scores = new Scores(2);
        // quick testing
        // should print 0
        //System.out.println(scores.size());
        // should print true
        //System.out.println(scores.isEmpty());
        //create an instance of the Random class
        Random r = new Random();
        //Iterate and fill the scores.list with 16 random int ranging from
        //-10 to 10 by using r.nextInt(21) which gives a range of 0 to 20
        //then subtract 10 so that the actual range is -10 to 10.
        for(int i=0;i<16;i++){
            int randomNum = r.nextInt(21)-10;
            scores.add(randomNum);
        }
        //{Prints out the contents of scores.
        System.out.println(scores.toString());
        //Add 3 to the end of scores.
        scores.add(3);
        //System.out.println(scores.toString()); //<-- For testing only
        //Removes a random int from scores.
        scores.randomRemove();
        //System.out.println(scores.toString()); //<-- For testing only
        //Prints the scores at the 6th index.
        System.out.println("The score at the 6th index is "+scores.list[5]);
        //Prints the contents of scores.
        System.out.println(scores.toString());
        //Prints the frequency of the int at index 6 of scores.list
        System.out.println("The frequency of "+scores.list[6]+
                " in scores is "+scores.getFrequencyOf(scores.list[6]));
        //Create a temp int to hold the int at index 6.
        int temp = scores.list[6]; //<-- A temp int see below.
        //Remove the int at index 6.
        scores.remove(scores.list[6]);
        //Check the frequency of the int removed.
        System.out.println("The frequency of the removed number "+temp+
                " in scores is "+scores.getFrequencyOf(temp));
        //Prints the contents of scores.
        System.out.println(scores.toString());
        //Checks to see if the number -5 is in scores.list
        System.out.println("Scores contains the number"
                + "negative five? - " + scores.contains(-5));
        //Create a second instance of the Scores object and make the array
        //equal to the size of the array in scores.
        Scores scores2 = new Scores(scores.list.length);
        //iterates to ensure scores and scores2 are of the same size
        //having equally as many int scores stored in their arrays.
        for(int i=0;i<scores.size;i++){
            int randomNum = r.nextInt(21)-10;
            scores2.add(randomNum);
        }
        //Prints contents of scores2
        System.out.println(scores2.toString());
        //Checks to see if the two objects are equal and prints result boolean.
        //Using two different objects for a false test case and an object
        //compared to itself for a true case.
        System.out.println(scores.equals(scores2)); //<-- False Case.
        System.out.println(scores.equals(scores));  //<-- True Case.
    }
}
