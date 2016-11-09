package advancedalgorithmslab2;


/**
 *
 * @author Oona
 */
public class MyDictionary {
    
    private MyDictionaryList[] hashArray;
    
    
    public MyDictionary(int n) {
          hashArray = new MyDictionaryList[n];
          
          for(int i = 0; i < n; i++) {
              hashArray[i] = new MyDictionaryList();
          }
    }
    
    public Object get(String key) {
        
        Object result = null;
        
        //find the index we need to check
        int index = hash(key) % hashArray.length;
        
        result = hashArray[index].get(key);
        
        return result;
    }
    
    public int put(Object item, String key) {
        
        int hashValue = hash(key);
        int index = hashValue % hashArray.length;
        hashArray[index].add(item, key);
        
        return 0;
    }
    
    public int del(String key) {
        
        int arrayIndex = hash(key) % hashArray.length;
        
        int listIndex = hashArray[arrayIndex].indexOf(key);
        
        boolean removed = hashArray[arrayIndex].remove(listIndex);
        
        return 0;
    }
    
    public void printDictionary() {
        for(int i = 0; i < hashArray.length; i++) {
            System.out.print(i + ". ");
            if(hashArray[i].toString().equals("")) {
                System.out.print("[empty]");
            }
            System.out.println(hashArray[i].toString());
        }
    }
    
    /* K & R hash function for strings */
    private static final int MULTIPLIER = 31;
    private int hash(String str) {
        int h;
        h = 0;
        for (int i = 0; i < str.length(); i++) h = MULTIPLIER * h + str.charAt(i);
        return h & Integer.MAX_VALUE;
        
    } 
    
    private class Node {
        
        Node next;
        Object data;
        String key;

        public Node(Object dataValue, String key) {
            next = null;
            data = dataValue;
            this.key = key;
        }

        public String getKey() {
            return this.key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
    
    class MyDictionaryList {
 
	private int counter;
	private Node head;
 
	public MyDictionaryList() {}
        
        public void add(Object data, String key) {
            if (head == null) {
                head = new Node(data, key);
            }
            Node temp = new Node(data, key);
            Node current = head;
            if (current != null) {
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(temp);
            }
            counter++;
	}
 
	private int getCounter() {
            return counter;
	}
        
        //get an object based on the given key
        public Object get(String key) {
            Node current = null;
            
            if (head != null) {
                current = head.getNext();
                
                while (current != null) {
                    
                    if(current.getKey().equals(key)) {
                        return current;
                    }
                    
                    if (current.getNext() == null){
                            return null;
                    }
                    
                    current = current.getNext();
                }
            }
            return current;
	}
 
	// removes the element at the specified position in this list.
	public boolean remove(int index) {
            
            Node current = head;
            Node temp = head;
            
		if(index == 0) {
                    if (head == null) {
                        return false;
                    } else {
                        if (head.getNext() == null) {
                            head = null;
                            return true;
                        } else {
                            head = head.getNext();
                            return true;
                        }
                    }
                }
 
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null) {
					return false;
                                }
                                
                                temp = current;
 
				current = current.getNext();
                                
                        }
                        Node n = current;
                        current = temp;
                        current.setNext(n.getNext());

			counter--;
			return true;
 
		}
		return false;
	}
        
        public int indexOf(String key) {
            int index = 0;
            Node current = head;

            while (current != null) {
                if (current.getKey().equals(key)) {
                    return index; 
                }
                index++;
                current = current.next;
            }
            return -1;
        }
 
	// returns the number of elements in this list.
	public int size() {
		return getCounter();
	}
 
        @Override
	public String toString() {
            String output = "";

            if (head != null) {
                Node current = head.getNext();
                
                while (current != null) {
                    
                    output += "[" + current.getKey() + "]";
                    
                    current = current.getNext();
                }
            }
            
            return output;
	}
    }
}
