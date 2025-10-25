class Solution {

    void dfs(int row, int col, int[][] grid, int[][] vis, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        int r = grid.length;
        int c = grid[0].length;

        
        for (int i = 0; i < 4; i++) 
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) 
            {
                dfs(nrow, ncol, grid, vis, delrow, delcol);
            }
        }
    }

    public int numEnclaves(int[][] grid) 
    {
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        
        
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1)
                {
                    if (grid[i][j] == 1 && vis[i][j] == 0) 
                    {
                        dfs(i, j, grid, vis, delrow, delcol);
                    }
                }
            }
        }

       
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
