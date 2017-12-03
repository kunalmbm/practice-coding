package ds.problems.arrays.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeros {
	
	public static void main(String[] args) {
		
		MoveZeros obj = new MoveZeros();
		obj.runTests();
		
	}
	
	public void runTests() {
		
/*
6
5
0 1 0 3 12
14
1 5 0 0 10 4 3 0 12 0 14 41 0 0
1
1
2
1 2
1
0
2
0 0
 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			int i = 0;
			while(i<n)
				A[i++] = sc.nextInt();
			moveZeroes2(A);
			System.out.println(Arrays.toString(A));
		}
		sc.close();
		
	}
	
	public void moveZeroes3(int[] nums) {
        int j = 0;
        int n = nums.length;
        for(int i = 0; i< n ; i++)
            if(nums[i]!=0) {
                nums[j++] = nums[i];
                if(i!=(j-1))
                	nums[i] = 0;
            }
    }
	
	public void moveZeroes(int[] nums) {
        int j = 0, t;
        int n = nums.length;
        for(int i = 0; i< n ; i++)
            if(nums[i]!=0) {
            	t = nums[i];
            	nums[i] = nums[j];
                nums[j++] = t;
            }
        
    }
	
	public void moveZeroes2(int[] nums) {
        int c = 0;
        int n = nums.length;
        for(int i = 0; i< n ; i++)
            if(nums[i]!=0)
            	nums[c++] = nums[i];

        while(c<n)
        	nums[c++] = 0;
        
    }

}
