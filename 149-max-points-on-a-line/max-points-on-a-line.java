class Solution {
    
    public int maxPoints(int[][] points) {
        
        int n = points.length;

        if (n <= 2) return n;

        int maxPoints = 0;

        for (int i = 0; i < n; i++) {

            HashMap<String, Integer> map = new HashMap<>();
            int currMax = 0;

            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int gcd = gcd(dx, dy);

                dx /= gcd;
                dy /= gcd;

                // Normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                }

                String slope = dx + "," + dy;

                map.put(slope, map.getOrDefault(slope, 0) + 1);

                currMax = Math.max(currMax, map.get(slope));
            }

            maxPoints = Math.max(maxPoints, currMax + 1);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}