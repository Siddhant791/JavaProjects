package src.maths;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /**
     * LeetCode: https://leetcode.com/problems/happy-number/ (Problem 202)
     *
     * Problem:
     * Determine if a number n is "happy". Repeatedly replace n with the sum of the squares of its digits.
     * If this process reaches 1, n is happy; if it loops endlessly in a cycle that does not include 1, it is not happy.
     *
     * Technique / Pattern:
     * - Cycle detection using a HashSet to track seen intermediate sums (detect repeated states).
     *
     * Approach:
     * - Iteratively compute the sum of squares of digits (getSquareNumber).
     * - Use a HashSet to detect cycles: if a sum repeats, we are in a cycle and n is not happy.
     *
     * Complexity:
     * - getSquareNumber(int n): Time O(d) where d = number of digits in n; Space O(1).
     * - isHappy(int n): Each iteration does O(d) work and a HashSet add/check which is O(1) average.
     *   Let k be the number of iterations until we either reach 1 or detect a cycle.
     *   Time: O(k * d). In base-10, k is bounded by a small constant for all ints, so practical performance is O(d).
     *   Space: O(k) for the HashSet storing seen intermediate numbers.
     */
    class Solution {
        // HashSet to detect cycles of intermediate sums. If we see the same sum twice, a cycle exists.
        Set<Integer> set = new HashSet<>();
        public boolean isHappy(int n) {
            // Start with the input number. We'll compute the next number (sum of squares of digits)
            int squareNumber = n;
            while(true){
                // Compute next number in the sequence
                squareNumber = getSquareNumber(squareNumber);
                // Attempt to add to set; if already present, we've found a cycle -> not happy
                if (!set.add(squareNumber)) {
                    return false;
                }

                // If we reach 1, the number is happy
                if (squareNumber == 1){
                    return true;
                }
            }
        }

        // Compute sum of squares of digits of n.
        // Example: n=19 -> 1^2 + 9^2 = 82
        private int getSquareNumber(int n){
            int out = 0;
            int d = 0;
            // Process each digit: extract with n % 10, square, add to out, then remove digit with n /= 10
            while (n > 0){
                d = n%10;
                out+=d*d;
                n=n/10;
            }
            return out;
        }
    }
}
