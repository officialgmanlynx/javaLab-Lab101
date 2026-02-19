/**
 *
 *
 * @Author Taylor B. Schaefer-Jackson
 * @version 02.07.2026
 * @genericBag_interface
 * A generic API for communication and developer enforcement which contains
 * public abstract methods which uses the generic placeholder denoted as Z.
 * 
 * @param <E>
 * A generic placeholder.
 * 
 * @Citations
 * please see the following resources for additional information
 * https://docs.oracle.com/javase/tutorial/extra/generics/simple.html
 * https://docs.oracle.com/javase/tutorial/java/IandI/usinginterface.html
 * https://www.geeksforgeeks.org/java/generic-constructors-and-interfaces-in-java/
 * https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html
 */
public interface genericBag_interface<E>{
    int size(); //returns a count of items in the bag boolean.
    boolean isEmpty(); //checks if the bag is empty, returns true when empty
    void clear(); //removes all the items from the bag
    int getFrequencyOf (E e); //returns a count the number of times z in bag.
    boolean contains (E e); //Tests whether the bag contains the item z.
    void add (E e);//adds item z to the next 'free' position in bag.
    E remove (E e);//removes first occurence of z in bag, return null if
    //item not in bag or bag is null.
    E remove();//removes random z from bag and returns z or null if empty.
    E get(int i);//returns Z at index i else returns exception if out of bounds.
    @Override //override notation see citations.
    String toString();//returns a string of contents of bag.
    @Override // override notation see citations.
    boolean equals(Object o);//returns true if two objects are equal in size,
    //content and order.
}
