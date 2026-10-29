import java.util.*;

class Solution {

    List<Integer>[] graph;
    int[] parent, depth, heavy, head, pos, size;
    int curPos = 0;

    SegmentTree seg;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        size = new int[n];

        Arrays.fill(heavy, -1);

        dfs(0, -1);
        decompose(0, 0);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[pos[i]] = 1 << (s.charAt(i) - 'a');
        }

        seg = new SegmentTree(arr);

        char[] chars = s.toCharArray();

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {

            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {

                int node = Integer.parseInt(parts[1]);
                char ch = parts[2].charAt(0);

                chars[node] = ch;

                seg.update(pos[node], 1 << (ch - 'a'));

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private int dfs(int u, int p) {

        parent[u] = p;
        size[u] = 1;

        int maxSize = 0;

        for (int v : graph[u]) {

            if (v == p) continue;

            depth[v] = depth[u] + 1;

            int childSize = dfs(v, u);

            size[u] += childSize;

            if (childSize > maxSize) {
                maxSize = childSize;
                heavy[u] = v;
            }
        }

        return size[u];
    }

    private void decompose(int u, int h) {

        head[u] = h;
        pos[u] = curPos++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : graph[u]) {

            if (v == parent[u] || v == heavy[u]) {
                continue;
            }

            decompose(v, v);
        }
    }

    private int queryPath(int u, int v) {

        int res = 0;

        while (head[u] != head[v]) {

            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            res ^= seg.query(pos[head[u]], pos[u]);

            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        res ^= seg.query(pos[u], pos[v]);

        return res;
    }

    class SegmentTree {

        int[] tree;
        int n;

        SegmentTree(int[] arr) {

            n = arr.length;
            tree = new int[4 * n];

            build(1, 0, n - 1, arr);
        }

        private void build(int node, int l, int r, int[] arr) {

            if (l == r) {
                tree[node] = arr[l];
                return;
            }

            int mid = (l + r) / 2;

            build(node * 2, l, mid, arr);
            build(node * 2 + 1, mid + 1, r, arr);

            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {

            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) / 2;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }

        int query(int L, int R) {
            return query(1, 0, n - 1, L, R);
        }

        private int query(int node, int l, int r, int L, int R) {

            if (L > r || R < l) {
                return 0;
            }

            if (L <= l && r <= R) {
                return tree[node];
            }

            int mid = (l + r) / 2;

            return query(node * 2, l, mid, L, R)
                 ^ query(node * 2 + 1, mid + 1, r, L, R);
        }
    }
}