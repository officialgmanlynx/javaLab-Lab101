/**
 *
 * @author Taylor B. Schaefer-Jackson
 * @Verision 02/25/2026
 * REFRENCE
 * https://docs.oracle.com/javase/8/docs/api/java/lang/System.html
 */
public class client {
    
    public static void main(String[] args) throws stack.StackFullException, queue.QueueFullException{
        /**
         *
         *
         *       ___________________________
                /                           \
               ( Yum, Tasty Memory.          )
                \ __________________________/
                |/_
                |\_,,____
                ( o__o \/
                /(..)  \
               (_ )--( _)
               / ""--"" \
        ,===,=| |-,,,,-| |==,==
        |d  |  WW   |  WW   |
        |s  |   |   |   |   |
         */
        int mPig = 45000;
        int[][] memoryPig = new int[mPig][mPig];
        for(int i = 0; i < mPig; i++){
            memoryPig[i][0] = i; // Allocated array to eat up memory
        }
        
        int numTests = 6; // 9 powers of ten for milliard test 6 for million
        long[][] results = new long[numTests][5]; // columns: ArrayStack, LinkedStack, ArrayQueue, LinkedQueue, ArrayList
        int testIndex = 0;
        
        int N = 10; //starting val of N
        int maxN = 1000000; //Max val of N
        
        while(N <= maxN){
            try{
                //ArrayStack
                arrayStack<Integer> stack = new arrayStack<>(N);
                long start = System.nanoTime();
                //Add n elements into arrayStack
                for(int i = 0; i<N;i++){
                    stack.push(i);
                }
                //Remove n elements
                for(int i = 0; i<N;i++){
                    stack.pop();
                }
                long end = System.nanoTime();
                results[testIndex][0]=end-start;
            } catch (OutOfMemoryError e){
                results[testIndex][0]=-1;
            }
            // LinkedStack
            try{
                linkedStack<Integer> stack = new linkedStack<>();
                //start time
                long start = System.nanoTime();
                for(int i=0; i<N; i++) stack.push(i);
                for(int i=0; i<N; i++) stack.pop();
                //end time
                long end = System.nanoTime();
                results[testIndex][1] = end - start;
            } catch(OutOfMemoryError e){
                results[testIndex][1] = -1;
            }

            // ArrayQueue
            try{
                arrayQueue<Integer> queue = new arrayQueue<>(N);
                //start timer
                long start = System.nanoTime();
                //might need to check for stackFull.
                for(int i=0; i<N; i++) queue.enqueue(i);
                for(int i=0; i<N; i++) queue.dequeue();
                //end timer
                long end = System.nanoTime();
                results[testIndex][2] = end - start;
            } catch(OutOfMemoryError e){
                results[testIndex][2] = -1;
            }

            // LinkedQueue
            try{
                linkedQueue<Integer> queue = new linkedQueue<>();
                //start timer
                long start = System.nanoTime();
                //there may be a bug here when calling enqueue check later.
                //likely a QueueFullException Error.
                for(int i=0; i<N; i++) queue.enqueue(i);
                for(int i=0; i<N; i++) queue.dequeue();
                //ender timer
                long end = System.nanoTime();
                results[testIndex][3] = end - start;
            } catch(OutOfMemoryError e){
                results[testIndex][3] = -1;
            }

            // ArrayList
            try{
                arrayList<Integer> list = new arrayList<>(N);
                //start timer
                long start = System.nanoTime();
                // Add element at the end of the list.
                // To avoid IndexOutOfBoundsException when list is empty
                // a conditional statement.
                for(int i=0; i<N; i++) {
                    // safely determine insertion index 
                    int insertIndex = (list.size() == 0) ? 0 : list.size();
                    //add element at the end.
                    list.add(insertIndex, i);
                } 
                // remove element from the end of the list
                for(int i=0; i<N; i++) list.remove(list.size()-1); 
                //end timer
                long end = System.nanoTime();
                results[testIndex][4] = end - start;
            } catch(OutOfMemoryError e){
                results[testIndex][4] = -1;
            }
            //Incrementing N by a factor of 10.
            N*=10;
            //Incrment testIndex
            testIndex++;
            //LinkedStack
            //ArrayQueue
            //LinkedQueue
            //ArrayList
        }
        //PRINTOUT
        printASCII_table(results);
    }
   
    /**
     *
     * @param data
     * REFRENCES
     * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
     * https://stackoverflow.com/questions/21034955/when-to-use-long-vs-long-in-java
     */
    public static void printASCII_table(long[][] data){
        int rows = data.length;
        int columns = data[0].length;
        
        //Find width for each column
        //IDE replaced explicit type with var
        var columnWidths = new int[columns];
        for(int col = 0; col < columns; col++){
            //set intial to zero and reset on loop.
            int maxWidth = 0;
            for(int row = 0; row < rows; row++){
                //call on helper method to format the number.
                String formatNUM = formatNumber(data[row][col]);
                if(formatNUM.length() > maxWidth) maxWidth = formatNUM.length();
            }
            columnWidths[col] = maxWidth;
        }
        
        //printing table
        //create horizontal top line for each row
        String horizontalLine = buildLine(columnWidths);
        //print horizontal top line
        System.out.println(horizontalLine);
        
        for(int row = 0; row<rows;row++){
            // Print vertical separator
            System.out.print("|");
            for (int col = 0; col<columns; col++){
                String string = formatNumber(data[row][col]);
                System.out.print(" " + string + rightPadding("", columnWidths[col] - string.length()) + " |");
            }
            System.out.println();
            //print horizontal bottom line for each row
            System.out.println(horizontalLine);
        }
    }
    
    public static String buildLine(int[] widthOf_columns){
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("+");
        for(int wide : widthOf_columns){
            for(int i = 0; i < wide+2; i++){
                stringbuilder.append("-");
                
            }
            stringbuilder.append("+");
        }
        return stringbuilder.toString();
    }
    
    /**
     *REFRENCE
     * https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
     * @param n string to be formatted.
     * @return a formatted string.
     */
    public static String formatNumber(long n){
        if(n==-1){ return "out of memory!";}
        String string = ""+n;
        StringBuilder stringBuilder = new StringBuilder();
        int LENGTH = string.length();
        //used for counting to ensure comma every 3 digits.
        int commaCount = 0;
        for(int i = LENGTH-1; i >= 0; i--){
            stringBuilder.insert(0, string.charAt(i));
            commaCount++;
            if(i>0 && commaCount % 3 == 0) stringBuilder.insert(0, ",");
        }
        return stringBuilder.toString();
    }
    
    /**
     *
     * @param string a string that needs padding on the right side.
     * @param padding the amount of padding needed.
     * @return the padded string.
     */
    public static String rightPadding(String string, int padding){
        StringBuilder stringbuilder = new StringBuilder(string);
        while(stringbuilder.length()< padding) stringbuilder.append(' ');
        return stringbuilder.toString();
    }
    
}
