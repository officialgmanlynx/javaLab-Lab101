/*
 * @author Taylor Schaefer-Jackson
 * @version 1/24/2026
 */

//For more information on creating test cases see the following.
//https://www.baeldung.com/java-unit-testing-best-practices
public class ClientTest {
    public static void runTests(Employee[] employeeList) {
        // Picks the first two Hourly employees in the array.
        Hourly h1 = null, h2 = null;
        for (Employee e : employeeList) {
            if (e instanceof Hourly h) {
                if (h1 == null) h1 = h;
                else if (h2 == null) h2 = h;
            }
        }

        if (h1 != null && h2 != null) {
            // true test: compare an employee to themselves.
            System.out.println("Hourly equals true test: " + h1.equals(h1));
            // false test: compare two different Hourly employees.
            System.out.println("Hourly equals false test: " + h1.equals(h2));
        }

        System.out.println("\n=== Salaried Tests ===");

        // pick first two Salaried employees in the array.
        Salaried s1 = null, s2 = null;
        for (Employee e : employeeList) {
            if (e instanceof Salaried s) {
                if (s1 == null) s1 = s;
                else if (s2 == null) s2 = s;
            }
        }

        if (s1 != null && s2 != null) {
            // true test: compare the same salaried employee to themselves.
            System.out.println("Salaried equals true test: " + s1.equals(s1));
            // false test: compare two different Salaried employees.
            System.out.println("Salaried equals false test: " + s1.equals(s2));
        }

        System.out.println("\n=== Employee Base Class Test ===");
        if (employeeList.length >= 2) {
            // true test: same object
            System.out.println("Employee equals true test: " + employeeList[0].equals(employeeList[0]));
            // false test: different objects
            System.out.println("Employee equals false test: " + employeeList[0].equals(employeeList[1]));
        }
    }
}
