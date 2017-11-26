package ds.problems.searching;

import java.util.Scanner;

public class ReplaceByX {

	public static void main(String[] args) {

		ReplaceByX obj = new ReplaceByX();
		obj.startProcesing();

	}

	private void startProcesing() {

		/*
9
ababcabcab
abc
abcabcxyz
abc
adxyz
abc
abdxyz
abc
xyzabcabc
abc
xyzab
abc
xyzad
abc
xyzabd
abc
xyzabcabclmn
abc
ababcabcabcxyzabcabcxyzabc
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			String p = sc.next();

			char[] S = str.toCharArray();
			char[] P = p.toCharArray();
			printReplacedString(S, S.length, P, P.length);

		}
		sc.close();

	}

	public void printReplacedString(char[] S, int n1, char[] P, int n2) {

		for (int i = 0; i < n1; i++) {
			if (S[i] != P[0]) {
				System.out.print(S[i]);
				continue;
			}

			int si = i;
			int c = 0;
			do {
				int j = 0;
				for (; j < n2 && i < n1; j++, i++) {
					if (S[i] != P[j])
						break;
				}
				if (j == n2)
					c++;
				else
					break;

			} while (i<n1 && S[i] == P[0]);
			
			if(c>0)
				System.out.print('X');
			
			i--;
			
			for(int k = si + c * n2; k <= i && k < n1 ; k++) {
				System.out.print(S[k]);
			}
		}

		System.out.println();
	}

}
