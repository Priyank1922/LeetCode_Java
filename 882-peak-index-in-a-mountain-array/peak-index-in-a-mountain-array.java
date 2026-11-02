class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int st = 0;
        int end = a.length-1;
        int ans = 0;

        while(st<= end){
            int mid = st +(end-st)/2;

            if(a[mid] < a[mid+1]){
                ans = mid+1;
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}