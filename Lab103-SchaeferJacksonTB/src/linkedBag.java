//imported only for hash coded to get rid of pesky flags
import java.util.Objects;
//imported to generate a random int.
import java.util.Random;

/**
 * Generic object E.
 * @Author Taylor B. Schaefer-Jackson
 * @version 02.07.2026
 * @param <E>
 * Object parameter denoted at E.
 * 
 * Resources used
 * https://docs.oracle.com/javase/tutorial/java/javaOO/usingobject.html
 * 
 * @linkedBag a generic class which implements a generic interface. It can
 * return the size of the object, check if the object is empty, clear the
 * object, get the frequency of an element (e) in the object (E), check if an
 * element (e) is in object (E), add an element, remove a specific or random
 * element, get the index of a specific element, convert the elements of the
 * object to a string, or compare two objects to see if they are the same.
 * 
 */
public class linkedBag<E> implements genericBag_interface<E> {
    private SinglyLinkedList<E> list;
    
    //constructor
    public linkedBag(){
        list = new SinglyLinkedList<>();
    }
    
    //constructor overload
    public linkedBag(int newSize){
        this();
    }

    @Override
    //returns the size of object using SinglyLinkedList.java
    public int size() {
        return list.size();
    }

    @Override
    //returns boolean of object wether empyty or not using SinglyLinkedList.java
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    //clears list my simply overwriting it with new list - i.e. new save on old.
    public void clear() {
        list = new SinglyLinkedList<>();
    }

    @Override
    //gets the frequency of e in E
    public int getFrequencyOf(E e) {
        int count = 0;
        int n = list.size();
        for(int i = 0; i < n; i++){
            E temp = list.removeFirst();
            if(e == null ? temp == null : e.equals(temp)){
                count++;
            }
            list.addLast(temp);
        }
        return count;
    }

    @Override
    //checks to see if element e is in Object E SinglyLinkedList.
    //uses a circular pattern to iterate through the nodes by creating a
    //a temporary copy of list deleting the first element and adding it to the 
    //end so that each node can be iterated through.
    public boolean contains(E e) {
        int n = list.size();
        //iterate through using size.
        for (int i = 0; i < n; i++) {
            // E temp allows for circular iteration through nodes.
            E temp = list.removeFirst();
            //check if e not null.
            if (e == null) {
                if (temp == null) return true;
            } else {
                if (e.equals(temp)) return true;
            }
            list.addLast(temp);
        }

        return false;
    }

    @Override
    //adds an element e to E on the tail.
    public void add(E e) {
        list.addLast(e);
    }

    @Override
    //see the following for more details
    //https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
    //removes an elment e from E using a circular pattern.
    public E remove(E e) {
        int n = list.size();
        for(int i=0;i<n;i++){
           E temp = list.removeFirst();
           //shorthand if else statement
           //see the following
           //https://www.w3schools.com/java/java_conditions_shorthand.asp
           if(e == null ? temp == null: e.equals(temp)) {
               return temp;
           }
           list.addLast(temp);
        }
        return null;
    }

    @Override
    //uses the same pattern as previous method, but finds e at random index
    public E remove() {
        if(list.size() == 0) return null;
        //Generate a random int for index.
        Random r = new Random();
        int randomIndex = r.nextInt(list.size());
        //return var declared
        E removed = null;
        //use same circular patterns as previous two methods to iterate
        //through the nodes and eliminate the intended node then cycle through
        //and return nodes to original order less removed random node.
        for(int i=0;i<list.size();i++){
            E temp = list.removeFirst();
            if(i==randomIndex){
                removed = temp;
            } else {
                list.addLast(temp);
            }
        }
        return removed;
    }

    @Override
    //returns e from E at index i else returns exception if out of bounds.
    public E get(int q) {
        //used only as a placeholder for the e to be returned from E.
        E placeHolder = null;
        //check to see if in bounds.
        if(q >= list.size() || q < 0) {
            //see the following
            //https://docs.oracle.com/javase/8/docs/api/java/lang/IndexOutOfBoundsException.html
            throw new IndexOutOfBoundsException();
        }
        //for loop using circular iteration concept taken from circular singly
        //lists in the text.
        for(int i=0;i<list.size();i++){
            E temp = list.removeFirst();
            //if index proper set placeHolder to equal temp
            if(q==i){
                placeHolder = temp;
            } else {
                list.addLast(temp);
            }
        }
        return placeHolder;
    }
    @Override
    //converts contents to a string using a string builder.
    //recycled from lab 101.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");

        int n = list.size();
        for (int i = 0; i < n; i++) {
            E temp = list.removeFirst();
            sb.append(temp);
            if (i < n - 1) {
                sb.append("\n");
            }
            list.addLast(temp);
        }

        sb.append("\n\n\n");
        return sb.toString();
    }
    @Override
    //checks to see if two objects are equal.
    public boolean equals(Object o) {
        if (this == o) return true;
        //check if object null or of different class.
        if (o == null || getClass() != o.getClass()) return false;
        //create a temp E for comparison.
        linkedBag<E> other = (linkedBag<E>) o;
        //check if same size.
        if (this.size() != other.size()) return false;
        //create temp int equal to list size.
        int n = list.size();
        //iterate through nodes.
        for (int i = 0; i < n; i++) {
            E tempThis = list.removeFirst();
            E tempOther = other.list.removeFirst();
            boolean equal;
            if (tempThis == null) {
                equal = (tempOther == null);
            } else {
                equal = tempThis.equals(tempOther);
            }
            list.addLast(tempThis);
            other.list.addLast(tempOther);

            if (!equal) return false;
        }

        return true;
    }

    @Override
    //hash code implemented only because my OCD goes haywire if I see little
    //red squiggly lines anywhere.
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.list);
        return hash;
    }
}
