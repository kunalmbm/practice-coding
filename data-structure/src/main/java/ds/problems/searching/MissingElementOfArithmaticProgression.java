package ds.problems.searching;

import java.util.Scanner;

public class MissingElementOfArithmaticProgression {

	public static void main(String[] args) {
		
/*
7
3 
2 10 14 
4 
-28 -21 -7 0 
5 
9 12 15 21 24
3
2 10 14
3 
14 10 2
3
-14 -12 -8
2
2 6

3
-10 -2 6
3 
2 4 6



 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			int x = findMissingElement(A, n);
			System.out.println(x);

		}
		sc.close();
	}
	
	public static int findConstant(int[] A, int n) {
		
		if(n == 2) {
			return (A[1]-A[0])/2;	
		}
		
		int c1 = A[1]-A[0];
		int c2 = A[2]-A[1];		
		
		if(c1==c2)
			return c1;
		
		if(c1<0)
			return Math.max(c1, c2);
		else
			return Math.min(c1, c2);
	}
	
	public static int findMissingElement(int[] A, int n) {
		
		int c = findConstant(A, n);
		//System.out.println(c + "- " + Arrays.toString(A));
		for(int i=1; i <n; i++) {
			int prev = A[i] - c;
			if(prev != A[i-1])
				return prev;
		}
		
		boolean flag = true;
		if(flag)
			throw new RuntimeException("invalid input no missing element found");
		
		return 0;
	}

}
