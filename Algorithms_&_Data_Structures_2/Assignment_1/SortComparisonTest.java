import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Eoin Brereton Hurley
 *  @version HT 2020
 *  
 *  RUNNING TIME RESULTS:
 *  -----------------------------------------------------------------------
 *  						|Insertion|	|Selection|	|Quick|	|Merge|
 *  ------------------------|---------|-|---------|-|-----|-|-----|
 *  1000 Random:			|  ~6ms	  |	|  ~5ms	  |	| ~2ms|	| ~1ms|
 *  ------------------------|---------|-|---------|-|-----|-|-----|
 *  1000 Few Unique:		|  ~2ms   | |  ~2ms	  |	| ~0ms|	| ~0ms|
 *  ------------------------|---------|-|---------|-|-----|-|-----|
 *  1000 Nearly Ordered:	|  ~1ms	  |	|  ~2ms	  |	| ~0ms|	| ~0ms|
 *  ------------------------|---------|-|---------|-|-----|-|-----|
 *  1000 Reverse Ordered:	|  ~3ms	  |	|  ~2ms	  |	| ~0ms|	| ~0ms|
 *  ------------------------|---------|-|---------|-|-----|-|-----|
 *  1000 Sorted:			|  ~0ms	  |	|  ~2ms	  |	| ~0ms|	| ~0ms|
 *  ------------------------|---------|-|---------|-|-----|-|-----|
 *  10000 Random:			|  ~67ms  |	|  ~27ms  |	| ~2ms|	| ~3ms|
 *  -----------------------------------------------------------------------
 *  
 *  
 *  
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty() {
    	double [] a1 = {};
    	double [] a2 = {};
    	double [] a3 = {};
    	double [] a4 = {};
    	assertEquals("Testing Insertion Sort on empty array", SortComparison.insertionSort(a1).length, 0);
    	assertEquals("Testing Selection Sort on empty array", SortComparison.selectionSort(a2).length, 0);
    	assertEquals("Testing Quick Sort on empty array", SortComparison.quickSort(a3).length, 0);
    	assertEquals("Testing Merge Sort on empty array", SortComparison.mergeSort(a4).length, 0);
    }


    // TODO: add more tests here. Each line of code and each decision in SortComparison.java should
    // be executed at least once from at least one test.
    
    @Test
    public void tests() {
    	double [] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    	double [] b1 = {0, 3, 2, 6, 5, 8, 9, 11, 1, 4, 12, 10, 13, 19, 16, 7, 14, 15, 17, 18};
    	double [] b2 = {0, 3, 2, 6, 5, 8, 9, 11, 1, 4, 12, 10, 13, 19, 16, 7, 14, 15, 17, 18};
    	double [] b3 = {0, 3, 2, 6, 5, 8, 9, 11, 1, 4, 12, 10, 13, 19, 16, 7, 14, 15, 17, 18};
    	double [] b4 = {0, 3, 2, 6, 5, 8, 9, 11, 1, 4, 12, 10, 13, 19, 16, 7, 14, 15, 17, 18};
    	double [] test1 = SortComparison.insertionSort(b1); 
    	boolean same = true;
    	for (int i = 0; i < test1.length; i++) {
    		if (test1[i] != b[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Insertion Sort on array with twenty elements", same);
    	
    	double [] test2 = SortComparison.selectionSort(b2);
    	same = true;
    	for (int i = 0; i < test2.length; i++) {
    		if (test2[i] != b[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Selection Sort on array with twenty elements", same);
    	
    	double [] test3 = SortComparison.quickSort(b3);
    	same = true;
    	for (int i = 0; i < test3.length; i++) {
    		if (test3[i] != b[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Quick Sort on array with twenty elements", same);
    	
    	double [] test4 = SortComparison.mergeSort(b4);
    	same = true;
    	for (int i = 0; i < test4.length; i++) {
    		if (test4[i] != b[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Merge Sort on array with twenty elements", same);
    	
    	double [] c = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
    			16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39};
    	double [] c1 = {0, 3, 2, 6, 5, 8, 9, 24, 32, 30, 33, 39, 13, 19, 16,
    			7, 14, 15, 17, 18, 20, 23, 22, 26, 25, 28, 29, 31, 21, 11, 1, 4, 12, 10, 36, 27, 34, 35, 37, 38};
    	double [] c2 = {0, 3, 2, 6, 5, 8, 9, 24, 32, 30, 33, 39, 13, 19, 16,
    			7, 14, 15, 17, 18, 20, 23, 22, 26, 25, 28, 29, 31, 21, 11, 1, 4, 12, 10, 36, 27, 34, 35, 37, 38};
    	double [] c3 = {0, 3, 2, 6, 5, 8, 9, 24, 32, 30, 33, 39, 13, 19, 16,
    			7, 14, 15, 17, 18, 20, 23, 22, 26, 25, 28, 29, 31, 21, 11, 1, 4, 12, 10, 36, 27, 34, 35, 37, 38};
    	double [] c4 = {0, 3, 2, 6, 5, 8, 9, 24, 32, 30, 33, 39, 13, 19, 16,
    			7, 14, 15, 17, 18, 20, 23, 22, 26, 25, 28, 29, 31, 21, 11, 1, 4, 12, 10, 36, 27, 34, 35, 37, 38};
    	double [] test5 = SortComparison.insertionSort(c1); 
    	same = true;
    	for (int i = 0; i < test5.length; i++) {
    		if (test5[i] != c[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Insertion Sort on array with forty elements", same);
    	
    	double [] test6 = SortComparison.selectionSort(c2);
    	same = true;
    	for (int i = 0; i < test6.length; i++) {
    		if (test6[i] != c[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Selection Sort on array with forty elements", same);
    	
    	double [] test7 = SortComparison.quickSort(c3);
    	same = true;
    	for (int i = 0; i < test7.length; i++) {
    		if (test7[i] != c[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Quick Sort on array with forty elements", same);
    	
    	double [] test8 = SortComparison.mergeSort(c4);
    	same = true;
    	for (int i = 0; i < test8.length; i++) {
    		if (test8[i] != c[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Merge Sort on array with forty elements", same);
    	
    	double [] d = {2, 4, 8, 12, 55};
        double [] d1 = {8, 12, 4, 55, 2};
        double [] d2 = {2, 12, 4, 55, 8};
        double [] d3 = {8, 12, 2, 55, 4};
        double [] d4 = {4, 12, 2, 55, 8};
        double [] d5 = {2, 12, 8, 55, 4};
        double [] d6 = {4, 12, 8, 55, 2};
        
    	double [] test9 = SortComparison.insertionSort(d1); 
    	same = true;
    	for (int i = 0; i < test9.length; i++) {
    		if (test9[i] != d[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Insertion Sort on array with different pivots", same);
    	
    	double [] test10 = SortComparison.selectionSort(d2);
    	same = true;
    	for (int i = 0; i < test10.length; i++) {
    		if (test10[i] != d[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Selection Sort on array with different pivots", same);
    	
    	double [] test11 = SortComparison.quickSort(d3);
    	same = true;
    	for (int i = 0; i < test11.length; i++) {
    		if (test11[i] != d[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Quick Sort on array with different pivots", same);
    	
    	double [] test12 = SortComparison.mergeSort(d4);
    	same = true;
    	for (int i = 0; i < test12.length; i++) {
    		if (test12[i] != d[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Quick Sort on array with different pivots", same);
    	
    	double [] test13 = SortComparison.insertionSort(d5); 
    	same = true;
    	for (int i = 0; i < test13.length; i++) {
    		if (test13[i] != d[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Insertion Sort on array with different pivots", same);
    	
    	double [] test14 = SortComparison.selectionSort(d6);
    	same = true;
    	for (int i = 0; i < test14.length; i++) {
    		if (test14[i] != d[i]) {
    			same = false;
    		}
    	}
    	assertTrue("Testing Selection Sort on array with different pivots", same);
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	ArrayList<Double> numbers1 = new ArrayList<Double>();
		ArrayList<Double> numbers2 = new ArrayList<Double>();
		ArrayList<Double> numbers3 = new ArrayList<Double>();
		ArrayList<Double> numbers4 = new ArrayList<Double>();
		ArrayList<Double> numbers5 = new ArrayList<Double>();
		ArrayList<Double> numbers6 = new ArrayList<Double>();
    	try {
    		File numbers1000 = new File("/Users/eoinwbh/Desktop/College/Second Year/Algorithms"
    				+ " & Data Structures/Algorithms & Data Structures 2/Assignment 1/numbers1000.txt");
    		Scanner scanner1 = new Scanner(numbers1000);
    		while (scanner1.hasNextLine()) {
    			String s = scanner1.nextLine();
    			double d = Double.parseDouble(s);
    			numbers1.add(d);
    		}
    		scanner1.close();
    		
    		File numbers1000Duplicates = new File("/Users/eoinwbh/Desktop/College/Second Year/Algorithms"
    				+ " & Data Structures/Algorithms & Data Structures 2/Assignment 1/numbers1000Duplicates.txt");
    		Scanner scanner2 = new Scanner(numbers1000Duplicates);
    		while (scanner2.hasNextLine()) {
    			String s = scanner2.nextLine();
    			double d = Double.parseDouble(s);
    			numbers2.add(d);
    		}
    		scanner2.close();
    		
    		File numbersNearlyOrdered1000 = new File("/Users/eoinwbh/Desktop/College/Second Year/Algorithms"
    				+ " & Data Structures/Algorithms & Data Structures 2/Assignment 1/numbersNearlyOrdered1000.txt");
    		Scanner scanner3 = new Scanner(numbersNearlyOrdered1000);
    		while (scanner3.hasNextLine()) {
    			String s = scanner3.nextLine();
    			double d = Double.parseDouble(s);
    			numbers3.add(d);
    		}
    		scanner3.close();
    		
    		File numbersReverse1000 = new File("/Users/eoinwbh/Desktop/College/Second Year/Algorithms"
    				+ " & Data Structures/Algorithms & Data Structures 2/Assignment 1/numbersReverse1000.txt");
    		Scanner scanner4 = new Scanner(numbersReverse1000);
    		while (scanner4.hasNextLine()) {
    			String s = scanner4.nextLine();
    			double d = Double.parseDouble(s);
    			numbers4.add(d);
    		}
    		scanner4.close();
    		
    		File numbersSorted1000 = new File("/Users/eoinwbh/Desktop/College/Second Year/Algorithms"
    				+ " & Data Structures/Algorithms & Data Structures 2/Assignment 1/numbersSorted1000.txt");
    		Scanner scanner5 = new Scanner(numbersSorted1000);
    		while (scanner5.hasNextLine()) {
    			String s = scanner5.nextLine();
    			double d = Double.parseDouble(s);
    			numbers5.add(d);
    		}
    		scanner5.close();
    		
    		File numbers10000 = new File("/Users/eoinwbh/Desktop/College/Second Year/Algorithms"
    				+ " & Data Structures/Algorithms & Data Structures 2/Assignment 1/numbers10000.txt");
    		Scanner scanner6 = new Scanner(numbers10000);
    		while (scanner6.hasNextLine()) {
    			String s = scanner6.nextLine();
    			double d = Double.parseDouble(s);
    			numbers6.add(d);
    		}
    		scanner6.close();
    	} catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	}
    	
    	double[] a1A = new double[numbers1.size()];
    	double[] a1B = new double[numbers1.size()];
    	double[] a1C = new double[numbers1.size()];
    	double[] a1D = new double[numbers1.size()];
		for (int i = 0; i < numbers1.size(); i++) {
			a1A[i] = numbers1.get(i);
			a1B[i] = numbers1.get(i);
			a1C[i] = numbers1.get(i);
			a1D[i] = numbers1.get(i);
		}
		
		double[] a2A = new double[numbers2.size()];
		double[] a2B = new double[numbers2.size()];
		double[] a2C = new double[numbers2.size()];
		double[] a2D = new double[numbers2.size()];
		for (int i = 0; i < numbers2.size(); i++) {
			a2A[i] = numbers2.get(i);
			a2B[i] = numbers2.get(i);
			a2C[i] = numbers2.get(i);
			a2D[i] = numbers2.get(i);
		}
		
		double[] a3A = new double[numbers3.size()];
		double[] a3B = new double[numbers3.size()];
		double[] a3C = new double[numbers3.size()];
		double[] a3D = new double[numbers3.size()];
		for (int i = 0; i < numbers3.size(); i++) {
			a3A[i] = numbers3.get(i);
			a3B[i] = numbers3.get(i);
			a3C[i] = numbers3.get(i);
			a3D[i] = numbers3.get(i);
		}
		
		double[] a4A = new double[numbers4.size()];
		double[] a4B = new double[numbers4.size()];
		double[] a4C = new double[numbers4.size()];
		double[] a4D = new double[numbers4.size()];
		for (int i = 0; i < numbers4.size(); i++) {
			a4A[i] = numbers4.get(i);
			a4B[i] = numbers4.get(i);
			a4C[i] = numbers4.get(i);
			a4D[i] = numbers4.get(i);
		}
		
		double[] a5A = new double[numbers5.size()];
		double[] a5B = new double[numbers5.size()];
		double[] a5C = new double[numbers5.size()];
		double[] a5D = new double[numbers5.size()];
		for (int i = 0; i < numbers5.size(); i++) {
			a5A[i] = numbers5.get(i);
			a5B[i] = numbers5.get(i);
			a5C[i] = numbers5.get(i);
			a5D[i] = numbers5.get(i);
		}
		
		double[] a6A = new double[numbers6.size()];
		double[] a6B = new double[numbers6.size()];
		double[] a6C = new double[numbers6.size()];
		double[] a6D = new double[numbers6.size()];
		for (int i = 0; i < numbers6.size(); i++) {
			a6A[i] = numbers6.get(i);
			a6B[i] = numbers6.get(i);
			a6C[i] = numbers6.get(i);
			a6D[i] = numbers6.get(i);
		}
		
		long startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a1A);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("Time taken for Insertion Sort on numbers1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a1B);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Selection Sort on numbers1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a1C);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Quick Sort on numbers1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.mergeSort(a1D);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Merge Sort on numbers1000.txt: " + time + "ms");
		
		System.out.println("\n");
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a2A);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Insertion Sort on numbers1000Duplicates.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a2B);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Selection Sort on numbers1000Duplicates.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a2C);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Quick Sort on numbers1000Duplicates.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.mergeSort(a2D);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Merge Sort on numbers1000Duplicates.txt: " + time + "ms");
		
		System.out.println("\n");
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a3A);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Insertion Sort on numbersNearlyOrdered1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a3B);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Selection Sort on numbersNearlyOrdered1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a3C);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Quick Sort on numbersNearlyOrdered1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.mergeSort(a3D);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Merge Sort on numbersNearlyOrdered1000.txt: " + time + "ms");
		
		System.out.println("\n");
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a4A);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Insertion Sort on numbersReverse1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a4B);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Selection Sort on numbersReverse1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a4C);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Quick Sort on numbersReverse1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.mergeSort(a4D);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Merge Sort on numbersReverse1000.txt: " + time + "ms");
		
		System.out.println("\n");
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a5A);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Insertion Sort on numbersSorted1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a5B);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Selection Sort on numbersSorted1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a5C);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Quick Sort on numbersSorted1000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.mergeSort(a5D);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Merge Sort on numbersSorted1000.txt: " + time + "ms");
		
		System.out.println("\n");
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a6A);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Insertion Sort on numbers10000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a6B);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Selection Sort on numbers10000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a6C);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Quick Sort on numbers10000.txt: " + time + "ms");
		startTime = System.currentTimeMillis();
		SortComparison.mergeSort(a6D);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("Time taken for Merge Sort on numbers10000.txt: " + time + "ms");
		
    }
}
