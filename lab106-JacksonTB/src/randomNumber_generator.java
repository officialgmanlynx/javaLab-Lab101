/**
 *
 * @author Taylor B. Schaefer-Jackson
 * A random number generator that takes two variables both int.
 * A lower limit and upper limit determines the range of the random number.
 * 
 * RESOURCES
 * https://blogs.oracle.com/javamagazine/java-pseudo-random-number-generator-enhancements/
 * https://docs.oracle.com/en/java/javase/17/core/pseudorandom-number-generators.html#GUID-6946463F-C64B-4361-AB53-0D52FB279DE0
 * https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
 * https://www.geeksforgeeks.org/java/java-program-to-implement-the-linear-congruential-generator-for-pseudo-random-number-generation/
 */
public class randomNumber_generator {
    //initial seed can be negative, but modulus cleans this up.
    //not sure how but its working...
    static long seed = System.nanoTime();
    /**
     * REFRENCES
     * https://vovchenko.net/computational-physics/11_RandomNumbers/11_RandomNumbers_Basics.html
     */
    //The constant 1664525 is a specific linear congruential generator (LCG) for generating pseudo-random numbers taken from C libaries.
    static final long MULTIPLIER = 1664525L;
    //Ensures generator moves through entire number space.
    static final long INCREMENT = 1013904223L;
    //Defines size of number space using power of 2 such that values cycle over a 32-bit integer range (0 to 4,294,967,295).
    static final long MODULUS = 1L << 32;
    
    public static int randomNumber(int lowLim, int upLim) throws IllegalArgumentException{
        //update seed providing a number betwen 0 and m-1.
        seed = (MULTIPLIER *seed+INCREMENT)%MODULUS;
        //Convert to generic random fraction in range [0,1).
        double randDouble = (double) seed/MODULUS;
        //Validate the bounds of upper and lower limit.
        if(!(upLim<lowLim)){
            //+1 makes upper bound inclusive.
            int range = upLim-lowLim+1;
            //mult by range to stretch and truncate to val between 0 and range -1.
            //add low lim to shif val into bound.
            int numRand = (int)(randDouble*range)+lowLim;
            return numRand;
        } else {
            //If lower > upper → this is logically invalid throw IAE.
            throw new IllegalArgumentException("INVALID:");
        }
        
    }
    
    
}
