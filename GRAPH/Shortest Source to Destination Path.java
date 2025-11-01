// User function Template for Java

//company :  samsung
//  https://www.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1


class Solution {
    
    class Node{
        int x;
        int y;
        int dist;
        Node(int x,int y,int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    
    
    int shortestDistance(int n, int m, int A[][], int X, int Y) {
        // code here
        if(A[0][0]==0) return -1;
        
        boolean vis[][]=new boolean[n][m];
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(0,0,0));
        vis[0][0]=true;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        while(!q.isEmpty())
        {
            Node p=q.poll();
            if (p.x == X && p.y == Y)
                return p.dist;
                
            for(int i=0;i<4;i++)
            {
                int nRow=p.x+dx[i];
                int nCol=p.y+dy[i];
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&!vis[nRow][nCol]&&A[nRow][nCol]==1)
                {
                    vis[nRow][nCol] = true;
                    q.add(new Node(nRow,nCol,p.dist+1));
                }
            }
        }
        return -1;
    }
};
