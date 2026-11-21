class Solution {

    List<Integer>[] tree;
    List<Integer>[] finalTree;
    int[] newParent;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;

        tree = new ArrayList[n];
        finalTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        newParent = new int[n];
        newParent[0] = -1;

        ArrayList<Integer>[] stacks = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            stacks[i] = new ArrayList<>();
        }

        dfsFind(0, parent, stacks);

        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        dfsSize(0, ans);

        return ans;
    }

    private void dfsFind(int node, int[] parent,
                         ArrayList<Integer>[] stacks) {

        int ch = s.charAt(node) - 'a';

        if (node != 0) {
            if (!stacks[ch].isEmpty()) {
                newParent[node] =
                    stacks[ch].get(stacks[ch].size() - 1);
            } else {
                newParent[node] = parent[node];
            }
        }

        stacks[ch].add(node);

        for (int child : tree[node]) {
            dfsFind(child, parent, stacks);
        }

        stacks[ch].remove(stacks[ch].size() - 1);
    }

    private int dfsSize(int node, int[] ans) {

        int size = 1;

        for (int child : finalTree[node]) {
            size += dfsSize(child, ans);
        }

        ans[node] = size;
        return size;
    }
}