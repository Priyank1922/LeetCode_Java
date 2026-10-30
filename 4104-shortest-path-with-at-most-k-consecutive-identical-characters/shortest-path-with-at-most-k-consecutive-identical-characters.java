

class Solution {

    static class Edge {
        int to, wt;

        Edge(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    static class State {
        int node;
        int streak;
        long cost;

        State(int node, int streak, long cost) {
            this.node = node;
            this.streak = streak;
            this.cost = cost;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
        }

        long INF = Long.MAX_VALUE;

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            int u = cur.node;
            int streak = cur.streak;
            long cost = cur.cost;

            if (cost > dist[u][streak]) {
                continue;
            }

            for (Edge edge : graph[u]) {

                int v = edge.to;

                int newStreak;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newStreak = streak + 1;

                    if (newStreak > k) {
                        continue;
                    }
                } else {
                    newStreak = 1;
                }

                long newCost = cost + edge.wt;

                if (newCost < dist[v][newStreak]) {

                    dist[v][newStreak] = newCost;

                    pq.offer(
                        new State(v, newStreak, newCost)
                    );
                }
            }
        }

        long ans = INF;

        for (int streak = 1; streak <= k; streak++) {
            ans = Math.min(ans, dist[n - 1][streak]);
        }

        return ans == INF ? -1 : (int) ans;
    }
}