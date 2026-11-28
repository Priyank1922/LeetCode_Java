class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int [] row : image){
            int left = 0;
            int right = image.length-1;
            while(left<=right){
                if(row[left] == row[right]){
                    row[left]^=1;
                   if (left != right) {
                        row[right] ^= 1;
                    }
                }
                left++;
                right--;
            }
        }

        return image;
    }
}