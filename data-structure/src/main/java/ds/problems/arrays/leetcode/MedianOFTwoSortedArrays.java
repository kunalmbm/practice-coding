package ds.problems.arrays.leetcode;

import java.util.Arrays;

public class MedianOFTwoSortedArrays {

	public static void main(String[] args) {

		MedianOFTwoSortedArrays obj = new MedianOFTwoSortedArrays();
		
		//obj.testFindMedianSortedArrays();
		obj.testSolveRec();
		//obj.testbinarySearchReturnFloorIndex();
		
		
		
	}
	
	private void testbinarySearchReturnFloorIndex() {
		
		int[] nums1 = {1, 2}; 
		System.out.println(binarySearchReturnFloorIndex(nums1, 0, 1 ,1));
		
	}
	
	private void testFindMedianSortedArrays() {
		
		int[] nums1 = {11,15,16,17,18,19,22}; // 11,15,16,17,18,19,22
		int[] nums2 = {20,23,24,25}; // 20,23,24,25
		/*[1,2,3]
				[4,5,6]
						*/
		System.out.println(findMedianSortedArrays(nums1, nums2));

		
	}
	private void testSolveRec() {
		int[][] data = {
				{11,15,16,17,20},	
				{12,17},
				
				{11,15,16,17,20},	
				{33 ,47},

				{1,2},	
				{3},
				
				{1},	
				{},

				{1,3},	
				{},

				{1,2,3},	
				{4,5,6},
				
				{11,15,16,17,18,19,22},	
				{20,23,24,25},
				
				{1, 2},	
				{1, 2},
				
		};

		int k = 0;
		while(k < data.length-1) {
			int[] nums1 = data[k++];
			int[] nums2 = data[k++];
			
			System.out.println("##############");
			System.out.println(Arrays.toString(nums1));
			System.out.println(Arrays.toString(nums2));
			
			for (int i = 0 ; i < (nums1.length + nums2.length);i++) {
				int val = solveRec(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, i);
				System.out.printf("%d - %d\n",i,val);
			}
		}
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int t = nums1.length+ nums2.length;
		boolean odd = t % 2 == 0 ? false : true;
		int mid = t / 2;
		if (!odd)
			mid--;
		int val = findElementAtIndex(nums1, nums2, mid);
		if(odd) {
			return val;
		}
		val += findElementAtIndex(nums1, nums2, mid+1);
		return ((double) val) / 2;
	}
	
	
	
	private int binarySearchReturnFloorIndex(int[] A, int lo, int hi, int x) {
		
		if(lo > hi)
			return -1;
		
		int mid = lo + (hi - lo)/2;

		if(A[mid] == x)
			return mid;
		
		if(A[mid] < x && (mid == A.length-1 || x < A[mid+1]))
			return mid;
			
		if(A[mid] > x)
			return binarySearchReturnFloorIndex(A, lo, mid-1, x);
		
		return binarySearchReturnFloorIndex(A, mid+1, hi, x);

	}


	private int findElementAtIndex(int[] nums1, int[] nums2, int t) {
		
		int n1 = nums1.length;
		int n2 = nums2.length;
		
		if(n1 > 0 && n2 > 0) {
			if(nums1[n1-1] <= nums2[0]) {
				if(t < n1)
					return nums1[t];
				return nums2[t-n1];
				
			} else if(nums2[n2-1] <= nums1[0]) {
				if(t < n2)
					return nums2[t];
				return nums1[t-n2];
			}
		}
		System.out.println("no perfect match");
		return solveRec(nums1, 0, n1-1, nums2, 0, n2-1, t);
		
	}
	
	//private int swap = 0;
	private int solveRec(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int t) {

		//System.out.printf("(%d,%d), (%d,%d)" , l1, h1,l2 , h2);
		if(l1 > h1) {
			t-= Math.min(l1, h1)+1;
			//System.out.printf(" l1>h1 , t(%d)  \n" , t);
			return nums2[t];
		}
		
		if(l2 > h2) {
			t-= Math.min(l2 , h2)+1;
			//System.out.printf(" l2>h2  t(%d) \n" , t);
			return nums1[t];
		}
		
		
		int m2 = (l2+h2)/2;
		
		int i = binarySearchReturnFloorIndex(nums1, l1, h1, nums2[m2]);
		if(i == -1) {
			//static swap
			/*  if(swap > 1)
				throw new RuntimeException("swap rec unreachable");
			swap++;*/
			//System.out.println("\nmaking swap call...");
			return solveRec(nums2, l2, h2, nums1, l1, h1, t);
		}
		
		//swap = 0;
		
		int k = i+m2+1; 
		//System.out.printf(" -> (%d,%d) = [%d] [%d]\n" ,i,m2,k,t);
		
		if(k == t)
			return Math.max(nums1[i], nums2[m2]);
		
		if((k+1) == t) {
			if((i+1) < nums1.length && (m2+1) < nums2.length )
				return Math.min(nums1[i+1], nums2[m2+1]);

			if((i+1) < nums1.length) 
				return nums1[i+1];
			
			return nums2[m2+1];
		}

		if(k>t) {
			if(nums1[i] >= nums2[m2])
				return solveRec(nums1, l1, i-1, nums2, l2, m2, t);
			return solveRec(nums1, l1, i, nums2, l2, m2-1, t);
		}
			
		if(nums1[i] <= nums2[m2])
			return solveRec(nums1, i+1, h1, nums2, m2, h2, t);
		
		return solveRec(nums1, i, h1, nums2, m2+1, h2, t);
		
	}
	
	
	public double solve(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int t = m+n;
		int i = 0, j = 0, k = 0, val = 0, val1 = 0, val2 = 0;
		boolean odd = t % 2 == 0 ? false : true;
		int mid1 = t / 2;
		if (!odd)
			mid1--;
		int mid2 = mid1 + 1;
		
		while (i < m && j < n) {

			if (nums1[i] < nums2[j])
				val = nums1[i++];
			else
				val = nums2[j++];

			if (mid1 == k) {
				val1 = val;
				if (odd)
					return val1;
			}

			if (mid2 == k) {
				val2 = val;
				return ((double) val1 + val2) / 2;
			}

			k++;
		}
		while (i < m) {

			if (mid1 == k) {
				val1 = nums1[i];
				if (odd)
					return val1;
			}
			if (mid2 == k) {
				val2 = nums1[i];
				return ((double) val1 + val2) / 2;
			}
			i++;
			k++;
		}
		//System.out.printf("%d[%d - %d] - %d(%d) %d(%d)\n",k,i,j, val1,mid1,val2,mid2);
		while (j < n) {
			if (mid1 == k) {
				val1 = nums2[j];
				if (odd)
					return val1;
			}
			if (mid2 == k) {
				val2 = nums2[j];
				return ((double) val1 + val2) / 2;
			}
			j++;
			k++;
		}

		System.out.printf("%d[%d - %d] - %d(%d) %d(%d)\n",k,i,j, val1,mid1,val2,mid2);

		if (odd || !odd)
			throw new RuntimeException("unreachable code");

		return -1;
	}

}
