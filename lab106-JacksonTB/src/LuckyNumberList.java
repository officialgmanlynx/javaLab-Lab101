import java.util.NoSuchElementException;

/**
 * @version 3/4/2026
 * @author Taylor B. Schaefer-Jackson
 * An implementation fo Lucky number list which can be called be client. 
 * It instantiates a variation doubly linked listed called linkedPositonal_list
 * which contains nodes 
 */
public class LuckyNumberList {
    private linkedPositional_list<LuckyNumber> luckynumberlist = null;
    
    /**
     * Constructor builds a list of LuckyNumbers.
     */
    public LuckyNumberList(){
        luckynumberlist = new linkedPositional_list<>();
    }
    
    //public methods

    /**
     *
     * @param number
     */
    public void addLuckyNumber(LuckyNumber number){
        luckynumberlist.addLast(number);
    }

    /**
     *
     * @param number
     * @return
     */
    public boolean isEven(int number){
        if(number==0) return false;
        return (number % 2)==0;
    }
    
    public boolean isPrime(int number){
        if(number<=1) return false; //0 and 1 are not prime
        if(number==2) return true; //only even prime number
        if(isEven(number)) return false;
        //check for odd inegers less than the square root of number.
        for(int i=3; i*i<=number;i+=2){
            if(number%i==0) return false;
        }
        return true;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringbuilder =new StringBuilder();
        Position<LuckyNumber> position = luckynumberlist.first();
        while(position!=null){
        stringbuilder.append(position.getElement()).append("\n");
        position = luckynumberlist.after(position);
        }
        return stringbuilder.toString();
    }
    
    //an iterator that iterates over the positions in the list 
    //that have an even value
    //
    //-------NESTED POSITION ITERATOR CLASS-------//
    private class evenLucky_positionIterator implements Iterator<Position<LuckyNumber>>{
        //Position of the next element to report
        private Position<LuckyNumber> cursor = luckynumberlist.first();
        //position of the last reported element
        private Position<LuckyNumber> recent = null;
        /**
         * Testing whether the iterator has a next object
         */
        @Override
        public boolean hasNext(){return (cursor!=null);}
        /**
         * 
         * @return the next position in the iterator
         * @throws NoSuchElementException 
         */
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if(recent==null){
                while(cursor!=null&&!isEven(cursor.getElement().getLucky_number())) {
                    cursor = luckynumberlist.after(cursor);
                }
            }
            if(cursor==null)throw new NoSuchElementException("Nothing is left");
            recent = cursor;
            cursor = luckynumberlist.after(cursor);
            //Advance cursor to the next even number//
            while(cursor!=null&&!isEven(cursor.getElement().getLucky_number())){
                cursor = luckynumberlist.after(cursor);
            }
            
            return recent;
        }
        /**
         * Removes the element returned by most recent call to next.
         */
        @Override
        public void remove()throws IllegalStateException{
            if(recent==null)throw new IllegalStateException("Nothing to remove.");
            //Remove from the outer list
            luckynumberlist.remove(recent);
            //Do not all remove again until next is called.
            recent=null;
        }
    }
    //-------END OF NESTED POSITION ITERATOR CLASS-------//
    //
    //
    //an iterator that iterates over the positions in the list that have a prime 
    //
    //-------NESTED POSITION ITERATOR CLASS-------//
    private class primeLucky_positionIterator implements Iterator<Position<LuckyNumber>>{
        //Position of the next element to report
        private Position<LuckyNumber> cursor = luckynumberlist.first();
        //position of the last reported element
        private Position<LuckyNumber> recent = null;
        /**
         * Testing whether the iterator has a next object
         */
        @Override
        public boolean hasNext(){return (cursor!=null);}
        /**
         * 
         * @return the next position in the iterator
         * @throws NoSuchElementException 
         */
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if(recent==null){
                while(cursor!=null&&!isPrime(cursor.getElement().getLucky_number())) {
                    cursor = luckynumberlist.after(cursor);
                }
            }
            if(cursor==null)throw new NoSuchElementException("Nothing is left");
            recent = cursor;
            cursor = luckynumberlist.after(cursor);
            //Advance cursor to the next prime number//
            while(cursor!=null&&!isPrime(cursor.getElement().getLucky_number())){
                cursor = luckynumberlist.after(cursor);
            }
            
            return recent;
        }
        /**
         * Removes the element returned by most recent call to next.
         */
        @Override
        public void remove()throws IllegalStateException{
            if(recent==null)throw new IllegalStateException("Nothing to remove.");
            //Remove from the outer list
            luckynumberlist.remove(recent);
            //Do not all remove again until next is called.
            recent=null;
        }
    }
    //-------END OF NESTED POSITION ITERATOR CLASS-------//
    //-------NESTED POSITION ITERABLE CLASSES-------//
    private class EvenPositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator(){
            return new evenLucky_positionIterator();
        }
    }
    
    private class PrimePositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new primeLucky_positionIterator();
        }
    }
    //-------END OF NESTED POSITION ITERABLE CLASSES-------//
    /**
     * @return an iterable representation of the list's even positions.
     */
    public Iterable<Position<LuckyNumber>> evenPositions(){
        //create a new instance of the inner class.
        return new EvenPositionIterable();
    }
    
    /**
     *
     * @return an iterable respresentation of the list's prime positions.
     */
    public Iterable<Position<LuckyNumber>> primePositions() {
        return new PrimePositionIterable();
    }
    
}