package ds.problems.searching;

import java.util.Scanner;

public class SearchInAMatrix {

	public static void main(String[] args) {
		
/*
2
3 3
3 30 38 44 52 54 57 60 69
62
1 6
18 21 27 38 55 67
55


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			int[][] A = new int[r][c];
			for(int i=0; i <r; i++)
				for(int j=0; j <c; j++)
					A[i][j] = sc.nextInt();

			int x = sc.nextInt();
			int index = findXinMatrix(A, r, c, x);
			if(index == -1)
				System.out.println(0);
			else 
				System.out.println(1);

		}
		sc.close();
	}

	public static int findXinMatrix(int[][] A, int r, int c, int x) {
		
		for(int i=0; i <r; i++) {
			if(x <= A[i][c-1])
				return binarySearch(A[i], 0, c-1, x);
		}
		return -1;
	}
	
	public static int binarySearch(int[] arr, int low, int high, int e) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		if(arr[mid] == e)
			return mid;
		
		if(arr[mid] > e)
			return binarySearch(arr, low, mid-1, e);
		
		return binarySearch(arr, mid+1, high, e);
		
	}


}
