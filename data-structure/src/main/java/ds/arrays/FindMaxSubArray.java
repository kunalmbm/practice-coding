package ds.arrays;

public class FindMaxSubArray {
	
	public static void main(String[] args) {
		
		int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4 , 7};
		
		Tuple result = findMaxSubArray(A, 0, A.length-1);
		System.out.printf("\n (%d, %d) - %d " , result.left(), result.right(), result.sum());
		
		result = findMaxSubArrayBruteForce(A, A.length);
		System.out.printf("\n (%d, %d) - %d " , result.left(), result.right(), result.sum());
		
		//(6, 10) - 38 
	}
	
	private static Tuple findMaxSubArrayBruteForce(int[] A, int n) {
		
		int left = -1, right = -1;
		int sum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			int tmpSum = A[i];
			if(tmpSum > sum) {
				sum = tmpSum;
				left = right =i;
			}
			
			for (int j = i+1; j< n; j++) {
				tmpSum += A[j]; 
				if(tmpSum > sum) {
					sum = tmpSum;
					left = i;
					right =j;
				}
				
			}
		}
		
		return new Tuple(left, right, sum);
	}
	
	private static Tuple findMaxSubArray(int[] A, int lo, int hi) {
		
		if(lo==hi)
			return new Tuple(lo, hi, A[lo]);
		
		int mid = (lo+hi)/2;
		Tuple left = findMaxSubArray(A, lo, mid);
		Tuple right = findMaxSubArray(A, mid+1, hi);
		Tuple cross = findMaxCrossoverSubArray(A, lo, mid, hi);
		
		if(left.sum() >= right.sum() && left.sum() >= cross.sum())
			return left;
		
		if(right.sum() >= left.sum() && right.sum() >= cross.sum())
			return left;

		return cross;
		
	}
	
	private static Tuple findMaxCrossoverSubArray(int[] A, int lo, int mid, int hi) {
		
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;
		int left=-1,right=-1;
		
		for(int i = mid; i>=lo; i--) {
			sum+=A[i];
			if(sum>leftSum) {
				leftSum = sum;
				left = i;
			}
		}
		
		sum = 0;
		for(int j = mid+1; j<=hi; j++) {
			sum+=A[j];
			if(sum>rightSum) {
				rightSum = sum;
				right = j;
			}
		}
		
		return new Tuple(left, right, leftSum+rightSum);

	}

}

class Tuple {

	private int left;
	private int right;
	private int sum;
	
	public Tuple(int left, int right, int sum) {
		this.left = left;
		this.right = right;
		this.sum = sum;
	}

	public int left() {
		return left;
	}

	public void left(int left) {
		this.left = left;
	}

	public int right() {
		return right;
	}

	public void right(int right) {
		this.right = right;
	}

	public int sum() {
		return sum;
	}

	public void sum(int sum) {
		this.sum = sum;
	}

}
