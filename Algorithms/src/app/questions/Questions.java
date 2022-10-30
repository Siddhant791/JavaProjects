package app.questions;

import java.util.LinkedList;
import java.util.Queue;

public class Questions {

	public static void main(String[] args) {
//		int input[][] = { { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
//				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//				{ 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 } };
//		updateMatrix(input);
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[]{1,2});

		LongestPalindromeString lp = new LongestPalindromeString();
		System.out.println(lp.longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
	}

	/**
	 * Rotate a array question
	 * 
	 * @param nums
	 * @param k
	 */
	public static void rotateArray(int[] nums, int k) {
		int[] out = new int[nums.length];
		if (k >= nums.length) {
			k = nums.length % k;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums.length - k - i > 0) {
				out[i + k] = nums[i];
			} else {
				out[i - (nums.length - k)] = nums[i];
			}

		}
		nums = out;
		for (int x : nums) {
			System.out.println(x);
		}

	}

	/**
	 * Find square of array and sort it
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] sortedSquares(int[] nums) {
		int[] output = new int[nums.length];
		int start = 0;
		int end = nums.length - 1;
		int index = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == 0) {
				start = mid;
				end = mid - 1;
			}
			if (nums[mid] < 0) {
				start = mid + 1;
			}
			if (nums[mid] > 0) {
				end = mid - 1;
			}
		}

		while (end >= 0 && start < nums.length) {
			if (Math.abs(nums[end]) >= nums[start]) {
				output[index] = nums[start] * nums[start];
				start++;
			} else {
				output[index] = nums[end] * nums[end];
				end--;
			}
			index++;
		}
		while (end >= 0) {
			output[index] = nums[end] * nums[end];
			end--;
			index++;
		}
		while (start < nums.length) {
			output[index] = nums[start] * nums[start];
			start++;
			index++;
		}
		return output;
	}

	public static int[][] updateMatrix(int[][] mat) {
		// First pass: check for left and top
		int rows = mat.length;
		int cols = mat[0].length;
		int dist[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dist[i][j] = Integer.MAX_VALUE - 100000;
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 0) {
					dist[i][j] = 0;
				} else {
					if (i > 0)
						dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
					if (j > 0)
						dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
				}
			}
		}

		// Second pass: check for bottom and right
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if (i < rows - 1)
					dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
				if (j < cols - 1)
					dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
			}
		}
		return dist;
	}

	
	
}
