//USED ONLY FOR THE OVERRIDE HASHCODE TO GET RID OF PESKY ERROR MARKINGS
//INSIDE OF THE IDE.
import java.util.Arrays;
//used as needed for remove random.
import java.util.Random;

/**
 *
 * @param <E>
 * Generic object E.
 * @Author Taylor B. Schaefer-Jackson
 * @version 02.07.2026
 * @ArrayBag
 * A generic class which implements the methods of the interface and additional
 * methods as needed.
 * 
 * see the following for more details
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html
 * https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
 * 
 */
public class ArrayBag<E> implements genericBag_interface<E> {
    // A generic Array called Bag which implements its own API.
    public E[] list;
    //an integer which holds the size of the generic array.
    public int size;
    
    //consturctor
    public ArrayBag(){
        //array object set to size 2.
        this(2);
    }
    
    //generic constructor overload
    public ArrayBag(int newLength){
        //when overloaded
        this.list = (E[]) new Object[newLength];
        this.size = 0;
    }
    //helper method to return size of object in generic array.
    @Override
    public int size(){
        return this.size;
    }
    //helper method to check if generic array is empty.
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }
    //clears the array and size for the object - i.e. a reset button.
    @Override
    //clears object E.
    public void clear(){
        for (int i = 0; i < size; i++) {
            this.list[i] = null;
        }
        this.size = 0;
    }
    //checks the frequency of a element e in the array of object E.
    @Override
    //gets the frequency of element e in object E.
    public int getFrequencyOf(E e){
        int tempCount = 0;
        for(int i=0; i<this.size;i++){
            if(this.list.equals(e)){
                tempCount++;
            }
        }
        return tempCount;
    }
    //checks if an element e exists in the object array E.
    @Override
    public boolean contains(E e){
        //Iterate through the object using a comparison with size.
        for(int i=0;i<this.size;i++){
            //if element e at index i of object E is equal to input e return true.
            if(this.list[i].equals(e)){
                return true;
            }
        }
        //if full iteration occurse return false.
        return false;
    }
    //method to add new e to tail of E.
    @Override
    //adds an element e to object E.
    public void add(E e){
        //check size of Object array E before adding element e.
        if(this.size == this.list.length){
            //creates a temp Object array twice the size of E.
            E[] temp =(E[]) new Object[this.list.length*2];
            //Copies the contents of Object to a temp Object of twice the size.
            // Using System.arraycopy(source, srcPos, destination, destPos, length)
            System.arraycopy(this.list, 0, temp, 0, this.list.length);
            //Copy temp to E setting E to the Object size with all 
            //original e in order.
            list = temp;   
        }
        //add the next numer to the array list.
        this.list[this.size]=e;
        this.size++;
    }
    @Override
    //removes and element e from object E.
    public E remove(E e){
    // check if int num in list
        if(this.contains(e)) {
            // iterate to index of int num in array list
            for(int i = 0; i < this.size; i++){
                // index of int num in array list found
                if(this.list[i].equals(e) && list[i] != null){
                    // a temporary storage val for return.
                    E temp = list[i];
                    // shift all elements right of index left one
                    for(int j = i; j < this.size - 1; j++){
                        this.list[j] = this.list[j+1];
                    }
                    // set last element to 0
                    this.list[this.size - 1] = null;
                    // decrement size
                    this.size--;
                    // stop after removing first occurrence
                    return temp;
                }
            }
        }
        return null;
    }
    // removes a random number from the list utalizing the remove method
    @Override
    public E remove(){
        if (size == 0) {
            throw new IllegalStateException("The remove() method cannot be called on an null object");
        }
        //create an instance of the Random class
        Random r = new Random();
        //Remove a random int from (0, size)
        // by picking a random index
        int randomIndex = r.nextInt(size);
        //grabbing the value of the int at that index
        E valueToRemove = list[randomIndex];
        remove(valueToRemove);
        return valueToRemove;
    }
    
    @Override
    public E get(int i){
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
    @Override
    public String toString() {
        //first poriton of string
        String result = "";
        //for loop to append string with each element and spacing.
        for (int i = 0; i < size; i++) {
            result += list[i];
            if (i < size - 1) {
                result += "\n";
            }
        }
        //end of string.
        result += "\n\n\n";
        return result;
    }
    
    //check to see if two objects are equal i.e. Object o and list.
    @Override
    //makes use of java wildcards see the following for more details.
    //https://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
    public boolean equals(Object o) {
        // check to see if both objects have the same refrence.
        if (this == o) {
            return true;
        }

        // checks if o is null or not the same object.
       if (o == null || !(o instanceof ArrayBag<?>)) {
            return false;
        }

        ArrayBag<?> other = (ArrayBag<?>) o;

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
    //check how many items are actually in the bag not to be confused with size
    public int checkCount() {
        int count= 0;
        int i = 0;
        while(this.list[i]!=null){
            if(this.list[i]!=null){
                count++;
            }
            i++;
        }
        return count;
    }
    //shrinks the size of the bag array so that its length 
    //is equal to the number of objects currently in the bag array.
    public void trim() {
        int countVal = this.checkCount();
        if(this.size!=countVal){
            E[] temp = (E[]) new  Object[countVal];
            System.arraycopy(this.list, 0, temp, 0, countVal);
            list = temp;
        }
    }
    //Added using IDE only to get rid of erros markings to make revision
    //more easy of a task.
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Arrays.deepHashCode(this.list);
        hash = 41 * hash + this.size;
        return hash;
    }
}
