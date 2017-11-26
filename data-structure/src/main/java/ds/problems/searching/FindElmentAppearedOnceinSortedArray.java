package ds.problems.searching;

import java.util.Scanner;

public class FindElmentAppearedOnceinSortedArray {

	private static int findElement(int[] arr, int n) {
		
		for(int i=0; i<n;i++) {
			
			if(i==0 && (n == 1 || arr[i]!=arr[i+1]))
				return arr[i];

			if(i==n-1 && arr[i]!=arr[i-1])
				return arr[i];

			if(arr[i]!=arr[i+1] && arr[i]!=arr[i-1])
				return arr[i];

		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		
		/*
4
11
1 1 2 2 3 3 4 50 50 65 65
11
1 2 2 3 3 4 4 5 5 10 10
7
1 1 3 3 10 10 15
1
1

		
			*/

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-- > 0) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i<n; i++) {
				arr[i] = scanner.nextInt();
			}
			int element = findElement(arr, n);
			System.out.println(element);
		}

		scanner.close();

	}

}
