package src.Arrays;

/**
 * LeetCode Problem: 387. First Unique Character in a String
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Technique/Pattern: Frequency Array / Hash Map
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 */
public class FirstUniqueCharacter {
    /**
     * Finds the index of the first non-repeating character in a string.
     *
     * @param s The input string consisting of lowercase English letters.
     * @return The index of the first unique character, or -1 if no unique character exists.
     */
    public int firstUniqChar(String s) {
        // Step 1: Initialize a frequency array for lowercase English letters.
        // The size 26 is used because there are 26 lowercase English letters ('a' through 'z').
        // This array will store the count of each character.
        int[] charArray = new int[26];

        // Step 2: Populate the frequency array.
        // Iterate through the string once to count the occurrences of each character.
        // Time Complexity: O(N), where N is the length of the string 's'.
        for (int i =0 ; i<s.length();i++){
            charArray[s.charAt(i) - 'a']++; // 's.charAt(i) - 'a'' converts a character to an index (0-25).
        }

        // Step 3: Find the first unique character.
        // Iterate through the string again. For each character, check its count in the frequency array.
        // Time Complexity: O(N), where N is the length of the string 's'.
        for (int i = 0 ; i<s.length();i++){
            if (charArray[s.charAt(i) - 'a'] == 1) return i; // If the count is 1, it's the first unique character.
        }
        return -1; // If no unique character is found after checking all characters, return -1.
    }
}
