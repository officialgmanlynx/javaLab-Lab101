/**
 * ArrayQueue taken from the following source.
 * @Title: <Data Structures and Algorithms in Java>
 * @author Michael T. Goodrich
 ∗ @author Roberto Tamassia
 ∗ @author Michael H. Goldwasser
 * @Date: <1997>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <243>
 * 
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 6.10
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/22/2026
 * The following Transcribed class is an ArrayQueue.
 * 
 * REFRENCE TO JAVA NATIVE QUEUE CLASS
 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * 
 */

//∗∗ Implementation of the queue ADT using a fixed-length array.
public class arrayQueue<E> implements queue<E>{
    public static final int CAPACITY = 1000; //Defualt array capacity.
    //instance variables.
    private E[] data; //generic array used for storage.
    private int f=0; //index of the front element
    private int sz=0; //current number of elements
    
    
    //constructor
    public arrayQueue(){this(CAPACITY);} //construct queue with default capacity.

    /**
     * construct queue with given capacity
     * @param capacity capacity of arrayQueue
     */
    public arrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }
    //methods

    /**
     *
     * @return
     */
    @Override
    public int size(){return sz;}

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty(){return sz==0;}
    
    /**
     *
     * @param e
     * @throws IllegalStateException
     */
    @Override
    public void enqueue(E e) throws QueueFullException {
        if(sz==data.length){
            throw new QueueFullException("Queue is full.");
        }
        //use modular arithmatic to prevent out of bound crash
        //circular array flow
        int avail=(f+sz)%data.length;
        data[avail]=e;
        sz++;
    }

    /**
     *
     * @return
     */
    @Override
    public E peek(){
        if(isEmpty()) return null;
        return data[f];
    }

    /**
     *
     * @return
     */
    @Override
    public E dequeue(){
        if(isEmpty()) return null;
        E answer = data[f];
        data[f]=null;
        f=(f+1)%data.length;
        sz--;
        return answer;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<sz;i++){
            int index = (f + i) % data.length;
            result.append(data[index]);
        }
           return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        // checks if o is null or not the same object.
        if (o == null || !(o instanceof arrayQueue<?>)) {
             return false;
        }
        arrayQueue<?> other = (arrayQueue<?>) o;
        // ensure that the sizes match
        if (this.sz != other.sz) {
            return false;
        }
        // compare every element in order
        for (int i = 0; i < this.sz; i++) {
            int indexA = (this.f + i) % this.data.length;
            int indexB = (other.f + i) % other.data.length;
            E elemThis = this.data[indexA];
            Object elemOther = other.data[indexB];
            if (elemThis == null) {
                if (elemOther != null) return false;
            } else if (!elemThis.equals(elemOther)) {
                return false;
            }
        }
        return true;
    }
    
}
