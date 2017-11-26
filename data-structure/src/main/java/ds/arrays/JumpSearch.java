package ds.arrays;

import ds.util.ArrayUtility;
import ds.util.SearchUtility;

public class JumpSearch {

	public static void main(String[] args) {
		
		int[] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 613, 615};
		int n = arr.length;
		
		ArrayUtility.printArray(arr, n, "before : ");
		int index = SearchUtility.jumpSearch(arr, n, 615);
		System.out.println("found index : " + index);
		
	}

}
