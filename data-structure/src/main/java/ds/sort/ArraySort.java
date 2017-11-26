package ds.sort;

import ds.util.ReadInputUtility;
import ds.util.SortingUtility;

public class ArraySort {


	static void sortArrays(int[][] data) {

		System.out.println("Sorted Output: ");
		for(int index = 0; index <data.length ;index++) {
			
			int[] arr = data[index];
			int n = arr.length;

			//SortingUtility.selectionSort(arr, n);
			//SortingUtility.bubbleSort(arr, n);
			//SortingUtility.selectionSort(arr, n);
			//SortingUtility.bubbleSort(arr, n);
			//SortingUtility.insertionSortLong(arr, n);
			//SortingUtility.insertionSort(arr, n);
			//SortingUtility.insertionSortBinarySearch(arr, n);
			//SortingUtility.mergeSort(arr, 0, n-1);
			//SortingUtility.mergeSortLong(arr, 0, n-1);
			//arr = SortingUtility.maxHeapSortNewArray(arr, n);
			//SortingUtility.maxHeapSort(arr, n);
			//SortingUtility.minHeapSort(arr, n);
			//SortingUtility.quickSortLastPivot(arr, 0, n-1);
			//SortingUtility.quickSort3WayLastPivot(arr, 0, n-1);
			//SortingUtility.countingSort(arr, n);
			//SortingUtility.radixSort(arr, n);
			//SortingUtility.bucketSort(arr, n);
			SortingUtility.minHeapSortKSorted(arr, n, 3);

			System.out.println("");
			for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);

		}
	}

	static void sortFloatArrays(float[][] data) {

		System.out.println("Sorted Output: ");
		for(int index = 0; index <data.length ;index++) {
			
			float[] arr = data[index];
			int n = arr.length;
			SortingUtility.bucketSort(arr, n);

			System.out.println("");
			for(int i = 0; i<n ;i++) 
				System.out.printf("%.4f ",arr[i]);

		}
	}

	public static void main(String[] args) {
		
		int[][] data = {{10, 12, 14, 2, 4, 6}};
		data = ReadInputUtility.readInputTestDataFromSystemIn();
		sortArrays(data);
		
		//float[][] data = {{0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f}};
		//data = ReadInputUtility.readInputTestDataFromSystemIn();
		//sortFloatArrays(data);
	}

}
