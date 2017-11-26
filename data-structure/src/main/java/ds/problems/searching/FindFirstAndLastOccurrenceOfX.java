package ds.problems.searching;

import java.util.Scanner;

public class FindFirstAndLastOccurrenceOfX {

	public static void main(String[] args) {
		
/*
4
9
1 3 5 5 5 5 67 123 125
5
9
1 3 5 5 5 5 7 123 125
7
5
1 1 1 2 3
1
6
1 2 3 4 4 4
4


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0;i < n; i++) {
				A[i] = sc.nextInt();
			}
			int x = sc.nextInt();
			printFirstLastOccurrence(A, n, x);
		}
		sc.close();
	}
	private static void printFirstLastOccurrence(int[] A, int n, int x) {
		
		int i = binarySearch(A, 0, n-1, x);
		if(i == -1) {
			System.out.println(-1);
			return;
		}
		
		int l = i;
		while(l >= 0 && A[l] == x)
			l--;
		System.out.printf("%d ", (l+1));

		while(i < n && A[i] == x)
			i++;
		System.out.println((i-1));

	}
	
	private static int binarySearch(int[] A, int lo, int hi, int x) {
		
		if(lo > hi)
			return -1;
		
		int mid = (lo+hi)/2;
		
		if(A[mid] == x)
			return mid;
		
		if(A[mid] < x)
			return binarySearch(A,mid+1,hi,x);
		
		return binarySearch(A,lo,mid-1,x);
		
	}

}
