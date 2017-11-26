package ds.problems.arrays.leetcode;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		Solution obj = new Solution();
		// System.out.println(obj.lengthOfLongestSubstring("abcabcdaxyzzmnopqrmnomno"));
		System.out.println(obj.reverse(621));

		byte b = 127;
		// System.out.println(b++);
		// System.out.println(b++);
	}

	public int reverse(int x) {

		boolean negative = x < 0 ? true : false;
		char[] chars = String.valueOf(x).toCharArray();
		int i = negative ? 1 : 0, j = chars.length - 1;
		char c;
		while (i < j) {
			c = chars[i];
			chars[i] = chars[j];
			chars[j] = c;
			i++;
			j--;
		}

		
		String s = String.valueOf(chars);

		if (Long.valueOf(s) < Integer.MIN_VALUE)
			return 0;

		if (Long.valueOf(s) > Integer.MAX_VALUE)
			return 0;

		return Integer.valueOf(s);
	}

	public int lengthOfLongestSubstring1(String s) {

		if (s.length() == 0)
			return 0;

		char[] C = s.toCharArray();
		int n = C.length;
		int l = 0, r = 0;
		int i = 0, j = 1;
		java.util.Set<Character> set = new java.util.HashSet<Character>();
		set.add(C[0]);
		while (j < n) {
			System.out.printf("-- %d - %c\n", j, C[j]);
			System.out.println(s + " - " + set.toString() + " - " + l + " , " + r);
			if (set.contains(C[j])) {
				if ((j - i) > (r - l + 1)) {
					l = i;
					r = j - 1;
				}
				i = j;
				// i = map.get(C[j]) + 1;

				// for(int k = i ; k <= set.get(C[j]);k++)

			}

			set.add(C[j]);
			j++;
		}

		if ((j - i) > (r - l + 1)) {
			l = i;
			r = j - 1;
			i = j;
		}
		System.out.printf("%d - %d\n", l, r);
		System.out.println(s.substring(l, r + 1));
		return (r - l + 1);

	}

	public int lengthOfLongestSubstring(String s) {

		if (s.length() == 0)
			return 0;

		char[] C = s.toCharArray();
		int n = C.length;
		int l = 0, r = 0;
		int i = 0, j = 1;
		java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
		map.put(C[0], 0);
		while (j < n) {
			System.out.printf("-- %d - %c\n", j, C[j]);
			System.out.println(s + " - " + map.toString() + " - " + l + " , " + r);
			if (map.containsKey(C[j])) {
				System.out.println("dup ind ");
				if ((j - i) > (r - l + 1)) {
					l = i;
					r = j - 1;
				}

				int k = i;
				i = map.get(C[j]) + 1;
				for (; k < i; k++)
					map.remove(C[k]);

				// map.clear();
			}

			map.put(C[j], j);
			j++;
		}

		if ((j - i) > (r - l + 1)) {
			l = i;
			r = j - 1;
		}

		// System.out.printf("%d - %d\n",l,r);
		System.out.println(s.substring(l, r + 1));
		return (r - l + 1);

	}
}
