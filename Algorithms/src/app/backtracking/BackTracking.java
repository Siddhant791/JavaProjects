package app.backtracking;

import java.util.*;

public class BackTracking {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> outputList = new ArrayList<>();
		perm(outputList, nums, new ArrayList<Integer>(), 0);
		return outputList;
	}

	public void perm(List<List<Integer>> outputList, int[] nums, List<Integer> permutation, int start) {
		if (nums.length == permutation.size()) {
			outputList.add(permutation);
			return;
		}

		for (int i = 0; i <= permutation.size(); i++) {
			ArrayList<Integer> newPermutation = new ArrayList<Integer>(permutation);
			newPermutation.add(i, nums[start]);
			perm(outputList, nums, newPermutation, start + 1);
		}
	}

	public static void main(String[] args) {
		BackTracking bt = new BackTracking();
		bt.permute(new int[] { 1, 2, 3 }).forEach(System.out::println);

	}
}
