package ds.problems.arrays.leetcode;

public class MedianOFTwoSortedArrays2 {

	public static void main(String[] args) {

		MedianOFTwoSortedArrays2 obj = new MedianOFTwoSortedArrays2();
		int[] nums1 = {1,2,3}; // 11,15,16,17,18,19,22
		int[] nums2 = {4,5,6}; // 20,23,24,25
		int index = 0;

		/*[1,2,3]
				[4,5,6]
						*/
		//System.out.println(obj.findMedianSortedArrays(nums1, nums2));
		System.out.println(obj.solveRec(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, index));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int t = nums1.length+ nums2.length;
		boolean odd = t % 2 == 0 ? false : true;
		int mid = t / 2;
		if (!odd)
			mid--;
		int val = solveRec(nums1, 0, nums1.length-1, nums2, 0,  nums2.length-1, mid);
		if(odd) {
			return val;
		}
		val += solveRec(nums1, 0, nums1.length-1, nums2, 0,  nums2.length-1, mid+1);
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

	/*if(l1 > h1) {
		throw new RuntimeException("unreachable condition l1 > h1");
		t-= Math.min(l1, h1)+1;
		System.out.printf(" l1>h1 , t(%d)  \n" , t);
		return nums2[t];
	}
	*/
	
	private int boundaryCheck(int[] nums1, int[] nums2, int m1, int m2, int t, boolean[] ret) {
		
		
		int k = m1+m2;
		ret[0] = true;
		
		// current column
		if(k == t)
			return Math.min(nums1[m1], nums2[m2]);

		if((k+1) == t)
			return Math.max(nums1[m1], nums2[m2]);

		// left column

		if((k-1) == t) {
			if(m1 == 0)
				return nums2[m2-1];

			if(m2 == 0)
				return nums1[m1-1];
			
			return Math.max(nums1[m1-1], nums2[m2-1]);
		}
		
		if((k-2) == t) {
			if(m1 > 0 && m2 > 0)
				return Math.min(nums1[m1-1], nums2[m2-1]);
		}
		
		// right column

		if((k+2) == t) {
			if(m1 >= nums1.length)
				return nums2[m2+1];

			if(m2 >= nums1.length)
				return nums1[m1+1];
			
			return Math.min(nums1[m1-1], nums2[m2-1]);
		}

		if((k+3) == t) {
			if(m1 < nums1.length && m2 < nums2.length)
				return Math.max(nums1[m1+1], nums2[m2+1]);
		}
		
		ret[0] = false;

		return -1;
	}
	
	private int solveRec(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int t) {
		
		if(l1 > h1) {
			t-= Math.min(l1, h1)+1;
			System.out.printf(" l1>h1 , t(%d)  \n" , t);
			return nums2[t];
		}
		
		if(l2 > h2) {
			t-= Math.min(l2, h2)+1;
			System.out.printf(" l1>h1 , t(%d)  \n" , t);
			return nums2[t];
		}
		
		boolean[] ret = new boolean[1];

		System.out.printf("(%d,%d), (%d,%d)" , l1, h1,l2 , h2);
		if(l1 > h1) {
			throw new RuntimeException("unreachable condition l1 > h1");
		}
		
		if(l2 > h2) {
			throw new RuntimeException("unreachable condition l2 > h2");
		}
		
		
		int m2 = (l2+h2)/2;
		int i = binarySearchReturnFloorIndex(nums1, l1, h1, nums2[m2]);
		System.out.printf(" -> %d - %d - [%d,%d] (%d)\n" ,i,m2, (m2+i), (m2+i+1), t);
		if(i == -1) {
			System.out.println("\n making swap call...");
			return solveRec(nums2, l2, h2, nums1, l1, h1, t);
		}
		
		int val = boundaryCheck(nums1, nums2, i, m2, t, ret);
		if(ret[0])
			return val;

		if((i+m2+1) < t)
			return solveRec(nums1, i+1, h1, nums2, m2+1, h2, t);
		
		if(nums1[i] > nums2[m2])
			return solveRec(nums1, l1, i-1, nums2, l2, m2, t);
		
		return solveRec(nums1, l1, i, nums2, l2, m2-1, t);
		
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
