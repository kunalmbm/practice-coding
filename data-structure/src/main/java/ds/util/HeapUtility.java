package ds.util;

public class HeapUtility {

	public static int minHeapAddElement(int[] arr, int capacity, int n, int e) {
		
		if(n >= capacity) {
			System.out.println("capacity is full");
			return n;
		}

		n++;
		int i = n-1;
		int pi = (i-1)/2;
		arr[i] = e;
		while(i>0 && arr[i] < arr[pi]) {
			ArrayUtility.swap(arr, i, pi);
			i = pi;
			pi = (i-1)/2;
		}
		
		return n;
		
	}

	public static int maxHeapAddElement(int[] arr, int capacity, int n, int e) {
		
		if(n >= capacity) {
			System.out.println("capacity is full");
			return n;
		}

		n++;
		int i = n-1;
		int pi = (i-1)/2;
		arr[i] = e;
		while(i>0 && arr[i] > arr[pi]) {
			ArrayUtility.swap(arr, i, pi);
			i = pi;
			pi = (i-1)/2;
		}
		
		return n;
		
	}
	
	public static int replaceMinHeapElement(int[] arr, int n, int e) {
		
		int ne = arr[0];
		arr[0] = e;
		minHeapify(arr, n, 0);

		return ne;
	}

	public static int removeMinHeapElement(int[] arr, int n) {
		
		int ne = arr[0];
		arr[0] = arr[n-1];
		minHeapify(arr, n-1, 0);

		return ne;
	}
	
	public static int[] createMinHeap(int[] input, int size) {
		
		int capacity = size;
		int n = 0;
		int[] arr = new int[capacity];
		
		for(int i = 0; i< size ; i++) {
			n = minHeapAddElement(arr, capacity, n, input[i]);
		}
		
		return arr;
	}

	
	public static int[] createMinHeap(int[] input) {
		
		int capacity = input.length;
		int n = 0;
		int[] arr = new int[capacity];
		
		for (int e : input) {
			n = minHeapAddElement(arr, capacity, n, e);
		}
		
		return arr;
	}
	
	public static int[] createMaxHeap(int[] input) {
		
		int capacity = input.length;
		int n = 0;
		int[] arr = new int[capacity];
		
		for (int e : input) {
			n = maxHeapAddElement(arr, capacity, n, e);
		}
		
		return arr;
	}

	public static void maxHeapify(int[] arr, int n, int p) {
		
		while(p<n) {
			int largest = p;
			int l = 2*p+1;
			int r = l+1;
			
			if(l<n && arr[l] > arr[largest])
				largest = l;

			if(r<n && arr[r] > arr[largest])
				largest = r;
			
			if(p!=largest) {
				ArrayUtility.swap(arr, p, largest);
				p = largest;
			} else 
				break;
		}
	}

	public static void minHeapify(int[] arr, int n , int p) {
		while(p<n) {
			int smallest = p;
			int l = 2*p+1;
			int r = l+1;
			
			if(l<n && arr[l] < arr[smallest])
				smallest = l;

			if(r<n && arr[r] < arr[smallest])
				smallest = r;
			
			if(p!=smallest) {
				ArrayUtility.swap(arr, p, smallest);
				p = smallest;
			} else 
				break;
		}

	}
 

}
