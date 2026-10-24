class Solution {
    public int getDate(String date){
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3));

        int total = day;
        for(int i = 0; i < month-1 ; i++){
            total += days[i];
        }
        return total;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceStart = getDate(arriveAlice);
        int aliceEnd = getDate(leaveAlice);

        int bobStart = getDate(arriveBob);
        int bobEnd = getDate(leaveBob);

        int start = Math.max(aliceStart , bobStart);
        int end = Math.min(aliceEnd , bobEnd);

        if(start>end)return 0;
        else return end - start + 1;
    }
}