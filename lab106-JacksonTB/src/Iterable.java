/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser 
 * Section 7.4.1
 * @transcribingAuthor Taylor B. Schaefer-Jackson
 */
public interface Iterable<E> {
    //returns an iterator of the elements in the collection.
    Iterator<E> iterator();
}
