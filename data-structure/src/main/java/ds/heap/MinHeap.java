package ds.heap;

import ds.util.HeapUtility;
import ds.util.ReadInputUtility;

public class MinHeap {
	
	
	
	public static void main(String[] args) {
		
		int[][] data = {{5, 40, 0, 25, 10}};
		data = ReadInputUtility.readInputTestDataFromSystemIn();
		createMinHeap(data); // create new array
		//minHeapify(data); // heapify existing array

	}
	
	static void minHeapify(int[][] data) {
		
		for (int[] arr : data) {
			
			int n = arr.length;
			
			for(int p = n/2-1 ; p >= 0 ; p--) 
				HeapUtility.minHeapify(arr, n, p);
			
			System.out.println("");
			for(int i = 0; i< arr.length ;i++) 
				System.out.printf("%d ",arr[i]);

		}
	}

	static void createMinHeap(int[][] data) {
		
		for (int[] input : data) {
			
			int[] arr = HeapUtility.createMinHeap(input);
			System.out.println("");
			for(int i = 0; i< arr.length ;i++) 
				System.out.printf("%d ",arr[i]);

		}


	}

}
