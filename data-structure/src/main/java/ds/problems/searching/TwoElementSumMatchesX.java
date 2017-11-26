package ds.problems.searching;

public class TwoElementSumMatchesX {

	
	static int hasTwoElementsMatchingSum(int[] arr, int n, int sum) {
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) {
				if( i!=j && ((arr[i]+arr[j]) == sum)) {
					System.out.printf("matched : %d + %d = %d ",arr[i],arr[j],sum);
					return 0;
				}
			}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 20, 15, 5, 6, 8};
		int n = arr.length;
		int sum = 10;
		
		int flag = hasTwoElementsMatchingSum(arr, n, sum);
		
		if(flag == -1) {
			System.out.printf("not found a match for sum %d ", sum);
		}
		
	}
	
}
