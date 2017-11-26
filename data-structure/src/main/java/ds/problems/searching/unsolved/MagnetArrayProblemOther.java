package ds.problems.searching.unsolved;

import java.util.*;
import java.lang.*;
import java.io.*;

class MagnetArrayProblemOther {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			double[] arr = new double[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextDouble();
			for (int i = 0; i < n - 1; i++) {
				double ans = solve(arr[i], arr[i + 1], arr, n);
				System.out.print(roundOffTo2DecPlaces(ans) + " ");
			}
			System.out.println();
		}
	}

	public static String roundOffTo2DecPlaces(double val) {
		return String.format("%.2f", val);
	}

	public static double solve(double a, double b, double[] arr, int n) {
		double e = 0.0000000000001;
		double x = (a + b) / 2.0;
		double force = 0.0;
		for (int i = 0; i < n; i++)
			force += 1.0 / (x - arr[i]);
		if (Math.abs(force) < e)
			return x;
		if (force > 0)
			return solve(x, b, arr, n);
		else
			return solve(a, x, arr, n);
	}
}