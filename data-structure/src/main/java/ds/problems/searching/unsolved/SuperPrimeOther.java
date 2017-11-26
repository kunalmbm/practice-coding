package ds.problems.searching.unsolved;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader s1 = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		Scanner s2 = new Scanner(System.in);
		int t = s2.nextInt();
		boolean prime[] = new boolean[31];
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		for (int i = 2; i <= 30; i++) {
			if (!prime[i]) {
				l1.add(i);
				for (int j = 2; j * i < 31; j++)
					prime[j * i] = true;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < l1.size() - 1; i++) {
			if ((l1.get(i + 1) - l1.get(i) == 2))
				ans.add(l1.get(i + 1));
		}
		for (int q = 0; q < t; q++) {
			int n = s2.nextInt();
			int ind = Collections.binarySearch(ans, n);
			if (ind >= 0)
				pw.println(ind + 1);
			else {
				ind = -(ind + 1);
				pw.println(ind);
			}
		}
		pw.flush();
	}
	
	public void main2(String[] args) throws IOException {
		BufferedReader s1 = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		Scanner s2 = new Scanner(System.in);
		int t = s2.nextInt();
		boolean prime[] = new boolean[10000001];
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		for (int i = 2; i <= 10000000; i++) {
			if (!prime[i]) {
				l1.add(i);
				for (int j = 2; j * i < 10000001; j++)
					prime[j * i] = true;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < l1.size() - 1; i++) {
			if ((l1.get(i + 1) - l1.get(i) == 2))
				ans.add(l1.get(i + 1));
		}
		for (int q = 0; q < t; q++) {
			int n = s2.nextInt();
			int ind = Collections.binarySearch(ans, n);
			if (ind >= 0)
				pw.println(ind + 1);
			else {
				ind = -(ind + 1);
				pw.println(ind);
			}
		}
		pw.flush();
	}
}