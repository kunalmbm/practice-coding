package ds.problems.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RelativeSorting {

	public static void main(String[] args) {
		
/*
2
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
12 3
1 5 2 45 100 3 78 12 34 3 12 1
3 12 1

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			int[] A1 = new int[a1];
			int[] A2 = new int[a2];
			for(int i=0; i <a1; i++) {
				A1[i] = sc.nextInt();
			}
			for(int i=0; i <a2; i++) {
				A2[i] = sc.nextInt();
			}
			
			int[] O = relativeSortOrder(A1,a1,A2,a2);
			int n = O.length;
			// System.out.println();
			for(int i=0; i< n; i++) {
				if(i == n-1)
					System.out.println(O[i]);
				else 
					System.out.printf("%d ", O[i]);
			}

		}
		sc.close();
	}

	public static int[] relativeSortOrder(int[] A1, int a1, int[] A2, int a2) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i <a2; i++) {
			map.put(A2[i], i);
		}

		int o1 = 0 , o2 = 0;
		for(int i=0; i <a1; i++) {
			Integer val = map.get(A1[i]);
			if(val == null)
				o2++;
			else 
				o1++;
		}
		
		//System.out.printf("- o1 o2 - %d %d\n", o1, o2);
		int[] O1 = new int[o1+o2];
		int[] O2 = new int[o2];
		int o1Index = 0, o2Index = 0;
		for(int i=0; i<a1; i++) {
			Integer val = map.get(A1[i]);
			if(val == null) {
				O2[o2Index++] = A1[i];
				continue;
			}
			
			int j = o1Index - 1;
			// A1[i] < O1[j]
			while(j>=0 && val < map.get(O1[j])) {
				O1[j+1] = O1[j];
				j--;
			}
			O1[j+1] = A1[i];
			o1Index++;

		}
		
		Arrays.sort(O2);
		
		if(o1 == 0)
			return O2;
		
		for(int i=o1; i<o1+o2; i++) {
			O1[i] = O2[i-o1];
		}
		
		return O1;
	}

}
