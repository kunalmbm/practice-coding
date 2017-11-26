package ds.arrays;

import ds.util.SearchUtility;

public class SortedArraySearch {
	
	
	public static void main(String[] args) {
		
		//int[] arr = {3,5,10,12,90};
		int[] arr = {5, 6, 8 ,9};
		int n = arr.length;
		int e = 6;
		
		int pos = SearchUtility.binarySearch(arr, 0, n-1, e);
		//int pos = SearchUtility.binarySearchReturnCeilingIndex(arr, 0, n-1, e);
		//int pos = SearchUtility.binarySearchIterative(arr, n, e);
		
		if(pos == -1)
			System.out.printf("%d not found in array", e);
		else
			System.out.printf("%d found at %d index", e,pos);
		
	}

}
