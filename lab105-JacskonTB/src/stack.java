/**
 * stack interface taken from the following source.
 * @param <E> generic type parameter
 * @Title: <Data Structures and Algorithms in Java>
 * @author Michael T. Goodrich
 ∗ @author Roberto Tamassia
 ∗ @author Michael H. Goldwasser
 * @Date: <1997>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <229>
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 6.1.
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/21/2026
 * The following Transcribed class is a stack interface which forms constraints
 * between the sub-classes and the outer world. It also promises formal behavior
 * of all subclasses at run time. In particular it is q collection of objects 
 * that are inserted and removed according to the last-in first-out principle. 
 * Although similar in purpose, this interface differs from java.util.Stack.
 * 
 * REFRENCE TO JAVA NATIVE STACK CLASS
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html
 * 
 */
public interface stack<E>{
    /**
     * Returns the number of elements in the stack 
     * @return number of elements in stack.
     */
    int size();
    /**
     * Tests whether the stack is empty
     * @return true if stack empty, false otherwise.
     */
    boolean isEmpty();
    /**
     * Inserts an element at the top of the stack or throws a StackFullException
     * if the stack is full.
     * @param e the element to be inserted
     */
    void push(E e) throws StackFullException;
    /**
     * Returns, but doesn't remove the top element of the stack.
     * @return the top element of the stack (or null if empty).
     */
    E peek(); //modified to peek to be concurrent with Java native Class Stack
    /**
     * Removes and returns the top element of the stack.
     * @return the top element of the stack removed (or null if empty).
     */
    E pop();
    /**
     * Returns the 1-based position where an object is in the stack.
     * Not implemented, but commented out in case it may be of use in 
     * future projects
     * @return returns the 1-base position of the object in stack.
     */
    //int search();
    /**
     * Concatenates elements of the stack and converts them to a String
     * @Override overrides method toString from Class Vector<E>
     * REFRENCE CLASS VECTOR<E>
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Vector.html#toString()
     * @return Concatenated string of elements in stack.
     */
    @Override
    String toString();
    /**
     * 
     * @param o
     * @return returns true if two objects equal else false.
     */
    @Override
    boolean equals(Object o);
    
    
   

    /**
     * Exception thrown when a stack is full.
     * 
     * //exception subclass
     * //REFRENCE
     * //https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html
     * //I chose a subclass rather than a full class to avoid package clutter.
     */
    
    class StackFullException extends Exception {
        /** Default constructor */
        //calls on the superClass Exception.
        public StackFullException(){super();}
        /** Constructor with a custom error message
         * @param message custom String to be passed through super.*/
        //Feeds a String i.e. error message to the superClass.
        public StackFullException(String message) {super(message);}
    }
    
    
}
