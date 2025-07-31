https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list



class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList < Integer > res = new ArrayList < > ();
        int v=adj.size();
        
        Queue<Integer>q=new LinkedList<>();
        boolean visited[]=new boolean[v];
        
        q.add(0);
        visited[0]=true;
        
        while(!q.isEmpty())
        {
            int node=q.poll();
            res.add(node);
            for(int i:adj.get(node))
            {
                if(!visited[i])
                {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        return res;
        
        
    }
}
