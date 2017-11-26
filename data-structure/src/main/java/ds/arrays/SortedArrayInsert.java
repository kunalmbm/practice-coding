package ds.arrays;

public class SortedArrayInsert {
	
	static int insertElement(int[] arr, int capacity, int n, int e) {
		
		if(n >= capacity) {
			System.out.print("\narray capacity is full, can't insert anymore");
			return n;
		}
		
		int i;
		for(i = n-1; ( i>=0 && arr[i] > e) ; i--) {
			arr[i+1] = arr[i];
		}
		arr[i+1] = e;
		return (n+1);
			
	}
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 10; arr[1] = 20; arr[2] = 30;
		int capacity = arr.length;
		int n = 3;
		int e = 35;
		System.out.printf("array before insertion (capacity : %d) : \n" , capacity);
		for(int i = 0; i<n;i++)
			System.out.printf("%d " , arr[i]);
		
		n = insertElement(arr, capacity, n, e);

		System.out.printf("\narray after insertion (capacity : %d) : \n" , capacity);
		for(int i = 0; i<n;i++)
			System.out.printf("%d " , arr[i]);

	}

}
