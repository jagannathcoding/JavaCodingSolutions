class Pair{
    int first;//
    int second;//
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(wt,v));//wight, node 
        }
        
        int dist[]=new int[V];
        
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Pair(0, src)); // (dist=0, node=src for starting)
        
        
        while(!pq.isEmpty())
        {
            Pair currentNode=pq.poll();
            int d=currentNode.first;
            int node=currentNode.second;
            
            for(Pair it:adj.get(node))
            {
                int edgeWeight=it.first;
                int adjNode=it.second;
                if(edgeWeight+d<dist[adjNode])
                {
                    dist[adjNode]=d+edgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
         for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) dist[i] = -1;
        }
        return dist;
        
    }
}
