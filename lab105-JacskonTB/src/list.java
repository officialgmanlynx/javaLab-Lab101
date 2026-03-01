/**
 * List interface taken from the following source.
 * @param <E>
 * @Title: <Data Structures and Algorithms in Java>
 * @author Michael T. Goodrich
 ∗ @author Roberto Tamassia
 ∗ @author Michael H. Goldwasser
 * @Date: <1997>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <259>
 * 
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 7.1
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/25/2026
 * The following Transcribed class is an ArrayQueue.
 * 
 * REFRENCE TO JAVA NATIVE QUEUE CLASS
 * 
 */
public interface list<E> {

    /**
     *
     * @return
     */
    int size();

    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @param i
     * @return
     * @throws IndexOutOfBoundsException
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     *
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     *
     * @param i
     * @param e
     * @throws IndexOutOfBoundsException
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     *
     * @param i
     * @return
     * @throws IndexOutOfBoundsException
     */
    E remove(int i) throws IndexOutOfBoundsException;

    /**
     *Here if its wanted later
     * @return
     */
    //@Override
    //String toString();

    /**
     * Here if its wanted later
     * @param o
     * @return
     */
    //@Override
    //boolean equals(Object o);
}
