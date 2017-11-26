package ds.problems.searching;

import java.util.Scanner;

public class WhoWillWin {

	public static void main(String[] args) {
		
/*
3
10 8 10 25
10 8 10 30
10 8 10 12


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int g = sc.nextInt();
			int s = sc.nextInt();
			
			int costG = g * m;
			int tmp = binarySearch(1, n, m,0);
			int costS = s * tmp;
			// System.out.printf("%d (%d) %d (%d)\n", m, costG, tmp, costS);
			
			if(costG > costS)
				System.out.println(2);
			else if(costG < costS)
				System.out.println(1);
			else
				System.out.println(0);
		}
		sc.close();
	}
	
	private static int binarySearch(int lo, int hi, int x, int iterCount) {

		iterCount++;
		
		//System.out.printf("---- %d (%d) %d (%d)\n", lo, hi, x, iterCount);
		
		if(lo > hi)
			return -1;
		
		int mid = (lo+hi)/2;
		
		if(mid == x)
			return iterCount;
		
		if(mid < x)
			return binarySearch(mid+1,hi,x,iterCount);
		
		return binarySearch(lo,mid-1,x,iterCount);
		
	}

}
