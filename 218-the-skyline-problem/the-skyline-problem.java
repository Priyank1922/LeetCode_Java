class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // start
            events.add(new int[]{b[1], b[2]});  // end
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(0);

        int prevHeight = 0;

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] event : events) {

            int x = event[0];
            int h = event[1];

            if (h < 0) {
                pq.offer(-h);      
                } else {
                pq.remove(h);      
            }

            int currHeight = pq.peek();

            if (currHeight != prevHeight) {
                ans.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return ans;
    }
}