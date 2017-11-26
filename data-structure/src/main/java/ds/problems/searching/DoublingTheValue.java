package ds.problems.searching;

import java.util.Scanner;

public class DoublingTheValue {

	public static void main(String[] args) {
		
/*
1
5 2
1 2 3 4 8



 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			long b = sc.nextLong();
			long[] A = new long[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextLong();
			}
			
			b=doubleTheValue(A, n, b);
			System.out.println(b);
		}
		sc.close();
	}

	public static long doubleTheValue(long[] A, int n, long b) {
		for(int i=0; i <n; i++) {
			if(A[i] == b) 
				b*=2;
		}
		
		return b;

	}

}
