package ds.problems.searching;

import java.util.Scanner;

public class CountTheZerosInAMatrix {

	public static void main(String[] args) {
		
/*
1
3 4
0 0 0 1
0 0 1 1
0 1 1 1

 */
		
		CountTheZerosInAMatrix obj = new CountTheZerosInAMatrix();
		obj.process();

	}
	
	void process() {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int[][] A = new int[r][c];
			for(int i=0; i <r; i++)
				for(int j=0; j <c; j++)
					A[i][j] = sc.nextInt();
			System.out.println(countZeros(A, r));

		}
		sc.close();
	}
	
	int countZeros2(int A[][], int n)
    {
		int c = 0;
		for(int i=0; i < A.length; i++)
			for(int j=0; j < A[i].length; j++)
				if(A[i][j] == 0)
					c+=1;
       return c;
    }

	
	int countZeros(int A[][], int n)
    {
		int c = 0;
		for(int i=0; i < A.length; i++) {
			int t = findFirstIndexOfOne(A[i], 0, A[i].length-1);
			if(t == -1)
				t = A[i].length;
			//System.out.println(t);
			c+=t;
		}
       return c;
    }

	int findFirstIndexOfOne(int[] A, int lo, int hi) {
		
		if(lo > hi)
			return -1;
		
		int mid = (lo+hi)/2;

		if(A[mid] == 0)
			return findFirstIndexOfOne(A, mid+1, hi);
		
		if(mid == lo || A[mid-1] == 0) 
			return mid;
		
		return findFirstIndexOfOne(A, lo, mid-1);

	}

}
