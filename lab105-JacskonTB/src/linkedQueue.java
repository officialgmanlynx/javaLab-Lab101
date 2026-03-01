/**
 * LinkedQueue taken from the following source.
 * @param <E>
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
 * @Verision 02/24/2026
 * The following Transcribed class is an LinkedQueue.
 * 
 * REFRENCE TO JAVA NATIVE QUEUE CLASS
 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * 
 */
public class linkedQueue<E> implements queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>( ); // an empty list
    public linkedQueue( ) { } // new queue relies on the initially empty list
    /**
     *
     * @return the size value of the list.
     */
    @Override
    public int size( ) { return list.size( ); }

    /**
     *
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty( ) { return list.isEmpty( ); }

    /**
     *
     * @param element the element to be added into the queue.
     */
    @Override
    public void enqueue(E element){ 
        list.addLast(element); }

    /**
     *
     * @return the first element in the queue.
     */
    @Override
    public E peek() {
        return list.first();
    }

    /**
     *
     * @return the element removed from the queue.
     */
    @Override
    public E dequeue( ) { return list.removeFirst( ); }

    /**
     *
     * @return a concatenation of the elements in list as a string.
     */
    @Override
    public String toString(){
        if (isEmpty()) return "";
        StringBuilder answer = new StringBuilder();
        int tempSize = list.size();
        for(int i = 0; i < tempSize; i++){
                E temp = this.dequeue();
                answer.append(temp);
                this.enqueue(temp);
            
        }
        return answer.toString();
    }

    /**
     *
     * @param o an object for comparison.
     * @return true if equal false otherwise.
     * REFRENCE
     * FOR USAGE OF VAR SEE...
     * https://docs.oracle.com/en/java/javase/17/language/local-variable-type-inference.html
     */
    @Override
    public boolean equals(Object o) {
        boolean answer = true;
        if(this == o) {
            return answer;
        }
        // checks if o is null or not the same object.
        if (o == null || !(o instanceof linkedQueue<?>)) {
            answer = false;
            return answer;
        }
        linkedQueue<E> other = (linkedQueue<E>) o;
        // ensure that the sizes match
        if (this.size() != other.size()) {
            answer = false;
            return answer;
        }
        SinglyLinkedList<E> tempThis = new SinglyLinkedList<>();
        SinglyLinkedList<E> tempOther = new SinglyLinkedList<>();
        for(int i = 0; i < this.size(); i++){
            var thisElement = (E) this.dequeue();
            var thatElement = (E) other.dequeue();
            // Check if Null
            if (thisElement == null) {
                if (thatElement != null) {
                    answer = false;  // one is null, the other is not → not equal
                }
            //Chekc if elements equals
            } else {
                if (!thisElement.equals(thatElement)) {
                    answer = false;  // both non-null but not equal → not equal
                }
            }
            tempThis.addLast(thisElement);
            tempOther.addLast(thatElement);
        }
        //Loop to return Linked Queues back to normal.
        for(int i = 0; i <tempThis.size(); i++){
                var THIS = (E) tempThis.removeFirst();
                var THAT = (E) tempOther.removeFirst();
                this.enqueue(THIS);
                other.enqueue(THAT);
            
        }
        return answer;
    }
}
