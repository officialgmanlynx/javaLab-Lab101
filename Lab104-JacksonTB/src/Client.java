
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * @authorBoiler_plate Joseph latimer
 * @author Taylor B. Schaefer-Jackson
 */
public class Client {

    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        boolean quit = false;

        // loop until the user wants to quit
        while (!quit) {
            System.out.println("==========  Menu  ==========");
            System.out.println(" A)  Option A ");
            System.out.println(" B)  Option B ");
            System.out.println(" C)  Option C ");
            System.out.println(" Q)  Quit ");

            System.out.print("Enter choice: ");
            String choice = keyScan.nextLine();

            switch (choice) {
                case "A", "a" -> callOptionA();
                case "B", "b" -> callOptionB();
                case "C", "c" -> callOptionC();
                case "Q", "q" -> quit = true;
                default -> System.out.println("Invalid Choice, Try Again\n");
            }
        }
    }

    /**
     * This method is called by the menu when the user want to calculate OptionA.
     * To run, OptionA needs a single parameter that the user enters from the keyboard.
     * This method 
     *    asks the user to enter a value
     *    checks for a valid parameter
     *    when the parameter is valid the optionA method is called with the parameter.
     * - when the parameter is invalid, appropriate action is taken.
     */
    public static void callOptionA() {
        //print out that option A has been called
        System.out.println("callOptionA() method has been called.");
        //create an instance of scanner
        Scanner keyScan = new Scanner(System.in);
        //instance variable String answer used for scanning
        String answer;
        //instance variable boolean tryAgain used for while loop
        boolean tryAgain = true;
        //instance variable integer n used with scanner
        int n = 0;
        // loop unitl user does not want to try again.
        while (tryAgain) {

            boolean inValidInput = true;

            // loop until user enters a valid integer
            while (inValidInput) {

                System.out.print("Enter a positive Integer: ");
                answer = keyScan.nextLine();
                //try using scanned answer
                try {
                    //ensure answer is an int
                    n = Integer.parseInt(answer);
                    //if n is an int less than zero threw exception
                    if (n < 0) {
                        throw new IllegalArgumentException("Parameter be >= 0.");
                    }
                    //a valid input has been entered change to false to end loop
                    inValidInput = false;
                    //catch case 1
                } catch (NumberFormatException nfe) {
                    System.out.println("You must enter an integer value.  Try again.");
                    //catch case 2
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage() + " Try again.");
                }
            }
        
            System.out.printf("optionA( %d ) = %.2f\n", n, OptionA(n));  // the call to the optionA method.
            
            //Ask user if they would like to repeat
            System.out.print("Calculate another optionA? (Y/N): ");
            answer = keyScan.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                tryAgain = false;
            }
        }
    }

    /**
     * OptionA
     * This algorithm does not check for valid parameters and should only
     * be called by the callOptionA method.
     * This algorithm must returns a double.
     * 
     * @param i
     * @return 
     * 
     * RESOURCES
     * https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html
     * 
     */
    private static double OptionA(int i) {
        //try integer i
        try{
            //if i less than zero, though it shouldnt be throw exception
            if(i < 0) throw new IllegalArgumentException("YOU HAVE ENTERED A VALUE LESS THAN 0");
            //case 1: if i is 1 return it.
            if (i==1){
                return i;
            //case 2: return 1/1 + recursive call of (i-1) while widdening int i
            //to a double given the result is a fractional number in most cases
            }else{
                return 1.0/i + OptionA(i-1);
            }
        //catch case 1: illegal argument passed
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
           
    /**
     * callOptionB( )  is a helper method which asks the user
     * for a value and checks the validity of it before calling the method used
     * in option B
     */
    public static void callOptionB() {
        //Let the user know option B has been called.
        System.out.println("callOptionB() method has been called.");
        //create an instance of scanner class
        Scanner keyScan = new Scanner(System.in);
        //instance variable used with scanner.
        String answer;
        //boolean used with while loop.
        boolean tryAgain = true;
        //instance varaible used with scanner
        int n = 0;
        // loop unitl user does not want to try again.
        while (tryAgain) {
            //instance variable used with internal while loop
            boolean inValidInput = true;
            // loop until user enters a valid integer
            while (inValidInput) {
                //ask the user for input
                System.out.print("Enter a positive Integer: ");
                //scan the user input
                answer = keyScan.nextLine();
                //try the user input
                try {
                    //parse user input to type int from String
                    n = Integer.parseInt(answer);
                    //check if n is greater than or equal to 0
                    if (n < 0) {
                        throw new IllegalArgumentException("Parameter be >= 0.");
                    }
                    //valid input passed
                    inValidInput = false;
                //Catch case 1: unable to parse from String to int
                } catch (NumberFormatException nfe) {
                    System.out.println("You must enter an integer value.  Try again.");
                //Catch case 2: unable to parse from String to int
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage() + " Try again.");
                }
            }

            System.out.printf("optionB( %d ) = %d\n", n, OptionB(n));  // the call to the optionB method.
           //ask user if they would like to try again
            System.out.print("Calculate another optionB? (Y/N): ");
            answer = keyScan.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                tryAgain = false;
            }
        }
    }
    
    /**
     * OptionB - a recursive algorithm to compute the sum of positive integers
     * between 1 and n inclusively.
     * This algorithm does not check for valid parameters and is only
     * called by the callOptionB method.
     * 
     * @param i is an integer value
     * @return 
     */
    private static int OptionB(int i) {
        // a switch case which returns i if i is 0 or 1 and returns
        // the sum of i and the recursion of (i-1) if i is not 0 or 1.
        return switch (i) {
            // i is zero
            case 0 -> i;
            // i is one
            case 1 -> i;
            //i is any number larger than one
            default -> i + OptionB(i-1);
        };
        }

    /**
     * CallOptionC
     * A helper method which request input form the client before check
     * if entered values are acceptable. Loops until the user enters correct
     * arguments or decides to quit. If a valid argument is passed then it calls
     * the actual method which searches a directory for a target file.
     * 
     */    
    public static void callOptionC() {
        //confirm option c has been called
        System.out.println("callOptionC() method has been called.");
        //create a scanner instance
        Scanner keyScan = new Scanner(System.in);
        String answer;
        File target;
        File path = new File("C:\\digitalLocker"); // <- must have default to avoid compiler error
        //set try again to true and is directory to false;
        boolean tryAgain = true;
        boolean isDirectory = false;
        // loop unitl user does not want to try again.
        outerLoop:
        while (tryAgain) {
            //scan for necessary variable directory start path and target file
            while(!isDirectory){
                //request directory path name
                System.out.print("Enter a directory path name "); //<- test directory is C:\digitalLocker
                //store inpute as a string
                String temp = keyScan.nextLine();
                if(temp.equals("q")) break outerLoop;
                //convert input to a new file instance
                path = new File(temp);
                isDirectory = getValid_directory(path);
                if(!isDirectory) System.out.print("Invalid try again or press q to quit\n");
            }
            
            //request directory path name
            System.out.print("Enter a target file name "); //<- test file is test.txt
            //store inpute as a string
            String temp2 = keyScan.nextLine();
            //convert input to a new file instance
            target = new File(temp2);
            
            //begin searching folder for file
            SinglyLinkedList<String> foundFiles = fileScan(path, target);
            if (foundFiles.isEmpty()) {
                System.out.println("No files found.");
            } else {
                System.out.println("Found files:");
                while (!foundFiles.isEmpty()) {
                    System.out.println(foundFiles.removeFirst());
                }
            }
            //check if user would like to try again.
            System.out.print("Search again using optionC? (Y/N): ");
            answer = keyScan.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                tryAgain = false;
            }
        } 
        
    }
    
    /**
     *getValid_directory
     *checks if the user gave a proper directory or not
     *@return a Boolean value 
     *@param f file to be checked
     *
     */
    public static boolean getValid_directory(File f){
        return f.isDirectory();
    }
    
    
    
    /**
     * RECURSIVE FILE SCANNER
     * scans for all instances of a file in a target directory and returns
     * the file as well as their location
     * //Class Files
     * https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#exists-java.nio.file.Path-java.nio.file.LinkOption...-
     * Checking a File or Directory
     * https://docs.oracle.com/javase/tutorial/essential/io/check.html
     * SCANNING A SUBTREE USING RECURSION
     * https://stackoverflow.com/questions/189094/how-to-scan-a-folder-in-java
     * FILE WALKING WITH TAIL RECURSION
     * https://stackoverflow.com/questions/3154488/how-do-i-iterate-through-the-files-in-a-directory-and-its-sub-directories-in-ja
     * //FINDING FILENAMES IN A FOLDER
     * https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
     * @return a print out of all the absolute file paths which contain the target file given the starter file directory.
     * @param targetFile_name the file in question to be searched for
     * @param startPath the starting path for the recursive search to begin in
     */
    public static SinglyLinkedList<String> fileScan(File startPath, File targetFile_name){
        //create an instance of SinglyLinkedList
        SinglyLinkedList<String> results = new SinglyLinkedList<>();
        //instantiate an array
        File[] listOf_files;
        //try the following
        try{
            //assigning listOf_files
            listOf_files = startPath.listFiles();
            if (listOf_files == null) {
                // Directory is unreadable or does not exist
                throw new FileNotFoundException("Cannot access directory: " + startPath.getAbsolutePath());
            }
            
            for(File f: listOf_files){
                //recursive instance checks inside folder 
                if(f.isDirectory()){
                    SinglyLinkedList<String> subResults = fileScan(f, targetFile_name);
                    while (!subResults.isEmpty()) {
                        results.addLast(subResults.removeFirst());
                    }
                //non recursive poriton checks if file
                } else if(f.isFile()){
                    if (f.getName().equals(targetFile_name.getName())) {
                        results.addLast(f.getAbsolutePath());
                    }
                } else {
                // handler for unreadable file types
                System.out.println("Unusual file type skipped: " + f.getAbsolutePath());
                }
            }
        // if file not found
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            // Optionally continue with other folders instead of stopping completely
        }
        //returns the files' absolute paths respectively
        return results;
    }
}
