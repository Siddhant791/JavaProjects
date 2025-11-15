package src.graph;

public class NumberOfIslands {
    // LeetCode: https://leetcode.com/problems/number-of-islands/
    // Problem: Given a 2D grid of '1's (land) and '0's (water), count the number of islands.
    // Pattern/Technique: Depth-First Search (DFS) / Flood Fill on an implicit grid graph.
    // Approach:
    //  - Iterate every cell; when a '1' (land) is found, perform DFS to mark the whole connected component as visited.
    //  - Convert visited '1's to '0' in-place to avoid extra visited memory.
    // Complexity:
    //  - Time: O(R * C) — each cell is processed at most once.
    //  - Space: O(R * C) worst-case recursion stack when one island fills the grid. Additional extra space is O(1).
    private static final int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        // Assume grid is non-empty (grid.length > 0 and grid[0].length > 0)
        int ROW = grid.length;                 // number of rows
        int COLUMN = grid[0].length;           // number of columns
        int output = 0;                        // counter for islands found

        // Scan each cell in the grid
        for (int i = 0; i<ROW; i++){
            for (int j = 0; j<COLUMN;j++){
                // Found unvisited land -> start DFS to sink the island
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);           // mark the entire island as visited (converted to '0')
                    output++;                  // increment island count after DFS completes
                }
            }
        }

        return output;                         // total number of islands
    }

    private void dfs(char[][] grid, int i, int j) {
        // Base cases: out of bounds or already water -> nothing to do
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark current land cell as visited by sinking it to '0'
        grid[i][j] = '0';

        // Explore all four cardinal neighbors (up, down, left, right)
        for (int[] dir : d) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
