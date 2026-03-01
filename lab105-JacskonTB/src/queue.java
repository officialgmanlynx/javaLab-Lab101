/**
 * Queue interface taken from the following source.
 * @param <E>
 * @Title: <Data Structures and Algorithms in Java>
 * @author Michael T. Goodrich
 ∗ @author Roberto Tamassia
 ∗ @author Michael H. Goldwasser
 * @Date: <1997>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <239>
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 6.9
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/22/2026
 * The following Transcribed class is a queue interface.
 * 
 * REFRENCE TO JAVA NATIVE QUEUE CLASS
 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * 
 */
public interface queue<E> {
    /**
     *
     * @return the number of elements in the queue.
     */
    int size();
    /**
     * 
     * @return true if queue is empty otherwise false.
     */
    boolean isEmpty();
    /**
     * 
     * @param e element to be inserted at the rear of the queue 
     * without violating capacity restrictions or throws
     * IllegalStateException if no space is currently available.
     * @throws queue.QueueFullException if Queue is full.
     */
    void enqueue(E e) throws QueueFullException;
    /**
     * 
     * @return The first element, not removed, of the queue(null if empty).
     */
    E peek();
    /**
     * 
     * @return Removes and returns the first element of the queue(null if empty).
     */
    E dequeue();
    /**
     * 
     * @return A concatenated string of the elements in the queue.
     */
    @Override
    String toString();
    /**
     * 
     * @param o
     * @return true if two ques are equal or false if not.
     */
    @Override
    public boolean equals(Object o);
    
    /**
     * A class which defines the extension of Exception called QueueFullException.
     * 
     */
    class QueueFullException extends Exception {
        //*DEFUALT CONSTRUCTOR*/
        public QueueFullException(){super();}
        //*Override*/
        public QueueFullException(String message){super(message);}
    }
    
    
}
