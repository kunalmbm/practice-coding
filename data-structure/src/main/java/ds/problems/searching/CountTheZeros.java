package ds.problems.searching;

import java.util.Scanner;

public class CountTheZeros {

	public static void main(String[] args) {
		
/*
5
4
1 0 0 0
4
1 1 1 0 
12
1 1 1 1 1 1 1 1 1 0 0 0 
5
0 0 0 0 0
6
1 1 1 1 1 1


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			printNoZeros(A, n);

		}
		sc.close();
	}

	public static void printNoZeros(int[] A, int n) {
		int i=0;
		for(; i <n; i++) {
			if(A[i] == 0)
				break;
		}
		
		System.out.println(n-i);

	}

}
