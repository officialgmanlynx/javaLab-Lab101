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
 * @Page(s): <260-261>
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
 * 
 */
public class arrayList<E> implements list<E>{
    //instance variable
    public static int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    //constructor
    public arrayList(){this(CAPACITY);}
    public arrayList(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    //public methods

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i,E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i]=e;
        return temp;
    }

    @Override
    public void add(int i,E e) throws IndexOutOfBoundsException {
        //Please see below as to why this helper method is called.
        checkIndexForAdd(i, size); // allow adding at the end
        if(size==data.length){
            throw new IllegalStateException("Array is Full");
        }
        for(int k=size-1;k>=i;k--){
            data[k+1]=data[k];
        }
        data[i]=e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for(int k=i;k<size-1;k++){
            data[k]=data[k+1];
        }
        data[size-1]=null;
        size--;
        return temp;
    }
    
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if(i<0||i>=n){
            throw new IndexOutOfBoundsException("Illegal Index" + i);
        }
    }
    /**Here if its wanted for later*/
    //@Override
    //public String toString(){
    //    return "";
    //}
    
    //public boolean isEqual(){
    //    return true;
    //}
    
    /**
     * The implementation of arrayList does not allow adding at i == size.
     * My workaround is a helper method.
     * @param i
     * @param n
     * @throws IndexOutOfBoundsException 
     */
    protected void checkIndexForAdd(int i, int n) throws IndexOutOfBoundsException {
    if(i < 0 || i > n){  // note: i > n, not i >= n
        throw new IndexOutOfBoundsException("Illegal Index " + i);
    }
    }
    
    
}
