package ds.problems.searching;

import java.util.Scanner;

public class IndexOfExtraElement {

	public static void main(String[] args) {
		
/*
11
7
2 4 6 8 9 10 12
2 4 6 8 10 12
6
3 5 7 9 11 13
5 7 9 11 13
6
3 5 7 9 11 13
3 5 7 9 11
8
2 3 4 5 6 7 8 9
3 4 5 6 7 8 9
7
3 4 5 6 7 8 9
4 5 6 7 8 9
8
3 4 5 6 7 8 9 10
3 4 5 6 7 8 9
7
4 5 6 7 8 9 10
4 5 6 7 8 9
8
3 4 5 6 7 8 9 10
3 4 6 7 8 9 10
7
4 5 6 7 8 9 10
4 6 7 8 9 10
8
2 3 4 5 6 7 8 9
2 3 4 5 6 7 9
7
3 4 5 6 7 8 9
3 4 5 6 7 9


 */
		
		IndexOfExtraElement obj = new IndexOfExtraElement();
		obj.process();
		
	}
	
	public void process() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			int[] B = new int[n-1];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0; i < n-1; i++) {
				B[i] = sc.nextInt();
			}
			
			int i = findExtra(A, B, n);
			System.out.println(i);

		}
		sc.close();		
	}

	public int findExtraOld(int a[],int b[],int n)
    {
		for(int i=0; i < n-1; i++) {
			if(a[i]!=b[i])
				return i;
		}
		return n-1;
    }
	
	public int findExtra(int a[],int b[],int n)
    {
		return binarySearch(a, b, 0, a.length-1);
    }
	
	private int binarySearch(int A[],int B[],int lo, int hi)
    {
		if(lo == hi)
			return lo;
		
		int mid = (lo+hi)/2;
		
		if(A[mid]!=B[mid]) {
			if(mid == 0 || A[mid-1]==B[mid-1])
				return mid;
			else 
				return binarySearch(A, B, lo, mid-1);
		} else 
			return binarySearch(A, B, mid+1, hi);
    }

}
