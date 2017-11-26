package ds.problems.searching;

import java.util.Scanner;

public class NextGreaterNumberOfSameSetOFDigit {

	
	private static int[] convert(int num) {
		int l = String.valueOf(num).length();
		int[] A = new int[l];
		for (int i = 0; i < l; i++) {
			A[i] = num % 10;
			num /= 10;
		}
		return A;
	}
	
	public static void main(String[] args) {

		/*
8
143
431
5321 
2315 
19170
26963
22941
22943

		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int num = sc.nextInt();
			printNextNum(num);
		}
		sc.close();
	}

	public static void printNextNum(int num) {
		
		int[] A = convert(num);
		int n = A.length;
		int i = 1;
		for (; i < n; i++) {
			if (A[i] < A[i - 1])
				break;
		}
		if(i == n) {
			System.out.println("not possible");
			return;
		}

		int minIndex = -1;
		for (int k = i - 1; k >= 0; k--) {
			if ((A[k] > A[i]) && (minIndex == -1 || A[k] < A[minIndex])) {
				minIndex = k;
			}
		}
		swap(A, i, minIndex);
		quickSortLastPivot(A,0,i-1);
		
		for (int k = 0; k < n; k++) {
			System.out.print(A[n - k - 1]);
		}
		System.out.println();

		return;
	}

	public static void swap(int[] A, int i, int j) {
		if (i == j)
			return;
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	private static int partitionLastPivot(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int pi = low;
		for(int i = low ; i<= high ; i++) {
			
			if(arr[i]<pivot) 
				continue;

			swap(arr, pi, i);
			pi++;
			
		}
		
		pi--;
		return pi;
		
	}
	
	public static void quickSortLastPivot(int[] arr, int low, int high){
		
		if(low >= high)
			return;

		int pi = partitionLastPivot(arr, low, high);
		quickSortLastPivot(arr, low, pi-1);
		quickSortLastPivot(arr, pi+1, high);

	}

}
