class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int n = numbers.length;
       int [] res = new int[2];
       int i = 0;
       int j = n-1;
       while(i<j){
        int front = numbers[i];
        int back = numbers[j];
        if(front + back == target){
            res[0] = i + 1;
            res[1] = j + 1;
            break;
        }else if(front + back > target){
            j--;
        }else{
            i++;
        }
       } 
       return res;
    }
}