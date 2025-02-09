73. Set Matrix Zeroes


 Question link : https://leetcode.com/problems/set-matrix-zeroes/description/

Solved
Medium
Topics
Companies
Hint
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1




  **************Approach-1***********
  tc: O((N*M)*(N + M)) + O(N*M),
  sc:???????
  class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int row[]=new int[r];
        int col[]=new int[c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {   
                if(matrix[i][j]==0)
                {
                    row[i]=-1;
                    col[j]=-1;
                }
            }
        }
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(row[i]==-1||col[j]==-1)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}

************************Approach-2********************
//tc: O(2(R*C)), 

//Space Complexity: O(1)
  class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int row[]=new int[r];
        int col[]=new int[c];
         

        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = 1; 
                    col[j] = 1; 
                }
            }
        }

        
        for (int i = 0; i < r; i++) 
        {
            if (row[i] == 1) 
            { 
                for (int j = 0; j < c; j++) 
                {
                    matrix[i][j] = 0;// If row[i] is marked, koro eibar the entire row to 0
                }
            }
        }

       
        for (int j = 0; j < c; j++) {
            if (col[j] == 1)
            { 
                for (int i = 0; i < r; i++)
                {
                    matrix[i][j] = 0;// If col[j] is marked, koro eibar  the entire column to 0
                }
            }
        }

      
      
    }
}
  

******************Approach-3*************
 //dry run korte hobey logic mathate eshe geche halka halka
 //porey korbo ekhon icche koreche na
