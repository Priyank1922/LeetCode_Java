class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0;
        int sumBob = 0;

        for(int x : aliceSizes) sumAlice += x;
        for(int y : bobSizes) sumBob += y;

        int diff = (sumAlice - sumBob)/2;

        HashSet<Integer>set = new HashSet<>();
        for(int y : bobSizes) set.add(y);
        for(int x : aliceSizes){
            int y = x-diff;
            if(set.contains(y))return new int[] {x,y};
        }
        return new int []{};
    }
}