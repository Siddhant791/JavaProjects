package app.questions;

public class Questions {
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

}
