package ds.sort;

import ds.list.single.Node;
import ds.util.ReadInputUtility;
import ds.util.SortingUtility;

public class SinglyListSort {


	static void sortLists(Node[] nodes) {

		System.out.println("Sorted Output: ");
		for(int index = 0; index <nodes.length ;index++) {
			
			Node node  = nodes[index];

			System.out.print("Before ");
			Node.printAllNodes(node);
			node = SortingUtility.quickSortLastPivotSingleList(node);
			System.out.print("After ");
			Node.printAllNodes(node);

		}
	}
	
	

	public static void main(String[] args) {
		
		Node[] nodes = ReadInputUtility.readArraySortTestDataInSingleLinkList("/test-input/ArraySort.txt");
		sortLists(nodes);

	}

}
