package ds.problems.searching;

import java.util.Scanner;

public class FacingTheSun {

	public static void main(String[] args) {
		
/*
3
5
7 4 8 2 9
4
2 3 4 5
10
4 3 2 5 7 8 9 1 2 14

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			facingTheSun(A, n);

		}
		sc.close();
	}

	public static void facingTheSun(int[] A, int n) {
		int max = A[0];
		int count = 1;
		for(int i = 1; i <n; i++) {
			if(A[i] > max) {
				max = A[i];
				count++;
			}
		}
		
		System.out.println(count);

	}

}
