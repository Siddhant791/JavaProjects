package src.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode Problem 22: Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Technique/Pattern Used: Backtracking
 * - The algorithm uses backtracking to build all valid combinations by adding '(' or ')' at each step,
 *   ensuring at no point do we add more ')' than '('.
 *
 * Time Complexity: O(4^n / sqrt(n))
 * - The number of valid combinations is the nth Catalan number, which is asymptotically O(4^n / sqrt(n)).
 * - Each combination is built in O(n) time.
 *
 * Space Complexity: O(n) for the recursion stack and O(4^n / sqrt(n)) for the output.
 */
public class GenerateParanthesis {
    /**
     * Generates all combinations of well-formed parentheses for a given number of pairs.
     *
     * @param n The number of pairs of parentheses.
     * @return A list of strings representing all valid combinations.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        StringBuilder buffer = new StringBuilder();
        backtrack(0, 0, n, buffer, result);
        return result;
    }

    /**
     * Helper method to perform backtracking and generate valid combinations.
     *
     * @param openCount   The current count of open parentheses added.
     * @param closedCount The current count of closed parentheses added.
     * @param n           The total number of pairs of parentheses.
     * @param buffer      The current state of the string being built.
     * @param result      The list to store all valid combinations.
     */
    public void backtrack(int openCount, int closedCount, int n, StringBuilder buffer, List<String> result) {
        // Base case: If the number of open and closed parentheses equals n, add the combination to the result.
        if (openCount == n && closedCount == n) {
            result.add(buffer.toString());
            return;
        }

        // Add open parenthesis if the count is less than n.
        if (openCount < n) {
            buffer.append('(');
            backtrack(openCount + 1, closedCount, n, buffer, result);
            buffer.deleteCharAt(buffer.length() - 1); // Undo the addition for backtracking.
        }

        // Add closed parenthesis if the count of closed parentheses is less than open parentheses.
        if (openCount > closedCount) {
            buffer.append(')');
            backtrack(openCount, closedCount + 1, n, buffer, result);
            buffer.deleteCharAt(buffer.length() - 1); // Undo the addition for backtracking.
        }
    }
}
