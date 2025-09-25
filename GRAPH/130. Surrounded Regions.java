class Solution {

    void dfs(int row, int col, int vis[][], char mat[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i]; 

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delcol); 
            }
        }
    }

    public void solve(char[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1}; 
        int vis[][] = new int[r][c];

        // first row & last row
        for (int j = 0; j < c; j++) {
            if (mat[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, vis, mat, delrow, delcol);
            }
            if (mat[r-1][j] == 'O' && vis[r-1][j] == 0) {
                dfs(r-1, j, vis, mat, delrow, delcol); 
            }
        }

       
        for (int i = 0; i < r; i++) {
            if (mat[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, vis, mat, delrow, delcol); 
            }
            if (mat[i][c-1] == 'O' && vis[i][c-1] == 0) {
                dfs(i, c-1, vis, mat, delrow, delcol); 
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X'; 
                }
            }
        }
    }
}
