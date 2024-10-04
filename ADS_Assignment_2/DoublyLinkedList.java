//import java.util.Iterator;
//import java.util.ListIterator;
//import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Eoin Brereton Hurley
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{
	public int DLLNodeCounter = 0;
    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  This method has an if-else statement which is not affected by the size of the list.
     *  It has constant running time.
     */
    public boolean isEmpty()
    {
    	if (DLLNodeCounter == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  This method contains if-else statements which don't depend on the size of the list.
     *  In one branch however, there is a for-loop which executes n times in worst case.
     *  Therefore the worst-case asymptotic running time cost is Theta(n).
     */
    public void insertBefore( int pos, T data ) 
    {
    	if (DLLNodeCounter == 0) {
    		DLLNode tmp = new DLLNode(data, null, null);
    		head = tmp;
    		tail = tmp;
    		DLLNodeCounter++;
    	}
    	else {
    		if (pos <= 0) {
        		DLLNode tmp = new DLLNode(data, null, head);
        		head.prev = tmp;
        		head = tmp;
        		DLLNodeCounter++;
    		} else if (pos >= DLLNodeCounter) {
        		DLLNode tmp = new DLLNode(data, tail, null);
        		tail.next = tmp;
        		tail = tmp;
        		DLLNodeCounter++;
    		}
    		else {
    			DLLNode p = head;
    			DLLNode n = head;
    			for (int i = 0; i < (pos - 1); i++) {
    				p = p.next;
    			}
    			n = p.next;
    			DLLNode tmp = new DLLNode(data, p, n);
    			p.next = tmp;
    			if (n != null) {
    				n.prev = tmp;
    			}
        		DLLNodeCounter++;
    		}
    	}
    	return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  All statements are of constant running time apart from the for-loop which iterates n times
     *  in worst-case scenario. Thus, worst-case asymptotic running time cost is Theta(n).
     *
     */
    public T get(int pos) 
    {
    	if ((DLLNodeCounter != 0) && ((pos >= 0) && (pos < DLLNodeCounter))) {
    		DLLNode tmp = head;
			for (int i = 0; i < pos; i++) {
				tmp = tmp.next;
			}
			return tmp.data;
    	}
    	return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  This method contains if-else statements which don't depend on the size of the list.
     *  In one branch however, there is a for-loop which executes n times in worst case.
     *  Therefore the worst-case asymptotic running time cost is Theta(n).
     */
    public boolean deleteAt(int pos) 
    {
    	if ((pos >= 0) && (pos < DLLNodeCounter)) {
    		if (DLLNodeCounter == 1) {
        		head.next = null;
        		head.prev = null;
        		head = null;
        		tail = null;
        		DLLNodeCounter--;
        		return true;
        	}
        	else if (pos == 0) {
        		DLLNode n = head.next;
        		if (n != null) {
    				n.prev = null;
    			}
        		head.next = null;
        		head.prev = null;
        		head = n;
        		DLLNodeCounter--;
        		return true;
        	}
        	else if (pos == (DLLNodeCounter - 1)) {
        		DLLNode p = tail.prev;
        		p.next = null;
        		tail.next = null;
        		tail.prev = null;
        		tail = p;
        		DLLNodeCounter--;
        		return true;
        	}
        	else {
        		DLLNode p = head;
    			DLLNode n = head;
    			DLLNode curr = head;
    			for (int i = 0; i < (pos - 1); i++) {
    				p = p.next;
    			}
    			curr = p.next;
    			n = curr.next;
    			curr.next = null;
    			curr.prev = null;
    			p.next = n;
    			if (n != null) {
    				n.prev = p;
    			}
    			DLLNodeCounter--;
        		return true;
        	}
    	}
    	return false;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  The most costly operation in this method is a for-loop which iterates n times in the
     *  worst case scenario. All other operations are of constant running time. Thus, the worst-case
     *  asymptotic running time cost is Theta(n)
     */
    public void reverse()
    {
    	if (DLLNodeCounter <= 1) {
    		return;
    	}
    	DLLNode tmp = head;
    	head = tail;
    	tail = tmp;
    	DLLNode start = head;
    	while(start != null) {
    		DLLNode tmp2 = start.prev;
    		start.prev = start.next;
    		start.next = tmp2;
    		start = start.next;
    	}
    	return;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
     public void makeUnique()
    {
    	 if (DLLNodeCounter > 1) {
    		 DLLNode start = head;
        	 while (start != null) {
        		 T item = start.data;
        		 DLLNode tmp = start;
        		 tmp = tmp.next;
        		 while (tmp != null) {
        			 if (tmp.data == item) {
        				 tmp.prev.next = tmp.next;
        				 if (tmp.next != null) {
        					 tmp.next.prev = tmp.prev;
        				 }
            		 }
        			 tmp = tmp.next;
        		 }
        		 start = start.next;
        	 }
    	 }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  All operations are of constant running time.
     */
    public void push(T item) 
    {
    	DLLNode tmp = new DLLNode(item, null, head);
    	head = tmp;
    	DLLNodeCounter++;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  This method contains if-else statement which are not affected by the size of the list. All
     *  other operations are of constant running time, Theta(1).
     */
    public T pop() 
    {
    	if (DLLNodeCounter != 0) {
    		if (DLLNodeCounter == 1) {
        		head.next = null;
        		head.prev = null;
        		T item = head.data;
        		head = null;
        		tail = null;
        		DLLNodeCounter--;
        		return item;
        	}
        	else {
        			DLLNode n = head.next;
            		n.prev = null;
            		head.next = null;
            		head.prev = null;
            		T item = head.data;
            		head = n;
            		DLLNodeCounter--;
            		return item;
        	}
    	}
      return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  This method contains a for-loop which iterates n times in worst-case. All other operations
     *  are of constant running time. Thus, worst-case asymptotic running time cost is Theta(n).
     */
    public void enqueue(T item) 
    {
    	if (DLLNodeCounter == 0) {
    		DLLNode tmp = new DLLNode(item, null, null);
    		head = tmp;
    		tail = tmp;
    		DLLNodeCounter++;
    	}
    	else {
			DLLNode n = tail;
			for (int i = 0; i < (DLLNodeCounter - 1); i++) {
				n = n.prev;
			}
    		DLLNode tmp = new DLLNode(item, null, n);
    		n.prev = tmp;
    		head = tmp;
    		DLLNodeCounter++;
    	}
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an enqueue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  This method contains if-else statement which are not affected by the size of the list. All
     *  other operations are of constant running time, Theta(1).
     */
    public T dequeue() 
    {
    	if (DLLNodeCounter != 0) {
    		if (DLLNodeCounter == 1) {
        		head.next = null;
        		head.prev = null;
        		T item = head.data;
        		head = null;
        		tail = null;
        		DLLNodeCounter--;
        		return item;
        	}
        	else {
        			DLLNode p = tail.prev;
            		p.next = null;
            		tail.next = null;
            		tail.prev = null;
            		T item = tail.data;
            		tail = p;
            		DLLNodeCounter--;
            		return item;
        	}
    	}
      return null;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}