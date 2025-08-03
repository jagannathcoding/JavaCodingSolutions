////BFS TRAVERSAL


class Solution {
    void bfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) 
    {
        Queue<Integer>q=new LinkedList<>();
            q.add(node);
             visited[node]=true;
             while(!q.isEmpty())
             {
                int node1=q.poll();
               
             
                for (int neighbor : adjList.get(node1)) 
                {
                if (!visited[neighbor]) {
                   visited[neighbor]=true;
                   q.add(neighbor);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        int l = isConnected.length;

     
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i <l; i++) 
        {
            for (int j = 0; j < l; j++)
             {
                if (i != j && isConnected[i][j] == 1)
                 {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i); 
                    
                }
            }
        }

     
        boolean[] visited = new boolean[l];
        int provinceCount = 0;
        for (int i = 0; i < l; i++) 
        {
            if (!visited[i]) 
            {
                provinceCount++;
                bfs(i, adjList, visited);
            }
        }

        return provinceCount;
    }
}





//////////////////////DFS TRAVERSAL


class Solution {
    void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) 
    {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) 
        {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        int l = isConnected.length;

     
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i <l; i++) 
        {
            for (int j = 0; j < l; j++)
             {
                if (i != j && isConnected[i][j] == 1)
                 {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i); 
                    
                }
            }
        }

     
        boolean[] visited = new boolean[l];
        int provinceCount = 0;
        for (int i = 0; i < l; i++) 
        {
            if (!visited[i]) 
            {
                provinceCount++;
                dfs(i, adjList, visited);
            }
        }

        return provinceCount;
    }
}
