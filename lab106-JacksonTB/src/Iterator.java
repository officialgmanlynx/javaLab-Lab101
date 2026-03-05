/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser 
 * Section 7.4
 * @transcribingAuthor Taylor B. Schaefer-Jackson
 */
public interface Iterator<E> {

    /**
     *
     * @return false if no next element true otherwise.
     */
    boolean hasNext();

    /**
     *
     * @return the next element in the sequence.
     */
    E next();

    /**
     * Removes the element last called from hasNext or throws an IAE if hasNext
     * has not yet been called or if remove has already been called since the 
     * last call of hasNext.
     * @throws IllegalStateException
     */
    void remove() throws IllegalStateException;
}
