https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1



class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    void dfsHelper(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result)
    {
        visited[node]=true;
        result.add(node);
        for(int neighbour:adj.get(node))
        {
            if(!visited[neighbour])
            {
                visited[neighbour]=true;
                dfsHelper(neighbour, adj, visited, result);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V=adj.size();
        boolean visited[]=new boolean[V];
        ArrayList<Integer>result=new ArrayList<>();
        dfsHelper(0, adj, visited, result); // Start DFS from node 0
        
        return result;
        
    }
}
