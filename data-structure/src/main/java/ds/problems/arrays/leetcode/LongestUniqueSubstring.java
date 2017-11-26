package ds.problems.arrays.leetcode;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		
		LongestUniqueSubstring obj = new LongestUniqueSubstring();
		System.out.println(obj.lengthOfLongestSubstring("abcbacaxyzmn"));

	}
	
	public int lengthOfLongestSubstring4(String s)  {
		int i=0, j = 0, ans = 0, n = s.length();
		int[] chars = new int[256];
		while(j<n) {
			char c = s.charAt(j);
			ans = Math.max(ans, j-i);
			// i = Math.max(map.get(c)+1, i);
			// map.put(c, j++);
		}
		return Math.max(ans, j-i);
	}


	public int lengthOfLongestSubstring3(String s)  {
		int i=0, j = 0,ans = 0, n = s.length();
		java.util.Set<Character> set = new java.util.HashSet<Character>();
		while(j<n) {
			char c = s.charAt(j);
			if(set.contains(c)) {
				ans = Math.max(ans, j-i);
				set.remove(s.charAt(i++));
			} else {
				set.add(c);
				j++;
			}
			
		}
		return Math.max(ans, j-i);
	}
	
	public int lengthOfLongestSubstring2(String s)  {
		int i=0, j = 0, dupJ = 0, ans = 0, n = s.length();
		
		java.util.Map<Character,Integer> map = new java.util.HashMap<Character,Integer>();
		while(j<n) {
			char c = s.charAt(j);
			if(map.containsKey(c)) {
				dupJ = map.get(c);
				ans = Math.max(ans, j-i);
				for(int k = i ; k<=dupJ;k++)
					map.remove(s.charAt(k));
				i = dupJ+1;
			}
			map.put(c, j++);
		}
		return Math.max(ans, j-i);
	}
	
	public int lengthOfLongestSubstring(String s) {
		int i=0, j = 0, ans = 0, n = s.length();
		java.util.Map<Character,Integer> map = new java.util.HashMap<Character,Integer>();
		while(j<n) {
			char c = s.charAt(j);
			if(map.containsKey(c)) {
				ans = Math.max(ans, j-i);
				i = Math.max(map.get(c)+1, i);
			}
			map.put(c, j++);
		}
		return Math.max(ans, j-i);
	}

}
