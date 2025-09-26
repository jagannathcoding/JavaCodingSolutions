Flood Fill algorithm.java
  https://leetcode.com/problems/flood-fill/
  
//Time Complexity: O(NxM + NxMx4) ~ O(N x M)
//Space Complexity: O(N x M) + O(N x M)
*********DFS**************
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


*****************BFS*****************
  class Solution {
    void bfs(int sr, int sc, int[][] ans, int[][] image, int iniColor, int color, int[] delRow, int[] delCol) {
        int r = image.length;
        int c = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        ans[sr][sc] = color;  // marking starting pixel

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

           
            for (int i = 0; i < 4; i++) {
                int adjRow = row + delRow[i];
                int adjCol = col + delCol[i];

                if (adjRow >= 0 && adjRow < r && adjCol >= 0 && adjCol < c &&
                    image[adjRow][adjCol] == iniColor && ans[adjRow][adjCol] != color) {

                    ans[adjRow][adjCol] = color;   // color it
                    q.add(new int[]{adjRow, adjCol}); // push to queue for BFS
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor=image[sr][sc];
        int ans[][]=image;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        bfs(sr,sc,ans,image,initColor,color,delRow,delCol);

        return ans;
    }
}
