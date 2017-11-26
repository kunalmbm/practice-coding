package ds.util;

public class ArrayUtility {

	public static void swap(int[] arr, int i, int j) {
		if(i == j)
			return;
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void printArray(int[] arr, int n, String startText) {
		
		System.out.print(startText);
		for(int i = 0; i<n ; i++) {
			System.out.printf("%d, ", arr[i]);
		}
		System.out.println();
		
	}

	public static void printArray(int[] arr, int n) {
		printArray(arr, n, "arr: ");
	}
	
	public static void printArrayOfArray(int[][] data) {
		
		for (int i=0; i<data.length;i++) {
			printArray(data[i], data[i].length, "arr" + (i+1) + " : ");	
		}
		
	}

}
