import java.util.Random;
// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Eoin Brereton Hurley
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        for (int i = 1; i < a.length; i++) {
        	for (int j = i; ((j > 0) && (a[j - 1] > a[j])); j--) {
        		double tmp = a[j];
        		a[j] = a[j - 1];
        		a[j - 1] = tmp;
        	}
        }
    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
         for (int i = 0; i < a.length; i++) {
        	 double min = a[i];
        	 int index = i;
        	 for (int j = i + 1; j < a.length; j++) {
        		 if (a[j] < min) {
        			 min = a[j];
        			 index = j;
        		 }
        	 }
        	 double tmp = a[i];
        	 a[i] = min;
        	 a[index] = tmp;
         }
         return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	if (a.length != 0) {
    		a = shuffle(a);
    	}
    	int lo = 0;
    	int hi = a.length - 1;
    	partition(a, lo, hi);
    	return a;
    }
    
    private static final int CUTOFF = 10;
    
    private static double[] partition (double a[], int lo, int hi) {
    	if ((hi - lo) <= CUTOFF) {
    		double[] copy = new double[(hi - lo) + 1];
    		for (int i = 0, j = lo; i < copy.length; i++, j++) {
    			copy[i] = a[j];
    		}
    		copy = insertionSort(copy);
    		for (int i = 0, j = lo; i < copy.length; i++, j++) {
    			a[j] = copy[i];
    		}
    		return a;
    	}
    	pivot(a, lo, hi);
    	for (int i = lo + 1, j = hi; (i <= hi) && (j >= lo); i++,j--) {
    		if (i > j) {
    			double tmp = a[lo];
				a[lo] = a[j];
				a[j] = tmp;
				a = partition(a, lo, j - 1);
				a = partition(a, j + 1, hi);
				return a;
    		}
    		if (a[j] < a[lo]) {
    			if (a[i] > a[lo]) {
    				double tmp = a[i];
    				a[i] = a[j];
    				a[j] = tmp;
    			}
    			else {
    				j++;
    			}
    		}
    		else if (a[i] > a[lo]) {
    			i--;
    		}
    	}
    	return a;
    }
    
    private static double[] pivot (double a[], int lo, int hi) {
    	int start = lo;
    	int middle = lo + ((hi - lo) / 2);
    	int end = hi;
    	if (((a[end] > a[start]) && (a[end] < a[middle])) || ((a[end] > a[middle]) && (a[end] < a[start]))) {
    		double tmp = a[start];
    		a[start] = a[end];
    		a[end] = tmp;
    	}
    	else if (((a[middle] > a[start]) && (a[middle] < a[end])) || ((a[middle] > a[end]) && (a[middle] < a[start]))) {
    		double tmp = a[start];
    		a[start] = a[middle];
    		a[middle] = tmp;
    	}
    	return a;
    }
    
    private static double[] shuffle (double a[]) {
    	Random random = new Random();
    	int randomIndex = random.nextInt(a.length);
    	for (int i = 0; i < a.length; i++) {
    		double tmp = a[i];
    		a[i] = a[randomIndex];
    		a[randomIndex] = tmp;
    		randomIndex = random.nextInt(a.length);
    	}
    	return a;
    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSort (double a[]) {
		 sort(a, 0 , (a.length - 1) / 2, a.length - 1);
		 return a;
    }
    
    private static double[] sort (double a[], int lo, int mid, int hi) {
    	if ((hi - lo) <= CUTOFF) {
    		double[] copy = new double[(hi - lo) + 1];
    		for (int i = 0, j = lo; i < copy.length; i++, j++) {
    			copy[i] = a[j];
    		}
    		copy = insertionSort(copy);
    		for (int i = 0, j = lo; i < copy.length; i++, j++) {
    			a[j] = copy[i];
    		}
    		return a;
    	}
    	sort(a, lo, (lo + ((mid - lo) / 2)), mid);
    	sort(a, (mid + 1), ((mid + 1) + ((hi - mid) / 2)), hi);
    	return merge(a, lo, mid, hi);
    }
    
    private static double[] merge (double a[], int lo, int mid, int hi) {
    	double[] copy = new double[(hi - lo) + 1];
		for (int i = 0, j = lo; i < copy.length; i++, j++) {
			copy[i] = a[j];
		}
		int x = 0;
		int y = (mid - lo) + 1;
		int xLimit = y - 1;
		int yLimit = copy.length - 1;
		int i = 0;
    	for (i = lo; ((i <= hi) && (x <= xLimit) && (y <= yLimit)); i++) {
    		if (copy[x] <= copy[y]) {
    			a[i] = copy[x];
    			x++;
    		}
    		else {
    			a[i] = copy[y];
    			y++;
    		}
    	}
    	while (x <= xLimit) {
    		a[i] = copy[x];
    		i++;
    		x++;
    	}
    	while (y <= yLimit) {
    		a[i] = copy[y];
    		i++;
    		y++;
    	}
    	return a;
    }//end mergesort
    
    //See SortComparisonTest.java for main method
    /*
    public static void main(String[] args) {
		
    }
    */

 }//end class