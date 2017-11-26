package ds.arrays;

import ds.util.SearchUtility;

public class UnsortedArraySearch {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40};
		int element = 30;
		int s = arr.length;
		
		
		int i = SearchUtility.linearSearch(arr, 0, s-1, element);
		
		if(i == -1) {
			System.out.printf("%d not found \n" , element);
		} else {
			System.out.printf("%d found at %d position \n",element,i);
		}

	}

}
