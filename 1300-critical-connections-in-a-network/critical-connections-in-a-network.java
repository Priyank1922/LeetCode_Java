import java.util.*;

class Solution {
    private int time;
    private List<List<Integer>> result;
    private List<Integer>[] graph;
    private int[] disc, low;
    private boolean[] visited;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }


        time = 0;
        result = new ArrayList<>();
        disc = new int[n];
        low = new int[n];
        visited = new boolean[n];

        
        dfs(0, -1);

        return result;
    }

    private void dfs(int u, int parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (v == parent) continue; 
            if (!visited[v]) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v)); 
                }
            } else {

                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
