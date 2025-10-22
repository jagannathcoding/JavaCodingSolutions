// User function Template for Java

class Solution {

    void dfs(int row,int col,int vis[][],int[][] grid, ArrayList<String>vec,int row0,int col0)
    {
         vis[row][col] = 1;
         vec.add(toString(row-row0,col-col0));
        int n = grid.length;
        int m = grid[0].length;
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, vec, row0, col0);
            }
        }
    }
    
     String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int r=grid.length;
        int c=grid[0].length;
       HashSet<ArrayList<String>> set = new HashSet<>();
          int vis[][] = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(vis[i][j]==0&& grid[i][j]==1)
                {
                    ArrayList<String>alist=new ArrayList<>();
                    dfs(i,j,vis,grid,alist,i,j);
                    set.add(alist);
                }
            }
        }
        return set.size();
    }
}
