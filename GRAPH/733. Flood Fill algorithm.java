Flood Fill algorithm.java
  https://leetcode.com/problems/flood-fill/
  
//Time Complexity: O(NxM + NxMx4) ~ O(N x M)
//Space Complexity: O(N x M) + O(N x M)

class Solution
{
    private void dfs(int row, int col, 
     int[][] ans,
     int[][] image, 
     int newColor, int delRow[], int delCol[],
     int iniColor) {
        
        ans[row][col] = newColor; 
        int n = image.length;
        int m = image[0].length; 
        
        for(int i = 0;i<4;i++) 
        {
            int nrow = row + delRow[i]; 
            int ncol = col + delCol[i]; 
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && 
            image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) 
            {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor); 
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
       
        int iniColor = image[sr][sc]; 
        int[][] ans = image; 
       // delta row and delta column for neighbours
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1}; 
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor); 
        return ans;  
    }
}
