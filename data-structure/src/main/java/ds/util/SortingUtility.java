package ds.util;

import ds.list.doubly.NodeFloat;
import ds.list.doubly.NodeInt;
import ds.list.single.Node;
import ds.list.single.NodeTuple;

public class SortingUtility {

	public static void selectionSort(int[] arr, int n) {
		
		for(int i = 0; i<n-1 ;i++) {
			int mi = i;
			for(int j=i+1;j<n;j++){
				if(arr[mi] > arr[j])
					mi = j;
			}
			ArrayUtility.swap(arr, mi, i);
		}
	}

	public static void insertionSort(int[] arr, int n) {
		
		for(int i=1; i<n;i++) {
			int e = arr[i];
			int j = i-1;
			while(j>=0 && e < arr[j]) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1] = e;
		}
		
	}

	public static void insertionSortBinarySearch(int[] arr, int n) {
		
		for(int i=1; i<n;i++) {
			int e = arr[i];
			int j = i-1;
			
			int pos = SearchUtility.binarySearchReturnExpecedIndex(arr, 0, j, e);
			
			while(j>=pos) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1] = e;
		}
		
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		
		if(r == l)
			return;
		
		int m = l + (r-l)/2;
		mergeSort(arr,l,m);
		mergeSort(arr,m+1,r);
		merge(arr,l,m,r);
		
	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		
		for(int i = m+1; i<=r ; i++) {
			int e = arr[i];
			int j = i-1;
			while(j>=l && e < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = e;
		}
		
	}
	
	public static void mergeSortLong(int[] arr, int l, int r) {
		
		if(r == l)
			return;
		
		int m = l + (r-l)/2;
		mergeSortLong(arr,l,m);
		mergeSortLong(arr,m+1,r);
		mergeLong(arr,l,m,r);
		
	}

	public static void mergeLong(int[] arr, int l, int m, int r) {
		
		int n1 = m-l+1;
		int n2 = r-m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
		
		int i = 0;
		int j = 0;
		int k = l;
		while(i < n1 && j < n2) {
		
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k]=L[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
	}

	public static void insertionSortLong(int[] arr, int n) {
		for(int i=1; i<n;i++) {
			for(int j =0;j<i ;j++) {
				if(arr[j] > arr[i]) {
					int tmp = arr[i];
					for(int k = i;k >j;k--) {
						arr[k] = arr[k-1];
					}
					arr[j] = tmp; 
					break;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] arr, int n) {
		
		boolean swapped = false;
		for(int j = n-1; j>0 ;j--) {
			swapped = false;
			for(int i=0;i<j;i++){
				if(arr[i] > arr[i+1]) {
					ArrayUtility.swap(arr, i, i+1);
					swapped = true;
				}
			}
			// IF no two elements were swapped by inner loop, then break
		    if (swapped == false)
		        break;
		}
	}


	public static int[] maxHeapSortNewArray(int[] arr, int n) {
		
		arr = HeapUtility.createMaxHeap(arr);
		for(int i = n-1;i>0;i--) {
			ArrayUtility.swap(arr, 0, i);
			HeapUtility.maxHeapify(arr, i, 0);
		}
		return arr;
	}

	public static void maxHeapSort(int[] arr, int n) {
		
		for(int p = n/2-1 ; p >= 0 ; p--) 
			HeapUtility.maxHeapify(arr, n, p);
	
		for(int i = n-1;i>0;i--) {
			ArrayUtility.swap(arr, 0, i);
			HeapUtility.maxHeapify(arr, i, 0);
		}

	}

	public static void minHeapSortKSorted(int[] arr, int n, int k) {
		
		int[] heap = HeapUtility.createMinHeap(arr, k+1);
		int i = k+1, j = 0, hs = heap.length;
		
		while(true) {
			
			if(i<n) {
				int e = arr[i++];
				arr[j++] = HeapUtility.replaceMinHeapElement(heap, hs, e);
			} else {
				arr[j++] = HeapUtility.removeMinHeapElement(heap, hs);
				hs--;
			}
			
			if(hs == 0)
				break;
			
		}
		
	}
	
	public static void minHeapSort(int[] arr, int n) {
		
		for(int p = n/2-1 ; p >= 0 ; p--) 
			HeapUtility.minHeapify(arr, n, p);
	
		for(int i = n-1;i>0;i--) {
			ArrayUtility.swap(arr, 0, i);
			HeapUtility.minHeapify(arr, i, 0);
		}

	}

	public static void quickSortLastPivot(int[] arr, int low, int high){
		
		if(low >= high)
			return;

		int pi = partitionLastPivot(arr, low, high);
		quickSortLastPivot(arr, low, pi-1);
		quickSortLastPivot(arr, pi+1, high);

	}
	
	public static void quickSort3WayLastPivot(int[] arr, int low, int high){
		
		if(low >= high)
			return;

		int[] tuple = partition3WayLastPivot(arr, low, high);
		int l = tuple[0];
		int r = tuple[1];
		quickSortLastPivot(arr, low, l-1);
		quickSortLastPivot(arr, r+1, high);

	}
	
	private static int[] partition3WayLastPivot(int[] arr, int low, int high) {
		
		int[] tuple = new int[2];
		int pivot = arr[high];
		int pi = low;
		int l = low;
		for(int i = low ; i<= high ; i++) {
			
			if(arr[i]>pivot) {
				continue;
			} else if(arr[i]<pivot) {
				ArrayUtility.swap(arr, pi, i);
				ArrayUtility.swap(arr, pi, l);
				pi++;
				l++;
			} else {
				ArrayUtility.swap(arr, pi, i);
				pi++;
			}
		}
		
		pi--;
		
		tuple[0] = l;
		tuple[1] = pi;

		return tuple;
	}
	
	private static int partitionLastPivot(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int pi = low;
		for(int i = low ; i<= high ; i++) {
			
			if(arr[i]>pivot) 
				continue;

			ArrayUtility.swap(arr, pi, i);
			pi++;
			
		}
		
		pi--;
		return pi;
		
	}
	
	private static int partitionLastPivotSlow(int[] arr, int low, int high) {
		
		if(low >= high)
			return low;
		
		int pi = high;
		for(int i = low; i< pi; i++) {
			
			if(arr[i] <= arr[pi])
				continue;
			
			int j = i;
			int e = arr[i];
			while(j<pi) {
				arr[j] = arr[++j];
			}
			arr[j]=e;
			pi--;
			i--;
		}
		
		return pi;
	}



	public static void countingSort(int[] arr, int n) {

		int lowRange = arr[0];
		int highRange = arr[0];
		
		for(int i = 1 ; i<n ;i++) {
			if(arr[i] < lowRange)
				lowRange = arr[i];
			if(arr[i] > highRange)
				highRange = arr[i];
		}
		
		int r = highRange-lowRange+1;
		int[] count = new int[r];
		for(int i = 0; i < n; i++) {
			int index = arr[i]-lowRange;
			count[index]++;
		}
		
		for(int i = 1; i < r; i++) 
			count[i] += count[i-1];
		
		int[] out = new int[n];
		for(int i = 0; i < n; i++) {
			int keyIndex = arr[i]-lowRange;
			int outIndex = count[keyIndex]-1;
			out[outIndex] = arr[i];
			count[keyIndex]--;
		}
		
		for(int i = 0 ; i<n ;i++)
			arr[i] = out[i];

	}
	
	private static int getLeastSignificantDigit(int num, int d) {
		
		int tmp = (int) (num / Math.pow(10, d-1));
		int val = (tmp % 10);

		//System.out.printf("%d - %d - %d \n" , num, d, val);
		
		return val;

	}

	private static void countingSort(int[] arr, int n, int d) {
		
		int[] out = new int[n];
		int[] count = new int[10];
		
		//System.out.println("\n #### d : " + d);
		
		
		for(int i = 0; i<n; i++) {
			int key = getLeastSignificantDigit(arr[i], d);
			count[key]++;
		}
		
		int prev = 0;
		for(int i = 0; i < 10; i++) {
			int tmp = count[i];
			count[i] = prev;
			prev+=tmp;
		}
			
		
		for(int i = 0; i<n; i++) {
			int key = getLeastSignificantDigit(arr[i], d);
			int index = count[key];
			out[index] = arr[i];
			count[key]++;
		}
		
		for (int i = 0; i < n; i++)
            arr[i] = out[i];

	}



	private static int getMaxDigitCount(int arr[], int n)
    {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return String.valueOf(max).length();
    }
	
	public static void radixSort(int[] arr, int n) {

		int dC = getMaxDigitCount(arr, n);
		for(int d = 1 ; d <= dC ; d++)
			countingSort(arr, n, d);
	}
	
	public static void bucketSort(int[] arr, int n) {
		
		int dC = getMaxDigitCount(arr, n);
		NodeInt[] nodes = new NodeInt[n];
		
		for(int i = 0; i<n ; i++) {
			int val = arr[i];
			int index = (int)((n * val) / Math.pow(10, dC));
			NodeInt node = new NodeInt(val);
			nodes[index] = NodeInt.addLast(nodes[index], node);
		}
		
		/*for(int i = 0; i < n ; i++) {
			NodeInt.printAllNodes(nodes[i]);
		}*/
		
		int index = 0;
		for(int i = 0; i<n ; i++) {
			if(nodes[i] == null)
				continue;
			
			NodeInt node = nodes[i] = insertionSort(nodes[i]);
			do {
				arr[index++] = node.data();
				node = node.next();
			} while(node != null);
		}
		
		/*for(int i = 0; i < n ; i++) {
			NodeInt.printAllNodes(nodes[i]);
		}*/
		
		
	}

	public static void bucketSort(float[] arr, int n) {
		
		NodeFloat[] nodes = new NodeFloat[n];

		for(int i = 0; i < n ; i++) {
			float val = arr[i];
			int index = (int)(n * val);
			NodeFloat node = new NodeFloat(val);
			nodes[index] = NodeFloat.addLast(nodes[index], node);
		}
		
		/*for(int i = 0; i < n ; i++) {
			NodeFloat.printAllNodes(nodes[i]);
		}*/
		
		for(int i = 0; i < n ; i++) {
			NodeFloat node = nodes[i];
			if(node == null) {
				continue;
			}
			nodes[i] = insertionSort(node);
		}

		/*System.out.println("----");
		for(int i = 0; i < n ; i++) {
			NodeFloat.printAllNodes(nodes[i]);
		}*/

		// {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f}

		int index = 0;
		for(int i = 0; i < n ; i++) {
			NodeFloat node = nodes[i];
			if(node == null)
				continue;

			do {
				
				arr[index++] = node.data();
				node = node.next();
			} while(node != null);
			
		}

	}
	
	public static NodeInt insertionSort(NodeInt node) {

		// 10 9 9 5 7 5 10
		
		NodeInt start = node;
		while(node != null) {
			
			NodeInt prev = node.prev();
			NodeInt origPrev = prev;
			boolean swapped = false;
			while(prev!=null && prev.data() > node.data()) {
				swapped = true;
				NodeInt pp = prev.prev();
				NodeInt next = node.next();
				
				node.prev(pp);
				if(pp!=null) {
					pp.next(node);
				}
				
				node.next(prev);
				prev.prev(node);
				prev.next(next);
				if(next!=null)
					next.prev(prev);
				
				prev = node.prev();
			}
			
			if(prev == null)
				start = node;
			
			if(swapped) {
				node = origPrev;
			}

			//System.out.print(" ### ");
			//NodeInt.printAllNodes(start);
			if(node!=null)
				node = node.next();
		
		}
		
		return start;

	}
	
	public static Node quickSortLastPivotSingleList(Node node) {
		
		Node firstNode = null;
		NodeTuple tuple = quickSortPartitionSingleList(node);
		
		if(tuple == null)
			return firstNode;
		
		Node left = tuple.getLeft();
		Node center = tuple.getCenter();
		Node right = tuple.getRight();
		
		if(left!=null)
			left = quickSortLastPivotSingleList(left);
		
		if(right!=null)
			right = quickSortLastPivotSingleList(right);
		
		firstNode = Node.addLastNode(left, center);
		Node.addLastNode(center, right);
		
		return firstNode;
		
	}
	
	private static NodeTuple quickSortPartitionSingleList(Node node) {
		
		Node left, right, center, origLeft, origRight, origCenter;
		left = right = center = origLeft = origRight = origCenter = null;
		
		Node lastNode = Node.getLastNode(node);
		
		if(lastNode == null)
			return null;
		
		int pivot = lastNode.data();
		
		/*System.out.println("######### Start of partition: ");
		Node.printAllNodes(node, "node");
		System.out.println("Pivot : " + pivot);*/
		
		while(node!=null) {
			
			if(node.data()<pivot) {
				left = Node.addNextNode(left, node);
				if(origLeft == null)
					origLeft = left;
			}else if(node.data()>pivot) {
				right = Node.addNextNode(right, node);
				if(origRight == null)
					origRight = right;
			} else {
				center = Node.addNextNode(center, node);
				if(origCenter == null)
					origCenter = center;
			}
			
			node = node.next();

		}
		
		if(left!=null)
			left.next(null);

		if(right!=null)
			right.next(null);

		if(center!=null)
			center.next(null);
/*
		Node.printAllNodes(origLeft, "origLeft");
		Node.printAllNodes(origRight, "origRight");
		Node.printAllNodes(origCenter, "origCenter");
		System.out.println("######### End of partition: ");*/
		
		return new NodeTuple(origLeft, origCenter, origRight);
		
		
	}

	public static NodeFloat insertionSort(NodeFloat node) {

		// 10 9 9 5 7 5 10
		
		NodeFloat start = node;
		while(node != null) {
			
			NodeFloat prev = node.prev();
			NodeFloat origPrev = prev;
			boolean swapped = false;
			while(prev!=null && prev.data() > node.data()) {
				swapped = true;
				NodeFloat pp = prev.prev();
				NodeFloat next = node.next();
				
				node.prev(pp);
				if(pp!=null) {
					pp.next(node);
				}
				
				node.next(prev);
				prev.prev(node);
				prev.next(next);
				if(next!=null)
					next.prev(prev);
				
				prev = node.prev();
			}
			
			if(prev == null)
				start = node;
			
			if(swapped) {
				node = origPrev;
			}

			//System.out.print(" ### ");
			//NodeFloat.printAllNodes(start);
			if(node!=null)
				node = node.next();
		
		}
		
		return start;

	}


}
