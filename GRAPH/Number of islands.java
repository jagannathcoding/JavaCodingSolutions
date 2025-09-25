class Solution12 {

    void dfs(int row, int col, char[][] grid, int[][] vis) {
        vis[row][col] = 1;
        int r = grid.length;
        int c = grid[0].length;

        int delRow[]   = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nrow = row + delRow[k];
            int ncol = col + delCol[k];

            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return cnt;
    }
}
