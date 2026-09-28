class Solution {
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        if(l1 > l2){
            return false;
        }
        if(l1 == 0 ){
            return true;
        }
        int i = 0 ;
        int j = 0 ;
        while(i<l1 && j<l2){
            char c = s.charAt(i);
            if(c == t.charAt(j)){
                i++;
            }
            j++;
            if(i == l1){
                return true;
            }
        }
        return false;
    }
}