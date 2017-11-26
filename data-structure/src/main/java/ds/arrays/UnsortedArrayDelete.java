package ds.arrays;

public class UnsortedArrayDelete {

	static int findElement(int[] arr, int s, int e) {
		
		for(int i = 0; i < s ; i++) {
			if(arr[i] == e)
				return i;
		}
		return -1;
	}
	
	static int deleteElement(int[] arr, int s, int e) {
		
		int pos = findElement(arr, s, e);
		if(pos == -1) {
			System.out.printf("\n%d not found in array \n", e);
			return s;
		}
		
		int i = pos;
		for(; i < s-1 ; i++) 
			arr[i] = arr[i+1];
		
		return s-1;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {23,14,8,1,20};
		int s = arr.length;
		int e = 14;
		
		System.out.print("Before : ");
		for(int i = 0; i<s; i++)
			System.out.printf("%d ",arr[i]);
		
		s = deleteElement(arr, s, e);

		System.out.print("\nAfter : ");
		for(int i = 0; i<s; i++)
			System.out.printf("%d ",arr[i]);

	}
	
}
