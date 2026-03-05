/**
 * @version 3/03/2026
 * @author Taylor B. Schaefer-Jackson
 */
public class LuckyNumber {
    //Instance Variables
    private String name;
    private int luckyNumber;
    
    //Base Constructor
    public LuckyNumber(String name){
        this.name=name;
        this.luckyNumber=randomNumber_generator.randomNumber(0, 9);
    }
    
    //Accessor and Update Methods
    public String getName(){
        return this.name;
    }
    public int getLucky_number(){
        return this.luckyNumber;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " @ " + this.name + " : " + this.luckyNumber;
    }
    public boolean equals(Object o){
        if(!(o instanceof LuckyNumber)) return false;
        LuckyNumber Luck = (LuckyNumber) o;
        return this.name.equals(Luck.name) 
                && this.luckyNumber == Luck.luckyNumber;
    }
    
}
