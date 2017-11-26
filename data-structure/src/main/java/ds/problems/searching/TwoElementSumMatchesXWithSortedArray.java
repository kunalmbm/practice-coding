package ds.problems.searching;

public class TwoElementSumMatchesXWithSortedArray {

	
/*	hasArrayTwoCandidates (A[], ar_size, sum)
	1) Sort the array in non-decreasing order.
	2) Initialize two index variables to find the candidate 
	   elements in the sorted array.
	       (a) Initialize first to the leftmost index: l = 0
	       (b) Initialize second  the rightmost index:  r = ar_size-1
	3) Loop while l < r.
	       (a) If (A[l] + A[r] == sum)  then return 1
	       (b) Else if( A[l] + A[r] <  sum )  then l++
	       (c) Else r--    
	4) No candidates in whole array - return 0
*/
	static int hasTwoElementsMatchingSum(int[] arr, int n, int sum) {
		
		int l = 0;
		int r = n-1;
		while(l < r) {
			
			int value = arr[l] + arr[r];
			if(value == sum) {
				System.out.printf("matched : %d + %d = %d ",arr[l],arr[r],sum);
				return 0;
			}
			
			if(value > sum)
				r--;
			else
				l++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 5, 6, 8, 15, 20 };
		int n = arr.length;
		int sum = 23;
		
		int flag = hasTwoElementsMatchingSum(arr, n, sum);
		
		if(flag == -1) {
			System.out.printf("not found a match for sum %d ", sum);
		}
		
	}
	
}
