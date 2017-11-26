package ds.util;

public class SearchUtility {
	
	/*
	 * Given a sorted array of integers, what can be the minimum worst case time complexity to find
	 *  ceiling of a number x in given array? Ceiling of an element x is the smallest element present in 
	 *  array which is greater than or equal to x. Ceiling is not present if x is greater than the maximum element present in array.
	 *   For example, if the given array is {12, 67, 90, 100, 300, 399} and x = 95, then output should be 100. 
	 * 
	 * 
	 */
	
	public static int binarySearchReturnFloorIndex(int[] A, int lo, int hi, int x) {
		
		if(lo > hi)
			return -1;
		
		int mid = lo + (hi - lo)/2;
		
		//System.out.printf("### %d - %d - %d : %d : %d \n", low, high, mid , e, arr[mid]);
		
		if(A[mid] == x)
			return mid;
		
		if(A[mid] < x && (mid == A.length-1 || x < A[mid+1]))
			return mid;
			
		if(A[mid] > x)
			return binarySearchReturnFloorIndex(A, lo, mid-1, x);
		
		return binarySearchReturnFloorIndex(A, mid+1, hi, x);

	}
	
	public static int binarySearchReturnCeilingIndex(int[] arr, int low, int high, int e) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		
		//System.out.printf("### %d - %d - %d : %d : %d \n", low, high, mid , e, arr[mid]);
		
		if(arr[mid] == e)
			return mid;
		
		if(arr[mid] > e && (mid == 0 || arr[mid-1] < e))
			return mid;
			
		if(arr[mid] > e)
			return binarySearchReturnCeilingIndex(arr, low, mid-1, e);
		
		return binarySearchReturnCeilingIndex(arr, mid+1, high, e);
		
		
	}
	
	public static int binarySearchReturnActualIndex(int[] arr, int low, int high, int e) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		if(arr[mid] == e)
			return mid;
		
		if(arr[mid] > e)
			return binarySearchReturnActualIndex(arr, low, mid-1, e);
		
		return binarySearchReturnActualIndex(arr, mid+1, high, e);
		
	}
	
	public static int binarySearchReturnExpecedIndex(int[] arr, int low, int high, int e) {
		
		if(low >= high)
			return e >= arr[low] ? low+1 : low;
		
		int mid = low + (high - low)/2;
		if(arr[mid] == e)
			return mid+1;
		
		if(arr[mid] > e)
			return binarySearchReturnExpecedIndex(arr, low, mid-1, e);
		
		return binarySearchReturnExpecedIndex(arr, mid+1, high, e);
		
	}

	public static int linearSearch(int[] arr, int low, int high, int key) {
		
		for(int i=low;i<=high;i++) {
			if(arr[i] == key)
				return i;
		}
		
		return -1;
	}
	
	public static int exponentialSearch(int[] arr, int x) {
		
		int lo =0, hi = 1, n = arr.length;
		
		while(hi < n) {
			
			if(x == arr[hi])
				return hi;
			
			if(x < arr[hi])
				return binarySearch(arr, lo, hi-1, x);
			
			lo = hi+1;
			hi*=2;
			
		}
		
		return -1;		
	}

	public static int interpolationSearch(int[] arr, int x) {
		
		int lo = 0, hi = arr.length -1;
		while(lo<=hi && x>=arr[lo] && x<=arr[hi]) {
			int pos = lo + ( ((x-arr[lo]) * (hi-lo)) / (arr[hi]-arr[lo]));
			//int pos = lo + (((hi-lo) /(arr[hi]-arr[lo]))*(x - arr[lo]));

			if(arr[pos] == x)
				return pos;
			
			if(x > arr[pos])
				lo = pos +1;
			else 
				hi = pos-1;

		}
		
		return -1;

	}
	
	public static int jumpSearch(int[] arr, int n, int key) {
		
		int step = (int)Math.sqrt(n);
		//System.out.println("step = " + step);
		
		int low = 0;
		int high = step;
		
		while(true) {
			
			if(low>=n)
				return -1;
			
			if(high>n)
				high = n;
			
			if(key<=arr[high-1])
				break;
			
			low+=step;
			high+=step;
		}
		
		return SearchUtility.linearSearch(arr, low, high-1, key);
		
	} 

	public static int binarySearchIterative(int[] arr, int n, int e) {
		
		int i = 0, j = n-1, k;
		
		do {
			k = (i+j)/2;
			
			//System.out.printf("%d - %d, %d, %d \n",e, i, j, k);
			
			if(e<=arr[k]) 
				j = k-1;
			
			if(arr[k]<=e)
				i = k +1;
			
			//System.out.printf("   new %d, %d \n",i, j);
			
		} while( i<=j);
		
		//System.out.printf("last %d - %d, %d, %d \n",e, i, j, k);
		
		if(arr[k] == e)
			return k;
		else 
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
	
	public static int ternarySearch(int[] arr, int lo, int hi, int x) {
		
		if(lo>hi)
			return -1;
		
		int mid1 = lo + (hi-lo)/3;
		int mid2 = mid1 + (hi-lo)/3;
		
		if(x == arr[mid1])
			return mid1;
		
		if(x == arr[mid2])
			return mid2;
		
		if(x < arr[mid1])
			return ternarySearch(arr,lo,mid1-1,x);
		
		if(x > arr[mid2])
			return ternarySearch(arr,mid2+1,hi,x);
		
		return ternarySearch(arr,mid1+1,mid2-1,x);

	}
	
}
