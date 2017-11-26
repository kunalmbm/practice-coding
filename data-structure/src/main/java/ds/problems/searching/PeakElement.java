package ds.problems.searching;

import java.util.Scanner;

public class PeakElement {

	public static void main(String[] args) {

		/*
		 * 
		 * 4 3 1 2 3 4 4 3 2 1 5 1 2 6 5 4 9 1 3 4 2 5 6 7 8 3
		 * 
		 */

		PeakElement obj = new PeakElement();
		obj.process();

	}

	public void process() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}

			int i = peakElement(A, n);
			System.out.println(i);

		}
		sc.close();
	}

	public int peakElementBS(int[] A, int lo, int hi) {

		if (lo == hi)
			return lo;

		if ((lo + 1) == hi)
			return (A[lo] >= A[hi] ? lo : hi);

		int mid = (lo + hi) / 2;

		if (A[mid - 1] <= A[mid] && A[mid + 1] <= A[mid]) {
			return mid;
		}

		if (A[mid - 1] > A[mid])
			return peakElementBS(A, lo, mid - 1);

		return peakElementBS(A, mid + 1, hi);
	}

	public int peakElement(int[] a, int n) {
		return peakElementBS(a, 0, n - 1);
	}

	public int peakElementOld(int[] a, int n) {

		if (n <= 1 || a[0] >= a[1])
			return 0;

		if (a[n - 1] >= a[n - 2])
			return n - 1;

		for (int i = 1; i < n - 1; i++) {

			if (a[i - 1] <= a[i] && a[i + 1] <= a[i])
				return i;

			if (a[i + 1] < a[i])
				i++;
		}

		return -1;
	}
}
