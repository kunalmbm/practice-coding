package ds.problems.searching;

import java.util.Scanner;

public class HappiestTripletBruteForce {

	private int[][] readInputData() {
		/*
2
3
5 2 8
10 7 12 
9 14 6
4
15 12 18 9
10 17 13 8
14 16 11 5

			*/

		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		int[][] data = new int[t][];
		for(int index = 0; index < t; index++) {
			int n = scanner.nextInt();
			int[] arr = new int[n*3];
			for (int i = 0; i< n * 3; i++) {
				arr[i] = scanner.nextInt();
			}
			data[index] = arr;
		}

		scanner.close();

		return data;
	}
	
	public static void main(String[] args) {
		
		HappiestTripletBruteForce object = new HappiestTripletBruteForce();

		int[][] data = object.readInputData();
		//ArrayUtility.printArrayOfArray(data);
		for (int[] arr : data) {
			int n = arr.length/3;
			Node node = object.findHappiestTriplet(arr, n);
			System.out.printf("%d %d %d\n", node.max, node.mid, node.min);
			
		}

	}
	
	private Node findHappiestTriplet(int[] arr, int n) {
		
		Node node = null;
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				for(int k = 0; k < n ; k++) {
					
					int ai = i;
					int bi = n+j;
					int ci = 2*n+k;
					
					int minIndex = i;
					int maxIndex = i;
					int midIndex = i;
					
					if(arr[bi] <arr[minIndex])
						minIndex = bi;
					
					if(arr[ci] <arr[minIndex])
						minIndex = ci;
					
					if(arr[bi] >arr[maxIndex])
						maxIndex = bi;
					
					if(arr[ci] >arr[maxIndex])
						maxIndex = ci;
					
					if(ai!=minIndex && ai!=maxIndex)
						midIndex = ai;
					
					if(bi!=minIndex && bi!=maxIndex)
						midIndex = bi;
					
					if(ci!=minIndex && ci!=maxIndex)
						midIndex = ci;
					
					if(node == null) {
						node = new Node(arr[minIndex],arr[midIndex],arr[maxIndex]);
						
					} else {
						node.updateNode(arr[minIndex],arr[midIndex],arr[maxIndex]);
					}

					//System.out.printf("- %d %d %d (%d, %d, %d)\n", arr[ai],arr[bi],arr[ci],arr[maxIndex],arr[midIndex],arr[minIndex]); 
					
				}
				
			}
			
		}

		return node;
	}

	private class Node {
		
		int min,mid,max, diff;
		
		public Node(int min, int mid, int max) {
			this.min = min;
			this.mid = mid;
			this.max = max;
			this.diff = max - min;
		}

		
		public void updateNode(int min, int mid, int max) {
			
			int diff = max-min;
			if(this.diff < diff) 
				return;
			
			if(this.diff > diff) {
				this.min = min;
				this.mid = mid;
				this.max = max;
				this.diff = diff;
			}
			
			int sum1 = this.min + this.mid + this.max;
			int sum2 = min + mid + max;
			if(sum2 < sum1) {
				this.min = min;
				this.mid = mid;
				this.max = max;
				this.diff = diff;
			}
		}
		
		
	}
	
	
}
