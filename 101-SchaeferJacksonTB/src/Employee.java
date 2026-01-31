import java.util.Objects;

/**
 *
 * @boilerPlate_author Joseph Latimer
 * @author Taylor Schaefer-Jackson
 * @version 1.24.2026
 * A super class the defines id and name. It's child classes are Hourly 
 * and Salaried they define title & salary and position & hourlyRate respectively.
 * 
 */
public class Employee {
    
    private static int employeeCount = 0;  // count of Employee instances
    private int id;       // the employee id
    private String name;  // the employees name
    
    /**
     * Constructor for the Employee class
     * @param id // identification number for the employee
     * @param name // name of the employee
     */
    //Takes the id and the employee name as an input and builds and object of
    //of type Employee.
    public Employee( int id, String name ) {
        this.id = id;
        this.name = name;
        employeeCount++;
    }
    
    /**
     * 
     * A simple class that retrieves the employee id.
     * @return id
     */
    public int getId( ) { return id; }
    
    /**
     * A simple class using 'this' that sets the employee id.
     * @param id updates id instance variable
     */
    public void setId( int id ) { this.id = id; }
    
    /**
     * A simple class that retrieves the employee name.
     * @return name
     */
    public String getName() { return name; }
    
    
    /**
     * A simple class using 'this' to set the employee name.
     * @param name updates name instance variable
     */
    public void setName( String name ) { this.name = name; }
    
    /**
     * 
     * @return number of time Employee constructor called
     */
    public int getEmployeeCount() { return employeeCount; }
    
    /**
     * 
     * @return contents of Employee instance
     */
    @Override
    public String toString(){
        return getClass().getName() + "@" + id + ":" + name + ":" + employeeCount;
    }
    
    /**
     * @param o  object to be compared
     * @return  true if objects equal
     */
    @Override
    public boolean equals( Object o )
    {
        if ( !( o instanceof Employee ) )
            return false;
        Employee e = ( Employee ) o;
        
        return id == e.id
                && name.equals( e.name );
    }
    
    /**
     * Gives the compiler explicit instructions to override the superclass or
     * interface such that the code is in accordance with Modern Java Style.
     * 
     * Example 1 - A Typo in the name or wrong signatureNew would result
     * in a new method being created, a silent bug, where as with override
     * it result in a Compilation error – bug caught early
     * 
     * Example 2 - The Readability and team interoperability is not inherently
     * obvious that an override is occurring, but with the @Override it becomes
     * very clear to every reader even those without the proper background.
     * 
     * I chose to put it in the project because
     * it's a zero-runtime-cost safety net that prevents logic bugs.
     * 
     * For more info read
     * Bloch, J. (2018). Effective Java (3rd ed.). Addison-Wesley Professional.
     * Available for viewing here
     * https://kea.nu/files/textbooks/new/Effective%20Java%20%282017%2C%20Addison-Wesley%29.pdf
     * I have not read the full contents of the book yet, but did go over the
     * portion which came up using the google search engine.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
}
