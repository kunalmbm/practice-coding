package ds.problems.arrays.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {

		TwoSum obj = new TwoSum();
		int[] nums = { 5, 8, 8, 0, 18 };
		// java.util.Arrays.sort(nums);
		int t = 23;
		System.out.println(Arrays.toString(nums) + " - " + t);
		System.out.println(Arrays.toString(obj.twoSum(nums, t)));

	}
	
	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		int l = 0, r = n - 1;
		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum == target)
				return new int[] { l+1, r+1 };

			if (sum < target)
				l++;
			else
				r--;
		}
		return new int[] { -1, -1 };
    }

	public int[] twoSum3(int[] nums, int target) {
		int n = nums.length;
		java.util.Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int compliment = target-nums[i];
			if(map.containsKey(compliment))
				return new int[] {map.get(compliment) , i };
			
			map.put(nums[i], i);
		}

		return new int[] { -1, -1 };
	}

	public int[] twoSum1(int[] nums, int target) {
		int n = nums.length;
		for (int l = 0; l < n - 1; l++)
			for (int r = l + 1; r < n; r++)
				if (target == (nums[l] + nums[r]))
					return new int[] { l, r };

		return new int[] { -1, -1 };

	}

	public int[] twoSum2(int[] nums, int target) {

		int n = nums.length;
		int[] copy = Arrays.copyOf(nums, n);
		java.util.Arrays.sort(copy);
		int l = 0, r = n - 1;
		while (l < r) {
			int sum = copy[l] + copy[r];
			if (sum == target) {

				for (int i = 0; i < n; i++)
					if (nums[i] == copy[l]) {
						l = i;
						break;
					}

				for (int i = 0; i < n; i++)
					if (i!=l && nums[i] == copy[r]) {
						r = i;
						break;
					}

				return new int[] { l, r };

			}

			if (sum < target)
				l++;
			else
				r--;
		}
		return new int[] { -1, -1 };

	}

}
