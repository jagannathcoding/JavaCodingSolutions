***************DFS*************

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


*******************BFS************

  class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {

        Queue<Pair>q=new LinkedList<>();
        int r=grid.length;
        int c=grid[0].length;
        int vis[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i==0||j==0||i==r-1||j==c-1)
                {
                    if(grid[i][j]==1)
                    {
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }   
            }
        }
         int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            // traverses all 4 directions
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i]; 
                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <r && ncol >=0 && ncol < c
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1; 
                }
            }
            
        }
        int cnt = 0;
        for(int i = 0;i<r;i++) {
            for(int j = 0;j<c;j++) {
               
                if(grid[i][j] == 1 & vis[i][j] == 0) 
                    cnt++; 
            }
        }
        return cnt; 
        
    }



    
}
