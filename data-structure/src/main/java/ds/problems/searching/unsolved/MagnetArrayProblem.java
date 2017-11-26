package ds.problems.searching.unsolved;

import java.util.Scanner;

class MagnetArrayProblem {
	
	public static void main(String[] args) {
		/*
3
2
1 2
4
0 10 20 30
4
10 30 70 90

		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			
			int n = sc.nextInt();
			double[] A = new double[n];
			for (int i = 0; i < n; i++)
				A[i] = sc.nextDouble();
			
			for (int i = 0; i < n - 1; i++) {
				double ans = findZeroForcePoint(A[i], A[i + 1], A, n);
				System.out.printf("%.2f ",ans);
			}
			System.out.println();
		}
		sc.close();
	}

	public static double findZeroForcePoint(double a, double b, double[] A, int n) {
		double e = 0.0000000000001;
		double mid = (a + b) / 2.0;
		double force = 0.0;
		for (int i = 0; i < n; i++)
			force += 1.0 / (mid - A[i]);
		
		if (Math.abs(force) < e)
			return mid;
		
		if (force > 0)
			return findZeroForcePoint(mid, b, A, n);
		else
			return findZeroForcePoint(a, mid, A, n);
	}
}