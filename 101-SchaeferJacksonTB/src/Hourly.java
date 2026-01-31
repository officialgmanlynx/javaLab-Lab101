import java.util.Objects;

/*
 * @author Taylor Schaefer-Jackson
 * @version 1/24/2026
 */
public class Hourly extends Employee {
    
    private String position;   //  the title
    private double hourlyRate;     //  the hourly rate of the employee
    
    /**
     * 
     * @param id
     * @param name
     * @param title
     * @param hourlyRate 
     */
    public Hourly( int id, String name, String title, double hourlyRate )
    {
        super( id, name );
        this.position = title;
        this.hourlyRate = hourlyRate;
    }
    
    /**
     * 
     * @return title
     */
    public String getTitle( ) { return position; }
    
    /**
     * 
     * @param title updates title
     */
    public void setTitle( String title ) { this.position = title; }
    
    /**
     * 
     * @return salary
     */
    public double getRate( ) { return hourlyRate; }
    
    /**
     * 
     * @param hourlyRate updates salary
     */
    public void setRate( double hourlyRate ) { this.hourlyRate = hourlyRate; }
    
    /**
     * 
     * @return contents of instance
     */
    @Override
    public String toString()
    {
        return super.toString() + ":" + getClass().getName() + "@" + position + ":" + hourlyRate;
    }
    
    /**
     * 
     * @param o
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals( Object o )
    {
        if ( !( o instanceof Hourly ) )
            return false;
        
        Hourly h = ( Hourly ) o;
        
        return super.equals( h )
                && position.equals(h.position )
                && hourlyRate == h.hourlyRate;
    }    
    /**
     * See Employee.java for explanation.
     * @return 
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.position);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.hourlyRate) ^ (Double.doubleToLongBits(this.hourlyRate) >>> 32));
        return hash;
    }
}
