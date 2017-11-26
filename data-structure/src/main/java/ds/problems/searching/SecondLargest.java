package ds.problems.searching;

import java.util.Scanner;

public class SecondLargest {

	public static void main(String[] args) {
		
/*
4
5
89 24 75 11 23
6
56 42 21 23 65 20
7
1 0 12 7 23 4 23
42
28 43 26 65 60 54 51 35 42 48 33 40 58 38 64 47 44 49 46 25 57 39 55 45 29 32 61 53 31 36 56 63 30 52 27 34 50 41 37 66 62 59 


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			int x = getSecondLargest(A, n);
			System.out.println(x);

		}
		sc.close();
	}

	public static int getSecondLargest(int[] A, int n) {
		int max = 0, max2 = 0;
		for(int i=0; i <n; i++) {
			if(A[i] > max) {
				max2 = max;
				max = A[i];
				continue;
			}
			
			if(A[i] > max2) {
				max2 = A[i];
			}
		}
		
		return max2;

	}

}
