/**
 * @Author Taylor B. Schaefer-Jackson
 * @version 01.26.2026
 */
public class ScoresTest {
    public static void runAllTests(){
        System.out.println("// --------- TESTING AND DEBUG ---------- //");
        Scores scores = new Scores(10);
        int count = scores.size();
        System.out.println(count);
        System.out.println(scores.isEmpty()); // should be true
        
        System.out.println("manual addition of variables for testing");
        
        scores.list[0] = 5; scores.size++;
        scores.list[1] = 3; scores.size++;
        scores.list[2] = 5; scores.size++;
        System.out.println("TESTING FOR getFrequencyOf method.");
        //TESTING FOR getFrequencyOf method.
        System.out.println(scores.getFrequencyOf(5)); // prints 2
        System.out.println(scores.getFrequencyOf(3)); // prints 1
        System.out.println(scores.getFrequencyOf(1)); // prints 0
        System.out.println("// --------- TESTING FOR contains METHOD ---------- //");
        //TESTING FOR contains METHOD.
        scores.list[0] = 3; scores.size++;
        scores.list[1] = 7; scores.size++;
        System.out.println(scores.contains(3)); // true
        System.out.println(scores.contains(5)); // false
        System.out.println("// --------- Testing clear ---------- //");
        // Testing clear
        scores.clear();
        System.out.println("After clear, size: " + scores.size());   // 0
        System.out.println("After clear, isEmpty: " + scores.isEmpty()); // true
        System.out.println("Contains 3? " + scores.contains(3)); // false
        System.out.println("// --------- Adding more than initial capacity to test resizing ---------- //");
        // Add more than initial capacity to test resizing
        Scores scores2 = new Scores(2);  // small array to force resize
        scores2.add(1);
        scores2.add(2);
        scores2.add(3);  //<--triggers resize
        scores2.add(4);

        System.out.println("Size after adding 4 elements: " + scores2.size()); // 4
        System.out.println("Contains 3? " + scores2.contains(3)); // true
        System.out.println("Contains 5? " + scores2.contains(5)); // false
        System.out.println("// --------- TESTING Frequency of a number not in the list ---------- //");
        // Frequency of a number not in the list
        System.out.println("Frequency of 5: " + scores2.getFrequencyOf(5)); // 0
        System.out.println("// --------- TESTING Frequency of a number appearing multiple times ---------- //");
        // Frequency of a number appearing multiple times
        scores2.add(2);
        scores2.add(2);
        System.out.println("Frequency of 2: " + scores2.getFrequencyOf(2)); // 3
        System.out.println("// --------- TESTING Add, check contains, check frequency, then clear ---------- //");
        // Add, check contains, check frequency, then clear
        scores2.add(7);
        System.out.println("Contains 7? " + scores2.contains(7)); // true
        System.out.println("Frequency of 7: " + scores2.getFrequencyOf(7)); // 1
        scores2.clear();
        System.out.println("After clear, contains 7? " + scores2.contains(7)); // false
        System.out.println("// --------- TESTING remove ---------- //");
        Scores scores3 = new Scores(10);
        scores3.add(5);
        scores3.add(3);
        scores3.add(5);
        scores3.add(7);

        // Remove first 5
        scores3.remove(5);

        // Print array manually
        for (int i = 0; i < scores3.size(); i++) {
            System.out.print(scores3.list[i] + " ");
        }
        System.out.println(); // Output: 3 5 7

        System.out.println("Size: " + scores3.size()); // 3
        // ---------- TEST contains() RETURNS TRUE AND FALSE ----------
        Scores testScores4 = new Scores(5);
        testScores4.add(10);
        testScores4.add(20);
        testScores4.add(30);

        // Should return true (10 is in the list)
        boolean contains10 = testScores4.contains(10);
        System.out.println("Contains 10? " + contains10); // true

        // Should return false (40 is not in the list)
        boolean contains40 = testScores4.contains(40);
        System.out.println("Contains 40? " + contains40); // false
        // ---------- TEST randomRemove() ----------
        int removedValue = testScores4.randomRemove();  // removes a random number
        System.out.println("Randomly removed: " + removedValue);

        // After removal, the removed value should no longer be in the list
        boolean stillContains = testScores4.contains(removedValue);
        System.out.println("List still contains removed value? " + stillContains); // false
    }
    
    public static void main(String[] args) {
        runAllTests();
    }
}
