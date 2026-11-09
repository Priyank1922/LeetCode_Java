class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<long[]> busy =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            // Free completed servers
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int serverId = (int) busy.poll()[1];
                available.add(serverId);
            }

            // Request dropped
            if (available.isEmpty()) {
                continue;
            }

            int start = i % k;

            Integer server = available.ceiling(start);

            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            count[server]++;

            long finishTime = (long) arrival[i] + load[i];
            busy.offer(new long[]{finishTime, server});
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}