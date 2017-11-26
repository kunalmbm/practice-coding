package ds.problems.searching;

import java.util.Scanner;

public class SonamBewafaAsksQuestions {

	public static void main(String[] args) {

		/*
2
3 9
1 10 12 20 22 30 
1 5 10 15 19 25 28 29 30
7 7
1 29 31 33 37 40 41 49 51 57 60 99 100 101
34 61 52 87 22 44 99

		 * 
		 */

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			long[] N = new long[n * 2];
			long[] Q = new long[q];

			for (int i = 0; i < n; i++) {
				N[2 * i] = sc.nextLong();
				N[2 * i + 1] = sc.nextLong();
			}

			for (int i = 0; i < q; i++) {
				Q[i] = sc.nextLong();
			}

			findMarks(N, n, Q, q);

		}
		sc.close();
	}

	public static void findMarks(long[] N, int n, long[] Q, int q) {

		long[] C = new long[n];
		long val = 0;
		for (int i = 0; i < n; i++)
			C[i] = val = N[2 * i + 1] - N[2 * i] + 1 + val;
		

		for (int i = 0; i < q; i++) {
			long x = Q[i];
			if(x < N[0] || x > N[2*n-1])
				throw new RuntimeException("invalid value of x : "+x);
			
			
			int ind = binarySearchReturnCeilingIndex(C, 0, n - 1, x);
			if(ind == -1)
				ind = n-1;

			long base = ind == 0 ? 0 : C[ind-1];
			long m = N[2*ind] + x - base - 1;

			if (i == 0)
				System.out.print(m);
			else
				System.out.printf(" %d", m);
		}
		System.out.println();

	}

	public static int binarySearchReturnCeilingIndex(long[] A, int lo, int hi, long x) {

		if (lo > hi)
			return -1;

		int mid = lo + (hi - lo) / 2;

		// System.out.printf("### %d - %d - %d : %d : %d \n", low, high, mid ,
		// e, arr[mid]);

		if (A[mid] == x)
			return mid;

		if (A[mid] > x && (mid == 0 || A[mid - 1] < x))
			return mid;

		if (A[mid] > x)
			return binarySearchReturnCeilingIndex(A, lo, mid - 1, x);

		return binarySearchReturnCeilingIndex(A, mid + 1, hi, x);

	}

}
