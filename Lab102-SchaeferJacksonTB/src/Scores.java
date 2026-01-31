import java.util.Random;

/**
 *
 * @Author Taylor B. Schaefer-Jackson
 * @version 01.26.2026
 */
public class Scores {
    // an array for type int for holding the scores.
    public int[] list;
    //an integer which holds the size of the list.
    public int size;
    
    //consturctor
    public Scores(){
        //int object of list array set to length 2.
        this(2);
        // sets size to 0 as no initial val are stored.
        this.size = 0;
    }
    
    //constructor overload
    public Scores(int newLength){
        //when overloaded
        this.list = new int[newLength];
        this.size = 0;
    }
    //helper method to return size of object
    public int size(){
        return this.size;
    }
    //helper method to se if Scores is empty.
    public boolean isEmpty(){
        return this.size == 0;
    }
    //clears the array and size for the object - a reset.
    public void clear(){
        for (int i = 0; i < size; i++) {
            this.list[i] = 0;
        }
        this.size = 0;
    }
    //checks the frequency of a number in the array.
    public int getFrequencyOf(int num){
        int tempCount = 0;
        for(int i=0; i<this.size;i++){
            if(this.list[i]==num){
                tempCount++;
            }
        }
        return tempCount;
    }
    //checks if a number exists in the array list.
    public boolean contains(int num){
        //Iterate through the list using a comparison with size.
        for(int i=0;i<this.size;i++){
            //if num at index i of list is equal to input num return true.
            if(this.list[i]==num){
                return true;
            }
        }
        //if full iteration occurse return false.
        return false;
    }
    //method to add most recent score to the end of list.
    public void add(int num){
        //check to see if there is room for another score in the array list.
        if(this.size == this.list.length){
            //creates a temp array twice the size of list.
            int[] temp = new int[this.list.length*2];
            //Copies the contents of list to a temp array of twice the size.
            // Using System.arraycopy(source, srcPos, destination, destPos, length)
            System.arraycopy(this.list, 0, temp, 0, this.list.length);
            //Copy temp to list setting list to the new length with all 
            //original numbers in place.
            list = temp;   
        }
        //add the next numer to the array list.
        this.list[this.size]=num;
        this.size++;
    }
    public void remove(int num){
    // check if int num in list
        if(this.contains(num)) {
            // iterate to index of int num in array list
            for(int i = 0; i < this.size; i++){
                // index of int num in array list found
                if(this.list[i] == num){
                    // shift all elements right of index left one
                    for(int j = i; j < this.size - 1; j++){
                        this.list[j] = this.list[j+1];
                    }
                    // set last element to 0
                    this.list[this.size - 1] = 0;
                    // decrement size
                    this.size--;
                    // stop after removing first occurrence
                    break;
                }
            }
        }
    }
    // removes a random number from the list utalizing the remove method
    public int randomRemove(){
        if (size == 0) {
            throw new IllegalStateException("The remove( ) method cannot be called on an empty list");
        }
        //create an instance of the Random class
        Random r = new Random();
        //Remove a random int from (0, size)
        // by picking a random index
        int randomIndex = r.nextInt(size);
        //grabbing the value of the int at that index
        int valueToRemove = list[randomIndex];
        remove(valueToRemove);
        return valueToRemove;
    }
    
    public int getI (int i){
        // check logical bounds of list given size
        if (i < 0 || i >= size) {  
        throw new ArrayIndexOutOfBoundsException(
            "Index " + i + " is outside the logical array bounds (0 to " + (size - 1) + ")"
        );
    }
    return list[i];
    }

    //Returns a string of the total scores collected and a printed list
    //of their values.
    public String toString() {
        //first poriton of string
        String result = "Scores =" + size + ", values=[";
        //for loop to append string with each element and spacing.
        for (int i = 0; i < size; i++) {
            result += list[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        //end of string.
        result += "])";
        return result;
    }
    
    //check to see if two objects are equal i.e. Object o and list.
    public boolean equals(Object o) {
        // check to see if both objects have the same refrence.
        if (this == o) {
            return true;
        }

        // checks if o is null or not the same object.
       if (o == null || !(o instanceof Scores)) {
            return false;
        }

        Scores other = (Scores) o;

        // ensure that the sizes match
        if (this.size != other.size) {
            return false;
        }

        // compare every element in order
        for (int i = 0; i < this.size; i++) {
            if (this.list[i] != other.list[i]) {
                return false;
            }
        }

        return true;
    }
}
