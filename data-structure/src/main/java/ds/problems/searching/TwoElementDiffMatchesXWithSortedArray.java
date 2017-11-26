package ds.problems.searching;

public class TwoElementDiffMatchesXWithSortedArray {

	
/*
*/
	static int hasTwoElementsMatchingDiff(int[] arr, int n, int diff) {
		
		int l = 0;
		int r = 1;
		while(l < n && r < n) {
			
			int value = Math.abs(arr[l] - arr[r]);
			if(value == diff) {
				System.out.printf("matched : |%d - %d| = %d ",arr[l],arr[r],diff);
				return 0;
			}
			
			if(value > diff)
				l++;
			else
				r++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 5, 6, 8, 15, 20 };
		int n = arr.length;
		int diff = 5;
		
		int flag = hasTwoElementsMatchingDiff(arr, n, diff);
		
		if(flag == -1) {
			System.out.printf("not found a match for diff %d ", diff);
		}
		
	}
	
}
