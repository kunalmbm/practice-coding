package ds.problems.searching;

import java.util.Scanner;

public class FloorInSortedArray {

	public static void main(String[] args) {
		
/*
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			int index = binarySearchReturnFloorIndex(A, 0, n-1, x);
			System.out.println(index);

		}
		sc.close();
	}

	public static int binarySearchReturnFloorIndex(int[] A, int lo, int hi, int x) {
		
		if(lo > hi)
			return -1;
		
		int mid = lo + (hi - lo)/2;
		
		//System.out.printf("### %d - %d - %d : %d : %d \n", low, high, mid , e, arr[mid]);
		
		if(A[mid] == x)
			return mid;
		
		if(A[mid] < x && (mid == A.length-1 || x < A[mid+1]))
			return mid;
			
		if(A[mid] > x)
			return binarySearchReturnFloorIndex(A, lo, mid-1, x);
		
		return binarySearchReturnFloorIndex(A, mid+1, hi, x);

	}

}
