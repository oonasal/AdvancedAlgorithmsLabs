package advancedalgorithmslabs4;

import java.util.Arrays;

/**
 *
 * @author Oona
 */


//()
//[]

public class MinMax {
    
    private int min;
    private int max;
    private int numberOfComparisons;
    private Integer[] list;
    
    public MinMax(Comparable[] array) {
        
        list = (Integer[]) array;
        
    }
    
    public int getMax() {
        return Arrays.asList(list).indexOf(max);
    }
    
    public int getMin() {
        return Arrays.asList(list).indexOf(min); 
    }
    
    public int getComparisons() {
        return numberOfComparisons;
    }
    
    
    
    
    public void minMax(int start, int end) {
        int max2, min2;
        //System.out.println("comparisons made: " + numberOfComparisons);
        
        if(start == end) {
            //System.out.println("first");
            //System.out.println("comparing:: " + list[start] + " and " + list[start]);
            max = list[start];
            min = list[start];
            //numberOfComparisons++;
            
        } else if(start == end - 1){
            //System.out.println("second");
            System.out.println("comparing:: " + list[start] + " and " + list[end]);
            if(list[start] > list[end]) {
                max = list[start];
                min = list[end];
                
            } else {
                max = list[end];
                min = list[start];
                
            }
            
            numberOfComparisons++;
        } else {
            //split the array in two
            int middle = (start + end) / 2;

            //solve the halves separately 
            minMax(start, middle);
            max2 = max;
            min2 = min;
            
            //System.out.println("min2 and max2: " + min2 + ", " + max2);
            
            minMax(middle + 1, end);
            
            //System.out.println("min and max: " + min + ", " + max);
            
            
            
            System.out.println("comparing " + max + " and " + max2);
            if(max2 > max) {
                max = max2;
                //numberOfComparisons++;
            }
            
            //numberOfComparisons++;
            
            System.out.println("comparing: " + min + " and " + min2);
            if(min2 < min ) {
                min = min2;
                //numberOfComparisons++;
            }
            numberOfComparisons++;
            
        }
        
        System.out.println("min: " + min + ", max: " + max);
         
    }
    
    
    //loop through the list elements and find the min and max
    public void minMax2() {
        min = list[0];
        max = list[0];
        
        //System.out.println("the first min is " + min);
        //System.out.println("the first max is " + max);
        
        //loop through every integer in the list
        for(Integer i : list) {
            
            //if current integer is smaller than min
            if(i.compareTo(min) < 0) {
                //System.out.println("list element is smaller than current min");
                
                //the current integer is the new min
                min = i;
            }
            numberOfComparisons++;
            
            if(i.compareTo(max) > 0) {
                //System.out.println("list element is bigger than current max");
                
                //the current integer is the new max
                max = i;
            }
            numberOfComparisons++;
        }
        
        //System.out.println("the final min is " + min);
        //System.out.println("the final max is " + max);
        
        
    }
    
    
    
}
