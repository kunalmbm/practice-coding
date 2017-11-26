package ds.problems.searching;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumberInArray {

	public static void main(String[] args) {
		
/*
5
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10
4
4 3 2
4
3 2 1
15
14 1 2 3 4 5 6 7 8 10 13 9 12 11


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n-1];
			for(int i=0; i < n-1; i++) {
				A[i] = sc.nextInt();
			}
			
			printMissingNumber(A, n-1);
		}
		sc.close();
	}
	private static void printMissingNumber(int[] A, int n) {
		
		Arrays.sort(A);
		// System.out.println("---- " + Arrays.toString(A));
		int val = 0;
		for(int i=1;i <= n; i++) {
			if(A[i-1] != i){
				val = i;
				break;
			}
		}
		if(val == 0)
			val = n+1;
		
		System.out.println(val);
	}

}
