package ds.problems.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodPairs {

	public static void main(String[] args) {
		
/*
4
2
2 1  
3
2 3 2
12
5 5 7 6 1 2 4 5 5 2 2 3 
22
11 11 11 11 5 6 6 7 7 8 8 8 9 9 9 10 0 2 2 3 4 4  

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0; i <n; i++) {
				A[i] = sc.nextInt();
			}
			
			int count = findGoodPairs(A, n);
			System.out.println(count);

		}
		sc.close();
	}
	
	

	public static int findGoodPairs(int[] A, int n) {
		
		Arrays.sort(A);
		//System.out.println(Arrays.toString(A) + "- " + n);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			//System.out.println("i = " + i);
			
			if(i > 0 && A[i-1] == A[i]) {
				int c = 1;
				while(i < n && A[i-1] == A[i]) {
					c++;
					i++;
				}
				Integer key = c;
				Integer val = map.get(key);
				if(val == null)
					val = 0;
				val++;
				map.put(key, val);
			}
				
		}
		
		int count = (n * (n-1)) / 2;
		for (int key : map.keySet()) {
			//System.out.printf("--- %d -> %d\n", key, map.get(key));
			int val = map.get(key);
			count -= ((key * (key-1))/2)*val;
		}
		
		return count;

	}

}
