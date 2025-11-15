package src.graph;

public class NumberOfIslands {
    private static final int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        int ROW = grid.length;
        int COLUMN = grid[0].length;
        int output = 0;

        for (int i = 0; i<ROW; i++){
            for (int j = 0; j<COLUMN;j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    output++;
                }
            }
        }

        return output;

    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        for (int[] dir : d) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
