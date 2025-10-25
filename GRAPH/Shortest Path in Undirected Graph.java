Shortest Path in Undirected Graph


  class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        
       // ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
       
       int dist[]=new int[adj.size()];
       for(int i=0;i<adj.size();i++)
       {
           dist[i]=(int)1e9;
       }
       
       dist[src]=0;
       Queue<Integer>q=new LinkedList<>();
       q.add(src);
       while(!q.isEmpty())
       {
           int node=q.peek();
           q.remove();
           for(int it:adj.get(node))
           {
               if(dist[node]+1<dist[it])
               {
                   dist[it]=1+dist[node];
                   q.add(it);
               }
           }
       }
       
       for(int i=0;i<adj.size();i++)
       {
           if(dist[i]==1e9)dist[i]=-1;
       }
       
       return dist;
       
        
    }
}
