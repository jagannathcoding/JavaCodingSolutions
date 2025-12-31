///using dfs and binary search
class Solution {
        int ROW,COL;
         int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean dfs(int grid[][],int i,int j)
        {
            if (i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1) {
            return false;
        }

        if (i == ROW - 1) return true;


        grid[i][j]=1;
         for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (dfs(grid, newI, newJ)) return true;
        }

        return false;
    }

    boolean canCross(int[][] cells,int day)
    {
        int grid[][]=new int[ROW][COL];
        for(int i=0;i<=day;i++)
        {
            int r=cells[i][0]-1;
            int c=cells[i][1]-1;
            grid[r][c]=1;
        }
        for(int j=0;j<COL;j++)
        {
            if(grid[0][j]==0&& dfs(grid,0,j)) return true;
        }

        return false;

    }


    public int latestDayToCross(int row, int col, int[][] cells) {
        

        int l=0;
        int r=cells.length-1;
        int lastDay=0;

        ROW = row;          
        COL = col;

        while(l<=r)
        {
            int mid=l+(r-l)/2;

            if(canCross(cells,mid))
            {
                lastDay = mid + 1;   
                l = mid + 1;
            }
            else r=mid-1;
        }

        return lastDay;

    }
}

/******************Approach 2*******************/
need to add bfs + binary search
