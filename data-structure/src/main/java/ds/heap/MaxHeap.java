package ds.heap;

import ds.util.HeapUtility;
import ds.util.ReadInputUtility;

public class MaxHeap {
	
	
	
	public static void main(String[] args) {
		
		int[][] data = {{5, 40, 0, 25, 10}};
		data = ReadInputUtility.readInputTestDataFromSystemIn();
		//createMaxHeap(data); // create new array
		maxHeapify(data); // heapify existing array
		
	}
	
	static void maxHeapify(int[][] data) {
		
		for (int[] arr : data) {
			int n = arr.length;
			
			for(int p = n/2-1 ; p >= 0 ; p--) 
				HeapUtility.maxHeapify(arr, n, p);

			System.out.println("");
			for(int i = 0; i< arr.length ;i++) 
				System.out.printf("%d ",arr[i]);

		}
	}

	static void createMaxHeap(int[][] data) {
		
		for (int[] input : data) {
			
			int[] arr = HeapUtility.createMaxHeap(input);
			System.out.println("");
			for(int i = 0; i< arr.length ;i++) 
				System.out.printf("%d ",arr[i]);

		}
	}

}
