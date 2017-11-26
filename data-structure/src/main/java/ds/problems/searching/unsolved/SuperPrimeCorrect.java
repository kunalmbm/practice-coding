package ds.problems.searching.unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SuperPrimeCorrect {

	private static ArrayList<Integer> getAllSuperPrimesUpto(int n) {

		n++;
		boolean composites[] = new boolean[n];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int n1 = 0;
		for (int i = 2; i < n; i++) {
			if (!composites[i]) {
				primes.add(i);
				for (int j = 2; i * j < n; j++) {
					composites[i * j] = true;
					n1++;
				}
			}
		}
		
		System.out.println(n1);

		ArrayList<Integer> superPrimes = new ArrayList<Integer>();
		for (int i = 0; i < primes.size() - 1; i++) {
			if ((primes.get(i + 1) - primes.get(i)) == 2)
				superPrimes.add(primes.get(i + 1));
		}

		/*
		 * System.out.print("Primes: "); for (int val : primes) {
		 * System.out.printf("%d " , val); } System.out.println();
		 * 
		 * System.out.print("Super Primes: "); for (int val : superPrimes) {
		 * System.out.printf("%d " , val); } System.out.println();
		 */

		return superPrimes;
	}

	public static void main(String[] args) {

		int n = 10000001;
		ArrayList<Integer> superPrimes = getAllSuperPrimesUpto(n);

		/*
2
5
44

		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int num = sc.nextInt();
			int index = Collections.binarySearch(superPrimes, num);
			if(index>=0)
				System.out.println(index+1);
			else
				System.out.println((-(index + 1)));

		}
		sc.close();
	}
}
