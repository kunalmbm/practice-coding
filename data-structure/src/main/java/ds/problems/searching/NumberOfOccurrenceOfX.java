package ds.problems.searching;

import java.util.Scanner;

public class NumberOfOccurrenceOfX {

	public static void main(String[] args) {
		
/*
2
7 2
1 1 2 2 2 2 3
7 4
1 1 2 2 2 2 3


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] A = new int[n];
			for(int i=0;i < n; i++) {
				A[i] = sc.nextInt();
			}
			printNumberOfOccurrence(A, n, x);
		}
		sc.close();
	}
	private static void printNumberOfOccurrence(int[] A, int n, int x) {
		
		int i = binarySearch(A, 0, n-1, x);
		if(i == -1) {
			System.out.println(-1);
			return;
		}
		
		int l = i;
		while(l >= 0 && A[l] == x)
			l--;
		l++;
		
		while(i < n && A[i] == x)
			i++;
		i--;
		
		System.out.println(i-l+1);

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
