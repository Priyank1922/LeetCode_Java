import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int cheapest = Integer.MAX_VALUE;
        int maxFactor = 0;
        for (int[] item : items) {
            cheapest = Math.min(cheapest, item[1]);
            maxFactor = Math.max(maxFactor, item[0]);
        }
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }
long[] count = new long[maxFactor + 1];

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                count[i] += freq[j];
            }
        }
        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            long freeItems = count[factor] - 1;

            if (freeItems > 0 && price <= 2L * cheapest) {
                map.put(price,
                    map.getOrDefault(price, 0L) + freeItems);
            }
        }
        long total = 0;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {

            long price = entry.getKey();
            long available = entry.getValue();

            long buy = Math.min(available, budget / price);

            total += 2 * buy;
            budget -= buy * price;
        }
       total += budget / cheapest;

        return (int) total;
    }
}