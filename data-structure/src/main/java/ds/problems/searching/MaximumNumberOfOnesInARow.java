package ds.problems.searching;

import java.util.Scanner;

public class MaximumNumberOfOnesInARow {

	public static void main(String[] args) {
		
		/*
4
3 4
0 1 1 1 0 0 1 1 0 0 1 1
2 2
0 1 1 1
2 5
1 1 1 1 1 0 0 0 0 0
2 2
0 0 0 0



		
			*/

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-- > 0) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int rowNum = 0;
			int count = 0;
			for (int i = 0; i< row; i++) {
				boolean flag = false;
				for (int j = 0; j<col; j++) {
					int val = scanner.nextInt();
					if(flag)
						continue;
					
					if(val == 1) {
						flag = true;
						if(count < (col-j)){
							rowNum = i;
							count = col-j;
						}
					}
				}
			}
			
			System.out.println(rowNum);

		}

		scanner.close();

	}

}
