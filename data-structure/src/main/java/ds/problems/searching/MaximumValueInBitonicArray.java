package ds.problems.searching;

import java.util.Scanner;

public class MaximumValueInBitonicArray {

	public static void main(String[] args) {
		
/*
2
9
1 15 25 45 42 21 17 12 11
5
1 45 47 50 5

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			//int max = printMaxElement(A, n);
			int max = findMaxElement(A, 0, n-1);
			System.out.println(max);
		}
		sc.close();
	}

	public static int printMaxElement(int[] A, int n) {
		int i=1;
		for(; i <n; i++) {
			if(A[i] < A[i-1])
				break;
		}
		return A[i-1];
		
	}
	
	public static int findMaxElement(int[] A, int lo, int hi) {
	
		if(lo == hi)
			return A[lo];

		if( lo+1 == hi)
			return Math.max(A[lo], A[hi]);

		if( lo+2 == hi)
			return Math.max(Math.max(A[lo], A[lo+1]),A[hi]);
		
		int mid = (lo+hi)/2;
		
		if(A[mid-1] > A[mid])
			return findMaxElement(A, lo, mid-1);
		
		return findMaxElement(A, mid, hi);

	}

}
