import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testBinarySearchExtremities()
    {
    	int[] evenLengthTestArray = {1, 2, 3, 4};
    	int[] oddLengthTestArray = {1, 2, 3};
    	
    	assertTrue("binarySearch() failed to find lowest value in an even length array", Collinear.binarySearch(evenLengthTestArray, 1));
    	assertTrue("binarySearch() failed to find highest value in an even length array", Collinear.binarySearch(evenLengthTestArray, 4));
    	
    	assertTrue("binarySearch() failed to find lowest value in an odd length array", Collinear.binarySearch(oddLengthTestArray, 1));
    	assertTrue("binarySearch() failed to find highest value in an odd length array", Collinear.binarySearch(oddLengthTestArray, 3));
    }
    
    @Test
    public void testBinarySearchOutOfBounds()
    {
    	int[] evenLengthTestArray = {1, 2, 3, 4};
    	int[] oddLengthTestArray = {1, 2, 3};
    	
    	assertFalse("binarySearch() failed with test value below minimum value in an even length array", Collinear.binarySearch(evenLengthTestArray, 0));
    	assertFalse("binarySearch() failed with test value above maximum value in an even length array", Collinear.binarySearch(evenLengthTestArray, 5));
    	
    	assertFalse("binarySearch() failed with test value below minimum value in an odd length array", Collinear.binarySearch(oddLengthTestArray, 0));
    	assertFalse("binarySearch() failed with test value above maximum value in an odd length array", Collinear.binarySearch(oddLengthTestArray, 4));
    }
    
    @Test
    public void testInsertionSortBestCases()
    {
    	int[] evenLengthTestArray = {1, 2, 3, 4, 5, 6};
    	int[] oddLengthTestArray = {1, 2, 3, 4, 5};
    	
    	int[] expectedOrderedEvenLengthTestArray = {1, 2, 3, 4, 5, 6};
    	int[] expectedOrderedOddLengthTestArray = {1, 2, 3, 4, 5};
    	
    	Collinear.sort(evenLengthTestArray);
    	Collinear.sort(oddLengthTestArray);
    	
    	boolean isEvenReturnSame = true;
    	if (!Arrays.equals(evenLengthTestArray, expectedOrderedEvenLengthTestArray))
    	{
    		isEvenReturnSame = false;
    	}
    	
    	boolean isOddReturnSame = true;
    	if (!Arrays.equals(oddLengthTestArray, expectedOrderedOddLengthTestArray))
    	{
    		isOddReturnSame = false;
    	}
    	
    	assertTrue("sort() failed with an even length array already in order", isEvenReturnSame);
    	assertTrue("sort() failed with an odd length array already in order", isOddReturnSame);
    }
    
    @Test
    public void testInsertionSortWorstCases()
    {
    	int[] evenLengthTestArray = {6, 5, 4, 3, 2, 1};
    	int[] oddLengthTestArray = {5, 4, 3, 2, 1};
    	
    	int[] expectedOrderedEvenLengthTestArray = {1, 2, 3, 4, 5, 6};
    	int[] expectedOrderedOddLengthTestArray = {1, 2, 3, 4, 5};
    	
    	Collinear.sort(evenLengthTestArray);
    	Collinear.sort(oddLengthTestArray);
    	
    	boolean isEvenReturnSame = true;
    	if (!Arrays.equals(evenLengthTestArray, expectedOrderedEvenLengthTestArray))
    	{
    		isEvenReturnSame = false;
    	}
    	
    	boolean isOddReturnSame = true;
    	if (!Arrays.equals(oddLengthTestArray, expectedOrderedOddLengthTestArray))
    	{
    		isOddReturnSame = false;
    	}
    	
    	assertTrue("sort() failed with an even length array in reverse order", isEvenReturnSame);
    	assertTrue("sort() failed with an odd length array in reverse order", isOddReturnSame);
    }
    
    @Test
    public void testEmptyArrays()
    {
    	int[] emptyTestArray = {};
    	
    	assertFalse("binarySearch() failed with an empty array", Collinear.binarySearch(emptyTestArray, -45));
    	
    	int [] expectedOrderedTestArray = {};
    	Collinear.sort(emptyTestArray);
    	
    	boolean isReturnSame = true;
    	if (!Arrays.equals(emptyTestArray, expectedOrderedTestArray))
    	{
    		isReturnSame = false;
    	}
    	
    	assertTrue("sort() failed with an empty array", isReturnSame);
    }

}
