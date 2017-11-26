package ds.problems.searching;

import java.util.Arrays;
import java.util.Scanner;

public class HappiestTriplet {

	private void run() {
		/*
3
3
5 2 8  
10 7 12
9 14 6
4
15 12 18 9
10 17 13 8
14 16 11 5
11
5 2 8 3 5 5 10 10 12 4 4  
10 7 12 3 4 6 10 11 11 5 6
9 14 6 4 4 5 9 11 12 6 5

			*/

		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		for(int index = 0; index < t; index++) {
			int n = scanner.nextInt();
			int[] A = new int[n];
			for (int i = 0; i< n; i++) {
				A[i] = scanner.nextInt();
			}

			int[] B = new int[n];
			for (int i = 0; i< n; i++) {
				B[i] = scanner.nextInt();
			}

			int[] C = new int[n];
			for (int i = 0; i< n; i++) {
				C[i] = scanner.nextInt();
			}
			
			findHappiestTriplet(A, B, C, n);
			
			// System.out.printf("%d %d %d\n", node.max, node.mid, node.min);

		}

		scanner.close();

	}
	
	public static void main(String[] args) {
		
		HappiestTriplet object = new HappiestTriplet();
		object.run();


	}
	
	private int max(int a, int b, int c) {
		return Math.max(Math.max(a, b),c);
	}
	
	private int min(int a, int b, int c) {
		return Math.min(Math.min(a, b),c);
	}

	
	private void findHappiestTriplet(int[] A,int[] B,int[] C, int n) {

		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);

		/*ArrayUtility.printArray(A, n, "A : ");
		ArrayUtility.printArray(B, n, "B : ");
		ArrayUtility.printArray(C, n, "C : ");
		*/
		int diff = Integer.MAX_VALUE;
		int resMax = 0, resMin = 0, resMid = 0;

		int i =0, j =0 , k =0;
		while(i < n && j < n && k <n) {
			
			int min = min(A[i], B[j], C[k]);
			int max = max(A[i], B[j], C[k]);

			if(diff > (max-min)) {
				int sum = A[i] + B[j] + C[k];
				
				diff = (max-min);
				resMax = max;
				resMin = min;
				resMid = sum-(max+min);
			}
			
			if(min == A[i]) 
				i++;
			else if(min == B[j])
				j++;
			else
				k++;

		}
		
		System.out.printf("%d %d %d\n",resMax, resMid,resMin);

	}
	

}
