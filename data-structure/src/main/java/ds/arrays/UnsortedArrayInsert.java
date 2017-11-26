package ds.arrays;

public class UnsortedArrayInsert {
	
	static int insertElement(int[] arr, int capacity, int element, int n) {
		
		if(n >= capacity) {
			System.out.printf("\nCan't insert %d at %d index, Overflow detected", element,n);
			return n;
		}
			
		
		arr[n] = element;
		return (n+1);
		
	} 
	
	public static void main(String[] args) {
		
		int[] arr = new int[20];
		int capacity = arr.length;
		arr[0] = 24;
		arr[1] = 4;
		arr[2] = 45;
		arr[3] = 9;
			
		int n = 4;
		int e = 40;

		System.out.printf("array before insertion (capacity %d): \n",capacity);
		for(int i = 0 ; i<n ; i++) 
			System.out.printf("%d ",arr[i]);
		n = insertElement(arr, capacity, e, n);
		System.out.printf("\narray after insertion (capacity %d): \n",capacity);
		for(int i = 0 ; i<n ; i++) 
			System.out.printf("%d ",arr[i]);
		
		
		
	}

}
