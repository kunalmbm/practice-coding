package ds.problems.searching;

import java.util.Scanner;

public class ValueEqualToIndexValue {

	public static void main(String[] args) {
		
/*
4
5
15 2 45 12 7
1
1
4
10 12 13 14
6
2 1 3 5 4 6


 */
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int val = -1;
			boolean flag = false;
			for(int i=1 ;i <=n; i++) {
				
				val = sc.nextInt();
				
				if(val == i) {
					if(flag)
						System.out.printf(" %d", val);
					else
						System.out.printf("%d", val);
					flag = true;
				}
			}
			if(!flag) 
				System.out.println("Not Found");
			else
				System.out.println();
			
			
		}
		sc.close();
	}
}
