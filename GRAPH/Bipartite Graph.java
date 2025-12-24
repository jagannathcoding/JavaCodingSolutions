*****************using bfs***************

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int l = graph.length;
        int[] color = new int[l];
        Arrays.fill(color,-1);
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<l;i++)
        {
            if(color[i]!=-1)continue;
            q.add(i);
            color[i]=1;
            while(!q.isEmpty())
            {
                int node=q.poll();
                for(int j:graph[node])
                {
                    if(color[j]==-1)
                    {
                        color[j]=1-color[node];
                        q.add(j);
                    }
                    else if(color[j]==color[node])return false;
                }
            }
        }
        return true;
    }
}

///***************?////////////// ADDED DFS CODE



class Solution {
      boolean dfs(int node, int col, int[] color, int[][] graph) 
      {
        color[node] = col;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - col, color, graph))
                    return false;
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
    }
    
   public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        int V=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(i,0,color,graph)==false) return false;
            }
        }
        return true;  
    }
}
