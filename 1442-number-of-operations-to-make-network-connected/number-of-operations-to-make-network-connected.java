class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;  
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
    
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int components = 0;
        
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                bfs(i, graph, visited);
            }
        }
        
        // If the number of extra cables is sufficient to connect all components
        return components - 1;
    }

    private void bfs(int node, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}