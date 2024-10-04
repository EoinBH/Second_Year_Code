import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Eoin Brereton Hurley
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertNull( "Checking get() with an empty list - expected returned value to be null", testDLL.get(0) );
    	testDLL.insertBefore(0,1);
    	assertEquals( "Checking get() with a list containing one element - expected the element at the head of the list", "1", testDLL.get(0).toString() );
    	testDLL.insertBefore(0,2);
    	testDLL.insertBefore(0,3);
    	assertEquals( "Checking get() with a list containing 3 elements - expected the element at the tail of the list", "1", testDLL.get(2).toString() );
    	testDLL.insertBefore(3,20);
    	assertNull( "Checking get() over maximum number of objects with a list containing 4 elements - expected returned value to be null", testDLL.get(4) );
    	assertNull( "Checking get() under minimum number of objects with a list containing 4 elements - expected returned value to be null", testDLL.get(-1) );
    }
    
    @Test
    public void testDeleteAt()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertFalse( "Checking deleteAt with an empty list - expected returned boolean to be false", testDLL.deleteAt(0) );
    	testDLL.insertBefore(0,1);
    	assertTrue( "Checking deleteAt with a list containing one element - expected returned boolean to be true", testDLL.deleteAt(0) );
    	assertFalse( "Checking deleteAt with after list is emptied - expected returned boolean to be false", testDLL.deleteAt(0));
    	testDLL.insertBefore(0,2);
    	testDLL.insertBefore(0,3);
    	testDLL.insertBefore(0,20);
    	testDLL.deleteAt(0);
    	assertEquals( "Checking deleteAt with a list containing 3 elements - expected deletion of head element", "3,2", testDLL.toString() );
    	testDLL.insertBefore(0,70);
    	testDLL.deleteAt(2);
    	assertEquals( "Checking deleteAt with a list containing 3 elements - expected deletion of tail element", "70,3", testDLL.toString() );
    	assertTrue( "Checking deleteAt with a list containing 2 elements - expected returned boolean to be true", testDLL.deleteAt(0) );
    	assertFalse( "Checking deleteAt over maximum number of objects with a list containing one element - expected returned boolean to be false", testDLL.deleteAt(5));
    	assertFalse( "Checking deleteAt under minimum number of objects with a list containing one element - expected returned boolean to be false", testDLL.deleteAt(-1));
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with an empty list", "", testDLL.toString() );
    	testDLL.insertBefore(0,2);
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with a list containing one element", "2", testDLL.toString() );
    	testDLL.insertBefore(0,3);
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with a list containing 2 elements", "2,3", testDLL.toString() );
    	testDLL.insertBefore(0,4);
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with a list containing 3 elements", "3,2,4", testDLL.toString() );
    	testDLL.insertBefore(0,5);
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with a list containing 4 elements", "4,2,3,5", testDLL.toString() );
    	testDLL.insertBefore(0,6);
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with a list containing 5 elements", "5,3,2,4,6", testDLL.toString() );
    	testDLL.insertBefore(0,7);
    	testDLL.reverse();
    	assertEquals( "Checking reverse() with a list containing 6 elements", "6,4,2,3,5,7", testDLL.toString() );
    }
    
    @Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<String> testDLL = new DoublyLinkedList<String>();
    	testDLL.insertBefore(0,"A");
    	testDLL.insertBefore(0,"D");
    	testDLL.insertBefore(0,"B");
    	testDLL.insertBefore(0,"C");
    	testDLL.insertBefore(0,"B");
    	testDLL.insertBefore(0,"A");
    	testDLL.makeUnique();
    	assertEquals( "Checking makeUnique with list containing 6 elements", "A,B,C,D", testDLL.toString());
    	testDLL.deleteAt(3);
    	testDLL.deleteAt(2);
    	testDLL.deleteAt(1);
    	testDLL.insertBefore(1,"C");
    	testDLL.insertBefore(2,"C");
    	testDLL.makeUnique();
    	assertEquals( "Checking makeUnique with list containing 3 elements", "A,C", testDLL.toString());
    	testDLL.deleteAt(0);
    	testDLL.deleteAt(0);
    	assertEquals( "Checking makeUnique with empty list", "", testDLL.toString());
    }
    
    @Test
    public void testPushAndPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(0);
    	assertEquals( "Checking push() with an empty list", "0", testDLL.toString() );
    	testDLL.push(1);
    	testDLL.push(2);
    	assertEquals( "Checking pop() with a list containing 3 elements", "2", testDLL.pop().toString() );
    	assertEquals( "Checking pop() with a list containing 2 elements", "1", testDLL.pop().toString() );
    	assertEquals( "Checking pop() with a list containing 1 elements", "0", testDLL.pop().toString() );
    	assertNull( "Checking pop() with an empty list", testDLL.pop() );
    	
    	
    }
    
    @Test
    public void testEnqueueAndDequeue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(0);
    	assertEquals( "Checking enqueue() with an empty list", "0", testDLL.toString() );
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	assertEquals( "Checking dequeue() with a list containing 3 elements", "0", testDLL.dequeue().toString() );
    	assertEquals( "Checking dequeue() with a list containing 2 elements", "1", testDLL.dequeue().toString() );
    	assertEquals( "Checking dequeue() with a list containing 1 elements", "2", testDLL.dequeue().toString() );
    	assertNull( "Checking dequeue() with an empty list", testDLL.dequeue() );
    	
    	
    }

}