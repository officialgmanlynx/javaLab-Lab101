/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser 
 * Code Fragement 7.7
 * @transcribingAuthor Taylor B. Schaefer-Jackson
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position.
     * 
     * @return the stored element
     * @thorws IllegalStateExceptoin if position no longer valid
     */
    E getElement() throws IllegalStateException;
}
