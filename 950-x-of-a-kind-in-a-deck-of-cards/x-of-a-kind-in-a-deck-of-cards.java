class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int card : deck)map.put(card , map.getOrDefault(card , 0)+1);
        int gcd = 0;
        for(int freq : map.values()) gcd = gcd(gcd , freq);
        return gcd > 1;
    }
    private int gcd (int a , int b){
        while(b!=0){
        int temp = b;
        b = a % b;
        a = temp;
        }
        return a;
    }
}