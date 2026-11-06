

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = queries.length;
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i]; // query time
            q[i][1] = i;          // original index
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] freq = new int[n + 1];
        int activeServers = 0;

        int left = 0;
        int right = 0;

        int[] ans = new int[m];

        for (int[] query : q) {

            int time = query[0];

            // Add logs whose time <= query time
            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];

                if (freq[server] == 0) {
                    activeServers++;
                }

                freq[server]++;
                right++;
            }

            // Remove logs whose time < (time - x)
            while (left < right && logs[left][1] < time - x) {
                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            ans[query[1]] = n - activeServers;
        }

        return ans;
    }
}