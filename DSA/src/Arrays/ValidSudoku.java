package Arrays;
import java.util.*;

/**
 * LeetCode 36 - Valid Sudoku
 *
 * Problem Statement:
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
 * according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes must contain digits 1-9 without repetition.
 *
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * - Only the filled cells need to be validated according to the mentioned rules.
 * - The board is 9x9
 * - Board contains only digits 1-9 and character '.'
 */
public class ValidSudoku {
    /**
     * Validates if the given Sudoku board is valid according to the rules.
     *
     * Approach:
     * - Use three HashMaps to track numbers in each row, column, and 3x3 box
     * - For each cell, check if the number already exists in its corresponding row, column, or box
     * - Use computeIfAbsent to efficiently handle creation of new HashSets for first occurrence
     *
     * Time Complexity: O(1) since board is always 9x9
     * Space Complexity: O(1) since we store at most 9x9 elements
     *
     * @param board The 9x9 Sudoku board to validate
     * @return true if the board is valid, false otherwise
     */
    public boolean isValidSudoku(char[][] board) {
        // Maps to store seen numbers for rows, columns and 3x3 boxes
        Map<Integer, Set<Character>> rows = new HashMap<>();    // Key: row index, Value: Set of numbers in that row
        Map<Integer, Set<Character>> cols = new HashMap<>();    // Key: column index, Value: Set of numbers in that column
        Map<String, Set<Character>> box = new HashMap<>();      // Key: "box_row,box_col", Value: Set of numbers in that box

        int noOfRows = board.length;

        for(int i = 0; i < noOfRows; i++){
            for (int j = 0; j < board[i].length ; j++){
                // Skip empty cells marked with '.'
                if (board[i][j] == '.'){
                    continue;
                }

                // Calculate which 3x3 box we're in using integer division
                // For example: cell (7,8) would be in box "2,2" (7/3=2, 8/3=2)
                String squareKey = i/3 + "," + j/3;
                Character currentBoardValue = board[i][j];

                // Check if current number already exists in its row, column, or box
                // computeIfAbsent creates a new HashSet if the key doesn't exist
                if (rows.computeIfAbsent(i, (k) -> new HashSet<>()).contains(currentBoardValue) ||
                    cols.computeIfAbsent(j, (k) -> new HashSet<>()).contains(currentBoardValue) ||
                    box.computeIfAbsent(squareKey, (k) -> new HashSet<>()).contains(currentBoardValue)){
                    return false;   // Found a duplicate - board is invalid
                }
                else{
                    // Add the current number to its respective row, column, and box sets
                    rows.get(i).add(currentBoardValue);
                    cols.get(j).add(currentBoardValue);
                    box.get(squareKey).add(currentBoardValue);
                }
            }
        }
        // If we get here, no duplicates were found - board is valid
        return true;
    }
}
