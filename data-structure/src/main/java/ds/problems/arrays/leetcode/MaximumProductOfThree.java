package ds.problems.arrays.leetcode;


import java.util.Scanner;

public class MaximumProductOfThree {
	
	public static void main(String[] args) {
		
		MaximumProductOfThree obj = new MaximumProductOfThree();
		obj.runTests();
		
	}
	
	public void runTests() {
		
/*
11
3
1 2 3
3
1 2 -3
4
3 2 4 5
4
3 2 4 -5
4
3 -2 4 -5
4
3 -2 -4 -5
4
-3 -2 -4 -5
4
3 2 4 0
4
3 2 -4 0
4
3 -2 -4 0
4
-3 -2 -4 0

2
5
-5 0 22 10 30
10
-10 2 16 5 0 -12 -1 56 89  98

7
8
8 3 2 4 5 6 12 20
8
8 3 2 4 -5 6 12 20
8
8 3 2 -4 -5 6 12 20
8
8 3 2 -12 -10 6 12 20
8
8 3 -6 -12 -20 -2 -4 -5
8
8 -3 -6 -12 -20 -2 -4 -5
8
-8 -3 -6 -12 -20 -2 -4 -5

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			int i = 0;
			while(i<n)
				A[i++] = sc.nextInt();

			System.out.println(maximumProductSort(A));
		}
		sc.close();
		
	}
	
	private int maximumProductMoreThanfour(int[] nums) {
	
		int max1, max2,max3,min2,min1,tmp;
		max1 = max2 = max3 = -1001;
		min2 = min1 = 1001;

		for (int val : nums) {
			
			if(val >= max1) {
				tmp = max1;
				max1 = val;
				val = tmp;
			}
			
			if(val == -1001)
				continue;

			if(val >= max2) {
				tmp = max2;
				max2 = val;
				val = tmp;
			}

			if(val == -1001)
				continue;
			
			if(val >= max3) {
				tmp = max3;
				max3 = val;
				val = tmp;
			}

			if(val == -1001)
				continue;
			
			if(val <= min2) {
				tmp = min2;
				min2 = val;
				val = tmp;
			}

			if(val == 1001)
				continue;
			
			if(val <= min1) {
				tmp = min1;
				min1 = val;
				val = tmp;
			}
		}

		//System.out.printf("%d %d %d %d %d\n",min2, min1, max3,max2,max1);
		
		/*
		 * r = max3 max2 max1
		 * l = min2 * min1 * max1
		 * sorted: min2 min1 max3 max2 max1 :  
		 * sign  : +    +    +    +    +    : r
		 * sign  : -    +    +    +    +    : r
		 * sign  : -    -    +    +    +    : Max(r, l) 
		 * sign  : -    -    -    +    +    : l
		 * sign  : -    -    -    -    +    : l
		 * sign  : -    -    -    -    -    : r
		 */		
		
		int c = 0;
		if(min2 < 0)
			c++;

		if(min1 < 0)
			c++;

		if(max3 < 0)
			c++;

		if(max2 < 0)
			c++;

		if(max1 < 0)
			c++;

		int r = max3 * max2 * max1;
		if(c == 0 || c == 1 || c == 5)
			return r;
		
		int l = min2 * min1 * max1;
		if(c == 2)
			return Math.max(r, l);

        return l;
	}
	
	private int swap(int[] A, int i, int val, int bound) {

		int tmp;
		if(bound < 0 && val >= A[i]) {
			// update maximum
			tmp = A[i];
			A[i] = val;
			val = tmp;
		} else if(bound > 0 && val <= A[i]) {
			// update minimum
			tmp = A[i];
			A[i] = val;
			val = tmp;
		}

		return val;
	}
	private int maximumProductMoreThanfour2(int[] nums) {
		
		int[] A = {1001, 1001, -1001, -1001, -1001};
		int maxBound = -1001, minBound = 1001;
		for (int val : nums) {

			val = swap(A, 4, val, maxBound);
			if(maxBound == val)
				continue;
			
			val = swap(A, 3, val, maxBound);
			if(maxBound == val)
				continue;
			
			val = swap(A, 2, val, maxBound);
			if(maxBound == val)
				continue;
			
			val = swap(A, 0, val, minBound);
			if(minBound == val)
				continue;
			
			val = swap(A, 1, val, minBound);
			if(minBound == val)
				continue;

		}

		//System.out.printf(java.util.Arrays.toString(A));
		
		int c = 0;
		for (int val : A) {
			if(val < 0)
				c++;
		}
		
		/*
		 * r = 2 * 3 * 4
		 * l = 0 * 1 * 4
		 * sorted: 0    1    2    3    4    
		 * sign  : +    +    +    +    +    : r
		 * sign  : -    +    +    +    +    : r
		 * sign  : -    -    +    +    +    : Max(r, l) 
		 * sign  : -    -    -    +    +    : l
		 * sign  : -    -    -    -    +    : l
		 * sign  : -    -    -    -    -    : r
		 */		
		
		//System.out.println("cunt : " + c);

		int r = A[2] * A[3] * A[4];
		if(c == 0 || c == 1 || c == 5)
			return r;
		
		int l = A[0] * A[1] * A[4];
		if(c == 2)
			return Math.max(r, l);

        return l;
	}
	
	public int maximumProduct(int[] nums) {
		int n = nums.length;
		
		if(n == 3) {
			return nums[0] * nums[1] * nums[2];
		}
		
		if(n == 4) {
			
			java.util.Arrays.sort(nums);
			//System.out.println(java.util.Arrays.toString(nums));
			int c = 0;
			for (int val : nums) {
				if(val < 0)
					c++;
			}
			/*
			 * index : 0  1  2  3 : select 
			 * sign  : +  +  +  + : 1-3
			 * sign  : -  +  +  + : 1-3
			 * sign  : -  -  +  + : 0,1,3
			 * sign  : -  -  -  + : 1-3
			 * sign  : -  -  -  - : 1-3
			 */
			
			if(c == 2 || c == 3)
				return nums[0] * nums[1] * nums[3];
			else
				return nums[1] * nums[2] * nums[3];

		}
		
		return maximumProductMoreThanfour(nums);
		
    }


	public int maximumProductSort(int[] nums) {
		
		java.util.Arrays.sort(nums);
		return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
		
	}

}
