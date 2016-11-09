package advancedalgorithmslab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Oona
 * @param <T>
 */
public class Storage <T extends Comparable<T>> implements Stopwatch.Test {
    private ArrayList<T> list;
    
    private static Integer n;
    private static int limit;

    public Storage() {
        list = new ArrayList();
    }
    
    public int getLimit() {
        return limit;
    }
    
    //add an element to a list
    public void storeElement(T element) {
        list.add(element);
    }
    
    //find a particular element from a list of stored elements
    public int findElementUsingSequential(T element) {
        boolean foundElement = false;
        int i = 0;
        
        //since we're using an arraylist we could also just use its contains method
        for (T e : list) {
            if (list.get(i).compareTo(element) == 0) {
                foundElement = true;
                break;
            }
            i++;
        }
        
        if(foundElement) {
            //System.out.println("element " + element + " was found!");
            return list.indexOf(element);
        } else {
            //System.out.println("element " + element + " wasn't found.");
            return -1;
        }
    }
    
    
        
    public int findElementUsingBinary(T element) {
        //Collections.sort(list);
        
        int count;
        int low = 0;
        int high = list.size() - 1;
        while(low <= high) {
            count = (low + high)/2;
            if(list.get(count).compareTo(element) == 0) {
                return list.indexOf(element);
            } else if(list.get(count).compareTo(element) < 0) {
                high = count - 1;
            } else {
                low = count + 1;
            }
        }
        
        /*int count;
        int firstElement = 0;
        int lastElement = list.size() - 1;
        
        if(element.compareTo(list.get(firstElement)) >= 0 && element.compareTo(list.get(lastElement)) <= 0) {
            count = list.size() / 2;
            for(int j = 1; j <= list.size(); j++) {
                if(list.get(count).compareTo(element) > 0) {
                    count = (count) / 2;
                } else if(list.get(count).compareTo(element) < 0) {
                    count = (lastElement + count) / 2;
                } else if(list.get(count).compareTo(element) == 0) {
                    return list.indexOf(element);
                } else {
                    return -1;
                }
            }
        }*/
        
        return -1;
    }
    
    //works with integers only
    public void pickExistingRandomInt(int upperLimit) {
        Random random = new Random();
        
        while(true) {
            n = random.nextInt(upperLimit);
            if(list.contains((T)n)) {
                break;
            }
        }
        
    }
    
    public static void main(String[] args) {
        //Storage storage = new Storage();
        
        //testing with integers
        /*storage.storeElement(23);
        storage.storeElement(543);
        storage.storeElement(7);
        storage.storeElement(56);
        storage.storeElement(233);
        storage.storeElement(79);
        
        System.out.println(storage.findElementUsingSequential(543));
        System.out.println(storage.findElementUsingSequential(5));
        System.out.println(storage.findElementUsingSequential(-2121));
        System.out.println(storage.findElementUsingSequential(84848484));
        
        System.out.println(storage.findElementUsingBinary(233));
        System.out.println(storage.findElementUsingBinary(7));
        System.out.println(storage.findElementUsingBinary(1000));
        System.out.println(storage.findElementUsingBinary(-8));*/
        
        //testing with strings
        /*storage.storeElement("munakas");
        storage.storeElement("keitto");
        storage.storeElement("lasagne");
        storage.storeElement("cake");
        storage.storeElement("strawberry");
        
        System.out.println(storage.findElementUsingSequential("marjapuuro"));
        System.out.println(storage.findElementUsingSequential("kalakukko"));
        System.out.println(storage.findElementUsingSequential("lasagne"));
        System.out.println(storage.findElementUsingSequential("strawberry"));
        
        System.out.println(storage.findElementUsingBinary("keitto"));
        System.out.println(storage.findElementUsingBinary("marjapuuro"));
        System.out.println(storage.findElementUsingBinary("lasagne"));
        System.out.println(storage.findElementUsingBinary("munakas"));*/
        
        
        //testing stopwatch with integers
        Stopwatch stopwatch = new Stopwatch();
        Random random = new Random();
        Storage storage;
        
        //run the loop 10 times (once for each collection size)
        for(int i = 10000; i <= 55000; i += 5000) {
            storage = new Storage();
            
            System.out.println("Testing with " + i + " elements:");
            
            //add random numbers to the collection (x the number of collection size)
            for(int j = 0; j < i; j++ ) {
                storage.storeElement(random.nextInt(i));
            }
            
            Collections.sort(storage.list);
            storage.pickExistingRandomInt(i);
            limit = i;
            
            stopwatch.measure(storage);
            System.out.println("Result:" + stopwatch);
            System.out.println("");
        
        }  
    }

    @Override
    public void test() {
        for(int i = 0; i < 500; i+=1) {
            //findElementUsingSequential((T) n);
            findElementUsingBinary((T) n);
        }
    }
    
}
