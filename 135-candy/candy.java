class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0 ){
            return 0;
        }
        int res = 1 , up = 0 , down = 0 , peak = 0;

        for(int i = 1 ; i < ratings.length ; i++){
            int prev = ratings [i-1];
            int curr = ratings[i];

            if(prev < curr){
                up++;
                down = 0;
                peak = up ;
                res+=1+ up ;
            }else if(prev == curr){
                up = 0 ;
                down = 0 ;
                peak = 0 ;
                res += 1;
            }
            else{
                up = 0 ;
                down ++;
                res += 1+down;
                if(peak >= down){
                    res --;
                }
            }
        }
        return res;
    }
}