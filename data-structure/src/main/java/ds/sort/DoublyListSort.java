package ds.sort;

import ds.list.doubly.NodeFloat;
import ds.list.doubly.NodeInt;
import ds.util.ReadInputUtility;
import ds.util.SortingUtility;

public class DoublyListSort {


	static void sortLists(NodeInt[] data) {

		System.out.println("Sorted Output: ");
		for(int index = 0; index <data.length ;index++) {
			
			NodeInt node  = data[index];

			System.out.print("Before ");
			NodeInt.printAllNodes(node);
			node = SortingUtility.insertionSort(node);
			System.out.print("After ");
			NodeInt.printAllNodes(node);

		}
	}
	
	static void sortLists(NodeFloat[] data) {

		System.out.println("Sorted Output: ");
		for(int index = 0; index <data.length ;index++) {
			
			NodeFloat node  = data[index];

			System.out.print("before ");
			NodeFloat.printAllNodes(node);
			node = SortingUtility.insertionSort(node);
			System.out.print("after  ");
			NodeFloat.printAllNodes(node);

		}
	}

	public static void main(String[] args) {
		
		//NodeInt[] data = ReadInputUtility.readArraySortTestDataInDoublyLinkList("/test-input/ArraySort.txt");
		//sortLists(data);
		
		NodeFloat[] dataFlat = ReadInputUtility.readArraySortTestDataInDoublyLinkListFloat("/test-input/ArraySortFloat.txt");
		sortLists(dataFlat);
		
	}

}
