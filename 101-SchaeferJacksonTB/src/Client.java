/*
 * Import List for java libraries.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * A client that demonstrates polymorphism.
 * @boilerPlate_author Joseph Latimer
 * @author Taylor Schaefer-Jackson
 * @version 1.24.2026
 * 
 * Disclaimer - several resources where used in the creation of this project.
 * For future studying, clarity, or explanation said resources have been
 * referenced and included with a link for myself and the reader/grader. 
 * I do not claim to fully understand the contents of this program. 
 * I merely was able to get it to work and explained it to the best of my ability. 
 * ¯\_(ツ)_/¯
 * 
 */
public class Client {
    
    public static Employee[] buildEmployee_list() throws FileNotFoundException {
        /**
         * Create an array named employeeList of type Employee with a length of 10
         * https://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java
         * https://www.geeksforgeeks.org/java/how-to-create-array-of-objects-in-java/
         */
        Employee[] employeeList = new Employee[10];
        
        //Create scanner called fileScanner to read .csv file.
        try (Scanner fileScanner = new Scanner(new File("employees.csv"))) {
       
            //Skip header line.
            int index = 0;
            fileScanner.nextLine();
        
            // See the following for an explanaiton
            // https://www.w3schools.com/java/ref_scanner_hasnextline.asp
        
            while (fileScanner.hasNextLine() && index < employeeList.length) {

                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                String type = parts[0];
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];
                String title = parts[3];
                
                // see the following for more details
                //https://www.w3schools.com/java/ref_string_equalsignorecase.asp
                if (type.equalsIgnoreCase("Salaried")) {
                    int salary = Integer.parseInt(parts[4]);
                    employeeList[index] =
                            new Salaried(id, name, title, salary);

                } else if (type.equalsIgnoreCase("Hourly")) {
                    double rate = Double.parseDouble(parts[4]);
                    employeeList[index] =
                            new Hourly(id, name, title, rate);
                }

                index++;
            }
            //redundant close
            fileScanner.close();
            return employeeList;
        
        }
    }
    // A help class the iterates through the Employee array and prints
    //its contents.
    public static void printEmployeeList(Employee[] employeeList) {
        System.out.printf("%-10s %-5s %-15s %-10s %-10s%n", 
                          "Type", "ID", "Name", "Title", "Pay");
        //Java enhanced for loop to iterate through employee array.
        //See the following for more details.
        //https://www.geeksforgeeks.org/java/difference-between-for-loop-and-enhanced-for-loop-in-java/
        for (Employee e : employeeList) {
            //check to make sure there is a valid employee.
            if (e != null) {
                String type;
                String name = e.getName();
                int id = e.getId();
                String title = "N/A";
                String pay = "N/A";
                
                // if statement using a boolean comparison with instanceof.
                //see the following for more details.
                //https://www.geeksforgeeks.org/java/instanceof-keyword-in-java/
                if (e instanceof Salaried s) {
                    type = "Salaried";
                    title = s.getTitle();       // Salaried must have getTitle()
                    pay = String.valueOf(s.getSalary());
                } else if (e instanceof Hourly h) {
                    type = "Hourly";
                    title = h.getTitle();       // Hourly must have getTitle()
                    pay = String.format("%.2f", h.getRate());
                } else {
                    type = "Unknown";
                }

                System.out.printf("%-10s %-5d %-15s %-10s $%-10s%n",
                                  type, id, name, title, pay);
            }
        }
    }
    
    public static void giveRaise(Employee[] employeeList) {
        for (Employee e : employeeList) {
            // check if next employee is valid.
            if (e != null) {  
                if (e instanceof Salaried s) {
                    // Increase salary by 33%
                    int newSalary = (int)(s.getSalary() * 1.33);
                    s.setSalary(newSalary);
                } else if (e instanceof Hourly h) {
                    // Increase hourly rate by 33%
                    double newRate = h.getRate() * 1.33;
                    h.setRate(newRate);               
                }
            }
        }
    }


    
    public static void main(String[] args) throws FileNotFoundException {
        //Creates an array named employeeList of type Employee and populates it
        //using a help method buildEmployee_list to read from a csv file.
        Employee[] employeeList = buildEmployee_list();

        // Print the employee list using helper method printEmployeeList.
        System.out.println("\n=== Employee List ===");
        printEmployeeList(employeeList);
        
        //Give all employees a 33% raise using helper method giveRaise.
        giveRaise(employeeList);
        
        // Re-print for verificaiton
        System.out.println("\n=== After 33% Raise ===");
        printEmployeeList(employeeList);
        
        // Run explicit equals() tests
        System.out.println("\n=== Running Equals Tests ===");
        ClientTest.runTests(employeeList);
           
    }
                
}