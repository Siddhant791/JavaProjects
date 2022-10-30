package app.questions;

import java.util.HashMap;

public class LongestPalindromeString {

	public String longestPalindrome(String s) {
		HashMap<String, String> map = new HashMap<String, String>();
		return findPal(s, 0, s.length() - 1, map);
	}

	public String findPal(String s, int start, int end, HashMap<String, String> map) {
		if (map.get(s.substring(start, end + 1)) != null) {
			return map.get(s.substring(start, end + 1));
		}
		if (start == end) {
			map.put(s.substring(start, end + 1), s.substring(start, end + 1));
			return s.substring(start, end + 1);
		}

		if (isPalindrome(s, start, end)) {
			map.put(s.substring(start, end + 1), s.substring(start, end + 1));
			return s.substring(start, end + 1);
		}
		int leftIndex = start + 1;
		int rightIndex = end - 1;
		String left = findPal(s, start, rightIndex, map);
		String right = findPal(s, leftIndex, end, map);

		if (left.length() > right.length()) {
			map.put(s.substring(start, end + 1), left);
			return left;
		} else if (left.length() < right.length()) {
			map.put(s.substring(start, end + 1), right);
			return right;
		} else {
			map.put(s.substring(start, end + 1), left);
			return left;
		}
		// return "temp";
	}

	public boolean isPalindrome(String s, int start, int end) {

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
