package ds.problems.arrays.leetcode;

import java.util.Scanner;

public class RemoveElement {
	
	public static void main(String[] args) {
		
		RemoveElement obj = new RemoveElement();
		obj.runTests();
		
	}
	
	public void runTests() {
		
/*
8
5 0
0 1 0 3 12
14 0
1 5 0 0 10 4 3 0 12 0 14 41 0 0
1 0
1
2 0
1 2
1 0
0
2 0
0 0
4 3
3 2 2 3
4 2
3 2 2 3

 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int val = sc.nextInt();
			int[] A = new int[n];
			int i = 0;
			while(i<n)
				A[i++] = sc.nextInt();
			
			int n1 = removeElement2(A, val);
			i = 0;
			while(i<n) {
				if(i == n1)
					System.out.print(" - ");
				System.out.printf("%d " , A[i++]);
			}
			System.out.println(" : " + n1);
		}
		sc.close();
		
	}
	
	public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, n = nums.length;
        while(i<n) {
            if(nums[i]!=val)
                nums[j++] = nums[i];
            i++;
        }
        return j;
    }
	
	public int removeElement2(int[] nums, int val) {
        int i = 0, n = nums.length;
        while(i<n) {
            if(nums[i]==val)
                nums[i] = nums[--n];
            else
            	i++;
        }
        return n;
    }

}
