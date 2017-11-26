package ds.problems.searching;

import java.util.Scanner;

public class SearchElementInArray {

	public static void main(String[] args) {
		
/*
2
4
1 2 3 4
3
6
5 1 0 7 12 3
3

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			int x = sc.nextInt();
			
			int index = linearSearch(A, 0, n-1 ,x);
			System.out.println(index);

		}
		sc.close();
	}
	
	public static int linearSearch(int[] arr, int low, int high, int key) {
		
		for(int i=low;i<=high;i++) {
			if(arr[i] == key)
				return i;
		}
		
		return -1;
	}


	public static int binarySearch(int[] arr, int low, int high, int e) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		if(arr[mid] == e)
			return mid;
		
		if(arr[mid] > e)
			return binarySearch(arr, low, mid-1, e);
		
		return binarySearch(arr, mid+1, high, e);
		
	}

}
