package ds.problems.searching;

import java.util.Scanner;

public class MinimumElementInASortedAndRotatedArray {

	public static void main(String[] args) {
		
/*
16
8
1 2 3 4 5 6 7 8
8
8 1 2 3 4 5 6 7
8
7 8 1 2 3 4 5 6
8
6 7 8 1 2 3 4 5
8
5 6 7 8 1 2 3 4
8
4 5 6 7 8 1 2 3
8
3 4 5 6 7 8 1 2
8
2 3 4 5 6 7 8 1
8
8 7 6 5 4 3 2 1
8
7 6 5 4 3 2 1 8
8
6 5 4 3 2 1 8 7
8
5 4 3 2 1 8 7 6
8
4 3 2 1 8 7 6 5
8
3 2 1 8 7 6 5 4
8
2 1 8 7 6 5 4 3
8
1 8 7 6 5 4 3 2


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			int x = findMinimum(A, 0, n-1);
			System.out.println(x);

		}
		sc.close();
	}

	public static int findMinimum(int[] A, int lo, int hi) {
		
		if(lo == hi)
			return A[lo];
		
		if(hi == lo+1)
			return Math.min(A[lo], A[hi]);
		
		if(hi == lo+2)
			return Math.min(Math.min(A[lo], A[lo+1]),A[hi]);

		int mid = lo + (hi - lo)/2;
		int lMin = Math.min(A[lo], A[mid]);
		int rMin = Math.min(A[mid+1], A[hi]);

		if(lMin < rMin)
			return findMinimum(A, lo, mid);
		
		return findMinimum(A, mid+1, hi);
		
	}

}
