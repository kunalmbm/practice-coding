package ds.arrays;

public class SortedArrayDelete {
	
	static int binarySearch(int[] arr, int low, int high, int e) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		if(arr[mid] == e)
			return mid;
		
		if(arr[mid] > e)
			return binarySearch(arr, low, mid-1, e);
		
		return binarySearch(arr, mid+1, high, e);
		
	}
	
	static int deleteElement(int[] arr, int n, int e){
		
		int pos = binarySearch(arr, 0, n, e);
		if(pos == -1) {
			System.out.print("\ncan't find element in array for deletion");
			return n;
		}
		
		for(int i = pos ; i < n-1 ; i++) 
			arr[i] = arr[i+1];

		return n-1;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3,4,10,12,90};
		int n = arr.length;
		int e = 90;
		
		System.out.println("array before deletion : ");
		for(int i = 0; i<n;i++)
			System.out.printf("%d " , arr[i]);

		n = deleteElement(arr, n, e);

		System.out.println("\narray after deletion : ");
		for(int i = 0; i<n;i++)
			System.out.printf("%d " , arr[i]);
		
	}

}
