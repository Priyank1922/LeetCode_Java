class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder clean = new StringBuilder();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch != '-'){
                clean.append(Character.toUpperCase(ch));
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = clean.length()-1 ; i>=0 ; i--){
            ans.append(clean.charAt(i));
            count++;
            if(count==k && i != 0){
                ans.append('-');
            count = 0;
            }
        }
        return ans.reverse().toString();
    }
}