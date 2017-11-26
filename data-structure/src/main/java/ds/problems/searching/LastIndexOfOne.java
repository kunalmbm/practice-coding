package ds.problems.searching;

import java.util.Scanner;

public class LastIndexOfOne {


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
/*
5
00000000000111111111111111111
111111111111111111000000000
11111110000
11111
1


 */
				int t = scanner.nextInt();
				while(t-- > 0) {
					String str = scanner.next();
					int c = 0;
					for (int i = 0; i<str.length(); i++) {
						if(str.charAt(i) == '1')
				            c=i;
					}
					System.out.println(c);
				}

				scanner.close();
	}

}
