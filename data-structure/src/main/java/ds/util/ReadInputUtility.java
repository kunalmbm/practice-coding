package ds.util;

import java.io.InputStream;
import java.util.Scanner;

import ds.list.doubly.NodeFloat;
import ds.list.doubly.NodeInt;
import ds.list.single.Node;

public class ReadInputUtility {

	public static int[][] readBinaryTreeTestData(String fileName) {
		
		InputStream is = ReadInputUtility.class.getResourceAsStream(fileName);
		Scanner scanner = new Scanner(is);
		return readIntegerTestDataInArray(scanner);
		
	}

	public static int[][] readIntegerTestDataInArray(String fileName) {
		InputStream is = ReadInputUtility.class.getResourceAsStream(fileName);
		Scanner scanner = new Scanner(is);
		return readIntegerTestDataInArray(scanner);
	}

	
	public static int[][] readIntegerTestDataInArrayKSorted(String fileName) {
		InputStream is = ReadInputUtility.class.getResourceAsStream(fileName);
		Scanner scanner = new Scanner(is);
		return readIntegerTestDataInArrayKSorted(scanner);
	}
	
	private static int[][] readIntegerTestDataInArrayKSorted(Scanner scanner) {
		
		int t = scanner.nextInt();
		int[][] data = new int[t][]; 
		for(int index = 0; index < t; index++) {
			//System.out.printf("\n Test Case # %d : ", (index+1));
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] arr = new int[n+1];
			//System.out.printf("%d : ", n);
			for(int i = 0; i < n ; i++) {
				arr[i] = scanner.nextInt();
			}
			
			arr[n] = k;
			
			/*for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);
*/
			data[index] = arr;
		}
		
		scanner.close();
		return data;
		
	}
		
	private static int[][] readIntegerTestDataInArray(Scanner scanner) {
		
		int t = scanner.nextInt();
		int[][] data = new int[t][]; 
		for(int index = 0; index < t; index++) {
			//System.out.printf("\n Test Case # %d : ", (index+1));
			int n = scanner.nextInt();
			int[] arr = new int[n];
			//System.out.printf("%d : ", n);
			for(int i = 0; i < n ; i++) {
				arr[i] = scanner.nextInt();
			}
			
			/*for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);
*/
			data[index] = arr;
		}
		
		scanner.close();
		return data;
		
	}

	
	public static Node[] readArraySortTestDataInSingleLinkList(String fileName) {
		
		InputStream is = ReadInputUtility.class.getResourceAsStream(fileName);
		Scanner scanner = new Scanner(is);
		return readIntegerTestDataInLinkList(scanner);
		
	}
	
	private static Node[] readIntegerTestDataInLinkList(Scanner scanner) {
		
		int t = scanner.nextInt();
		Node[] nodes = new Node[t];
		for(int index = 0; index < t; index++) {
			// System.out.printf("\n Test Case # %d : ", (index+1));
			int n = scanner.nextInt();
			Node lastNode = null;
			// System.out.printf("%d : ", n);
			int i, val;
			
			for(i = 0; i < n ; i++) {

				val = scanner.nextInt();
				Node node = new Node(val);
				
				// System.out.printf(" : %d : ", val);

				if(lastNode == null) {
					lastNode = nodes[index] = node;
					continue;
				}
				
				lastNode = Node.addNextNode(lastNode,node);
				
			}

			//NodeInt.printAllNodes(nodes[index]);
			
			/*for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);
			 */

		}
		scanner.close();
		return nodes;

	}

	
	public static int[][] readInputTestDataFromSystemIn() {

		System.out.println("Enter Input: ");
		
		/*
		 * Sample input
		 * 
13
5 
5 40 0 25 10
4
34 45 345 987
5
15 14 9 7 1
10
10 11 15 13 13 20 0 5 8 1
13
100 25 50 24 21 14 10 5 13 0 75 55 45
19
1 4 2 4 2 4 1 2 4 1 2 2 2 2 4 1 4 4 4
7
1 4 1 2 7 5 2
7
10 9 9 5 7 5 10
5
5 4 0 5 1
9
121 231 23 233 1127 7 77 88 678
8
170 45 75 90 802 24 2 66
5
-1 0 0 -1 -2
13
1 4 5 6 1 2 8 4 4 4 2 1 4


		 * 
		 */
		
		Scanner scanner = new Scanner(System.in);
		return readIntegerTestDataInArray(scanner);

	}

	public static NodeInt[] readArraySortTestDataInDoublyLinkList(String fileName) {
		
		InputStream is = ReadInputUtility.class.getResourceAsStream(fileName);
		Scanner scanner = new Scanner(is);
		return readIntegerTestDataInDoublyLinkList(scanner);
		
	}
	
	private static NodeInt[] readIntegerTestDataInDoublyLinkList(Scanner scanner) {

		int t = scanner.nextInt();
		NodeInt[] nodes = new NodeInt[t];
		for(int index = 0; index < t; index++) {
			// System.out.printf("\n Test Case # %d : ", (index+1));
			int n = scanner.nextInt();
			NodeInt lastNode = null;
			// System.out.printf("%d : ", n);
			int i, val;
			
			for(i = 0; i < n ; i++) {

				val = scanner.nextInt();
				NodeInt node = new NodeInt(val);
				
				// System.out.printf(" : %d : ", val);

				if(lastNode == null) {
					lastNode = nodes[index] = node;
					continue;
				}
				
				lastNode.addNext(node);
				lastNode = node;
				
			}

			//NodeInt.printAllNodes(nodes[index]);
			
			/*for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);
			 */

		}
		scanner.close();
		return nodes;
	}

	public static NodeFloat[] readArraySortTestDataInDoublyLinkListFloat(String fileName) {
		
		InputStream is = ReadInputUtility.class.getResourceAsStream(fileName);
		Scanner scanner = new Scanner(is);
		return readFloatTestDataInDoublyLinkList(scanner);
		
	}

	private static NodeFloat[] readFloatTestDataInDoublyLinkList(Scanner scanner) {

		
		/*
		 * Sample input
		 * 
2
7
0.1 0.4 0.1 0.2 0.7 0.5 0.2
5
-0.1 0 0 -0.1 -0.2

		 * 
		 */

		int t = scanner.nextInt();
		NodeFloat[] nodes = new NodeFloat[t];
		for(int index = 0; index < t; index++) {
			// System.out.printf("\n Test Case # %d : ", (index+1));
			int n = scanner.nextInt();
			NodeFloat lastNode = null;
			// System.out.printf("%d : ", n);
			int i;
			float val;
			
			for(i = 0; i < n ; i++) {

				val = scanner.nextFloat();
				NodeFloat node = new NodeFloat(val);
				
				// System.out.printf(" : %d : ", val);

				if(lastNode == null) {
					lastNode = nodes[index] = node;
					continue;
				}
				
				lastNode.addNext(node);
				lastNode = node;
				
			}

			//NodeFloat.printAllNodes(nodes[index]);
			
			/*for(int i = 0; i<n ;i++) 
				System.out.printf("%d ",arr[i]);
			 */

		}
		scanner.close();
		return nodes;
	}

}
