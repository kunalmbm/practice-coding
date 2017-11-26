package ds.sort;

import ds.util.ReadInputUtility;
import ds.util.SortingUtility;

public class ArrayNearlySorted {


	static void sortArrays(int[][] data) {

		System.out.println("Sorted Output: ");
		for(int index = 0; index <data.length ;index++) {
			
			int[] arr = data[index];
			int n = arr.length-1;
			int k = arr[n];

			SortingUtility.minHeapSortKSorted(arr, n, k);

			System.out.println("");
			for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);

		}
	}


	public static void main(String[] args) {
		
		int[][] data = {{10, 12, 14, 2, 4, 6}};
		data = ReadInputUtility.readIntegerTestDataInArrayKSorted("/test-input/ArrayKSorted.txt");
		sortArrays(data);
		
		//float[][] data = {{0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f}};
		//data = ReadInputUtility.readInputTestDataFromSystemIn();
		//sortFloatArrays(data);
	}

}
