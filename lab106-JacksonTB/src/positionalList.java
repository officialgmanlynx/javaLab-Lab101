/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragement 7.8 
 * @transcribingAuthor Taylor B. Schaefer-Jackson
 */

/**
 * 
 * An Interface for a positional list.
 * @param <E> 
 */
public interface positionalList<E> {
    //

    /**
     *returns the number of elements in the list
     * @return size of list
     */
    int size();
    //

    /**
     *returns if the list is empty or not
     * @return true if empty false otherwise
     */
    boolean isEmpty();
    //

    /**
     *Returns the first position in the list or null if empty.
     * @return position of first element or null if empty
     */
    Position<E> first();
    //

    /**
     *Returns the last position in the list or null if empty.
     * @return position of last element or null if empty
     */
    Position<E> last();
    //

    /**
     *Returns the immediately position before Position p or null if p is first.
     * @param p position of compared element.
     * @return position of element before p.
     * @throws IllegalArgumentException
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;
    //

    /**
     *Returns the immediately position after Position p or null if p is last.
     * @param p position of compared element.
     * @return position of element after p
     * @throws IllegalArgumentException
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;
    //

    /**
     *Inserts element e at the front of the list and returns its position.
     * @param e
     * @return position of element e
     */
    Position<E> addFirst(E e);
    //

    /**
     *Inserts element e at the end of the list and returns its position
     * @param e
     * @return position of element e
     */
    Position<E> addLast(E e);
    //

    /**
     *Inserts element e immediately before element p and returns its position
     * @param p position of compared element
     * @param e
     * @return position of new element e
     * @throws IllegalArgumentException
     */
    Position<E> addBefore(Position<E> p,E e) throws IllegalArgumentException;
    //

    /**
     *Inserts element e immediately after element p and returns its position
     * @param p position of compared element
     * @param e
     * @return returns position of element e
     * @throws IllegalArgumentException
     */
    Position<E> addAfter(Position<E> p,E e) throws IllegalArgumentException;
    //

    /**
     *Replaces element at position p and returns replaced element.
     * @param p position of element to be removed
     * @param e element inserted
     * @return element removed
     * @throws IllegalArgumentException
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;
    //

    /**
     * removes the element at position p and returns it
     * @param p position of element to be removed
     * @return element removed
     * @throws IllegalArgumentException
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
