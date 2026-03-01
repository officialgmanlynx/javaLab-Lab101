
/**
 * SinglyLinkedList Class taken from the following source.
 * @Title: <Data Structures and Algorithms in Java>
 * @Author: <Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser>
 * @Date: <Publication year>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <Pages 123-126>
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 3.14 & 3.15.
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/07/2026
 * The following Transcribed class is a generic SinglyLinkedList which 
 * stores elements in linked nodes that hold a reference to the next node;
 * additionally the list holds reference to the head and tail, first and last,
 * node respectively, to allow efficient dual end insertion, though deletion
 * can only occur at the head.
 * 
 *@param <E> the type of elements stored in the list
 * 
 * @code Node
 * This implementation uses an inner static {@code Node} class to represent
 * each element in the list. The list grows dynamically as elements are added.
 * 
 *Supported operations include:
 *Checking the size of the list
 *Checking whether the list is empty
 *Accessing the first and last elements
 *Adding elements to the front or end of the list
 *Removing the first element
 * 
 */
public class SinglyLinkedList<E> {
    //---Nested Node Clas---
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {return element;}
        public Node<E> getNext() {return next;}
        public void setNext(Node<E> n) {next = n;}
    } //End of nested node class
    //instance var of SinglyLinkedList
    private Node<E> head = null; //head node of list
    private Node<E> tail = null; //tail node of list
    private int size = 0; //number of nodes
    public SinglyLinkedList() {} //construct of empty list
    //access method
    public int size() {return size;}
    public boolean isEmpty(){return size == 0;}
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if(size ==0)
            tail = head;
        size++;
    }
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
               head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public E removeFirst(){
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }
}
