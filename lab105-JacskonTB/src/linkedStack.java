/**
 * Linked Stack taken from the following source.
 * @param <E>
 * @Title: <Data Structures and Algorithms in Java>
 * @author Michael T. Goodrich
 ∗ @author Roberto Tamassia
 ∗ @author Michael H. Goldwasser
 * @Date: <1997>
 * @Edition: <Sixth Edition>
 * @Availability: <ISBN 978-1-118-77133-4>
 * @Page(s): <233>
 * 
 * Description: 
 * This file contains implementations of algorithms/concepts described in 
 * the cited textbook specifically Code Fragments 6.4
 * 
 * transcription
 * @Author Taylor B. Schaefer-Jackson
 * @Verision 02/22/2026
 * The following Transcribed class is a linkedStack which implements the Stack
 * interface. 
 * 
 * REFRENCE TO JAVA NATIVE STACK CLASS
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html
 * 
 */

public class linkedStack<E> implements stack<E>{
    //instantiate an empty list
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    //new stack built from linked list
    public linkedStack(){}
    //Optional capacity only for the sake of implmenting all abstract methods
    //of the interface fully.
    /**
     *
     *@return the size of the list i.e. count of elements
     */
    @Override
    public int size(){return list.size();}
    /**
     *
     *@return true if list is empty else false if not.
     */
    @Override
    public boolean isEmpty(){return list.isEmpty();}

    /**
     *
     * @param e the element to be add to the first position in the list
     * @throws stack.StackFullException
     */
    @Override
    public void push(E e) throws StackFullException {
        list.addFirst(e);
    }

    /**
     *
     * @return the first element in the list.
     */
    @Override
    public E peek(){return list.first();}

    /**
     *
     * @return the removed element having been the first element in the list.
     */
    @Override
    public E pop(){return list.removeFirst();}
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        if(!this.isEmpty()){
            linkedStack<E> tempStack = new linkedStack<>();
            int tempSize = this.size();
            for(int i = 0; i < tempSize; i++){
                E temp = this.pop();
                /**
                 * try-catch implemented around the push call because
                 * toString() is a part of Object and cannot throw checked
                 * exceptions. Due to implementation all call to push need a 
                 * try-catch.
                 */
                try {
                    tempStack.push(temp);
                } catch (StackFullException ex) {
                    throw new RuntimeException("Unexpected stack overflow during toString", ex);
                }
            }
            tempSize = tempStack.size();
            for(int i = 0; i < tempSize; i++){
                E temp = tempStack.pop();
                answer.append(temp);
                //See above for modificaiton using try-catch around statement.
                try {
                    this.push(temp);
                } catch (StackFullException ex) {
                    throw new RuntimeException("Unexpected stack overflow during toString", ex);
                }
            }
            //utalize java native toString to return a string from SB object.
            return answer.toString();
        }
        return "List is empty.";
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

            if (this == o) return true;

            if (o == null || !(o instanceof linkedStack<?>))
                return false;

            linkedStack<E> other = (linkedStack<E>) o;

            if (this.size() != other.size())
                return false;

            linkedStack<E> tempA = new linkedStack<>();
            linkedStack<E> tempB = new linkedStack<>();

            boolean equal = true;

            int n = this.size();

            // Compare while popping
            for (int i = 0; i < n; i++) {
                //try-catch implemented around whole block due to push.
                try {
                    E a = this.pop();
                    E b = other.pop();
                    
                    if (a == null) {
                        if (b != null) equal = false;
                    } else if (!a.equals(b)) {
                        equal = false;
                    }
                    
                    tempA.push(a);
                    tempB.push(b);
                } catch (StackFullException ex) {
                    throw new RuntimeException("Unexpected stack overflow during toString", ex);
                }
            }

            // Restore both stacks
            for (int i = 0; i < n; i++) {
                //try-catch implemented around whole block due to push.
                try {
                    this.push(tempA.pop());
                    other.push(tempB.pop());
                } catch (StackFullException ex) {
                    throw new RuntimeException("Unexpected stack overflow during toString", ex);
                }
            }

            return equal;
    }
    
}
