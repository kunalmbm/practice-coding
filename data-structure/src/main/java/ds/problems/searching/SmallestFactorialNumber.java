package ds.problems.searching;

import java.util.Scanner;

public class SmallestFactorialNumber {

	public static void main(String[] args) {
		
		/*
25
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25


			*/

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-- > 0) {
			int n = scanner.nextInt();

			int x = 4;
			int count = 0;
			long fact = 24;

			while(count < n) {
				x++;
				fact *= x;
				while(fact % 10 == 0){
					count++;
					fact /= 10;
				}
				fact %= 1000;
			}
			
			//System.out.printf("%d %d %d\n", x, fact, count);
			System.out.println(x);
		}

		scanner.close();

	}
	
	

}
