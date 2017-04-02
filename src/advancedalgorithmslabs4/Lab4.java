package advancedalgorithmslabs4;

import java.security.SecureRandom;

public class Lab4 {

    static private Integer[] collection;
    static private SecureRandom rnd = new SecureRandom();

    /* create a random unsigned value array with length of n */
    static void initTestSeq(int n) {
        /* first create the collection of integers */
        collection = new Integer[n];
        for (int i = 0; i < n; i++) {
            collection[i] = rnd.nextInt();
        }
    }

    /* print out the sequence */
    static void printTestSeq() {
        for (int i = 0; i < collection.length; i++) {
            System.out.format("%1$02d: %2$11d\n", i, collection[i]);
        }
        System.out.println();
    }
    private final static int N = 10;

    /**
     * @param args the command line arguments METROPOLIA Lab. exercise 4 Page 2
     * Information Technology TX00CO27 Advanced Algorithms 17.11.2016 JV
     */
    public static void main(String[] args) {
        int max, min;
        
        //create an array of 10 integers
        initTestSeq(N);
        
        //loop through the array and print them out
        printTestSeq();
        
        //create a new MinMax object and give it the array
        MinMax minmax = new MinMax(collection);
        
        //find the min and max values using the simple method
        minmax.minMax2();
        
        //get the indexes of the min and max values
        System.out.println("Brute Force minmax search");
        System.out.println("Min index " + minmax.getMin() + ", max index " + minmax.getMax());
        
        //get the number of comparisons made
        System.out.println("Number of comparisons " + minmax.getComparisons());
        
        System.out.println("");
        
        //create a new MinMax object,use the same array
        minmax = new MinMax(collection);
        
        //find the min and max values using the divide and conquer algorithm
        minmax.minMax(0, collection.length - 1);
        
        //get the indexes of the min and max values
        System.out.println("Divide and Conquer minmax search");
        System.out.println("Min index " + minmax.getMin() + ", max index " + minmax.getMax());
        
        //get the number of comparisons made
        System.out.println("Number of comparisons " + minmax.getComparisons());
    }

}
