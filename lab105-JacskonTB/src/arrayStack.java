/**
 * Array Stack taken from the following source.
 * @param <E> generic type parameter
 * @Title: <Data Structures and Algorithms in Java>
 * @author Michael T. Goodrich
 ∗ @author Roberto Tamassia
 ∗ @author Michael H. Goldwasser
 * @Date: <1997>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <230>
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 6.1.2
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/21/2026
 * The following Transcribed class is a arrayStack which implements the Stack
 * interface. 
 * 
 * REFRENCE TO JAVA NATIVE STACK CLASS
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html
 * 
 */

public class arrayStack<E> implements stack<E>{
    public static final int CAPACITY = 1000; //Defualt array capacity.
    private E[] data; //generic array used for storage
    private int t=-1; //index of the top element in the stack

    /**
     * Constructs an arrayStack with default capacity.
     */
    public arrayStack(){this(CAPACITY);}
    public arrayStack(int capacity){ //constructs arrayStack with given capacity.
        data = (E[]) new Object[capacity]; //safe case to generic array object.
    }
    
    
    /**
     * 
     * @return the size of the stack 0 if empty; 
     */
    @Override
    public int size() {
        return t+1;
    }

    /**
     * 
     * @return true if empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return t==-1;
    }

    /**
     * 
     * Add an element to the stack.
     * @param e the element added to the stack.
     * @throws stack.StackFullException if the stack is full.
     */
    @Override
    public void push(E e) throws StackFullException {
        //check if the stack is full
        if(size()==data.length){
            //stack is full then throw new exception
            throw new StackFullException("Stack is full");
        }
        //if stack is not full then...
        data[++t] = e; //increment t then store new item
    }

    /**
     * Checks if the stack is empty, if not return the top element.
     * @return the top element in the stack
     */
    @Override
    public E peek() {
        //check if the stack is empty
        if(isEmpty()){
            //the stack is empty os return null.
            return null;
        }
        //the stack is not empty so return element of data at index t.
        return data[t];
    }

    /**
     * Returns the top element of the stack and removes it from the stack.
     * @return the top element of the stack that has been removed.
     */
    @Override
    public E pop() {
        //check if the stack is empty
        if(isEmpty()){
            //the stack is empty so return null.
            return null;
        }
        //the stack is not empty create a temp element called answer
        //and assign the element at data[t] to it.
        E answer = data[t];
        //Assign the element at data[t] as null.
        //this eases the load on java garbage clean up; similar to malloc, 
        //helps to avoid memory leaks in long-lived arrays.
        //dereference to help garbage collection
        data[t]=null;
        //decrement t
        t--;
        //returnt the element removed.
        return answer;
    }
    
    /**
     *
     * @return the concatenated values of data as a string.
     */
    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i<t+1;i++){
            result += data[i];
        }
           return result;
    }
    
    /**
     *
     * @param o an object to be checked for equivalence.
     * @return a Boolean true if both objects are equal false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        boolean answer = true;
        // check to see if both objects have the same refrence.
        if(this == o) {
            answer=true;
            return answer;
        }
        // checks if o is null or not the same object.
        if (o == null || !(o instanceof arrayStack<?>)) {
            answer=false;
             return answer;
         }
        arrayStack<?> other = (arrayStack<?>) o;
        // ensure that the sizes match
        if (this.t != other.t) {
            answer = false;
            return answer;
        }
        // compare every element in order
        for (int i = 0; i <= this.t; i++) {
            if (this.data[i] != other.data[i]) {
                answer = false;
                return answer;
            }
        }
        return answer;
    }

}