package ds.arrays;

import ds.util.ArrayUtility;
import ds.util.SearchUtility;

public class TernarySearch {

	public static void main(String[] args) {
		
		int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23,24, 33, 35, 42, 47};
		int n = arr.length;

		int x =18;
		ArrayUtility.printArray(arr, n, "before : ");
		int index = SearchUtility.ternarySearch(arr,0,n-1,x);
		System.out.println("found index : " + index);
		
	}

}
