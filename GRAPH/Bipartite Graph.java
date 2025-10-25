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
