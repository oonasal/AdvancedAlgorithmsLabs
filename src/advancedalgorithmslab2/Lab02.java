package advancedalgorithmslab2;

import java.security.SecureRandom;

public class Lab02 {
    
    private final static int STRLEN = 32;
    private final static int N = 30;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    
    private static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    /**
    * @param args the command line arguments
    */
    
    public static void main(String[] args) {
        MyDictionary dict = new MyDictionary(N/2);
        String[] tableStr;
        String search_element;
        int j = 0;
        Object empty, result;
        int r;
    
        /* first create sorted collection of strings */
        tableStr = new String[N];
        for (int i = 0; i < tableStr.length; i++) tableStr[i] = randomString(STRLEN);

        /* then store it to the dictionary */
        empty = new Object();
        for (int i = 0; i < tableStr.length; i++) {
            dict.put(empty, tableStr[i]);
            //System.out.println(tableStr[i]);
        }
        System.out.println("Content of the dictionary:\n");
        dict.printDictionary();
        
        /* try to search half of the strings from the dictionary */
        System.out.println("\n\nHalf of the searches should succeed, half fail:\n");
        
        
        
        //loop 15 times
        for (int i = 0; i < N/2; i++) {
            
            //saves a random int between 0 and 30 into a variable
            j = rnd.nextInt(N);
            
            //saves a random string from the array into a variable
            search_element = tableStr[j];
            
            //if i is bigger than 7, append "#" to the end of the random string 
            //--> 8 of the strings searched will be modified 
            if (i > N/4) search_element += "#"; // quater of the strings should not be found
            
            //searches for the given string and saves the returned object into an object variable
            result = dict.get(search_element);
            
            //prints out F if the returned object is not null and N if it is
            System.out.format("%1$2d: element %2$s (%3$02d), search result %4$s\n", i, search_element, j, result!=null ? "F" : "N");
            //System.out.println("");
        }
        
        /* then delete first and the middle element from the dictionary */
        //remove elements that are at indexes 0 and 14 in the array of random strings
        System.out.println("");
        dict.del(tableStr[0]); 
        dict.del(tableStr[N/2-1]);
        
        /* try to search again strings from the dictionary, first and the last should not be found*/
        System.out.println("\nFirst and last search should fail, other should succeed:\n");
        for (int i = 0; i < N/2; i++) {
            j = i;
            search_element = tableStr[i];
            result = dict.get(search_element);
            System.out.format("%1$2d: element %2$s (%3$02d), search result %4$s\n", i,
            search_element, j, result!=null ? "F" : "N");
        }
    }
    
}
