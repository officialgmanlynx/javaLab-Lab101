/**
 * Data Structures & Algorithms 6th Edition 
 * @author Goodrick, Tamassia, Goldwasser
 * Code Fragements 7.9, 7.10, 7.11, 7.12 & 7.14
 * 
 *  @TranscribingAuthor Taylor B. Schaefer-Jackson
 */
public class linkedPositional_list<E> implements positionalList<E>{
    //Nested Node Class//
    private static class Node<E> implements Position<E>{
        //Refrence to element stored at this node.
        private E element;
        //Refrence to previous node in the list.
        private Node<E> prev;
        //Refrence to next node in the list.
        private Node<E> next;
        //OverRide Constructor
        public Node(E e, Node<E> p, Node<E> n){
            this.element = e;
            this.prev = p;
            this.next = n;
        }
        @Override
        public E getElement() throws IllegalArgumentException {
            //Convention for defunct node
            if(this.next == null) {
                throw new IllegalArgumentException("Positon Invalid");
            }
            return this.element;
        }
        public Node<E> getPrev() {
            return this.prev;
        }
        public Node<E> getNext() {
            return this.next;
        }
        public void setElement(E e){
            this.element = e;
        }
        public void setPrev(Node<E> e){
            this.prev = e;
        }
        public void setNext(Node<E> e){
            this.next = e;
        }
    }
    //END OF NESTED NODE CLASS//
    //Instance Variables for linedPositional_list class//
    //Header setinal
    private Node<E> Header;
    //Trailer setinal
    private Node<E> Trailer;
    //number of elements in the list
    private int size = 0;
    
    //CONSTRUCTOR - new empty list
    public linkedPositional_list(){
        //Create header node with no element, next, nor prev.
        this.Header = new Node<>(null, null, null);
        //Create Trailer node with no element nor next, set prev as Header.
        this.Trailer = new Node<>(null,Header,null);
        //Set Header next node as Trailer.
        this.Header.setNext(Trailer);
    }
    
    //Private Utilities//
    /**
     * Validates the position of a Node and returns it as a Node
     */
    private Node<E> validate(Position<E> p)throws IllegalArgumentException{
        if(!(p instanceof Node)) 
            throw new 
        IllegalArgumentException("INVALID P IS NOT A NODE OR DOES NOT EXIST");
        //Safe cast
        Node<E> node = (Node<E>) p;
        if(node.getNext()==null)
            throw new IllegalArgumentException("P IS NO LONGER IN THE LSIT");
        return node;
    }
    
    /**
     * Returns the given node as a position or null if it is a sentinel.
     */
    private Position<E> position(Node<E> node){
        if(node == Header || node == Trailer) return null;
        return node;
    }
    
    //Public Accessor Methods

    /**
     *
     * @return the size of the linked positional list.
     */

    @Override
    public int size(){return this.size;}
    
    /**
     *
     * @return true if empty false otherwise.
     */
    @Override
    public boolean isEmpty(){return this.size==0;}
    
    /**
     *
     * @return first position in linked list or null if empty.
     */
    @Override
    public Position<E> first(){
        return position(this.Header.getNext());
    }
    
    /**
     *
     * @return last position in linked list or null if empty.
     */
    @Override
    public Position<E> last(){
        return position(this.Trailer.getPrev());
    }
    
    /**
     *
     * @param p position in list
     * @return position before position p.
     * @throws IllegalArgumentException
     */
    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    
    /**
     *
     * @param a position in list
     * @return position after position a.
     * @throws IllegalArgumentException
     */
    @Override
    public Position<E> after(Position<E> a) throws IllegalArgumentException {
        Node<E> node = validate(a);
        return position(node.getNext());
    }
    
    //private util.
    /**
     * 
     * @param e element to be added
     * @param pred predecessor node
     * @param succ successor node
     * @return new node
     */
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
        //creat and link a new node
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }
    
    //public update methods

    /**
     *
     * @param e element to be added beginning.
     * @return new position of element.
     */
    @Override
    public Position<E> addFirst(E e){
        //insert right after header
        return addBetween(e, Header, Header.getNext());
    }
    
    /**
     *
     * @param e element to be inserted at the end of the list
     * @return the position of the new element
     */
    @Override
    public Position<E> addLast(E e){
        //insert right before trailer
        return addBetween(e, Trailer.getPrev(), Trailer);
    }
    
    /**
     *
     * @param p position of comparison for insertion.
     * @param e element to be inserted.
     * @return new node
     * @throws IllegalArgumentException
     */
    public Position<E> addBefore(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    
    /**
     *
     * @param a position of comparison for insertion.
     * @param e element to be inserted.
     * @return new node
     * @throws IllegalArgumentException
     */
    public Position<E> addAfter(Position<E> a,E e) throws IllegalArgumentException{
        Node<E> node = validate(a);
        return addBetween(e, node, node.getNext());
    }
    
    /**
     *
     * @param p position to be changed
     * @param e element to be inserted at p
     * @return removed element
     * @throws IllegalArgumentException
     */
    @Override
    public E set(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
    
    /**
     *
     * @param p position for removal
     * @return element removed
     * @throws IllegalArgumentException
     */
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
        
    }
    
}
