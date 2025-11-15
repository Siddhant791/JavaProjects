package src.twopointers;

import java.util.Arrays;

/*
 LeetCode: Assign Cookies
 Link: https://leetcode.com/problems/assign-cookies/

 Problem:
 Given two arrays, g (children's greed factors) and s (cookie sizes),
 assign cookies to maximize the number of content children. A child i
 is content if they receive a cookie of size >= g[i]. Each cookie can
 be assigned to at most one child.

 Technique / Pattern:
 Greedy algorithm using the Two Pointers pattern. Sort both arrays and
 iterate with two indices to match smallest sufficient cookie to each child.

 Complexity:
 - Sorting: O(n log n + m log m) where n = g.length, m = s.length.
 - Matching (two-pointer scan): O(n + m).
 - Total time: O(n log n + m log m).
 - Space: O(1) additional (ignoring sorting space); if sort is not in-place,
   consider O(n + m) due to sort implementations.
*/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Sort greed factors and cookie sizes so we can greedily assign smallest
        // sufficient cookie to each child.
        Arrays.sort(g); // O(n log n)
        Arrays.sort(s); // O(m log m)

        // Number of children and cookies
        int numberOfChildren = g.length;
        int numberOfCookies = s.length;
        // i -> index for children (greed factors)
        int i = 0;
        // j -> index for cookies (sizes)
        int j = 0;
        // output -> count of content children
        int output = 0;

        // Two-pointer scan:
        // Advance through cookies and children. For each cookie, if it can
        // satisfy the current child (s[j] >= g[i]), assign it and move both
        // pointers forward; otherwise, try the next larger cookie.
        // This loop runs in O(n + m).
        while (i < numberOfChildren && j < numberOfCookies) {
            if (s[j] >= g[i]) {
                // Cookie s[j] satisfies child g[i] -> assign and count it.
                i++;
                j++;
                output++;
            } else {
                // Cookie too small for current child -> discard cookie and
                // try next cookie (since arrays are sorted, larger cookies may fit).
                j++;
            }
        }

        // Return total number of content children after greedy assignment.
        return output;
    }
}
